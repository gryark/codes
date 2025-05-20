 package Week_6_7_Generalization;

/*
 * 1. Inheritance (Kalıtım)
Bir sınıfın özelliklerini ve metodlarını başka bir sınıfa miras vermesidir. Böylece kod tekrarı önlenir ve genelleştirme sağlanır.
 */
// Superclass (ana sınıf)  
class Animal {  
    String name;  

    void eat() {  
        System.out.println(name + " is eating.");  
    }  
}  

// Subclass (alt sınıf)  
class Dog extends Animal {  
    void bark() {  
        System.out.println(name + " is barking.");  
    }  
}  

public class TestInheritance {  
    public static void main(String[] args) {  
        Dog dog = new Dog();  
        dog.name = "Rex";  
        dog.eat();  // Animal sınıfından miras  
        dog.bark(); // Kendine ait metod  
    }  
}
/*
 * Açıklama: Dog sınıfı, Animal sınıfını extend ederek onun özelliklerini (name) ve metodlarını (eat) miras almıştır. Böylece kod tekrarından kaçınılır.

 */
