package Weeks4_5_UML_Class_Diagrams;


// 5 bina içeren bir yurt sınıfı
// Yurt sınıfı, içindeki binaları temsil eden bir iç sınıf içerir
// Yurt sınıfı, binaları oluşturur ve yazdırır
 class Dorm {  
    private Building[] mybuilds = new Building[5]; // 5 bina içeren dizi  

    // Constructor  
    public Dorm() {  
        for (int i = 0; i < mybuilds.length; i++) {  
            mybuilds[i] = new Building("Building " + (i + 1)); // Binaları oluştur  
        }  
    }  

    // Binaların bilgilerini yazdıran metot  
    public void printBuildings() {  
        for (Building building : mybuilds) {  
            System.out.println(building.getName());  
        }  
    }  

    // İçteki (inner) sınıf  
    class Building {  
        private String name;  

        public Building(String name) {  
            this.name = name;  
        }  

        public String getName() {  
            return name;  
        }  
    }  

    // Alternatif: Statik iç sınıf  
    /*  
    static class Building {  
        private String name;  

        public Building(String name) {  
            this.name = name;  
        }  

        public String getName() {  
            return name;  
        }  
    }  
    */  

    
}
public class CompositionExample1 {
   // Örnek kullanım  
   public static void main(String[] args) {  
        Dorm dorm = new Dorm();  
        dorm.printBuildings();  // Binaları yazdır  
    }   
}

/*
 * Açıklamalar:
Dorm Sınıfı: mybuilds adlı bir Building dizisi içerir. Bu dizide 5 adet bina oluşturulmaktadır.
Building Sınıfı: Dorm sınıfının iç sınıfı olarak tanımlanmıştır ve her bina için bir isim tutar.
printBuildings Metodu: Dorm içindeki tüm binaları yazdıran bir metot.
Alternatif Statik İç Sınıf:
Building sınıfı, Dorm sınıfının statik iç sınıfı olarak da tanımlanabilir. Bu durumda, Building sınıfı Dorm dışında bağımsız olarak tanımlanabilir.
Bu yapı, UML diyagramındaki bileşim ilişkisini başarıyla yansıtmaktadır.
 */
