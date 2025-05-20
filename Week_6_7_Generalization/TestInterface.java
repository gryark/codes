package Week_6_7_Generalization;

/*
 * 3. Interface (Arayüz)
Sadece metod imzalarını (gövdesiz metodlar) içeren yapılardır. Bir sınıf birden çok interface'i implement ederek çoklu kalıtım sağlayabilir.
 */
interface Movable  {  
    void move();  
}  

interface Soundable {  
    void sound();
}  

class Bird implements Movable, Soundable {  
    String name;  

    public Bird(String name) {  
        this.name = name;  
    }  

    @Override  
    public void move() {  
        System.out.println(name + " is flying.");  
    }  

    @Override  
    public void sound() {  
        System.out.println(name + " says: Tweet");  
    }  
}  

public class TestInterface {  
    public static void main(String[] args) {  
        Bird bird = new Bird("Tweety");  
        bird.move();  
        bird.sound();  
    }  
}
