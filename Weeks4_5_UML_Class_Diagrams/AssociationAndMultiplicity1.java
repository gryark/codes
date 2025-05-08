package Weeks4_5_UML_Class_Diagrams;
import java.util.ArrayList;  
import java.util.List; 

// This class is a placeholder for the Association and Multiplicity example

/****ONE to ONE */
// It demonstrates a one-to-one relationship between Company and BoardOfDirectors classes

//Company ve BoardOfDirectors sınıfları arasında bir "bir-bir" ilişkisini (one-to-one relationship) tanımlıyor.
 class Company {  
    private String name;  
    private BoardOfDirectors board; // Her şirketin bir yönetim kurulu vardır  

    public Company(String name) {  
        this.name = name;  
        this.board = new BoardOfDirectors(this); // Şirket oluşturulurken bir yönetim kurulu da oluşturulur  
    }  

    public String getName() {  
        return name;  
    }  

    public BoardOfDirectors getBoard() {  
        return board;  
    }  
}  

 class BoardOfDirectors {  
    private String name;  
    private Company company; // Her yönetim kurulunun bağlı olduğu bir şirket vardır  

    public BoardOfDirectors(Company company) {  
        this.company = company;  
        this.name = "Board of " + company.getName(); // Yönetim kurulu ismi şirket ismi ile tanımlı  
    }  

    public String getName() {  
        return name;  
    }  

    public Company getCompany() {  
        return company;  
    }  
}  

/******MANY to MANY */

// Sekreter sınıfı  
 class Secretary {  
    private String name;  
    private List<Manager> managers; // Sekreterin çalıştığı yöneticiler  

    public Secretary(String name) {  
        this.name = name;  
        this.managers = new ArrayList<>();  
    }  

    public void addManager(Manager manager) {  
        managers.add(manager);  
        manager.addSecretary(this); // İlişkiyi iki yönlü hale getir  
    }  

    public String getName() {  
        return name;  
    }  

    public List<Manager> getManagers() {  
        return managers;  
    }  
}  

// Yönetici sınıfı  
 class Manager {  
    private String name;  
    private List<Secretary> secretaries; // Yöneticinin çalıştırdığı sekreterler  

    public Manager(String name) {  
        this.name = name;  
        this.secretaries = new ArrayList<>();  
    }  

    public void addSecretary(Secretary secretary) {  
        secretaries.add(secretary);  
    }  

    public String getName() {  
        return name;  
    }  

    public List<Secretary> getSecretaries() {  
        return secretaries;  
    }  
} 


/******ONE to MANY */
// Araç sınıfı  
 class Car {  
    private String brand;  
    private Person owner; // Aracın sahibi olan kişi  

    public Car(String brand, Person owner) {  
        this.brand = brand;  
        this.owner = owner;  
    }  

    public String getBrand() {  
        return brand;  
    }  

    public Person getOwner() {  
        return owner;  
    }  
}

class Person {  
    private String name;  
    private List<Car> cars; // Kişinin sahip olduğu araçlar  

    public Person(String name) {  
        this.name = name;  
        this.cars = new ArrayList<>();  
    }  

    public void addCar(Car car) {  
        cars.add(car);  
    }  

    public String getName() {  
        return name;  
    }  

    public List<Car> getCars() {  
        return cars;  
    }  
}

/*************One to Many İkinci Örnek */
// Office sınıfı  
 class Office {  
    private String name;  
    private List<Employee> allocatedEmployees; // Çalışanları tutmak için bir liste  

    public Office(String name) {  
        this.name = name;  
        this.allocatedEmployees = new ArrayList<>();  
    }  

    public void allocateEmployee(Employee employee) {  
        allocatedEmployees.add(employee);  
        employee.setOffice(this); // Çalışanın ofisi atanıyor  
    }  

    public String getName() {  
        return name;  
    }  

    public List<Employee> getAllocatedEmployees() {  
        return allocatedEmployees;  
    }  
}  

