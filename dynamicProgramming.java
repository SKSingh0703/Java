import java.util.ArrayList;

public class dynamicProgramming {
    // public static int knapsackhelpermemorization(int val[],int wt[],int w,int i,int dp[][]){
    //     if(i==0 || w==0){
    //         return 0;
    //     }
    //     if(dp[i][w]!=-1){
    //         return dp[i][w];
    //     }
    //     if(wt[i-1]<=w){
    //         int ans1=val[i-1] +knapsackhelpermemorization(val, wt, w-wt[i-1], i-1, dp);
    //         int ans2=knapsackhelpermemorization(val, wt, w, i-1, dp);
    //         dp[i][w]=Math.max(ans1, ans2);
    //         return dp[i][w];
    //     }
    //     else{
    //         dp[i][w]=knapsackhelpermemorization(val, wt, w, i-1, dp);
    //         return dp[i][w];
    //     }
    // }
    // public static void knapsackMemorization(int wt[],int val[],int w){
    //     int dp[][]=new int[val.length+1][w+1];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<dp[0].length;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     int ans=knapsackhelpermemorization(val, wt, w, val.length, dp);
    //     System.out.println("The max value is:"+ans);
    // }

    // //Time complexity of O(nW) lesser time comparitively
    // public static void knapsackTabulation(int wt[],int val[],int w){
    //     int dp[][]=new int[wt.length+1][w+1];
    //     for(int i=0;i<dp.length;i++){
    //         dp[i][0]=0;
    //     }
    //     for(int j=0;j<dp[0].length;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<dp.length;i++){
    //         for(int j=1;j<dp[0].length;j++){
    //             int weight=wt[i-1];
    //             int v=val[i-1];
    //             if(weight<=j){
    //                 int inc=v+dp[i-1][j-weight];
    //                 int exc=dp[i-1][j];
    //                 dp[i][j]=Math.max(inc, exc);
    //             }
    //             else{
    //                 dp[i][j]=dp[i-1][j];
    //             }
    //         }
    //     }
    //     System.out.println(dp[wt.length][w]);
    // }
    // public static void targetSum(int num[],int t){
    //     boolean dp[][]=new boolean[num.length+1][t+1];
    //     for(int i=0;i<dp.length;i++){
    //         dp[i][0]=true;
    //     }
    //     for(int i=1;i<dp.length;i++){
    //         for(int j=1;j<dp[0].length;j++){
    //             int v=num[i-1];
    //             if(v<=j && dp[i-1][j-v]==true){
    //                 dp[i][j]=true;
    //             }
    //             else if(dp[i-1][j]==true) dp[i][j]=true;
    //         }
    //     }
    //     System.out.println(dp[num.length][t]);
    // }
    // public static void unboundedKnapsack(int wt[],int val[],int w){
    //     int dp[][]=new int[wt.length+1][w+1];
    //     for(int i=0;i<dp.length;i++){
    //         dp[i][0]=0;
    //     }
    //     for(int j=0;j<dp[0].length;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<dp.length;i++){
    //         for(int j=1;j<dp[0].length;j++){
    //             int weight=wt[i-1];
    //             int v=val[i-1];
    //             if(weight<=j){
    //                 int inc=v+dp[i][j-weight];
    //                 int exc=dp[i-1][j];
    //                 dp[i][j]=Math.max(inc, exc);
    //             }
    //             else{
    //                 dp[i][j]=dp[i-1][j];
    //             }
    //         }
    //     }
    //     print(dp);
    //     System.out.println(dp[wt.length][w]);
    // }
    // public static void coinchange(int wt[],int w){
    //     int dp[][]=new int[wt.length+1][w+1];
    //     for(int i=0;i<dp.length;i++){
    //         dp[i][0]=1;
    //     }
    //     for(int j=1;j<dp[0].length;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<dp.length;i++){
    //         for(int j=1;j<dp[0].length;j++){
    //             int weight=wt[i-1];
    //             if(weight<=j){
    //                 int inc=dp[i][j-weight];
    //                 int exc=dp[i-1][j];
    //                 dp[i][j]=inc+exc;
    //             }
    //             else{
    //                 dp[i][j]=dp[i-1][j];
    //             }
    //         }
    //     }
    //     System.out.println(dp[wt.length][w]);
    // }
    // public static void print(int dp[][]){
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<dp[0].length;j++){
    //             System.out.print(dp[i][j]+"   ");
    //         }
    //         System.out.println(" ");
    //     }
    // }
    // public static int largestCommomSubsequenceRecursive(String str1,String str2,int m,int n){
    //     if(m==0 || n==0) return 0;
    //     if(str1.charAt(m-1)==str2.charAt(n-1)){
    //         return 1+largestCommomSubsequenceRecursive(str1, str2, m-1, n-1);

    //     }
    //     else{
    //         int ans1=largestCommomSubsequenceRecursive(str1, str2, m-1, n);
    //         int ans2=largestCommomSubsequenceRecursive(str1, str2, m, n-1);
    //         return Math.max(ans1, ans2);
    //     }
    // }
    // public static void lcsMemorization(String str1,String str2){
    //     int n=str1.length();
    //     int m=str2.length();

    //     int dp[][]=new int[n+1][m+1];
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
    //             else{
    //                 int ans1=dp[i-1][j];
    //                 int ans2=dp[i][j-1];
    //                 dp[i][j]=Math.max(ans1, ans2);
    //             }
    //         }
    //     }
    //     System.out.println(dp[n][m]);
    // }
    // public static void longestCommomSubstringMemorization(String str1,String str2){
    //     int n=str1.length();
    //     int m=str2.length();
    //     int dp[][]=new int[n+1][m+1];
    //     int answer=0;
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(str1.charAt(i-1)==str2.charAt(j-1)){
    //                 dp[i][j]=1+dp[i-1][j-1];
    //                 answer=Math.max(answer,dp[i][j] );
    //             }
    //             else{
    //                 dp[i][j]=0;
    //             }
    //         }
    //     }
    //     System.out.println(answer);
    // }
    // public static void editDistance(String str1,String str2){
    //     int n=str1.length();
    //     int m=str2.length();
    //     int dp[][]=new int[n+1][m+1];
    //     // for(int i=0;i<n+1;i++){
    //     //     dp[i][0]=i;
    //     // }
    //     // for(int j=0;j<m+1;j++){
    //     //     dp[0][j]=j;
    //     // }
    //         // System.out.println("Sachin");
    //     for(int i=0;i<n+1;i++){
    //         for(int j=0;j<m+1;j++){
    //             if(i==0) dp[i][j]=j;
    //             if(j==0) dp[i][j]=i;
    //         }
    //     }
    //     // System.out.println("Kumar");
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(str1.charAt(i-1)==str2.charAt(j-1)){
    //                 dp[i][j]=dp[i-1][j-1];
    //                 // System.out.println("one");
    //             }
    //             else{
    //                 // System.out.println("two");
    //                 int add=dp[i][j-1];
    //                 int del=dp[i-1][j];
    //                 int rep=dp[i-1][j-1];
    //                 dp[i][j]=Math.min(add, Math.min(del, rep))+1;
    //                 // System.out.println("three");
    //             }
    //         }
    //     }
    //     // System.out.println("Singh");

    //     System.out.println(dp[n][m]);
    // }
    // public static void patternMatching(String s,String p){
    //     int n=s.length();
    //     int m=p.length();
    //     boolean dp[][]=new boolean[n+1][m+1];
    //     //Initialization
    //     dp[0][0]=true;
    //     for(int i=1;i<n+1;i++){
    //         dp[i][0]=false;
    //     }
    //     for(int j=1;j<m+1;j++){
    //         if(p.charAt(j-1)=='*'){
    //             dp[0][j]=dp[0][j-1];
    //         }
    //         else{
    //             dp[0][j]=false;
    //         }
    //     }
    //     //Loop
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
    //                 dp[i][j]=dp[i-1][j-1];
    //             }
    //             else if(p.charAt(j-1)=='*'){
    //                 dp[i][j]=dp[i-1][j]||dp[i][j-1];
    //                 //choose * or remove it here 2 options are considered
    //             }
    //             else{
    //                 dp[i][j]=false;
    //             }
    //         }
    //     }
    //     System.out.println(dp[n][m]);
    // }
    // public static int catalanHelper(int n,int dp[]){
    //     if(n==0 || n==1 ) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     int ans=0;
    //     for(int i=0;i<n;i++){

    //         ans+=catalanHelper(i, dp)*catalanHelper(n-i-1, dp);
    //     }
    //     return dp[n]=ans;
    // }
    // public static void catalan(int n){
    //     int dp[]=new int[n+1];
    //     for(int i=0;i<n+1;i++){
    //         dp[i]=-1;
    //     }
        
    //     int ans=catalanHelper(n, dp);
    //     System.out.println(ans);
    // }
    // public static void catalnMemorization(int n){
    //     int dp[]=new int[n+1];
    //     dp[0]=dp[1]=1;
    //     for(int i=2;i<n+1;i++){
    //         for(int j=0;j<i;j++){
    //             dp[i]+=dp[j]*dp[i-j-1];
    //         }
    //     }
    //     System.out.println(dp[n]);
    // }
    // public static void mountainRanges(int n){
    //     int dp[]=new int[n+1];
    //     dp[0]=dp[1]=1;
    //     for(int i=2;i<n+1;i++){
    //         for(int j=0;j<i;j++){
    //             dp[i]+=dp[j]*dp[i-j-1];
    //         }
    //     }
    //     System.out.println(dp[n]);
    // }
    // public static int matrixMultiplication(int arr[],int i,int j,int dp[][]){
    //     if(i==j) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int finalCost=Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         int cost1=matrixMultiplication(arr, i, k,dp);
    //         int cost2=matrixMultiplication(arr, k+1, j,dp);
    //         int cost3=arr[i-1]*arr[k]*arr[j];
    //         finalCost=Math.min(finalCost, cost1+cost2+cost3);
    //     }
    //     return dp[i][j]=finalCost;

    // }
    // public static void mcm(int arr[]){
    //     int dp[][]=new int[arr.length][arr.length];
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr.length;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     System.out.println(matrixMultiplication(arr, 1, arr.length-1,dp));
    // }
    // public static void minimumPartitioning(int arr[]){
    //     int n=arr.length;
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         sum+=arr[i];
    //     }
    //     int w=sum/2;
    //     int dp[][]=new int[n+1][w+1];
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<w+1;j++){
    //             if(arr[i-1]<=j){
    //                 dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
    //             }
    //             else{
    //                 dp[i][j]=dp[i-1][j];
    //             }
    //         }
    //     }
    //     int sum1=dp[n][w];
    //     int sum2=sum-sum1;
    //     System.out.println(Math.abs(sum1-sum2));
    // }
    // public static void generateBrackets(int n){
    //     int dp[]=new int[n+1];
    //     dp[0]=dp[1]=1;
    //     for(int i=2;i<n+1;i++){
    //         for(int j=0;j<i;j++){
    //             dp[i]+=dp[j]*dp[i-j-1];
    //         }
    //     }
    //     System.out.println(dp[n]);
    // }
    // public static class info{
    //     int num;
    //     ArrayList<String> arr=new ArrayList<>();
    // }
    // public static info catalanHelper(int n,info dp[]){
    //     if(n==1 ){
    //         info x=new info();
    //         x.num=1;
    //         x.arr.add("()");
    //         return x;
    //     }
    //     if(n==0){
    //         info x=new info();
    //         x.num=1;
    //         x.arr.add("");
    //         return x;
    //     }
    //     if(dp[n]!=null) return dp[n];
    //     info ans=new info();
    //     for(int i=0;i<n;i++){
    //         info inside=catalanHelper(i, dp);
    //         info outside=catalanHelper(n-i-1, dp);
    //         ans.num+=inside.num*outside.num;
    //         StringBuilder sb=new StringBuilder("(");
    //         for(int k=0;i<inside.num;k++){
    //             if(inside.arr.get(k)!=null){
    //                 sb.append(inside.arr.get(k));
    //             }
    //             sb.append(inside.arr.get(k));
    //             sb.append(")");
    //         }
    //         for(int j=0;j<outside.num;j++){
    //             sb.append(outside.arr.get(j));
    //             ans.arr.add(sb.toString());
    //         }


    //     }
    //     return dp[n]=ans;
    // }
    // public static void generateParanthesis(int n){
    //     info dp[]=new info[n+1];
    //     for(int i=0;i<n+1;i++){
    //         dp[i]=null;
    //     }
        
    //     info ans=catalanHelper(n, dp);
    //     System.out.println(ans.arr);
    // }
    // public static int jump(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         dp[i]=-1;
    //     }
    //     dp[n-1]=0;
    //     for(int i=n-2;i>=0;i--){
    //         int steps=nums[i];
    //         int ans=Integer.MAX_VALUE;
    //         for(int j=i+1;j<i+steps+1 && j<n;j++){
    //             if(dp[j]!=-1){
    //                 ans=Math.min(ans, dp[j]+1);
    //             }
    //         }
    //         if(ans!=Integer.MAX_VALUE){
    //             dp[i]=ans;
    //         }
    //     }
    //     return dp[0];
    // }
    // public static int greedy(int nums[]){
    //     int maxjump=-1,curridx=0,n=nums.length;
    //     if(n==1) return true;
    //     int steps=0;
    //     int i=0;
    //     while(i<n){
    //         steps=nums[i];
    //         if(i+nums[i]>=n-1){
    //             return true;
    //         }
    //         for(int j=i;j<=i+steps;j++){
    //             if(nums[j]+j>=maxjump){
    //                 curridx=j;
    //                 maxjump=nums[j]+j;
    //             }
    //         }
    //         if(maxjump==0) return false;
    //         maxjump=-1;
    //         i=curridx;
    //         curridx=0;
            
    //     }
    //     return true;
    // }
    // public static String longestPalindrome(String s) {
    //     StringBuilder s2=new StringBuilder(" ");
    //     for(int i=s.length()-1;i>=0;i++){
    //         s2.append(s.charAt(i));
    //     }
    //     lcsMemorization(s, s2);
    // }
    // public static String curr=" ";
    // // public static String final=" ";
    // public static int largestCommomSubsequenceRecursive(String str1,String str2,int m,int n){
    //         if(m==0 || n==0) return 0;
    //         if(str1.charAt(m-1)==str2.charAt(n-1)){

    //             return 1+largestCommomSubsequenceRecursive(str1, str2, m-1, n-1);
    
    //         }
    //         else{
    //             int ans1=largestCommomSubsequenceRecursive(str1, str2, m-1, n);
    //             int ans2=largestCommomSubsequenceRecursive(str1, str2, m, n-1);
    //             return Math.max(ans1, ans2);
    //         }
    //     }
    // public static void lcsMemorization(String str1,String str2){
    //     int n=str1.length();
    //     int m=str2.length();

    //     int dp[][]=new int[n+1][m+1];
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<m+1;j++){
    //             if(str1.charAt(i-1)==str2.charAt(j-1)){
    //                 dp[i][j]=1+dp[i-1][j-1];

    //             }
    //             else{
    //                 int ans1=dp[i-1][j];
    //                 int ans2=dp[i][j-1];
    //                 dp[i][j]=Math.max(ans1, ans2);
    //             }
    //         }
    //     }
    //     System.out.println(dp[n][m]);
    // }
    public static StringBuilder finalString=new StringBuilder(" ");
    public static void lcPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        int curr=0;
        int max=-1;
        String dp[][]=new String[s.length()][s.length()];
        lcsPalindromeHelper(s, i, j, curr, max);
        System.out.println(finalString.toString());
    }
    public static void lcsPalindromeHelper(String s,int i,int j,int curr,int max){
        if(i>=s.length() || j<=0 ) return;
        if(s.charAt(i)==s.charAt(j)){
            curr++;
            if(max<=curr){
                max=curr;
                finalString.append(s.charAt(i));
            }
            lcsPalindromeHelper(s, i+1, j-1, curr, max);
        }
        else{
            curr=0;
        
            finalString.delete(0,finalString.length());
            lcsPalindromeHelper(s, i+1, j, curr, max);
            lcsPalindromeHelper(s, i, j-1, curr, max);
        }
    }

    
    public static void main(String[] args) {
        lcPalindrome("babad");
        String str="Sachin Kumar";
        
    }
}
