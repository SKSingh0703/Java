import java.util.Arrays;
import java.util.Scanner;

public class testcssss {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        int count=0;
        Arrays.sort(a);
        Arrays.sort(b);
        int arr[]=new int[45];
        for(int i=0;i<n;i++){
            arr[b[i]]++;
        }
        for(int i=0;i<n;i++){
            if(arr[a[i]]>0){
                count=count+arr[a[i]];
            }
        }
        System.out.println(count);
        sc.close();
    }
}
