import java.util.*;

public class hollowrhombus {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of lines:");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(" ");
            }
            if(i==1 || i==n){
                for(int k=1;k<=n;k++){
                    System.out.print("*");
                }
            }
            else{
                for(int l=1;l<=n;l++){
                    if(l==1 || l==n){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
