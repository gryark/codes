package Weeks4_5_UML_Class_Diagrams;

// Class representing a Course with attributes and methods  
public class Course {  

    // Name of the course  
    String name;  
    
    // Semester when the course is offered (using an enum SemesterType)  
    SemesterType semester;  
    
    // Number of credit hours for the course  
    float hours;  

    // Method to get the number of credits for the course  
    public int getCredits() {  
        // Returning the integer value of credit hours (for example purpose)  
        return (int) hours;  
    }  

    // Method to get the lecturer teaching the course  
    public Lecturer getLecturer() {  
        // Return a Lecturer object (mock implementation)  
        return new Lecturer();  
    }  

    // Method to get the GPA for the course  
    public float getGPA() {  
        // Return a GPA value (mock implementation)  
        return 4.0f;  
    }  
}  

// Enum representing different semester types  
enum SemesterType {  
    SPRING, SUMMER, FALL, WINTER  
}  

// Dummy Lecturer class declaration for returning from getLecturer method  
class Lecturer {  
    // Lecturer details would be implemented here  
}
