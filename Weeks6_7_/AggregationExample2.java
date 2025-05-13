package Weeks6_7_;

import java.util.HashSet;  
import java.util.Set; 
class Course {  
    private String courseName;  

    public Course(String courseName) {  
        this.courseName = courseName;  
    }  

    public String getCourseName() {  
        return courseName;  
    }  
}  

class StudyProgram {  
    private String programName;  
    private Set<Course> courses;  

    public StudyProgram(String programName, Set<Course> courses) {  
        if (courses == null || courses.size() < 1)  
            throw new IllegalArgumentException("At least one course required");  
        this.programName = programName;  
        this.courses = new HashSet<>(courses);  
    }  

    public String getProgramName() {  
        return programName;  
    }  

    public Set<Course> getCourses() {  
        return courses;  
    }  

    public void addCourse(Course course) {  
        courses.add(course);  
    }  
} 
public class AggregationExample2 {
    
}
