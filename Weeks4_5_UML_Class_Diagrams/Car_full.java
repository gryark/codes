package Weeks4_5_UML_Class_Diagrams;

public class Car {

        // Özellikler  
        private String code;               // -code : String  
        private float maxSpeed = 90.0f;    // -maxSpeed : float = 90.0  
        private int length = 60;           // -length : integer = 60  
        public int defaultLength = 80; // +defaultLength : integer = 80  
        protected float velocity = 30.0f;   // #velocity : float = 30.0  
    
        // Constructor  
        public Car(String code) {  
            this.code = code;  
        }  
    
        // Metodlar  
        public float computeSpeed() {  
            // Hız hesaplama mantığı (örnek)  
            return maxSpeed - (velocity / 2);  
        }  
    
        private boolean isStopped() {  
            // Arabanın durup durmadığını kontrol et  
            return velocity <= 0;  
        }  
    
        private static float defaultSpeed(int trainType) {  
            // Varsayılan hız hesaplama mantığı (örnek)  
            return trainType * 10.0f;  
        }  
    
        protected float readFromDB(String dbID) {  
            // Veritabanından okuma mantığı (örnek)  
            System.out.println("Reading from DB with ID: " + dbID);  
            return 0.0f; // Örnek geri dönüş  
        }  
    
        // Diğer metodlar (gerekirse) buraya eklenebilir  
   
}
