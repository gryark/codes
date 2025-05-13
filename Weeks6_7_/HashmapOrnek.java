package Weeks6_7_;

import java.util.HashMap;  
import java.util.Map;  

public class HashmapOrnek<E> {  
    private Map<E, Integer> map = new HashMap<>();  

    // Eleman ekleme (eleman sayısını artırır)  
    public void add(E element) {  
        map.put(element, map.getOrDefault(element, 0) + 1);  
    }  

    // Eleman sayısını alma  
    public int count(E element) {  
        return map.getOrDefault(element, 0);  
    }  

    // Elemanı tamamen kaldırma  
    public void remove(E element) {  
        map.remove(element);  
    }  

    // Elemanı bir kez çıkarma (sayacı azaltma)  
    public boolean removeOne(E element) {  
        Integer count = map.get(element);  
        if (count == null) {  
            return false;  
        }  
        if (count == 1) {  
            map.remove(element);  
        } else {  
            map.put(element, count - 1);  
        }  
        return true;  
    }  

    // Toplam farklı eleman sayısı (unique)  
    public int uniqueSize() {  
        return map.size();  
    }  

    // Toplam eleman sayısı (tekrarlı)  
    public int size() {  
        int total = 0;  
        for (int count : map.values()) {  
            total += count;  
        }  
        return total;  
    }  

    @Override  
    public String toString() {  
        return map.toString();  
    }  

    // Test  
    public static void main(String[] args) {  
        HashmapOrnek<String> bag = new HashmapOrnek<>();  

        bag.add("apple");  
        bag.add("banana");  
        bag.add("apple");  
        bag.add("orange");  
        bag.add("banana");  
        bag.add("apple");  

        System.out.println("Bag içeriği: " + bag);                  // {orange=1, banana=2, apple=3}  
        System.out.println("apple sayısı: " + bag.count("apple"));  // 3  
        System.out.println("Toplam eleman sayısı: " + bag.size());  // 6  
        System.out.println("Unique eleman sayısı: " + bag.uniqueSize()); // 3  

        bag.removeOne("apple");  
        System.out.println("1 adet apple çıkarıldı: " + bag);  

        bag.remove("banana");  
        System.out.println("banana tamamen çıkarıldı: " + bag);  
    }  
}