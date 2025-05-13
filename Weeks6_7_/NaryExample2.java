package Weeks6_7_;

// Client sınıfı  
class Client {  
    private String name;  

    public Client(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  
}  

// Shop sınıfı  
 class Shop {  
    private String shopName;  

    public Shop(String shopName) {  
        this.shopName = shopName;  
    }  

    public String getShopName() {  
        return shopName;  
    }  
}  

// Bank sınıfı  
 class Bank {  
    private String bankName;  

    public Bank(String bankName) {  
        this.bankName = bankName;  
    }  

    public String getBankName() {  
        return bankName;  
    }  
}  

// Üçlü ilişki sınıfı: CreditCard  
 class CreditCard {  
    private Client client;  
    private Shop shop;  
    private Bank bank;  
    private String cardNumber;  
    private String expirationDate;  

    public CreditCard(Client client, Shop shop, Bank bank, String cardNumber, String expirationDate) {  
        this.client = client;  
        this.shop = shop;  
        this.bank = bank;  
        this.cardNumber = cardNumber;  
        this.expirationDate = expirationDate;  
    }  

    public Client getClient() {  
        return client;  
    }  

    public Shop getShop() {  
        return shop;  
    }  

    public Bank getBank() {  
        return bank;  
    }  

    public String getCardNumber() {  
        return cardNumber;  
    }  

    public String getExpirationDate() {  
        return expirationDate;  
    }  

    @Override  
    public String toString() {  
        return "CreditCard{" +  
                "client=" + client.getName() +  
                ", shop=" + shop.getShopName() +  
                ", bank=" + bank.getBankName() +  
                ", cardNumber='" + cardNumber + '\'' +  
                ", expirationDate='" + expirationDate + '\'' +  
                '}';  
    }  
}


public class NaryExample2 {
    public static void main(String[] args) {  
        Client client = new Client("Ahmet");  
        Shop shop = new Shop("SuperMarket");  
        Bank bank = new Bank("Best Bank");  

        CreditCard creditCard = new CreditCard(client, shop, bank, "1234-5678-9012-3456", "12/27");  

        System.out.println(creditCard);  
    } 
    
}
