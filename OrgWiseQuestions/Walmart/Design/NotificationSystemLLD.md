# Low-Level Design Requirements for a Notification System

## 1. Introduction
This document outlines the low-level design (LLD) requirements for a scalable notification system. The system is designed to handle real-time and scheduled notifications across multiple channels such as email, SMS, push notifications, and potentially others like WhatsApp or in-app alerts. It supports user preferences, retries for failures, and high-volume processing while ensuring extensibility for new channels without modifying existing code. The design adheres to SOLID principles, uses design patterns like Factory, Strategy, and Command, and incorporates asynchronous processing for scalability.

The system processes events that trigger notifications (e.g., user actions like likes, orders, or messages) and delivers them reliably with minimal latency. It is suitable for applications with millions of daily active users, handling up to 10 million notifications per day.

## 2. Functional Requirements
- **Notification Sending**: Support sending notifications via multiple channels (email, SMS, push, WhatsApp, in-app). Each notification can be single or bulk, with content customized per channel (e.g., larger bodies for email, shorter for SMS).
- **User Preferences**: Allow users to opt-in/out of channels, set preferences (e.g., email over SMS), and unsubscribe from certain types (e.g., promotions).
- **Event Detection and Triggering**: Capture events (e.g., new message, order shipment) and trigger notifications based on type and priority.
- **Scheduling and Prioritization**: Support scheduled (future-dated) notifications and prioritize messages (e.g., high for OTPs, low for promotions).
- **Retry and Failure Handling**: Implement retries with exponential backoff for failed deliveries; move persistent failures to a dead-letter queue (DLQ).
- **Logging and Tracking**: Log delivery status, timestamps, and errors for auditing and analytics.
- **Bulk Notifications**: Provide UI and service for sending notifications based on filters (e.g., users who ordered in the last 24 hours).
- **Searching and Querying**: Enable searching notifications by user ID, type, or status.

## 3. Non-Functional Requirements
- **Scalability**: Handle 10,000 notifications/second during peaks; support horizontal scaling of workers per channel and batch processing. System should manage 1 million DAU generating 10 million notifications/day.
- **Low Latency**: Deliver notifications within 200ms; use asynchronous queues for decoupling.
- **High Availability and Reliability**: Ensure at-least-once delivery with idempotency to handle duplicates; use load balancers, database replication, and failover mechanisms.
- **Fault Tolerance**: Resilient to failures with retries, DLQ, and monitoring.
- **Extensibility**: Easily add new channels (e.g., Telegram) by implementing new handlers without changing core code, adhering to Open/Closed principle.
- **Rate Limiting**: Limit requests per client/user (e.g., 5 notifications/day per user) to prevent abuse.
- **Storage and Bandwidth**: Store ~2 GB/day for notification logs; handle ~116 KB/s bandwidth.
- **Consistency**: Eventual consistency for logs and preferences.

## 4. Components
- **Notification API/Server**: Entry point for requests; validates, routes to queues, and retrieves preferences.
- **Message Queue (e.g., Kafka, RabbitMQ, SQS)**: Decouples producers/consumers; supports priority topics.
- **Workers/Handlers per Channel**: Separate services for email (e.g., SendGrid), SMS (e.g., Twilio), push (e.g., FCM/APNS), in-app, IVRS.
- **Validator & Prioritizer**: Validates payloads and assigns priorities.
- **Rate Limiter**: Enforces limits at client and user levels.
- **Notification Dispatcher/Executor**: Dispatches to senders; handles scheduling.
- **Query Service/Engine**: For searching notifications and filtering users for bulk sends.
- **Scheduler and Pipelines**: Manages timing, formatting, personalization, and localization.
- **Bulk Notification UI/Service**: UI for bulk sends with filter criteria.
- **Cache (e.g., Redis)**: For user preferences to reduce DB load.
- **Dead-Letter Queue (DLQ)**: For failed notifications.

## 5. Data Models and Database Schemas
- **Enums**: Channel (EMAIL, SMS, PUSH, WHATSAPP), NotificationType (e.g., ORDER_SHIPPED, POST_LIKE).
- **Notification Interface**: Methods like `getChannel()`, `getRecipient()`, `getContent()`. Implementations: EmailNotification (toEmail, subject, body), SMSNotification (toPhone, message), PushNotification (toDeviceId, title, payload).
- **NotificationSender Interface**: `send(Notification)`; extends to SchedulableNotificationSender with `schedule(Notification, LocalDateTime)`.
- **Database Schemas** (e.g., Relational DB like PostgreSQL for preferences, NoSQL like Cassandra for logs):
  - **Users Table**: userId (PK), name, preferences (JSON: {email: true, sms: false}).
  - **Notifications Table**: notificationId (PK), userId (FK), type, message, status (PENDING/SENT/FAILED), timestamp.
  - **NotificationLogs Table**: logId (PK), notificationId (FK), channel, deliveryStatus, errorMessage, timestamp.
  - **Preferences DB**: userId (PK), channelPreferences (JSON), unsubscribeSettings.
  - **EventDetection Table**: eventId (PK), type, payload (JSON), detectionTime.

## 6. APIs
- **POST /notifications**: Send notification. Payload: {userId, channels[], message, type, preferences}. Response: {status: "success"}.
- **GET /notifications/{notificationId}**: Get status. Response: {id, status, timestamp, channel}.
- **POST /retry/{notificationId}**: Retry failed notification.
- **GET /fetchUserData**: Params: api_dev_key, userId. Response: User data with preferences.
- **GET /fetchNotifications**: Params: api_dev_key, userId, filter. Response: List of notifications.
- **POST /queryNotifications**: Params: api_dev_key, userId, query. Response: Filtered notifications.
- **POST /sendNotification**: Params: api_dev_key, userId, type, message. Response: Success message.

## 7. Detailed Design Aspects
- **Class Hierarchy/Diagrams**: Use interfaces (Notification, MessageHandler) and abstract classes (AbsMessageHandler) for type-safe handling. Factory (NotificationSenderFactory) for sender creation. Map<Class<?>, MessageHandler> for dynamic handler lookup.
- **Design Patterns**: Factory for senders, Strategy for channel handling, Command for notifications, Dependency Injection for extensibility.
- **Workflow**: API receives request → Validate/prioritize → Queue (Kafka) → Worker consumes → Apply preferences → Send via handler → Log status. For bulk: UI → Service → Query filters → Schedule/pipeline → Send.
- **Implementation Notes**: Use third-party integrations (Twilio, SendGrid, FCM). Ensure idempotency with unique IDs. Cache preferences in Redis. Monitor DLQ for failures.
- **SOLID Compliance**: Single Responsibility (e.g., one task per handler), Open/Closed (extend for new channels), Liskov Substitution (subtypes interchangeable), Interface Segregation (focused interfaces), Dependency Inversion (abstract dependencies).