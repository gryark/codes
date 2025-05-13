// Office sınıfı  
class Office {  
    private String roomNumber;  

    public Office(String roomNumber) {  
        this.roomNumber = roomNumber;  
    }  

    public String getRoomNumber() {  
        return roomNumber;  
    }  
}  

// LectureHall sınıfı  
class LectureHall {  
    private String hallName;  

    public LectureHall(String hallName) {  
        this.hallName = hallName;  
    }  

    public String getHallName() {  
        return hallName;  
    }  
}  

// Exam sınıfı  
class Exam {  

    private Office office;             // Sınavın yapıldığı ofis  
    private LectureHall lectureHall;  // Sınavın yapıldığı derslik  

    // Constructor sadece office ile sınav için  
    public Exam(Office office) {  
        this.office = office;  
        this.lectureHall = null; // XOR kuralı gereği sadece biri olmalı  
    }  

    // Constructor sadece lectureHall ile sınav için  
    public Exam(LectureHall lectureHall) {  
        this.lectureHall = lectureHall;  
        this.office = null;      // XOR kuralı gereği sadece biri olmalı  
    }  

    // Sınavın ofiste yapılıp yapılmadığını kontrol et  
    public boolean isExamInOffice() {  
        return office != null;  
    }  

    // Sınavın derslikte yapılıp yapılmadığını kontrol et  
    public boolean isExamInLectureHall() {  
        return lectureHall != null;  
    }  

    // Sınavın yerini alır (ofis veya derslik) - sadece biri olabilir  
    public String getLocation() {  
        if (isExamInOffice()) {  
            return "Office: " + office.getRoomNumber();  
        } else if (isExamInLectureHall()) {  
            return "Lecture Hall: " + lectureHall.getHallName();  
        } else {  
            return "Location not set";  
        }  
    }  
}

public class XorExample {
    public static void main(String[] args) {
        // Office ve LectureHall nesneleri oluştur  
        Office office = new Office("Room 101");  
        LectureHall lectureHall = new LectureHall("Hall A");  

        // Sınav ofiste yapılıyor  
        Exam examInOffice = new Exam(office);  
        System.out.println("Exam Location: " + examInOffice.getLocation());  

        // Sınav derslikte yapılıyor  
        Exam examInLectureHall = new Exam(lectureHall);  
        System.out.println("Exam Location: " + examInLectureHall.getLocation());  
    }  
}