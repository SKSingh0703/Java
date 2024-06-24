import java.util.*;
public class javabasics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First number:\n");
        int a=sc.nextInt();
        System.out.print("Enter Second number:\n");
        int b=sc.nextInt();
        int c=a+b;
        System.out.print("The Sum of the two numbers is:");
        System.out.print(c);
        sc.close();
    }
}