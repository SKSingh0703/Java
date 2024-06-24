public class DPHomework {
    public static int rob(int nums[]) {
        int n=nums.length;
        int dp[]=new int[n];
        if(n<=2){
            int ans=-1;
            for(int i=0;i<n;i++){
                ans=Math.max(ans, nums[i]);
            }
            return ans;
        }
        dp[n-1]=nums[n-1];
        dp[n-2]=nums[n-2];
        for(int i=n-3;i>=0;i--){
            int val1=nums[i]+dp[i+2];
            int val2=dp[i+1];
            int val3=0;
            if(i+3<n){
                val3=nums[i]+dp[i+3];
            }
            dp[i]=Math.max(val1,Math.max(val3, val2));
        }
        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }
    public static int lpHelper(String s,int dp[][],int i,int j){
        if(i==s.length() || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=1+lpHelper(s, dp, i+1, j-1);
        }
        else{
            int val1=lpHelper(s, dp, i+1, j);
            int val2=lpHelper(s, dp, i, j-1);
            dp[i][j]=Math.max(val1, val2);
        }
        return dp[i][j];
    }
    public static int longestPalindromeSubseq(String s) {
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s.length()+1;j++){
                dp[i][j]=-1;
            }
        }
        return lpHelper(s, dp, 0, s.length()-1);
    }
    public static int knapsack(int nums[],int w,int n,int dp[][]){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(nums[i-1]<=j){
                    int val1=nums[i-1]+dp[i-1][j-nums[i-1]];
                    int val2=dp[i-1][j];
                    dp[i][j]=Math.max(val1, val2);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int dp[][]=new int[n+1][(sum/2)+1];
        int sum1=knapsack(nums, sum/2, n, dp);
        int sum2=sum-sum1;
        if(sum2==sum1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
