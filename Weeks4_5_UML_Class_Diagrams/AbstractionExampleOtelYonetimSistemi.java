package Weeks4_5_UML_Class_Diagrams;

import java.util.ArrayList;  
import java.util.List;  

/*
 * Açıklamalar:
Hotel Sınıfı: Nitelikleri olarak name ve guests listesi barındırıyor. Misafirlerin eklenmesi için bir metot içeriyor.

Guest Sınıfı: Her misafirin kendine ait ödemeleri ve harcamaları bulunuyor. staysAt, makePayment, ve addExpense metodları ile ilişkiler yönetiliyor.

Expense Sınıfı: Harcama ile ilgili açıklama ve miktarı içeriyor.

Payment Sınıfı: Ödeme miktarını tutuyor.
 */

// Hotel sınıfı  
 class Hotel {  
    private String name;  
    private List<Guest> guests; // Otelde kalan misafirler  

    public Hotel(String name) {  
        this.name = name;  
        this.guests = new ArrayList<>();  
    }  

    public void addGuest(Guest guest) {  
        guests.add(guest);  
        guest.staysAt(this); // Misafiri otele ekle  
    }  

    public String getName() {  
        return name;  
    }  

    public List<Guest> getGuests() {  
        return guests;  
    }  
}  

// Guest sınıfı  
 class Guest {  
    private String name;  
    private Hotel hotel; // Misafirin kaldığı otel  
    private List<Payment> payments; // Misafirin yaptığı ödemeler  
    private List<Expense> expenses; // Misafirin yaptığı harcamalar  

    public Guest(String name) {  
        this.name = name;  
        this.payments = new ArrayList<>();  
        this.expenses = new ArrayList<>();  
    }  

    public void staysAt(Hotel hotel) {  
        this.hotel = hotel;  
    }  

    public void makePayment(Payment payment) {  
        payments.add(payment);  
    }  

    public void addExpense(Expense expense) {  
        expenses.add(expense);  
    }  

    public List<Payment> getPayments() {  
        return payments;  
    }  

    public List<Expense> getExpenses() {  
        return expenses;  
    }  

    public String getName() {  
        return name;  
    }  
}  

// Expense sınıfı  
class Expense {  
    private String description;  
    private double amount;  

    public Expense(String description, double amount) {  
        this.description = description;  
        this.amount = amount;  
    }  

    public String getDescription() {  
        return description;  
    }  

    public double getAmount() {  
        return amount;  
    }  
}  

// Payment sınıfı  
class Payment {  
    private double amount;  

    public Payment(double amount) {  
        this.amount = amount;  
    }  

    public double getAmount() {  
        return amount;  
    }  
}  

// Örnek kullanım  

public class AbstractionExampleOtelYonetimSistemi {
    public static void main(String[] args) {  
        // Otel oluşturma  
        Hotel hotel = new Hotel("Grand Hotel");  

        // Misafir oluşturma  
        Guest guest1 = new Guest("Alice");  
        Guest guest2 = new Guest("Bob");  

        // Misafirleri otele ekleme  
        hotel.addGuest(guest1);  
        hotel.addGuest(guest2);  

        // Harcama ekleme  
        Expense expense1 = new Expense("Room Service", 50.0);  
        guest1.addExpense(expense1);  

        // Ödeme yapma  
        Payment payment1 = new Payment(50.0);  
        guest1.makePayment(payment1);  

        // Çıktıları yazdırma  
        System.out.println(guest1.getName() + " stays at " + hotel.getName() + ".");  
        System.out.println(guest1.getName() + "'s expenses: ");  
        for (Expense expense : guest1.getExpenses()) {  
            System.out.println(" - " + expense.getDescription() + ": $" + expense.getAmount());  
        }  
    }  

}
