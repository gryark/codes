package Weeks6_7_;



// University üst sınıfı (abstract olabilir)  
 abstract class University {  
    private String name;  

    public University(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

// UniversityA alt sınıfı  
 class UniversityA extends University {  
    public UniversityA(String name) {  
        super(name);  
    }  
}  

// UniversityB alt sınıfı  
 class UniversityB extends University {  
    public UniversityB(String name) {  
        super(name);  
    }  
}  

// Student sınıfı  
 class Student {  
    private String name;  

    public Student(String name) {  
        this.name = name;  
    }  

    // apply metodu: student ya University'ye ya da alt sınıflara başvurur  
    public void apply(University university) {  
        System.out.println(name + " applied to " + university.getName());  
    }  
}  

// Kullanım örneği  
public class UniversityApplyExample {
    

    public static void main(String[] args) {  
        Student student = new Student("Ali");  

        UniversityA universityA = new UniversityA("University A");  
        UniversityB universityB = new UniversityB("University B");  

        // Öğrenci üniversitelere başvuru yapıyor  
        student.apply(universityA);  
        student.apply(universityB);  
    }  
}