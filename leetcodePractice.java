import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcodePractice {
    // public static int uniquePaths(int m, int n) {
    //     int dp[][]=new int[m][n];
    //     return helper(0, 0, dp, m, n);
    // }
    // public static int helper(int i,int j,int dp[][],int[][] obstacleGrid,int m,int n){
    //     if(i==m-1 && j==n-1) return 1;
    //     if(i>=m || j>=n ||obstacleGrid[i][j]==1) return 0;
    //     if(dp[i][j]!=0) return dp[i][j];
    //     return dp[i][j]=helper(i+1, j, dp,obstacleGrid, m, n)+helper(i, j+1, dp,obstacleGrid, m, n);
    // }
    // public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m=obstacleGrid.length;
    //     int n=obstacleGrid[0].length;
    //     if(obstacleGrid[m-1][n-1]==1) return 0;
    //     int dp[][]=new int[m][n];
    //     return helper(0, 0, dp,obstacleGrid, m, n);
    // }
    // public static int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int dp[][]=new int[m][n];
    //     return helper(0, 0, grid, dp, m, n);
    // }
    // public static int helper(int i,int j,int grid[][],int dp[][],int m,int n){
    //     if(i==m-1 && j==n-1) return grid[i][j];
    //     if(i>=m || j>=n) return Integer.MAX_VALUE;
    //     if(dp[i][j]!=0) return dp[i][j];
    //     return dp[i][j]=grid[i][j]+Math.min(helper(i+1, j, grid, dp, m, n), helper(i, j+1, grid, dp, m, n));
    // }
    // public static int climbStairs(int n) {
    //     int dp[]=new int[n];
    //     return helper(0, n, dp);
    // }
    // public static int helper(int i,int n,int dp[]){
    //     if(i>n) return 0;
    //     if(i==n) return 1;
    //     if(dp[i]!=0) return dp[i];
    //     return dp[i]=helper(i+1, n, dp)+helper(i+2, n, dp);
    // }
    // public static int minDistance(String word1, String word2) {
    //     int m=word1.length();
    //     int n=word2.length();
    //     int dp[][]=new int[m+1][n+1];
    //     return helper(0, 0, m, n, dp, word1, word2);
    // }
    // public static int helper(int i,int j,int m,int n,int dp[][],String word1,String word2){
    //     if(j==n ) return (m-i);
    //     if(i==m) return (n-j);
    //     if(dp[i][j]!=0) return dp[i][j];
    //     if(word1.charAt(i)==word2.charAt(j)){
    //         return dp[i][j]=helper(i+1, j+1, m, n, dp, word1, word2);
    //     }
    //     else{
    //         return dp[i][j]=1+Math.min(helper(i, j+1, m, n, dp, word1, word2),Math.min(helper(i+1, j, m, n, dp, word1, word2), helper(i+1, j+1, m, n, dp, word1, word2)));
    //     }
    // }
    // public static int numDecodings(String s) {
    //     int n=s.length();
    //     if(s.charAt(0)=='0') return 0;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(0, n, s, dp);
    // }
    // public static int helper(int i,int n,String s,int dp[]){
    //     if(i==n) return 1;
    //     if(i>n) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     if(s.charAt(i)=='0'){
    //         return dp[i]=0;
    //     }
    //     int count = helper(i + 1, n, s, dp);  // Single digit decode
        
    //     if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
    //         count += helper(i + 2, n, s, dp);  // Two digit decode
    //     }
    //     return dp[i]=count;
    // }
    // public static boolean isInterleave(String s1, String s2, String s3) {
    //     int dp[]=new int[26];
    //     for(int i=0;i<s3.length();i++){
    //         dp[s3.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<s1.length();i++){
    //         dp[s1.charAt(i)-'a']--;
    //     }
    //     for(int i=0;i<s2.length();i++){
    //         dp[s2.charAt(i)-'a']--;
    //     }
    //     for(int i=0;i<26;i++){
    //         if(dp[i]!=0) return false;
    //     }
    //     return true;
    // }
    // public static boolean isInterleave(String s1, String s2, String s3) {
    //     boolean dp[][]=new boolean[s1.length()+1][s2.length()+1];
    //     if(s3.length()==0){
    //         return s1.length()==0 && s2.length()==0;
    //     }
    //     if(s1.length()==0){
    //         return s2.equals(s3);
    //     }
    //     if(s2.length()==0){
    //         return s1.equals(s3);
    //     }
    //     return helper(0, 0, 0, s1, s2, s3,dp);
    // }
    // public static boolean helper(int i,int j,int k,String s1, String s2, String s3,boolean dp[][]){
    //     if(i==s1.length() && j==s2.length() && k==s3.length()) return dp[i][j]=true;

    //     if(dp[i][j]!=null) return dp[i][j];

    //     if((k==s3.length() &&(i<s1.length() ||j<s2.length())) ||(i==s1.length() && j==s2.length() && k<s3.length() )) return dp[i][j]=false;

    //     // if(s1.charAt(i)==s3.charAt(k) && s1.charAt(i)==s3.charAt(k)) {
    //     //     return dp[i][j]=helper(i+1, j, k+1, s1, s2, s3,dp) || helper(i, j+1, k+1, s1, s2, s3,dp);
    //     // }
    //     if(s1.charAt(i)==s3.charAt(k)){
    //         return dp[i][j]=helper(i+1, j, k+1, s1, s2, s3,dp);
    //     }
    //     else if(s1.charAt(i)==s3.charAt(k)){
    //         return dp[i][j]=helper(i, j+1, k+1, s1, s2, s3,dp);
    //     }
    //     else{
    //         return dp[i][j]=false;
    //     }
    // }

    // public static int minimumTotal(List<List<Integer>> triangle) {
    //     int m=triangle.size();
    //     int n=triangle.get(m-1).size();
    //     int dp[][]=new int[m][n];
    //     // Arrays.fill(dp,-1);
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return helper(0, 0, dp, m, n, triangle);
    // }
    // public static int helper(int i,int j,int dp[][],int m,int n,List<List<Integer>> triangle){
    //     if(i==m) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=triangle.get(i).get(j)+Math.min(helper(i+1, j, dp, m, n, triangle), helper(i+1, j+1, dp, m, n, triangle));
    // }
    // public static int maxProfit(int[] prices) {
    //     int buyPrice=prices[0],curr=0,ans=0;
    //     for(int i=1;i<prices.length;i++){
    //         curr=prices[i];
    //         if(buyPrice<curr){
    //             ans+=curr-buyPrice;
    //             buyPrice=curr;
    //         }
    //         else{
    //             buyPrice=curr;
    //         }
    //     }
    //     return ans;
    // }
    // public static List<List<String>> partition(String s) {
    //     List<List<String>> arr= new ArrayList<>();
    //     for(int i=0;i<s.length();i++){
    //         arr.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<s.length();i++){
    //         for(int j=i;j<s.length();j++){
    //             if(j+1<s.length()){
    //                 if(isPalindrome(s.substring(i,j+1))){
    //                     arr.get(i).add(s.substring(i,j+1));
    //                 }
    //             }
    //             else{
    //                 if(isPalindrome(s.substring(i))){
    //                     arr.get(i).add(s.substring(i));
    //                 }
    //             }
    //         }
    //     }
    //     return arr;
    // }
    // public static boolean isPalindrome(String s){
    //     if(s.length()==1) return true;
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)!=s.charAt(s.length()-i-1)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    import java.util.Arrays;


    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, n, dp, nums);
    }

    public static int helper(int i, int n, int[] dp, int[] nums) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int robCurrent = nums[i] + (i + 2 < n ? helper(i + 2, n, dp, nums) : 0);
        int skipCurrent = helper(i + 1, n, dp, nums);

        dp[i] = Math.max(robCurrent, skipCurrent);
        return dp[i];
    }

    


    public static void main(String[] args) {
        int[] nums = {200,3,140,20,10};
        // System.out.println(rob(nums));
        StringBuilder sb=new StringBuilder("SachinKumar");
        System.out.println(sb.indexOf("z"));
        int i=10;
        String str=(String)i;
        System.out.println(str);
    }
}
