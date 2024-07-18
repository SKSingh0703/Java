import java.util.Scanner;

public class ciofioandfiunofiweoivn {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++){
            int n=sc.nextInt();
            int x=2;
            int arr[]=new int[n];
            arr[0]=1;
            for(int i=2;i<=n;i++){
                if (isPrime(i)) {
                    arr[i]=x;
                }
                else{
                    arr[i]=++x;
                }
            }
            
            System.out.println(x);
            System.out.println();
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
