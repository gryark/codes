package Weeks6_7_;

import java.util.HashSet;  
import java.util.Set;  

 class Student {  
    private String name;  
    private Set<Grade> grades = new HashSet<>(); // Bir öğrenci birçok not alabilir  

    public Student(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  

    public Set<Grade> getGrades() {  
        return grades;  
    }  

    public void addGrade(Grade grade) {  
        grades.add(grade);  
    }  
}  

 class Exam {  
    private String subject;  
    private Set<Grade> grades = new HashSet<>(); // Bir sınavda birçok öğrenci olabilir  

    public Exam(String subject) {  
        this.subject = subject;  
    }  

    public String getSubject() {  
        return subject;  
    }  

    public Set<Grade> getGrades() {  
        return grades;  
    }  

    public void addGrade(Grade grade) {  
        grades.add(grade);  
    }  
} 
 
class Lecturer {  
    private String name;  

    public Lecturer(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
} 

// Ternary ilişkisini temsil eden sınıf: Grade  
 class Grade {  
    private Student student;  
    private Exam exam;  
    private Lecturer examiner; // 0..1 olabilir  
    private double gradeValue;  

    public Grade(Student student, Exam exam, Lecturer examiner, double gradeValue) {  
        this.student = student;  
        this.exam = exam;  
        this.examiner = examiner;  
        this.gradeValue = gradeValue;  

        // Not oluşturulunca ilişkileri güncelle  
        student.addGrade(this);  
        exam.addGrade(this);  
    }  

    // getterler ve setterler  
}  



public class NaryExample {
    public static void main(String[] args) {  
        Student s1 = new Student("Ali");  
        Student s2 = new Student("Ayşe");  

        Exam mathExam = new Exam("Mathematics");  
        Exam physicsExam = new Exam("Physics");  

        Lecturer lecturer1 = new Lecturer("Prof. Can");  
        Lecturer lecturer2 = new Lecturer("Dr. Deniz");  

        Grade g1 = new Grade(s1, mathExam, lecturer1, 85.5);  
        Grade g2 = new Grade(s2, physicsExam, null, 90); // examiner yok  
        Grade g3 = new Grade(s1, physicsExam, lecturer2, 78);  

        System.out.println(g1);  
        System.out.println(g2);  
        System.out.println(g3);  
    }  
}
