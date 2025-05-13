package Weeks4_5_UML_Class_Diagrams;

import java.util.Date;
import java.util.LinkedHashSet;  

class Test {  
    public static void main(String[] args) {  
        // Test the Person class  
        Person person = new Person("123-45-6789");  
        person.name
        
}

public class Person {  

    
    // Attributes  
    private String firstName;                 // First name of person (private)  
    private String lastName;                  // Last name of person (private)  
    private Date dob;                        // Date of birth (private)  
   // Address koleksiyonu: benzersiz (unique) ve sıralı (ordered) olduğu için LinkedHashSet kullanıyoruz.  
    private LinkedHashSet<String> address = new LinkedHashSet<>();    
    private final String ssNo;               // Social security number - readOnly (final)  
    private int age;                        // age attribute calculated  
    private String password = "pw123";      // Default password value (private)  
    private static int personsCounter;      // Static counter for all Person objects  

    // Constructor to initialize SSN since it's final and read-only  
    public Person(String ssNo) {  
        this.ssNo = ssNo; // read-only: set only once via constructor  
        personsCounter++;  
    } 
    
    
    // Public method with 'out' and 'in' parameters to get full name as output parameter is not typical in Java;  
    // simulation: return via method return and input via argument  
    public String getName(String fn, String ln) {  
        return fn + " " + ln;  
    }  

    // Update last name  
    public boolean updateLastName(String newName) {  
        if (newName == null || newName.isEmpty()) {  
            return false;  
        }  
        this.lastName = newName;  
        return true;  
    }  

    // Static method to get the counter of persons  
    public static int getPersonsCounter() {  
        return personsCounter;  
    }  

    // Age calculation: example implementation base on dob and current date  
    public int calculateAge() {  
        if (dob == null) return 0;  

        // Using deprecated methods for simplicity (better to use Calendar or java.time API)  
        Date now = new Date();  
        age = now.getYear() - dob.getYear();  
        return age;  
    } 
    // Adres ekleme metodu (unique ve ordered olmasını sağlar)  
    public boolean addAddress(String newAddress) {  
        if (newAddress != null && !newAddress.isEmpty()) {  
            return address.add(newAddress); // True dönerse eklendi, false ise zaten vardı.  
        }  
        return false; // Geçersiz adres  
    }  

    // Tüm adresleri sıralı olarak döner (kopya Set veya liste)  
    public LinkedHashSet<String> getAddresses() {  
        return new LinkedHashSet<>(address);  
    }  

    // En az 1 adres olması gerektiğini kontrol eden metod  
    public boolean hasMinimumOneAddress() {  
        return address.size() >= 1;  
    }   

    // Getter and setter methods for encapsulation (if needed) could be added here  
}