package CodingPatterns.InPlaceReversal;

public class ReversingASublistOfALinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseLinkedList(ListNode head , int right , int left){
        ListNode prev = null;
        ListNode curr = head;
        for(int i=0;curr!=null&&i<left-1;i++){ // Move to the node before the sublist
            prev = curr;
            curr = curr.next;
        }
    }
}
