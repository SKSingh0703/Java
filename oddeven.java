import java.util.*;
public class oddeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evennumber=0,oddnumber=0,n;
        do{
            System.out.println("Enter Number");
            n=sc.nextInt();
            if(n%2==0){
                evennumber+=n;
            }
            else{
                oddnumber+=n;
            }
            System.out.println("The Sum of even numbers entered is:"+ evennumber);
            System.out.println("The Sum of odd numbers entered is:"+ oddnumber);
            System.out.println("\n \nPress 0 to Exit the program else enter next number ");
        }while(n!=0);
        sc.close();
    }
}
