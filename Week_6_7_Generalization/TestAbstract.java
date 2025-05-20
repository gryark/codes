package Week_6_7_Generalization;

/*
 * 2. Abstract Class (Soyut Sınıf)
Soyut sınıflar hem somut (gövdesi olan) hem de soyut (gövdesiz) metodlar içerebilir. Genel davranışları belirtmek ve zorunlu metodların alt sınıflar tarafından uygulanmasını sağlamak için kullanılır.
 */
abstract class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating.");
    }

    // Soyut metod - alt sınıflar tarafından implement edilmeli
    abstract void sound();
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println(name + " says: Meow");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        Cat cat = new Animal();
        cat.name = "Whiskers";
        cat.eat();
        cat.sound(); // Soyut metodun uygulanmış hali
    }
}
/*
 * Açıklama: Animal soyut sınıfı içerisinde bir soyut metod sound() tanımlanmıştır. Cat sınıfı bu metodu kendi şekline göre implement etmek zorundadır.


 */
