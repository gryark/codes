package Weeks6_7_;

import java.util.HashSet;  
import java.util.Set;  

// Student sınıfı  
 class Student {  
    private String name;  
    private Set<Exam> exams;  

    public Student(String name) {  
        this.name = name;  
        this.exams = new HashSet<>();  
    }  

    public String getName() {  
        return name;  
    }  

    public Set<Exam> getExams() {  
        return exams;  
    }  

    // Öğrencinin girdiği sınava ekle  
    public void addExam(Exam exam) {  
        exams.add(exam);  
    }  
}  

// Lecturer sınıfı  
 class Lecturer {  
    private String name;  
    private Set<Exam> examinedExams;  

    public Lecturer(String name) {  
        this.name = name;  
        this.examinedExams = new HashSet<>();  
    }  

    public String getName() {  
        return name;  
    }  

    public Set<Exam> getExaminedExams() {  
        return examinedExams;  
    }  

    // Öğretim görevlisinin sınavına atama yap  
    public void addExam(Exam exam) {  
        examinedExams.add(exam);  
    }  
}  

// Exam sınıfı  
class Exam {  
    private String subject;  
    private Set<Student> students;           // Sınava giren öğrenciler  
    private Set<Lecturer> examiners;         // Sınavı yapan öğretim görevlileri  

    public Exam(String subject) {  
        this.subject = subject;  
        this.students = new HashSet<>();  
        this.examiners = new HashSet<>();  
    }  

    public String getSubject() {  
        return subject;  
    }  

    public Set<Student> getStudents() {  
        return students;  
    }  

    public Set<Lecturer> getExaminers() {  
        return examiners;  
    }  

    // Sınava öğrenci ekle  
    public void addStudent(Student student) {  
        students.add(student);  
        student.addExam(this);  
    }  

    // Sınava examiner (öğretim görevlisi) ekle  
    public void addExaminer(Lecturer lecturer) {  
        examiners.add(lecturer);  
        lecturer.addExam(this);  
    }  
}


public class BinaryExample {

    public static void main(String[] args) {  
        Student student1 = new Student("Ali");  
        Student student2 = new Student("Zeynep");  

        Lecturer lecturer1 = new Lecturer("Dr. Mehmet");  
        Lecturer lecturer2 = new Lecturer("Prof. Ayşe");  

        Exam mathExam = new Exam("Mathematics");  

        // Sınava öğrencileri ekle  
        mathExam.addStudent(student1);  
        mathExam.addStudent(student2);  

        // Sınava öğretim görevlilerini (examiner) ekle  
        mathExam.addExaminer(lecturer1);  
        mathExam.addExaminer(lecturer2);  

        // Örnek çıktı  
        System.out.println("Exam: " + mathExam.getSubject());  
        System.out.println("Students:");  
        for (Student s : mathExam.getStudents()) {  
            System.out.println("- " + s.getName());  
        }  

        System.out.println("Examiners:");  
        for (Lecturer l : mathExam.getExaminers()) {  
            System.out.println("- " + l.getName());  
        }  
    }  

    /*
     *  Exam ile Student arasındaki ilişki hangi öğrencinin sınava girdiğini,
        Exam ile Lecturer arasındaki ilişki ise hangi öğretim görevlisinin sınavı yaptığını gösterir,
        ancak hangi öğretim görevlisinin hangi öğrenciyi sınavda değerlendirdiği bilgisi bu modelde yoktur.
     */
    
}
