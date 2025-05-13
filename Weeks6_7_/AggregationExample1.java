package Weeks6_7_;

import java.util.HashSet;  
import java.util.Set;  

class Student {  
    private String name;  

    public Student(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

class LabClass {  
    private String labName;  
    private Student student; // 0 veya 1  

    public LabClass(String labName) {  
        this.labName = labName;  
    }  

    public void setStudent(Student student) {  
        this.student = student;  
    }  

    public Student getStudent() {  
        return student;  
    }  
} 

public class AggregationExample1 {
    
}