// Employee sınıfı  
 class Employee {  
    private String name;  
    private Office office; // Çalışanın bağlı olduğu ofis  

    public Employee(String name) {  
        this.name = name;  
    }  

    public void setOffice(Office office) {  
        this.office = office;  
    }  

    public String getName() {  
        return name;  
    }  

    public Office getOffice() {  
        return office;  
    }  
}  

public class AssociationAndMultiplicity1 {

// Örnek kullanım
public static void main(String[] args) {
    // Şirketleri oluşturma -> One to One Örneği

    Company companyA = new Company("Tech Corp");  
    Company companyB = new Company("Creative Inc");  

    // Company Sınıfı: Her Company nesnesinin bir BoardOfDirectors nesnesi vardır. Bu, şirket oluşturulurken otomatik olarak oluşturulur.
    // BoardOfDirectors Sınıfı: Her BoardOfDirectors nesnesi, ona bağlı bir Company nesnesine sahiptir.

    System.out.println(companyA.getName() + "'s " + companyA.getBoard().getName());  
    System.out.println(companyB.getName() + "'s " + companyB.getBoard().getName()); 

    // -----------------------------------
    // Sekreter ve yönetici arasındaki ilişkiyi gösteren sınıflar -> Many to Many Örneği
    // Sekreterleri ve yöneticileri oluşturma
    // Yeni sekreter ve yönetici oluştur  
    Secretary secretary1 = new Secretary("Bob");  
    Secretary secretary2 = new Secretary("Charlie");  
    
    Manager manager1 = new Manager("Alice");  
    Manager manager2 = new Manager("David");  

    // Sekreterleri yöneticilere ekle  
    secretary1.addManager(manager1);  
    secretary1.addManager(manager2);  
    
    secretary2.addManager(manager1);  

    // Çıktı  
    System.out.println(secretary1.getName() + " works for: ");  
    for (Manager manager : secretary1.getManagers()) {  
        System.out.println(" - " + manager.getName());  
    }  

    System.out.println(secretary2.getName() + " works for: ");  
    for (Manager manager : secretary2.getManagers()) {  
        System.out.println(" - " + manager.getName());  
    }  

    System.out.println(manager1.getName() + " has secretaries: ");  
    for (Secretary secretary : manager1.getSecretaries()) {  
        System.out.println(" - " + secretary.getName());  
    } 
    
    /*Açıklamalar:
        Secretary Sınıfı: Her Secretary nesnesinin birden fazla yönetici ile ilişkisi vardır. addManager metodu ile bir yönetici sefere eklenir ve bu ilişki iki yönlü hale getirilir.
        Manager Sınıfı: Her Manager nesnesinin birden fazla sekreteri vardır. 
    */

    // -----------------------------------
    // Araç ve kişi arasındaki ilişkiyi gösteren sınıflar -> One to Many Örneği
    // Araçları ve kişileri oluşturma
   
    Person person1 = new Person("Eve");
    Person person2 = new Person("Frank");

    Car car1 = new Car("Toyota", person1);
    Car car2 = new Car("Honda", person2);
    Car car3 = new Car("Ford", person1);
   

    // Office sınıfı ve çalışanları oluşturma -> One to Many Örneği -2
    Office office = new Office("Main Office");  
    Employee employee1 = new Employee("Alice");  
    Employee employee2 = new Employee("Bob");  

        // Çalışanları ofise tahsis etme  
    office.allocateEmployee(employee1);  
    office.allocateEmployee(employee2);  

    // Ofisin çalışanlarını yazdırma  
    System.out.println("Employees allocated to " + office.getName() + ":");  
    for (Employee emp : office.getAllocatedEmployees()) {  
            System.out.println(" - " + emp.getName());  
    }  

    /*
     * Office Sınıfı:

        allocatedEmployees adında bir liste tanımlar. Bu liste ofisteki çalışanları tutar.
        allocateEmployee metodu, verilen çalışanı ofise tahsis eder ve çalışanın ofisini ayarlar.
        Employee Sınıfı:

        Her Employee nesnesinin bir Office nesnesi ile ilişkisi vardır. Çalışanın bağlı olduğu ofis, setOffice metodu ile atanır.
     */


}

    
}
