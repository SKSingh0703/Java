import java.util.Scanner;

public class newwegwe {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        System.out.println("Enter till where required:");
        int x=sc.nextInt();
        for(int i=1;i<=x;i++){
            for(int j=1;j<=x-i+1;j++){
                
                System.out.print(" ");
            }
            // for(int j=0;j<)
            
            System.out.println();
        }
        sc.close();
    }

}
