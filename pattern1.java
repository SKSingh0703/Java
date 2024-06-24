import java.util.*;
public class pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the rectangle");
        int l=sc.nextInt();
        System.out.println("Enter breadth of the rectangle");
        int b=sc.nextInt();
        for(int i=1;i<=b;i++){
            if(i==1 || i==b){
                for(int j=1;j<=(l);j++){
                System.out.print('*');
                }
            }
            else{
                for(int j=1;j<=(l);j++){
                    if(j==1 || j==l){
                        System.out.print('*');
                    }
                    else{
                        System.out.print(' ');
                    }
            }
            }
            System.out.print("\n");
        }
        sc.close();
    }
}
