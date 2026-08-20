import java.util.*;

public class Solution{

    public static int helper(int idx , int k , String str , int dp[][]){
        int n = str.length();
        if(idx>=n){
            return 0;
        }

        if(dp[idx][k]!=-1){
            return dp[idx][k];
        } 

        //take 
        int ans = helper(idx+1, k, str, dp) +
                ( 
                    ( idx!=0 && str.charAt(idx-1)==str.charAt(idx)) 
                    ? 0: 1 
                );
        
        if(k>0 && idx>0 && idx<n-1){
            
            int extra = (str.charAt(idx-1)==str.charAt(idx+1))?0:1;
            
            int curr = helper(idx+2, k-1, str, dp) + extra;
            
            ans = Math.min( ans , curr);
        }
        
        return dp[idx][k]=ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0) {
            int n = sc.nextInt();
            String str = sc.next();

            int dp[][] = new int[n][2];
            for(int[] a : dp) Arrays.fill(a,-1);

            int ans = helper(0, 1, str, dp);

            System.out.println(ans);
        }


        sc.close();
    }
}

// import java.util.*;

// public class Solution{

//     public static int helper(int idx , int k , int a[] , int dp[][]){
//         int n = a.length;
//         if(idx==n){
//             return 0;
//         }

//         if(dp[idx][k]!=-1){
//             return dp[idx][k];
//         }

//         //take 
//         int ans = helper(idx+1, k, a, dp) +
//                 ( (idx!=n-1)?Math.abs(a[idx]-a[idx+1]) : 0 );
        
//         if(k>0){
//             int curr =
//                 ( (idx==0 || idx==n-1)?0 : Math.abs( a[idx-1] - a[idx+1]) )
//                 - 
//                 (idx==0?0:Math.abs( a[idx-1] - a[idx]))
//                 + 
//                 helper(idx+1, k-1, a, dp);
            
//             ans = Math.min( ans , curr);
//         }
//         //skip
        
//         return dp[idx][k]=ans;
//     }
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);

//         int t = sc.nextInt();

//         while (t-->0) {
//             int n = sc.nextInt();
//             int a[] =new int[n];

//             for(int i = 0 ; i<n ; i++){
//                 a[i] = sc.nextInt();
//             }

//             int dp[][] = new int[n][2];
//             for(int[] arr : dp) Arrays.fill( arr , -1);
            
//             int ans = helper(0, 1, a, dp);

//             System.out.println(ans);
//         }


//         sc.close();
//     }
// }

// public class Solution{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         long count = 0;

//         for(long i = 1 ; i<=n ;i++){
//             for(long j = 1 ; j<= n ; j++){
//                 long curr = i*i + j*j;

//                 if(curr%m==0){
//                     count++;
//                 }
//             }
//         }

//         System.out.println(count);

//         sc.close();
//     }
// }

// public class Solution{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
        //         int n = sc.nextInt();
        //         boolean prev[] = new boolean[101];
        //         Arrays.fill(prev , true);            
        //         for(int i = 0 ; i<n ; i++){
        //             int r = sc.nextInt();                 
        //             boolean curr[] = new boolean[101]
        //             for(int j = 0; j<r ;j++){
        //                 int x = sc.nextInt();

        //                 if(prev[x]){
        //                     curr[x] = true;
        //                 }
        //             }

        //             prev = curr;
        //         }

        //         for(int i = 1 ; i<=100 ; i++){
        //             if(prev[i]){
        //                 System.out.print(i+" ");
        //             }
        //         }

        //         sc.close();
        //     }
        // }