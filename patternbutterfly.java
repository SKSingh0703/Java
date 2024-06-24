import java.util.*;

public class patternbutterfly {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of lines:");
        int n=sc.nextInt();
        // int x=1;
        int y=n/2;
        for(int i=1;i<=n;i++){
            if(i<=y){
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                for(int k=1;k<=n-2*i;k++){
                    System.out.print(" ");
                }
                for(int l=1;l<=i;l++){
                    System.out.print("*");
                }
            }
            else{
                int z=i-y;
                for(int m=1;m<=y-z+1;m++){
                    System.out.print("*");
                }
                for(int o=1;o<=2*z-2;o++){
                    System.out.print(" ");
                }
                for(int p=1;p<=y-z+1;p++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
