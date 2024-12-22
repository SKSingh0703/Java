import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     HashSet<String> hs = new HashSet<>();
    //     for(String str : wordDict){
    //         hs.add(str);
    //     }
    //     HashMap<String,Boolean> hm = new HashMap<>();
    //     return helper(s,hs,hm);
    // }
    // public boolean helper(String s,HashSet<String> hs,HashMap<String,Boolean> hm){
    //     if(s.length()==0) return true;
    //     if(hm.containsKey(s)) return hm.get(s);
    //     for(int i=0;i<s.length();i++){
    //         if(hs.contains(s.substring(0,i+1)) && helper(s.substring(i+1),hs)){
                
    //             return true;
    //         }
    //     }
    //     hm.put(s, false);
    //     return false;
    // }

    // public int findMinimumTime(List<Integer> strength, int K) {
    //     int x = 1;
    //     int energy = 0;
    //     boolean[] vis = new boolean[strength.size()];
    //     int totalTime = helper(energy, x, strength, K, vis, 0);
    //     return totalTime == Integer.MAX_VALUE ? -1 : totalTime;
    // }

    // public int helper(int energy, int x, List<Integer> strength, int k, boolean[] vis, int idx) {
    //     if (idx >= strength.size()) {
    //         return 0;
    //     }

    //     int cost = Integer.MAX_VALUE;

    //     for (int i = 0; i < strength.size(); i++) {
    //         if (!vis[i] && energy >= strength.get(i)) {
    //             vis[i] = true;
    //             int curr = helper(0, x + k, strength, k, vis, idx + 1);
    //             vis[i] = false;
    //             cost = Math.min(curr, cost);
    //         }
    //     }

    //     cost = Math.min(cost, helper(energy + x, x, strength, k, vis, idx));

    //     return cost == Integer.MAX_VALUE ? Integer.MAX_VALUE : cost + 1;
    // }
    // static int min=Integer.MAX_VALUE;
    // public static void helper(String num,int k){
    //     if(num.length()==0 || k==0){
    //         min=Math.min(min,Integer.parseInt(num));
    //         return;
    //     }
    //     for(int i=0;i<num.length();i++){
    //         String curr = num.substring(0,i)+num.substring(i+1);
    //         helper(curr,k-1);
    //     }
    //     return ;
    // }
    
    // public int kthElement(int a[], int b[], int k) {
    //     int n=a.length;
    //     int m=b.length;
    //     int l = Math.min(a[0],b[0]);
    //     int r = Math.max(a[n-1],b[m-1]);
    //     int ans=0;
    //     while(l<=r){
    //         int mid = l + (r-l)/2;
    //         int number = numberOfElements(mid,a) + numberOfElements(mid,b);
            
    //         if(number>=k-1){
    //             ans=mid;
    //             r=mid-1;
    //         }
    //         else l = mid +1;
    //     }
    //     //Minimum element that exist in array which is larger or equal to mid
    //     System.out.println(ans);
    //     int answer = Math.min(helper(ans,a),helper(ans,b));
    //     return answer;
    // }
    // public int numberOfElements(int target,int nums[]){
    //     int l = 0;
    //     int r = nums.length-1;
    //     int ans = nums.length;
    //     while(l<=r){
    //         int mid =l+(r-l)/2;
    //         if(nums[mid]>=target){
    //             ans = mid;
    //             r=mid-1;
    //         }
    //         else l=mid+1;
    //     }
    //     return ans;
    // }
    // public int helper(int target , int nums[]){
    //     int l = 0;
    //     int r = nums.length-1;
    //     int ans = nums.length;
    //     while(l<=r){
    //         int mid =l+(r-l)/2;
    //         if(nums[mid]>=target){
    //             ans = nums[mid];
    //             r=mid-1;
    //         }
    //         else l=mid+1;
    //     }
    //     return ans==nums.length?Integer.MAX_VALUE:ans;
    // }
    // public int books(int a[],int n,int b){
    //     int l=Integer.MAX_VALUE;
    //     int r=0;
    //     if(a.length<b) return -1;
    //     for(int num : a){
    //         l=Math.min(l, num);
    //         r+=num;
    //     }
    //     int ans=0;
    //     while(l<=r){
    //         int mid = l + (r-l)/2;
    //         int x = isPossible(mid,a,b);
    //         if(x!=-1){
    //             ans=x;
    //             l=mid+1;
    //         }
    //         else r=mid-1;
    //     }
    //     return ans;
    // }
    // public int isPossible(int pages ,int arr[] ,int req){
    //     int count=0;
    //     int currPages = 0;
    //     int max=Integer.MIN_VALUE;
    //     for(int num : arr){
    //         currPages+=num;
    //         if(currPages>=pages){
    //             count++;
    //             max=Math.max(max,currPages);
    //             currPages=0;
    //         }
    //     }
    //     return count>=req?max:-1;
    // }
    // public static boolean isPossible(int stalls[],int distance ,int cows){
    //     int count = 0;
    //     int l =stalls[0];
    //     for(int i=0;i<stalls.length;i++){
    //         int currDist = stalls[i]-l;
    //         if(currDist>=distance){
    //             count++;
    //             l=stalls[i];
    //         }
    //     }
    //     return count>=cows?true:false;
    // }
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://leetcode.com/graphql/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // GraphQL query to fetch questions
        String query = """
        {
            "query": "query { problemsetQuestionList(categorySlug: \"\", limit: 10) { questions { titleSlug } } }"
        }
        """;

        // Send request
        try (OutputStream os = conn.getOutputStream()) {
            os.write(query.getBytes());
        }

        // Read response
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            System.out.println(responseLine);
        }
    }
}
