//Explain the concept of interfaces and abstract classes with examples.
/*
 An abstract class is a class that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods.
 An interface is a completely abstract class that contains only abstract methods and constants.
 */
interface Animal {
    void sound();
}

abstract class Mammal {
    abstract void eat();
}

class Dog extends Mammal implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }

    public void eat() {
        System.out.println("Dog eats bones");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.eat();
    }
}
