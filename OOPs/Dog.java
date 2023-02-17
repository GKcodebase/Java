package OOPs;

/**
 * The Dog.
 */
public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("BOW");
    }

    @Override
    public void eat() {
        System.out.println("Non - Veg");
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        Animal dog = new Dog();
        dog.eat();
        dog.sound();
    }
}
