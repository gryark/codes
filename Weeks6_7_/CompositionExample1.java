package Weeks6_7_;


import java.util.ArrayList;  
import java.util.List;  

class Building {  
    private String name;  
    private List<LectureHall> lectureHalls = new ArrayList<>();  

    public Building(String name) {  
        this.name = name;  
    }  

    // Composition: Building kendisi LectureHall yaratır ve ekler  
    public void createLectureHall(String hallName, String beamerModel) {  
        LectureHall hall = new LectureHall(hallName, beamerModel);  
        lectureHalls.add(hall);  
    }  

    public List<LectureHall> getLectureHalls() {  
        return lectureHalls;  
    }  
}  

class LectureHall {  
    private String hallName;  
    private Beamer beamer; // 0..1 Beamer (composition)  

    // LectureHall oluşturulurken Beamer de oluşturuluyor  
    public LectureHall(String hallName, String beamerModel) {  
        this.hallName = hallName;  
        if (beamerModel != null) {  
            this.beamer = new Beamer(beamerModel);  
        }  
    }  

    public Beamer getBeamer() {  
        return beamer;  
    }  

    public String getHallName() {  
        return hallName;  
    }  
}  

class Beamer {  
    private String model;  

    public Beamer(String model) {  
        this.model = model;  
    }  

    public String getModel() {  
        return model;  
    }  
}
public class CompositionExample1 {
    public static void main(String[] args) {  
        Building building = new Building("Main Campus");  

        building.createLectureHall("Hall A", "Epson X123");  
        building.createLectureHall("Hall B", null); // Beamer yok  

        System.out.println("Building: " + building.getName());  
        for (LectureHall hall : building.getLectureHalls()) {  
            System.out.print(" LectureHall: " + hall.getHallName());  
            if (hall.getBeamer() != null) {  
                System.out.println(", Beamer: " + hall.getBeamer().getModel());  
            } else {  
                System.out.println(", Beamer: None");  
            }  
        }  
    } 
    
}

/*
 *  LectureHall nesnesi Building tarafından,
    Beamer nesnesi de LectureHall tarafından kendi içinde oluşturulmalı (new).
 * 
 */