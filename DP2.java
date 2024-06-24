public class DP2{
    public static void knapsack(int wt[],int val[],int w){
        int dp[][]=new int[wt.length+1][w+1];
        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<w+1;j++){
                dp[i][j]=-1;
            }
        }
        int ans=knapsackHelper(wt, val, w, 0,dp);
        System.out.println("The max amount will be equal to:"+ans);
    }
    public static int knapsackHelper(int wt[],int val[],int w,int i,int dp[][]){
        if(w<=0 || i==val.length) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        if(wt[i]<=w){
            int ans1=val[i]+knapsackHelper(wt, val, w-wt[i], i+1,dp);
            int ans2=knapsackHelper(wt, val, w, i+1,dp);
            dp[i][w]=Math.max(ans1, ans2);
            return dp[i][w];
        }
        else{
            dp[i][w]=knapsackHelper(wt, val, w, i+1,dp);
            return dp[i][w];
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World Again:)");
        int wt[]={2,5,1,3,4};
        int val[]={15,14,10,45,30};
        knapsack(wt, val,7);
    }
}