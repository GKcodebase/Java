package OOPs;

/**
 * The Animals.
 */
class Animals {
    /**
     * Make sound.
     */
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}

/**
 * The Doggy.
 */
class Doggy extends Animals {
    public void makeSound() {
        System.out.println("Dog is barking");
    }
}

/**
 * The Cat.
 */
class Cat extends Animals {
    public void makeSound() {
        System.out.println("Cat is meowing");
    }
}

/**
 * The Polymorphism.
 */
public class Polymorphism {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Animals myAnimal = new Animals();  // create an Animal object
        Animals myDog = new Doggy();  // create a Dog object
        Animals myCat = new Cat();  // create a Cat object

        myAnimal.makeSound();  // calls the Animal method
        myDog.makeSound();  // calls the Dog method
        myCat.makeSound();  // calls the Cat method
    }
}

