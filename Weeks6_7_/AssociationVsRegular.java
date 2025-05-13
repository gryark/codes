package Weeks6_7_;

import java.util.HashSet;  
import java.util.Set;  

/*
 * 1. Senaryo: Öğrenci (Student) aynı StudyProgram için sadece bir kez Enrollment yapabilir (tekil kayıt)
 * 
 */

class StudyProgram {  
    private String name;  

    public StudyProgram(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

class Student {  
    private String name;  
    private Set<Enrollment> enrollments;  

    public Student(String name) {  
        this.name = name;  
        this.enrollments = new HashSet<>();  
    }  

    public String getName() {  
        return name;  
    }  

    public Set<Enrollment> getEnrollments() {  
        return enrollments;  
    }  

    // Tekil enrollment ekleme  
    public boolean enroll(StudyProgram program) {  
        // Aynı program için daha önce kayıt kontrolü  
        for (Enrollment e : enrollments) {  
            if (e.getStudyProgram().equals(program)) {  
                System.out.println("Already enrolled to this StudyProgram: " + program.getName());  
                return false; // Zaten kayıtlı, ekleme yok  
            }  
        }  
        Enrollment newEnrollment = new Enrollment(this, program);  
        enrollments.add(newEnrollment);  
        return true;  
    }  
}  

class Enrollment {  
    private Student student;  
    private StudyProgram studyProgram;  

    public Enrollment(Student student, StudyProgram studyProgram) {  
        this.student = student;  
        this.studyProgram = studyProgram;  
    }  

    public Student getStudent() {  
        return student;  
    }  

    public StudyProgram getStudyProgram() {  
        return studyProgram;  
    }  
}  

/*
 * 2. Senaryo: Öğrenci aynı StudyProgram için birden fazla Enrollment yapabilir (çoklu kayıt)
 * 
 */

 import java.util.HashSet;  
import java.util.Set;  

class StudyProgram {  
    private String name;  

    public StudyProgram(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

class Student {  
    private String name;  
    private Set<Enrollment> enrollments;  

    public Student(String name) {  
        this.name = name;  
        this.enrollments = new HashSet<>();  
    }  

    public String getName() {  
        return name;  
    }  

    public Set<Enrollment> getEnrollments() {  
        return enrollments;  
    }  

    // Çoklu enrollment ekleme  
    public void enroll(StudyProgram program) {  
        Enrollment newEnrollment = new Enrollment(this, program);  
        enrollments.add(newEnrollment);  
    }  
}  

class Enrollment {  
    private Student student;  
    private StudyProgram studyProgram;  

    public Enrollment(Student student, StudyProgram studyProgram) {  
        this.student = student;  
        this.studyProgram = studyProgram;  
    }  

    public Student getStudent() {  
        return student;  
    }  

    public StudyProgram getStudyProgram() {  
        return studyProgram;  
    }  
}

public class AssociationVsRegular {
    
}

/*
 * Tekil kayıt senaryosunda, Student sınıfının enroll metodunda aynı program için önceden kayıt olup olmadığı kontrol edilir.
Çoklu kayıt senaryosunda, böyle bir kontrol yapılmaz, her çağrıda yeni kayıt eklenir.
 */