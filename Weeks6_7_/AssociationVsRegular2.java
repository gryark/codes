package Weeks6_7_;

/*
 * 1. Association Class Senaryosu — Benzersiz Kayıt (No duplicates)
 * 
 */

 import java.util.HashSet;  
import java.util.Objects;  
import java.util.Set;  

class Student {  
    private String name;  
    private Set<ExamMeeting> examMeetings = new HashSet<>();  

    public Student(String name) {  
        this.name = name;  
    }  

    public boolean addExamMeeting(ExamMeeting meeting) {  
        // Aynı sınav için varsa ekleme yapmaz (benzersiz)  
        for (ExamMeeting em : examMeetings) {  
            if (em.getExam().equals(meeting.getExam())) {  
                System.out.println("Student " + name + " already has an exam meeting for exam: " + em.getExam().getSubject());  
                return false;  
            }  
        }  
        examMeetings.add(meeting);  
        return true;  
    }  

    public String getName() {  
        return name;  
    }  
}  

class Exam {  
    private String subject;  

    public Exam(String subject) {  
        this.subject = subject;  
    }  

    public String getSubject() {  
        return subject;  
    }  
}  

class ExamMeeting {  
    private Exam exam;  
    private Student student;  

    public ExamMeeting(Exam exam, Student student) {  
        this.exam = exam;  
        this.student = student;  
    }  

    public Exam getExam() {  
        return exam;  
    }  

    public Student getStudent() {  
        return student;  
    }  

    // hashCode ve equals, benzersizliği sınav ve öğrenci bazında sağlar  
    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true;  
        if (!(o instanceof ExamMeeting)) return false;  
        ExamMeeting that = (ExamMeeting) o;  
        return Objects.equals(exam, that.exam) &&  
               Objects.equals(student, that.student);  
    }  

    @Override  
    public int hashCode() {  
        return Objects.hash(exam, student);  
    }  
}

/*
 * 2. Regular Class Senaryosu — Çoklu Kayıt (Duplicates Allowed)
 * 
 */

 import java.util.HashSet;  
import java.util.Set;  

class Student {  
    private String name;  
    private Set<ExamMeeting> examMeetings = new HashSet<>();  

    public Student(String name) {  
        this.name = name;  
    }  

    // Aynı sınav için birden fazla meeting eklenebilir  
    public void addExamMeeting(ExamMeeting meeting) {  
        examMeetings.add(meeting);  
    }  

    public String getName() {  
        return name;  
    }  
}  

class Exam {  
    private String subject;  

    public Exam(String subject) {  
        this.subject = subject;  
    }  

    public String getSubject() {  
        return subject;  
    }  
}  

class ExamMeeting {  
    private Exam exam;  
    private Student student;  

    public ExamMeeting(Exam exam, Student student) {  
        this.exam = exam;  
        this.student = student;  
    }  

    public Exam getExam() {  
        return exam;  
    }  

    public Student getStudent() {  
        return student;  
    }  

    // equals ve hashCode burada tanımlanmaz, böylece duplicate olabilir  
}

public class AssociationVsRegular2 {
    
}

/*
 * Kısa Açıklama:
Association Class olarak ExamMeeting sınıfında equals() ve hashCode() metodları override edilerek exam ve student çifti bazında eşsiz (unique) kayıt sağlanır.
Böylece bir öğrenci, bir sınav için sadece bir tane meeting alabilir.
Regular Class modelde ise eşsiz kayıt kontrolü yoktur, dolayısıyla bir öğrenci aynı sınav için birden fazla meeting alabilir; duplicate kayıtlar mümkündür.
 */