import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class sfasf {
    // public String clearDigits(String s) {
    //     Queue<Character> q=new LinkedList();
    //     for(int i=0;i<s.length();i++){
    //         char curr=s.charAt(i);
    //         if(Character.isDigit(curr)){
    //             if(!q.isEmpty()){
    //                 q.poll();
    //             }
    //             else{
    //                 q.add(curr);
    //             }
    //         }
    //         else{
    //             q.add(curr);
    //         }
    //     }
    //     StringBuilder sb=new StringBuilder("");
    //     for(int i=0;i<q.size();i++){
    //         sb.append(q.poll());
    //     }
    //     return sb.toString();
    // }
    // public static int findWinningPlayer(int[] skills, int k) {
    //     Stack<Integer> s=new Stack<>();
    //     for(int i=skills.length-1;i>=0;i--){
    //         s.push(skills[i]);
    //     }
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     int curr1=s.pop();
    //     int curr2=s.pop();
    //     int num=-1;
    //     while (!s.isEmpty()) {
    //         if(curr1>curr2){
    //             curr2=s.pop();
    //             hm.putIfAbsent(curr1,hm.getOrDefault(curr1,0)+1);
    //             if(hm.get(curr1)==k){
    //                 num=curr1;
    //                 break;
    //             } 
    //         }
    //         else{
    //             curr1=s.pop();
    //             hm.putIfAbsent(curr2,hm.getOrDefault(curr2,0)+1);
    //             if(hm.get(curr2)==k){
    //                 num=curr2;
    //                 break;
    //             }
    //         }
    //     }
    //     for(int i=0;i<skills.length;i++){
    //         if(skills[i]=num) return i;
    //     }
    //     return -1;
    // }
    // public static boolean canReach(String s, int minJump, int maxJump) {
    //     Boolean dp[]=new Boolean[s.length()];
    //     return helper(0, s.length()-1, minJump, maxJump, s,dp);
    // }
    // public static boolean helper(int curr,int des,int minJump,int maxJump,String s,Boolean dp[]){
    //     if(dp[curr]!=null) return dp[curr];
    //     if(curr==des) return dp[curr]=true;
    //     // for(int i=Math.min(maxJump+curr, des);i<=curr+minJump;i--)
    //     for(int i=Math.min(maxJump+curr, des);i>=curr+minJump;i--){
    //         if(s.charAt(i)=='0'){
    //             if(helper(i, des, minJump, maxJump, s,dp)) return dp[curr]=true;
    //         }
    //     }
    //     return dp[curr]=false;
    // }
    // public static boolean canReach(String s, int minJump, int maxJump) {
    //     return helper(0, s.length()-1, minJump, maxJump, s);
    // }
    // public static boolean helper(int curr,int des,int minJump,int maxJump,String s){
    //     if(curr==des) return true;
    //     for(int i=Math.min(maxJump+curr, des);i<=curr+minJump;i--){
    //         if(s.charAt(i)=='0'){
    //             if(helper(i, des, minJump, maxJump, s)) return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int numberOfChild(int n, int k) {
    //     int direction=1;
    //     while(k>0){
    //         if(k<=n-1){
    //             if(direction==1) return k;
    //             else if(direction==2) return n-1-k;
    //         }else{
    //             k-=n-1;
    //         }
    //     }
    //     return 0;
    // }
    // public static int valueAfterKSeconds(int n, int k) {
    //     int a[]=new int[n];
    //     Arrays.fill(a,1);
    //     for(int i=1;i<=k;i++){
    //         for(int j=1;j<n;j++){
    //             a[j]=a[j]+a[j-1];
    //         }
    //     }
    //     return a[n-1];
    // }
    // public static int maxTotalReward(int[] rewardValues) {
    //     int maxvalue=Integer.MIN_VALUE;
    //     for(int i=0;i<rewardValues.length;i++){
    //         maxvalue+=rewardValues[i];
            
    //     }
    //     int dp[][]=new int[rewardValues.length][maxvalue+1];
    //     for(int i=0;i<rewardValues.length;i++){
    //         for(int j=0;j<maxvalue+1;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return helper(0, 0, rewardValues, dp);
    // }
    // public static int helper(int curr,int currreward,int[] rewardValues,int dp[][]){
    //     if(curr>=rewardValues.length) return currreward;
    //     if(dp[curr][currreward]!=-1) return dp[curr][currreward];
    //     if(currreward<rewardValues[curr]){
    //         dp[curr][currreward]=Math.max(helper(curr+1, currreward+rewardValues[curr], rewardValues, dp),helper(curr+1, currreward, rewardValues, dp));
    //     }
    //     else{
    //         dp[curr][currreward]=helper(curr+1, currreward, rewardValues, dp);
    //     }
    //     return dp[curr][currreward];
    // }
    public static int subarraysDivByK(int[] nums, int k) {
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int currRemainder=0;
        int ans=0;
        HashSet<Integer> remainder=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                currRemainder=(i-j)==0?prefix[i]%k:(prefix[j]-prefix[i])%k;
                if(remainder.contains(currRemainder)){
                    ans++;
                }
                else{
                    remainder.add(currRemainder);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
