package Weeks4_5_UML_Class_Diagrams;

import java.util.ArrayList;  


    // Araç ve kişi arasındaki ilişkiyi gösteren sınıflar  
    // Araç sürme ilişkisi  
    // Araç ve kişi arasındaki ilişkiyi gösteren sınıflar  

    
 class Person {  
    private String name;  
    private ArrayList<Car> carsDriven; // Sürülen araçlar  

    // Constructor  
    public Person(String name) {  
        this.name = name;  
        this.carsDriven = new ArrayList<>(); // Araba listesi  
    }  

    // Araç sürme metodu  
    public void drives(Car car) {  
        carsDriven.add(car);  
    }  

    //getters setters methods
    public String getName() {  
        return name;  
    }

    public void setName(String name) {  
        this.name = name;  
    }
    
    public ArrayList<Car> getCarsDriven() {  
        return carsDriven;  
    }

    // Diğer metodlar (gerekirse) buraya eklenebilir  
}  

 class Car {  
    private String brand;  

    // Constructor  
    public Car(String brand) {  
        this.brand = brand;  
    }  

    // Diğer metodlar (gerekirse) buraya eklenebilir  
}  

public class AssociationExample2 {
// Örnek kullanım  
    public static void main(String[] args) {        
    // Kişileri oluşturma  
    Person ali = new Person("Ali");  
    Person veli = new Person("Veli");  
    Person john = new Person("John");  

    // Arabaları oluşturma  
    Car audi = new Car("Audi");  
    Car vw = new Car("VW");  
    Car fiat = new Car("Fiat");  
    Car bmw = new Car("BMW");  
    Car mazda = new Car("Mazda");  

    // Ali'nin arabaları  
    ali.drives(audi);  
    ali.drives(vw);  
    ali.drives(fiat);  

    // Veli'nin arabası  
    veli.drives(bmw);  

    // John's arabası  
    john.drives(mazda);  
    
    // Örnek çıktıları yazdırma (gerekirse)  
    System.out.println(ali.getName() + " has driven: Audi, VW, Fiat");  
    System.out.println(veli.getName() + " has driven: BMW");  
    System.out.println(john.getName() + " has driven: Mazda");  
    }  
}