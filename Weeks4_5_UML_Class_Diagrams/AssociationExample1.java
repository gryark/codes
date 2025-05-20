package Weeks4_5_UML_Class_Diagrams;

import java.util.ArrayList;  
import java.util.List;  

class Professor {  
    // Özellikler  
    private String lecturer; // +lecturer : String  
    private List<Student> students; // İlişkiyi göstermek için öğrenci listesi  

    // Constructor  
    public Professor(String lecturer) {  
        this.lecturer = lecturer;  
        students = new ArrayList<>(); // Öğrenci listesi initialize edilir  
    }  

    // Öğrenci ekleme metodu  
    public void givesLectureFor(Student student) {  
        students.add(student);  
    }  

    // Öğrencilerin listesini alma metodu  
    public List<Student> getStudents() {  
        return students;  
    }  

    public String getLecturer() {  
        return lecturer;  
    }  
}  

class Student {  
    // Özellikler  
    private String name; // Öğrencinin adı  
    priavte ArrayList>Professor> professors; // Öğrencinin ders aldığı profesörler

    // Constructor  
    public Student(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

public class AssociationExample1 {

// Örnek kullanım  
public static void main(String[] args) {  
        // Profesör oluşturma  
        Professor professor = new Professor("Dr. Smith");  

        // Öğrencileri oluşturma  
        Student student1 = new Student("Alice");  
        Student student2 = new Student("Bob");  

        // Profesörün öğrencilere ders vermesi  
        professor.givesLectureFor(student1);  
        professor.givesLectureFor(student2);  

        // Öğrencileri listeleme  
        System.out.println(professor.getLecturer() + " ders veriyor:");  
        for (Student student : professor.getStudents()) {  
            System.out.println("- " + student.getName());  
        }  
    }  

}
    
// Bu kod, bir profesörün öğrencilere ders vermesi ve öğrencilerin listesini tutması için bir örnek oluşturmaktadır.
// Professor sınıfı, öğrenci listesini tutar ve öğrenci ekleme metodunu içerir.
// Student sınıfı ise öğrencinin adını tutar. Main sınıfı, örnek kullanım için bir ana metot içerir.

/*
 * Açıklamalar:
Professor Sınıfı: lecturer özelliğine sahip ve birden fazla Student nesnesini tutmak için bir liste içerir. givesLectureFor metodu, profesörün öğrencilere ders verdiğini belirtir.
Student Sınıfı: Her öğrenci için bir isim tutar.
Main Sınıfı: Örnek bir kullanım senaryosu oluşturur. Bir Professor ve iki Student nesnesi yaratılır ve ardından profesörün öğrencilere ders verdiği gösterilir.
Bu yapı, UML diyagramındaki özellikleri ve ilişkileri başarıyla Java programlama diline dönüştürmektedir.
 */

