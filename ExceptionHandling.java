import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// public class ExceptionHandling {
    public class ExceptionHandling {
        public static void main(String args[]) throws IOException {
        if (args.length == 0) {
            System.out.println("Please provide a file path as a command-line argument.");
            return;
        }

        File f = new File(args[0]);
        byte[] b;

        if (f.exists()) {
            FileInputStream f1 = new FileInputStream(f);
            int num = f1.available(); // Number of bytes in the file
            b = new byte[num];        // Allocate byte array to hold the content
            int n = f1.read(b);       // Read content into byte array
            String s = new String(b); // Convert byte array to String
            
            System.out.println("Contents of " + args[0] + ": " + s);
            
            f1.close(); // Close the file input stream
            f = null;   // Dereference the file object (not necessary, but shown here)
        } else {
            System.out.println("File does not exist");
        }
    }
        public static void throwException() throws Exception {
            try {
                System.out.println("Method throwException");
                throw new Exception(); // Explicitly throwing an exception
            } catch (RuntimeException runtimeException) {
                System.out.println("Exception handled in method throwException");
            } finally {
                System.out.println("Finally is always executed");
            }
        }
    
        static void method1() {
            try {
                System.out.println("In method1");
                throw new NullPointerException();
            } catch (Exception e) {
                System.out.println("Exception handled: " + e);
            } finally {
                System.out.println("In method1 finally");
            }
        }
    
        static int method2(int a, int b) {
            try {
                return a / b; // This will throw an ArithmeticException if b is 0
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException handled in method2: " + e);
                return -1; // Return a default value when an exception occurs
            } finally {
                System.out.println("In method2 finally");
            }
        }
    }
    


