package OOPs;

/**
 * The type Animal.
 */
// Abstract class
abstract class Animal1 {
    /**
     * Animal sound.
     */
// Abstract method (does not have a body)
    public abstract void animalSound();

    /**
     * Sleep.
     */
// Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

/**
 * The type Pig.
 */
// Subclass (inherit from Animal)
class Pig extends Animal1 {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

/**
 * The type Abstract.
 */
class Abstract {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Pig myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}