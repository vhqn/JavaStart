package stage2_oop;

public class Cat extends Animal {
    private int age;
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}
