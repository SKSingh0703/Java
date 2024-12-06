import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.w3c.dom.Node;

class Solution {
    // static int count;
    // public int[][] validArrangement(int[][] pairs) {
    //     HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    //     int m=pairs.length,n=pairs[0].length;
    //     HashMap<Integer,Boolean> vis = new HashMap<>();
    //     for(int i=0;i<m;i++){
    //         int start=pairs[i][0];
    //         int end = pairs[i][1];
    //         hm.put(start, hm.getOrDefault(start, new ArrayList<>()).add(end));

    //         vis.put(start,false);
    //         vis.put(end, false);
    //     }
    //     for(int i=0;i<m;i++){
    //         if (!vis.get(pairs[i][0])) {
    //             count=0;

    //             dfs();
                
    //         }
    //     }
    // }
    // public int getLargestOutlier(int[] nums) {
    //     int n = nums.length;
    //     int totalSum = 0;
    //     HashMap<Integer,ArrayList> hm = new HashMap<>();

    //     for (int num : nums) {
    //         totalSum += num;
    //         hs.add(num);
    //     }
    //     for (int i = 0; i < n; i++){
    //         totalSum+=nums[i];
    //         hm.put(nums[i], hm.getOrDefault(nums[i], new ArrayList<>()).add(i));
    //     }
        

    //     int largestOutlier = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < n; i++) {
    //         int specialElement = nums[i];
    //         int specialSum = totalSum - specialElement;
    //         if (specialSum%2==0 && hm.containsKey(specialSum/2) && helper(hm,specialSum/2,i)) {
    //             largestOutlier=Math.max(largestOutlier, specialElement);
    //         }
    //     }
    //     return largestOutlier;
    // }
    // public boolean helper(HashMap<Integer,ArrayList> hm,int target ,int idx){
    //     ArrayList<Integer> arr = hm.get(target);
    //     for (Integer integer : arr) {
    //         if (integer!=idx) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public boolean checkIfExist(int[] arr) {
    //     return true;
    // }
    // static Node root;
    // public class Node{
    //     Node arr[];
    //     boolean EOW;
    //     public Node(){
    //         arr=new Node[26];
    //         for(int i=0;i<26;i++){
    //             arr[i]=null;
    //         }
    //         EOW=false;
    //     }
    // }
    // public void insert(String str){
    //     Node temp=root;
    //     for(int i=0;i<str.length();i++){
    //         int idx=str.charAt(i)-'a';
    //         if (temp.arr[idx]==null) {
    //             temp.arr[idx]=new Node();
    //         }
    //         temp=temp[idx];
    //     }
    //     temp.EOW=true;
    // }
    // public boolean search(String str){
    //     Node temp=root;
    //     for(int i=0;i<str.length();i++){
    //         int idx=str.charAt(i)-'a';
    //         if (temp.arr[idx]==null) {
    //             return false;
    //         }
    //         temp=temp[idx];
    //     }
    //     return true;
    // }
    // public int isPrefixOfWord(String sentence, String searchWord) {
    //     String arr[]=sentence.split(" ");
    //     for(int i=0;i<arr.length;i++){
    //         insert(arr[i]);
    //         if (search(searchWord)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // public int maxProduct(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         dp[i]=nums[i];
    //     }
    //     for(int i=1;i<n;i++){
    //         dp[i]=Math.max(dp[i-1]*nums[i], Math.max(dp[i-1], dp[i]));
    //     }
    //     return dp[n-1];
    // }
    // public int maxProduct(int[] nums) {
    //     int maxP=minP=prevMaxP=prevMinP=result=nums[0];
    //     int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         maxP=Math.max(maxP, Math.max(nums[i]*prevMaxP, nums[i]*prevMinP));
    //         minP=Math.max(minP, Math.min(nums[i]*prevMaxP, nums[i]*prevMinP));

    //         prevMaxP=maxP;
    //         prevMinP=minP;

    //         result=Math.max(maxP, minP);
    //     }
    //     return result;
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m=text1.length();
    //     int n=text2.length();
    //     int dp[][]=new int[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return helper(text1,text2,0,0,dp);
    // }
    // public int helper(String str1,String str2,int m,int n,int dp[][]){
    //     if(m==str1.length() || n==str2.length()) return 0;
    //     if (dp[m][n]!=-1) {
    //         return dp[m][n];
    //     }
    //     int result=0;
    //     if (str1.charAt(m)==str2.charAt(n)) {
    //         result=1+helper(str1, str2, m+1, n+1, dp);
    //     }
    //     result = Math.max(result, Math.max(helper(str1, str2, m+1, n, dp), helper(str1, str2, m, n+1, dp)));
    //     return dp[m][n]=result;
    // }
    // public String addSpaces(String s, int[] spaces) {
    //     StringBuilder sb = new StringBuilder();
    //     int j=0;
    //     for(int i=0;i<s.length();i++){
    //         if(j<spaces.length && spaces[j]==i){
    //             sb.append(" ");
    //         }
    //         sb.append(s.charAt(i));
    //     }
    //     return sb.toString();
    // }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict){
            hs.add(str);
        }
        HashMap<String,Boolean> hm = new HashMap<>();
        return helper(s,hs,hm);
    }
    public boolean helper(String s,HashSet<String> hs,HashMap<String,Boolean> hm){
        if(s.length()==0) return true;
        if(hm.containsKey(s)) return hm.
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.substring(0,i+1)) && helper(s.substring(i+1),hs)){
                return true;
            }
        }
        return false;
    }
}
