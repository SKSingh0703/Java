import java.util.*;
public class diamondpattern{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of lines:");
        int n=sc.nextInt();
        int y=n/2;
        for(int i=1;i<=n;i++){
            if(i<=y){
                for(int j=1;j<=y-i+1;j++){
                    System.out.print(" ");
                }
                for(int k=1;k<=2*i-1;k++){
                    System.out.print("*");
                }
            }
            else{
                for(int l=1;l<=i-y;l++){
                    System.out.print(" ");
                }
                for(int m=1;m<=n-2*(i-y)+1;m++){
                    System.out.print("*");
                }
            }
          
            System.out.println();
        }
        sc.close();
    }
}
