import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.tree.TreeNode;

public class LCPOne {
    // public int lengthOfLongestSubstring(String s) {
    //     HashSet<Character> hs=new HashSet<>();
    //     int l=0;
    //     int max=0;
    //     for(int i=0;i<s.length();i++){
    //         if (hs.contains(s.charAt(i))) {
                
    //             while (s.charAt(l)!=s.charAt(i)) {
    //                 hs.remove(s.charAt(i));
    //                 l++;
    //             }
    //         }
    //         els{
    //             hs.add(s.charAt(i));
    //         }
    //         max=Math.max(max, i-l+1);
    //     }
    //     return max;
    // }
    // public List<String> findRepeatedDnaSequences(String s) {
    //     List<String> ls=new ArrayList<>();
    //     if(s.length()<11){
    //         return ls;
    //     }

    //     HashSet<String> hs=new HashSet<>();
    //     HashSet<String> ans=new HashSet<>();

    //     StringBuilder sb=new StringBuilder("");
    //     sb.append(s.substring(0, 10));
    //     int l=0;
    //     int r=9;

    //     while (r<s.length()) {
    //         if (hs.contains(sb.toString())) {
    //             ans.add(sb.toString());
    //         }
    //         hs.add(sb.toString());
    //         l++;
    //         r++;
    //         sb.deleteCharAt(0);
    //         sb.append(s.charAt(r));
    //     }
    //     for (String str : ans) {
    //         ls.add(str);
    //     }
    //     return ls;
    // }
    // public int minSubArrayLen(int target, int[] nums) {
    //     int sum=0;
    //     int l=0;
    //     int min=Integer.MAX_VALUE;
    //     for(int i=0;i<nums.length;i++){
    //         while (sum>target) {
    //             sum-=nums[l];
    //             l++;
    //         }
    //         sum+=nums[i];
    //         if(sum>=target) min=Math.min(min,i-l+1);
    //     }
    //     return min==Integer.MAX_VALUE?0:min;
    // }
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for(int j=i+1;j<=i+indexDiff && j<nums.length;j++){
    //             if(Math.abs(nums[i]-nums[j])<=valueDiff) return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int longestSubstring(String s, int k) {
    //     int chars[]=new int[26];
    //     for(int i=0;i<s.length();i++){
    //         chars[s.charAt(i)-'a']++;
    //     }
    //     int max=0;
    //     int l=0;
    //     for(int i=0;i<s.length();i++){
    //         if(chars[s.charAt(i)-'a']<k){
    //             if(check(s.substring(l, i+1), k)){
    //                 max=Math.max(max,i-l+1);
    //             }
    //             l=i;
    //         }
    //         if(l==0 && i==s.length()-1) max=s.length();
    //     }
    //     return max;
    // }
    // public static boolean check(String s,int k){
    //     int chars[]=new int[26];
    //     for(int i=0;i<s.length();i++){
    //         chars[s.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<s.length();i++){
    //         if(chars[s.charAt(i)-'a']<k) return false;
    //     }
    //     return true;
    // }
    // public int characterReplacement(String s, int k) {
    //     int l=0;
    //     int max=0;
    //     int upperBound=1+k;
    //     int countOfChars=0;
    //     for(int i=0;i<s.length();i++){
    //         if (s.charAt(i)!=s.charAt(l)) {
    //             count++;
    //         }
    //         if (count>upperBound) {
    //             max=Math.max(max,i-l);
    //             l++;
    //         }
    //     }
    // }
    // public static List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> ans=new ArrayList<>();
    //     if(s.length()<p.length()) return ans;
    //     int l=0;
    //     int pt[]=new int[26];
    //     for(int i=0;i<p.length();i++){
    //         pt[p.charAt(i)-'a']++;
    //     }
        
    //     for(int i=0;i<s.length();i++){
    //         if (i-l+1>p.length()) {
    //             l++;
    //         }
    //         if(!ans.contains(l)){
    //             if(check(pt,l,i, s)){
    //                 ans.add(l);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public static boolean check(int pt[],int start,int end,String s){
    //     if (start==end) {
    //         return true;
    //     }
    //     int temp[]=pt.clone();
    //     for(int i=start;i<=end;i++){
    //         if (temp[s.charAt(i)-'a']==0) {
    //             return false;
    //         }
    //         else{
    //             temp[s.charAt(i)-'a']--;
    //         }
    //     }
    //     return true;
    // }
    // public static boolean checkInclusion(String s1, String s2) {
    //     if(s1.length()>s2.length()) return false;
    //     int ch[]=new int[26];
    //     for(int i=0;i<s1.length();i++){
    //         ch[s1.charAt(i)-'a']++;
    //         ch[s2.charAt(i)-'a']--;
    //     }
    //     int diff=0;
    //     for(int i=0;i<ch.length;i++){
    //         if(ch[i]>0){
    //             diff++;
    //         }
    //     }
    //     if (diff==0) {
    //         return true;
    //     }
    //     for(int i=0;i<s2.length()-s1.length();i++){
    //         if(++ch[s2.charAt(i)-'a']==1) diff++;
    //         if(--ch[s2.charAt(i+s1.length())-'a']==0) diff--;
    //         if (diff==0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public int findLHS(int[] nums) {
    //   Arrays.sort(nums);
    //   int l=0;
    //   int max=0;
    //   for(int i=0;i<nums.length;i++){
    //     while (nums[i]-nums[l]>1) {
    //         l++;
    //     }
    //     max=Math.max(max, i-l+1);
    //  }
    //  return max;
    // }
    // public static double findMaxAverage(int[] nums, int k) {
    //     float max=0;
    //     float currSum=0;
    //     int l=0;
    //     for(int i=0;i<k;i++){
    //         currSum+=nums[i];
    //     }
    //     max=currSum/(double)k;
    //     currSum=max;
    //     for(int i=k+1;i<nums.length;i++){
    //         currSum-=nums[l]/(double)k;
    //         currSum+=nums[i]/(double)k;

    //         max=Math.max(max,currSum);
    //         l++;
    //     }
    //     return max;
    // }
    // public static class Pair implements Comparable<Pair>{
    //     int num;
    //     int idx;
    //     public Pair(int n,int i){
    //         this.num=n;
    //         this..idx=i;
    //     }
    //     @Override
    //     public int compareTo(Pair p){
    //         if(this.num=p.num){
    //             return this.idx-p.idx;
    //         }
    //         else return Math.abs(this.num-p.num);
    //     }        
    // }
    // public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     List<Integer> ans=new ArrayList<>();
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     int diff[]=new int[arr.length];
    //     for (int i = 0; i < diff.length; i++) {
    //         diff[i]=arr[i]-x;
    //     }
    //     for (int i = 0; i < diff.length; i++) {
    //         pq.add(new Pair(arr[i], diff[i]));
    //     }
    //     while (!pq.isEmpty() && k>0) {
    //         ans.add(pq.poll().num);
    //         k--;
    //     }
    //     return ans;
    // }
    // public int numSubarrayProductLessThanK(int[] nums, int k) {
    //     int l=0;
    //     int product=1;
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         product*=nums[i];
    //         while (product>=k) {
    //             product/=nums[l];
    //             l++;
    //         }
    //         if(product<k) count++;
    //     }
    //     return count;
    // }
    // public static int findLength(int[] nums1, int[] nums2) {
    //     int dp[][]=new int[nums1.length+1][nums2.length+1];
    //     for(int i=0;i<nums1.length;i++){
    //         for(int j=0;j<nums2.length;j++){
    //             if(nums1[i]==nums2[j]){
    //                 dp[i][j]=1+Math.max(dp[i][j],dp[i-1][j-1]);
    //             }
    //             else{
    //                 dp[i][j]=0;
    //             }
    //         }
    //     }
    //     return dp[nums1.length][nums2.length];
    // }
    // public static int minKBitFlips(int[] nums, int k) {
    //     int rev[]=new int[nums.length];
    //     for (int i = 0; i < rev.length; i++) {
    //         rev[i]=nums[i]==0?1:0;
    //     }
    //     int lookInRevArrayFor=0;
    //     int count=0;
    //     for (int i = 0; i < nums.length-k; i++) {
    //         if (lookInRevArrayFor>0) {
    //             lookInRevArrayFor--;
    //             if (rev[i]==0) {
    //                 count++;
    //                 lookInRevArrayFor=-k+1;
    //             }
    //             else nums[i]=1;
    //         }
    //         else{
    //             if (nums[i]==0) {
    //                 count++;
    //                 nums[i]==1;
    //                 lookInRevArrayFor=k-1;
    //             }
    //         }
    //     }
    //     for (int j = 0; j < rev.length; j++) {
    //         if (nums[i]==0) {
    //             return -1;
    //         }
    //     }
    //     return count;
        
    // }
    // public static void push(){
        
    // }
    // public int minKBitFlips(int[] nums, int k) {
    //     int l=0;
    //     int count=0;
    //     for(int i=k;i<nums.length;i++){
    //         if (nums[l]==0) {
    //             count++;
    //             for(int j=l;j<k;j++){
    //                 nums[j]=nums[j]==0?1:0;
    //             }
    //         }
    //         l++;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if (nums[i]==0) {
    //             return -1;
    //         }
    //     }
    //     return count;
    // }
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
       }
    }
    // public static TreeNode bstToGst(TreeNode root) {
    //     List<Integer> arr=new ArrayList<>();
    //     inorderTraversal(arr, root);
    //     int reqArr[]=new int[arr.size()];
    //     int prevSum=0;
    //     int sum=0;
    //     for (int i = 0; i < arr.size(); i++) {
    //         sum+=arr.get(i);
    //     }
    //     for(int i=0;i<arr.size();i++){
    //         reqArr[i]=sum-prevSum;
    //         prevSum+=arr.get(i);
    //     }
    //     helper(reqArr,0,reqArr.length-1);
    //     return newRoot;
    // }
    // private static TreeNode helper(int[] nums, int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }

    //     int mid = left + (right - left) / 2;
    //     TreeNode node = new TreeNode(nums[mid]);

    //     node.left = helper(nums, left, mid - 1);
    //     node.right = helper(nums, mid + 1, right);

    //     return node;
    // }
    // public static void inorderTraversal(List<Integer> arr,TreeNode root){
    //     if(root==null){
    //         arr.add(-1);
    //         return;
    //     }
    //     if (root.left!=null) {
    //         inorderTraversal(arr, root.left);
    //     }
    //     arr.add(root.val);
    //     if (root.right!=null) {
    //         inorderTraversal(arr, root.right);
    //     }
    //     return;
    // }
    
    public static void main(String[] args) {
        
    }
}
