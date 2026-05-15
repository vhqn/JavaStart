package stage2_oop;

public class Dog extends Animal implements Pet {
    private int age;

    void bark() {
        System.out.println(name + " says: wang wang");
    }

    @Override
    void makeSound() {
        System.out.println(name + " is barking.");
    }

    void introduce() {
        System.out.println("I am " + name + ", " + age + " years old.");
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
        this.name = "Default Dog";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void play() {
        System.out.println(name + " is playing.");
    }

    @Override
    public void beFriendly() {
        System.out.println(name + " is being friendly.");
    }

    public static void main(String[] args) {
        // Polymorphism test: Parent reference pointing to child objects
        Animal dog = new Dog("Wang Wang", 3);
        Animal cat = new Cat("Kitty", 2);
        
        dog.makeSound();  // Calls Dog's makeSound()
        cat.makeSound();  // Calls Cat's makeSound()
        
        // Normal usage
        Dog d = new Dog("Wang Wang", 3);
        d.introduce();
        d.bark();

        d.setName("Wang Wang 2");
        d.setAge(4);
        d.introduce();

        d.eat();
        d.makeSound();
    }
}
