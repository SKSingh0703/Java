import java.util.*;
public class test {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int nt,x,y;
        
        // int count=0;

        // nt=sc.nextInt();
        // for(int i=0;i<nt;i++){
        //     count=0;
        //     x=sc.nextInt();
        //     y=sc.nextInt();
        //     while(y>0){
        //         y=y-x;
        //         count++;
        //     }
        //     System.out.println(count);
        // }
        // sc.close();

        // Scanner sc=new Scanner(System.in);
        // int n;
        // n=sc.nextInt();
        // int count=0;
        // for(int i=2;i<n;i++){
        //     if(n%i==0){
        //         count++;
        //     }
        // }

        // if(count>0){
        //     System.out.println("YES");
        // }
        // else{
        //     System.out.println("NO");
        // }
        // sc.close();

        // Scanner sc=new Scanner(System.in);
        // int n,d;
        
        // n=sc.nextInt();
        // d=sc.nextInt();

        // int arr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }

        // int count=0;
        // for(int i=1;i<n;i++){
        //     if(arr[i]<=arr[i-1]){
        //         while(arr[i]<arr[i-1]){
        //             arr[i]+=d;
        //             count++;
        //         }
        //     }
            
        // }
        // System.out.println(count);
        // sc.close();

        // Scanner sc=new Scanner(System.in);
       
        // Scanner sc=new Scanner(System.in);
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
        int arr[]=new int[n-1];
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



