import java.util.*;
public class OOPS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Complex c1=new Complex();
        Complex c2=new Complex();
        System.out.println("Enter Real Part of the first number:");
        c1.r=sc.nextInt();
        System.out.println("Enter Imaginary Part of the first number:");
        c1.im=sc.nextInt();
        System.out.println("Enter Real Part of the second number:");
        c1.r=sc.nextInt();
        System.out.println("Enter Imaginary Part of the second number:");
        c2.im=sc.nextInt();
        Complex.add(c1,c2);
        Complex.difference(c1, c2);
        Complex.product(c1, c2);
        sc.close();
    }
}

class Complex{
    int r;
    int im;

    static void add(Complex c1,Complex c2){
        int realpart =c1.r+c2.r;
        int imaginarypart =c1.im+c2.im; 
        System.out.println("The sum of the two imaginary numbers is :"+"( "+realpart+"+"+"i"+imaginarypart+" )");

    }
    static void difference(Complex c1,Complex c2){
        int realpart =c1.r+c2.r;
        int imaginarypart =c1.im+c2.im;
        System.out.println("The difference of the two imaginary numbers is :"+"( "+realpart+"+"+"i"+imaginarypart+" )");
    }
    static void product(Complex c1,Complex c2){
        int realpart =c1.r*c2.r-c1.im*c2.im;
        int imaginarypart =c1.r*c2.im+c1.im*c2.r;
        System.out.println("The product of the two imaginary numbers is :"+"( "+realpart+"+"+"i"+imaginarypart+" )");
    }
}
// c   c   
