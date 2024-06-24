import java.util.*;
public class productfunction {
    public static int product(int x,int y){
        int z=x*y;
        return z;
    }
    public static int fac(int n){
        int product=1;
        for(int i=1;i<=n;i++){
            product=product*i;
        }
        return product;
    }
    public static int binomial(int n,int r){
        int fact_n=fac(n);
        int fact_r=fac(r);
        int fact_n_r=fac(n-r);
        int binomialfactorial=fact_n/(fact_r*fact_n_r);
        return binomialfactorial;
    }
    public static void prime(int n){
        boolean flag=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag=false;
                break;
            }
        }
        if(n==1){
            System.out.println("1is neither odd nor even");
        }
        else if(flag==true){
            System.out.println("Enterd number is prime");
        }
        else{
            System.out.println("Entered number is not prime");
        }
        return;
    }
    public static boolean isprime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int binarytodecimal(int binary){
        int decimal=0,power=0;
        while(binary>0){
            decimal=decimal+(binary%10)*((int)Math.pow(2,power));
            power++;
            binary=binary/10;
        }
        return decimal;
    }
    public static int decimaltobinary(int decimal){
        int binary=0,remainder=0,power=0;
        while(decimal>0){
            remainder=decimal%2;
            binary=binary + remainder*((int)Math.pow(10,power));
            decimal=decimal/2;
            power++;
        }
        return binary;
    }
    public static int average(int a,int b,int c){
        return (a+b+c)/3;
    }
    public static void isEven(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First number:");
        int a=sc.nextInt();
        if(a%2==0){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        sc.close();
    }
    public static void palindrome(int n){
        int x=0,y=n;
        while(n>0){
            x=x*10+n%10;
            n=n/10;
        }
        if(x==y) System.out.print("Palindrome");
        else System.out.print("Not Palindrome");
    }
    public static void sumofdigits(int n){
        int count=0;
        while(n>0){
            count=count+n%10;
            n=n/10;
        }
        
        System.out.println("The Sum of the digits of the entered number is:"+count);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First number:");
        int a=sc.nextInt();
        // System.out.println("Enter Second number:");
        // int b=sc.nextInt();
        // // int c=product(a, b);
        // // System.out.println("The Product of the two numbers is:"+ c);
        // int bifac=binomial(a, b);
        // System.out.println("Binary of the entered decimal is:"+decimaltobinary(a));
        // prime(a);
        // for(int i=2;i<=a;i++){
        //     boolean b=isprime(i);
        //     if(b==true){
        //         System.out.println(i);
        //     }
        //     else{
        //         continue;
        //     }
        // }
        // System.out.println(123%10);
        // if(a%2==0){
        //     System.out.print("Even");
        // }
        // else System.out.println("odd");
        // isEven();
        // palindrome(a);
        sumofdigits(a);
        sc.close();
    }
}
