package task_1;

class Cow implements Voice {
    @Override
    public void voice() {
        System.out.println("Myy-myy");
    }
}

class Dog implements Voice {
    @Override
    public void voice() {
        System.out.println("Gav-gav");
    }
}

class Cat implements Voice {
    @Override
    public void voice() {
        System.out.println("Mow-mow");
    }
}



public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        System.out.println("Cat: ");
        cat.voice();
        System.out.println("Dog: ");
        dog.voice();
        System.out.println("Cow: ");
        cow.voice();

    }
}
