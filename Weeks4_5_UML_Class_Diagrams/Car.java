package Weeks4_5_UML_Class_Diagrams;

public class Car {  
    // Özellikler  
    private String code;               // -code : String  
    private float maxSpeed = 90.0f;    // -maxSpeed : float = 90.0  
    private int length = 60;           // -length : integer = 60  
    public int defaultLength = 80; // +defaultLength : integer = 80  
    protected float velocity = 30.0f;   // #velocity : float = 30.0  

    // Constructor  
    public Car(String code) {  
        this.code = code;  
    }  

    // Diğer metodlar (örneğin getSet metodları) buraya eklenebilir  
}

/*
 * Özellikler:
code: private erişim belirleyicisi ile tanımlanmıştır.
maxSpeed: private olarak, varsayılan değeri 90.0 ile tanımlanmıştır.
length: private, varsayılan değeri 60 ile tanımlanmıştır.
defaultLength: public static, varsayılan değeri 80 ile tanımlanmıştır.
velocity: protected, varsayılan değeri 30.0 ile tanımlanmıştır.
 */