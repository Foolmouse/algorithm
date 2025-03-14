package main.java.net.coding;

public class HashExample {
    public static void main(String[] args) {
        String key = "example";
        int h = key.hashCode();
        // 原始哈希码
        System.out.println("Original hash code: " + Integer.toBinaryString(h)); 
        int hash = (h = key.hashCode()) ^ (h >>> 16);
        // 扰动后的哈希码
        System.out.println("Perturbed hash code: " + Integer.toBinaryString(hash)); 
    }
}