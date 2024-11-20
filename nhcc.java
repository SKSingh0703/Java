public class nhcc {
    public static void main(String[] args) {
        int age = 15;
        
        // Check the condition
        assert age >= 18 : "Age must be 18 or older to proceed.";
        
        System.out.println("Age is valid.");
    }
}
