import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.w3c.dom.Node;

import GraphsDSA.edge;

public class Codeshef {
    // public static void(int A[],int B[],int n){
    //     if (n==1) {
    //         System.out.println(1+" ");
    //         return;
    //     }
    //     if(n==2){
    //         System.out.println(1+" "+2);
    //         System.out.println(2+" "+1);
    //     }
    //     if(n==3){
    //         System.out.println(1+" "+2+" "+3" ");
    //         System.out.println(3+" "+1+" "+2" ");
    //         return;
    //     }
    //     for(int i=0;i<n;i++){
    //         A[i]=i+1;
    //         B[i]=i+1;
    //     }
    //     if(n%2==0){
            
    //     }

    // }
    // public int maxDistance(int[] position, int m) {
    //     Arrays.sort(position);

    // }
    // public static int search(int[] position, int m,int start,int end){
    //     int mid=start+(end-start)/2;
    //     if (mid==position[mid]) {
            
    //     }
    // }
    // public static int minimizedMaximum(int n, int[] quantities) {
    //     Arrays.sort(quantities);
    //     int l=1;
    //     int r=quantities[quantities.length-1];
    //     while (l<r) {
    //         int mid=l+(l+r)/2;
    //         if(isPossible(mid,n,quantities)){
    //             r=mid-1;
    //         }
    //         else{
    //             l=mid+1;
    //         }
    //     }
    //     return l;
    // }
    // public static boolean isPossible(int maxPossibleSizeOfEachStore,int n,int quantities[]){
    //     int idxstore=0;
    //     int idxquantity=0;
    //     while (idxquantity!=quantities.length && idxstore<n) {
    //         int toFill=quantities[i];
    //         while (toFill>0 && idxstore<n) {
    //             int availableSpace=maxPossibleSizeOfEachStore;
    //             if (availableSpace>toFill) {
    //                 toFill=0;
    //             }
    //             else{
    //                 toFill-=availableSpace;
    //             }
    //             idxstore++;
    //         }
    //         idxquantity++;
    //     }
    //     return idxquantity==quantities.length;
    // }
    // public static int maximumCandies(int[] candies, long k) {
    //     long min=1;
    //     long max=-1;
    //     for(int i=0;i<candies.length;i++){
    //         max=Math.max(max, (long)candies[i]);
    //     }
    //     while (min<max) {
    //         long mid=min+(max-min)/2;
    //         if(isPossible(mid, k, candies)){
    //             max=mid;
    //         }
    //         else{
    //             min=mid+1;
    //         }
    //     }
    //     return min;
    // }
    // public static boolean isPossible(long Capacity,long k,int candies[]){
    //     long req=0;
    //     for(int i=0;i<candies.length;i++){
    //         req+=(long)Math.ceil(candies[i]/Capacity);
    //         if(req>n) return false;
    //     }
    //     return true;
    // }
    // public static int shipWithinDays(int[] weights, int days) {
    //     int min=1;
    //     int max=500;
        
    //     while (min<max) {
    //         int mid=min+(max-min)/2;
    //         if(isPossible(mid, weights, days)){
    //             max=mid;
    //         }
    //         else min=mid+1;
    //     }
    //     return min;
    // }
    // public static boolean isPossible(int c,int weights[],int days){
    //     int currDaysReq=0;
    //     int sum=0;
    //     for(int i=0;i<weights.length;i++){
    //         sum+=weights[i];
    //         if(Math.ceil(sum/c)>days) return false;
    //     }
    //     return true;
    // }
    // public static class Info implements Comparable<Info>{
    //     int capacity;
    //     int contains;
    //     int req;
    //     public Info(int ca,int c){
    //         this.capacity=ca;
    //         this.contains=c;
    //         this.req=ca-c;
    //     }
    //     @Override
    //     public int compareTo(Info p){
    //         return this.req-p.req;
    //     }
    // }
    // public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    //     PriorityQueue<Info> pq=new PriorityQueue<>();
    //     for(int i=0;i<capacity.length;i++){
    //         pq.add(new Info(capacity[i], rocks[i]));
    //     }
    //     int count=0;
    //     while (!pq.isEmpty() && additionalRocks>0) {
    //         int require=pq.poll().req;
    //         if(require==0) count++;
    //         else{
    //             if (require<additionalRocks) {
    //                 additionalRocks-=require;
    //                 count++;
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public int maximumUnits(int[][] boxTypes, int truckSize) {
    //     Arrays.sort(boxTypes,new Comparable<int[]> {
    //         @Override
    //         public int compareTo(int[] a,int[] b){
    //             return b[1]-a[1];
    //         }
    //     });
    //     int count=0;
    //     for(int i=0;i<boxTypes.length;i++){
    //         int availableBoxes=boxTypes[i][0];
    //         int unitsInEach=boxTypes[i][1];
    //         if(availableBoxes>truckSize){
    //             count+=truckSize*unitsInEach;
    //             break;
    //         }
    //         count+=availableBoxes*unitsInEach;
    //         truckSize-=availableBoxes;
    //     }
    //     return count;
    // }
    // public int returnToBoundaryCount(int[] nums) {
    //     int steps=nums[0];
    //     int count=0;
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]>0){
    //             if(steps<0 && steps+nums[i]>=0) count++;
    //         }
    //         else{
    //             if(steps>0 && steps+nums[i]<=0) count++;
    //         }
    //         steps+=nums[i];
    //     }
    //     return count;
    // }
    // public static int getMoneyAmount(int n) {
    //     if(n<3) return 1;
    //     if(n==1) return 0; 
    //     int req=(n*(n+1))/4;
    //     int comp=0;
    //     int mid=-1;
    //     for(int i=1;i<=n;i++){
    //         comp+=i;
    //         if(comp>=req){
    //             mid=i;
    //             break;
    //         }
    //     }
    //     int cost=mid;
    //     int left=helper(1,mid-1);
    //     int right=helper(mid+1, n);
    //     cost+=Math.max(left, right);
    //     return cost;
    // }
    // public static int helper(int start,int end){
    //     if(start==end) return 0;
    //     if(start-end==1) return start;
    //     if(start-end==2) return start+1;
    //     int mid=start+(end-start)/2;
    //     return mid+Math.max(helper(start,mid-1), helper(mid+1, end));

    // }
    // public boolean isSubsequence(String s, String t) {
    //     Boolean dp[][]=new Boolean[s.length()][t.length()];
    //     return helper(0, 0, dp, s, t);
    // }
    // public static boolean helper(int i,int j,Boolean dp[][],String s,String t){
    //     if(i==s.length()) return true;
    //     if(j==t.length() && i!=s.length()) return false;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j)){
    //         dp[i][j]=(helper(i+1, j+1, dp, s, t) );
    //     }
    //     else{
    //         dp[i][j]=helper(i+1, j, dp, s, t) || helper(i, j+1, dp, s, t);
    //     }
    //     return dp[i][j];
    // }
    // public static int wiggleMaxLength(int[] nums) {
    //     int dp[][]=new int[nums.length][2];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<2;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     int prev=nums[0];
    //     return 1+Math.max(helper(0, nums,0, prev ,dp),helper(0, nums,1, prev,dp));
    // }
    // public static int helper(int idx,int nums[],int moreOrLess,int prev,int dp[][]){
    //     if(idx==nums.length) return 0;
    //     if(dp[idx][moreOrLess]!=-1) return dp[i][j];
    //     if(moreOrLess==1){
    //         if (nums[i]>prev) {
    //             return dp[idx][moreOrLess]=Math.max(1+helper(idx+1, nums,0, nums[i],dp), helper(idx+1, nums,1, prev,dp));
    //         }
    //         else{
    //             return dp[idx][moreOrLess]=helper(idx+1, nums,1, prev,dp);
    //         }
    //     }
    //     else{
    //         if(nums[i]<prev){
    //             return dp[idx][moreOrLess]=Math.max(1+helper(idx+1, nums,1, nums[i],dp),helper(idx+1, nums,0, prev,dp));
    //         }
    //         else{
    //             return dp[idx][moreOrLess]=helper(idx+1, nums,0, prev,dp);
    //         }
    //     }
    // }
    // public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    //     int ans=0;
    //     int max=0;
    //     int curr=0;
    //     for(int i=0;i<customers.length;i++){
    //         if(grumpy[i]==0){
    //             ans+=customers[i];
    //         }
    //         else{
    //             curr=0;
    //             for(int j=i;j<i+minutes && j<customers.length;j++){
    //                 if(grumpy[j]==1){
    //                     curr+=customers[j];
    //                 }
    //             }
    //             max=Math.max(max, curr);
    //         }
    //     }
    //     return ans+max;
    // }
    // public static int combinationSum4(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int dp[][]=new int[nums.length][target+1];
    //     for (int[] is : dp) {
    //         Arrays.fill(is,-1);
    //     }
    //     return helper(0,target,nums,dp);
    // }
    // public static int helper(int idx,int weight,int nums[],int dp[][]){
    //     if (idx==nums.length) return 0;
    //     if (weight==0) return 1;
    //     if (dp[idx][weight]!=-1) return dp[idx][weight];
    //     int ways=0;
    //     if(nums[i]<=weight){
    //         ways+=helper(idx, weight-nums[idx], nums, dp) + helper(idx+1, weight, nums, dp);
    //     }
    //     else{
    //         ways+=helper(idx+1, weight, nums, dp);
    //     }
    //     return dp[idx][weight]=ways;
    // }
    // public static int maxRotateFunction(int[] nums) {
    //     int n=nums.length;
    //     int start=0;
    //     int end=-1;
    //     int max=0;
    //     for(int i=0;i<n;i++){
    //         start=0;
    //         end=n-i;
    //         int curr=0;
    //         for(int j=0;j<n;j++){
    //             if (end<n) {
    //                 curr+=j*nums[end];
    //                 end++;
    //             }
    //             else{
    //                 if (start<end) {
    //                     curr+=j*nums[start];
    //                     start++;
    //                 }
    //             }
    //         }
    //         max=Math.max(max, curr);
    //     }
    //     return max;
    // }
    // public static int integerReplacement(int n) {
    //     return helper(n);
    // }
    // public static int helper(int n){
    //     if(n==1) return 0;
    //     int ways=1;
    //     if(n%2==0){
    //         ways+=helper(n/2);
    //     }
    //     else{
    //         ways+=Math.min(helper(n-1),helper(n+1));
    //     }
    //     return ways;
    // }
    // public static int numberOfArithmeticSlices(int[] nums) {
    //     int dp[]=new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     dp[0]=0;
    //     dp[1]=1;
    //     return helper(2,dp[1]-dp[0],dp,nums);
    // }
    // public static int helper(int idx,int prevDiff,int dp[],int[] nums){
    //     if(idx==nums.length) return 0;
    //     if(dp[idx]!=-1) return dp[idx];
    //     int count=0;
    //     if (prevDiff==dp[idx]-dp[idx-1]) {
    //         count+=1+dp[idx-1]+1;
    //     }
    //     else{

    //     }
    // }
    // public static int integerReplacement(int n) {
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     int ways=0;
    //     pq.add(n);
    //     while (!pq.isEmpty()) {
    //         int curr=pq.poll();
    //         if (curr==1) {
    //             break;
    //         }
    //         ways++;
    //         if (curr%2==0) {
    //             pq.add(curr/2);
    //         }
    //         else{
    //             pq.add(curr+1);
    //             pq.add(curr-1);
    //         }
    //     }
    //     return ways;
    // }
    // public int numberOfArithmeticSlices(int[] nums) {
    //     int n=nums.length;
    //     int count=0;
    //     if(n<3) return 0;
    //     int start=0;
    //     int end=0;
    //     int diff=0;
    //     int length=0;
    //     while (start<=n-3) {
    //         end=start+1;
    //         diff=nums[end]-nums[start];
    //         while (end<n-1 && diff==nums[end+1]-nums[end]) {
    //             end++;
    //         }
    //         length=start-end;
    //         count+=(length-2)*(length-1)/2;
    //         start=end;
    //     }
    //     return count;
    // }
    {
        class Solution {
            int[] t;
            public int combinationSum4(int[] nums, int target) {
                t = new int[target+1];
                Arrays.fill(t,-1);
                return solve(nums,target);
            }
            public int solve(int[] nums, int target)
            {
                if(target == 0) {
                    return 1;
                }
                if(target < 0) {
                    return 0;
                }
                
                if(t[target] != -1) {
                    return t[target];
                }
                
                int result = 0;
                for(int i = 0; i<nums.length;i++) {
                    result += solve(nums, target-nums[i]);
                }
                return t[target] = result;
            }
        }
    }
    // public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> currList=new ArrayList<>();
    //     helper(target, candidates, currList, ans,0);
    //     return ans;
    // }
    // public static void helper(int t,int[] candidates,List<Integer> currList,List<List<Integer>> ans,int start){
    //     if(t==0){
    //         ans.add(new ArrayList<>(currList));
    //         return;
    //     }
    //     if (t<0) {
    //         return;
    //     }
    //     for(int i=start;i<candidates.length;i++){
    //         currList.add(candidates[i]);
    //         helper(t-candidates[i], candidates, currList, ans,i+1);
    //         currList.removeLast();
    //     }
    //     return;
    // }
    // public static List<List<Integer>> combinationSum3(int k, int n) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> currList=new ArrayList<>();
    //     helper(n, k, n, ans, currList,1);
    //     return ans;
    // }
    // public static void helper(int n,int k,int start,List<List<Integer>> ans,List<Integer> currList,int start){
    //     if(n==0){
    //         ans.add(new ArrayList<>(currList));
    //         return;
    //     }
    //     if(n<0) return;
    //     if(k<0) return;
    //     for(int i=start;i<=9;i++){
    //         currList.add(i);
    //         helper(n-i, k-1, start, ans, currList,i+1);
    //         currList.removeLast();
    //     }
    //     return;
    // }
    // public static int numberOfSubarrays(int[] nums, int k) {
    //     int count=0;
    //     int ans=0;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i;j<nums.length;j++){
    //             count=0;
    //             for(int k=i;k<=j;k++){
    //                 if(nums[k]%2!=0) count++;
    //             }
    //             if(count>=k) ans++;
    //         }
    //     }
    //     return ans;
    // }
    // public int countDistinct(int[] nums, int k, int p) {
        
    // }
    // public static int minimumOperations(int[] nums) {
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         count+=helper(nums[i]);
    //     }
    //     return count;
    // }
    // public static int helper(int n){
    //     if(n%3==0) return 0;
    //     else{
    //         return 1+Math.min(helper(n+1),helper(n-1));
    //     }
    // }
    // public int minOperations(int[] nums) {
    //     int reverse[]=new int[nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         reverse[i]=nums[i]==0?1:0;
    //     }
    //     int checkArray=1;
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         if (checkArray==1) {
    //             if (nums[i]==0) {
    //                 count++;
    //                 checkArray=2;
    //             }
    //         }
    //         else{
    //             if(reverse[i]==0){
    //                 count++;
    //                 checkArray=1;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public int numberOfPermutations(int n, int[][] requirements) {
    //     int arr[]=new int[n];
    //     int freeSpaces=n;
    //     Arrays.sort(requirements, (a, b) -> -a[0] + b[0]);
    //     for(int i=0;i<requirements.length;i++){
    //         int req=requirements[i][1];
    //         while (arr[n-req-1]!=0 && req!=0) {
    //             arr[n-req-1]=requirements[i][0];
    //             freeSpaces--;
    //         }
    //     }
    //     return 1;
    // }
    // public static double minimumAverage(int[] nums) {
    //     double min=Integer.MAX_VALUE;
    //     Arrays.sort(nums);
    //     int minIdx=0;
    //     int maxIdx=nums.length-1;
    //     double curr=(double)nums[0];
    //     while (minIdx<maxIdx) {
    //         curr=((double)nums[minIdx] +(double)nums[maxIdx])/2.0;
    //         min=Math.min(min, curr);
    //         minIdx++;
    //         maxIdx--;
    //     }
    //     return min;
    // }
    // public static int minimumArea(int[][] grid) {
    //     int minHIdx=Integer.MAX_VALUE;
    //     int maxHIdx=Integer.MIN_VALUE;

    //     int minVIdx=Integer.MAX_VALUE;
    //     int maxVIdx=Integer.MIN_VALUE;

    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[i].length;j++){
    //             if (grid[i][j]==1) {
    //                 minHIdx=Math.min(minHIdx, i);
    //                 maxHIdx=Math.max(maxHIdx,i);

    //                 minVIdx=Math.min(minVIdx, j);
    //                 maxVIdx=Math.max(maxVIdx, j);
    //             }
    //         }
    //     }
    //     int ans=(maxHIdx-minHIdx+1)*(maxVIdx-minVIdx+1);
    //     return ans;
    // }
//     public long maximumTotalCost(int[] nums) {
//         int negaTiveSum=0;
//         int posiTiveSum=0;

//         int sum=0;
//         int maxsum=0;

//         for(int i=0;i<nums.length;i++){
//             if (nums[i]>0) {
//                 posiTiveSum+=nums[i];
//             }
//             else negaTiveSum+=nums[i];
//             if (i%2==0) {
//                 sum=-posiTiveSum+negaTiveSum;
//             }
//             else{
//                 sum=posiTiveSum-negaTiveSum;
//             }
//             maxsum=Math.max(maxsum,sum);
//         }
//         return maxsum;
//     }
//     class Solution {
//     public int rectangleArea(int[][] rectangles) {
//         int n = rectangles == null ? 0 : rectangles.length;
//         if (n == 0) return 0;
//         long xmin = Long.MAX_VALUE;
//         long ymin = Long.MAX_VALUE;
//         long xmax = Long.MIN_VALUE;
//         long ymax = Long.MIN_VALUE;
//         for(int[] r: rectangles) {
//             if (r[0] < xmin) xmin = r[0];
//             if (r[1] < ymin) ymin = r[1];
//             if (r[2] > xmax) xmax = r[2];
//             if (r[3] > ymax) ymax = r[3];
//         }
//         Node root = new Node(xmin, ymin, xmax, ymax, false);
//         for(int[] r: rectangles) {
//             root.add(r[0], r[1], r[2], r[3]);
//         }
//         return (int)(root.getFilledArea() % 1000000007L);
//     }
//     static class Node {
//         long x1, y1, x2, y2;
//         boolean filled;
//         Node tl, tr, bl, br;
//         Node(long x1, long y1, long x2, long y2, boolean filled) {
//             this.x1 = x1;
//             this.x2 = x2;
//             this.y1 = y1;
//             this.y2 = y2;
//             this.filled = filled;
//         }
//         void add(int x1, int y1, int x2, int y2) {
//             if (tl == null && filled) {
//                 return;
//             }
//             if (x1 >= this.x2 || x2 <= this.x1 || y1 >= this.y2 || y2 <= this.y1) {
//                 return;
//             }
//             if (x1 <= this.x1 && y1 <= this.y1 && x2 >= this.x2 && y2 >= this.y2) {
//                 filled = true;
//                 tl = tr = bl = br = null;
//                 return;
//             }
//             if (tl == null) {
//                 long x = this.x1 < x1 ? x1 : Math.min(x2, this.x2);
//                 long y = this.y1 < y1 ? y1 : Math.min(y2, this.y2);
//                 bl = new Node(this.x1, this.y1, x, y, false);
//                 br = new Node(x, this.y1, this.x2, y, false);
//                 tl = new Node(this.x1, y, x, this.y2, false);
//                 tr = new Node(x, y, this.x2, this.y2, false);
//             }
//             bl.add(x1, y1, x2, y2);
//             br.add(x1, y1, x2, y2);
//             tl.add(x1, y1, x2, y2);
//             tr.add(x1, y1, x2, y2);
//         }
//         long getFilledArea() {
//             long area;
//             if (tl == null) {
//                 area = filled ? (x2-x1) * (y2-y1) : 0;
//             } else {
//                 area = tl.getFilledArea() + tr.getFilledArea() + bl.getFilledArea() + br.getFilledArea();
//             }
//             return area;
//         }
//     }
// }
    // public static int longestSubarray(int[] nums, int limit) {
    //     int l=0;
    //     int r=0;
    //     int curDiff=Integer.MAX_VALUE;
    //     int maxLength=-1;
    //     while (l<nums.length ) {
    //         for(int i=l;i<nums.length;i++){
    //             if(Math.abs(nums[l]-nums[i])>limit) break;
    //             else{
    //                 maxLength=Math.max(maxLength, l-i+1);
    //             }
    //         }
    //         l++;
    //     }
    //     return maxLength;
    // }
    // public int partitionArray(int[] nums, int k) {
    //     PriorityQueue<Integer> min=new PriorityQueue<>();
    //     PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

    //     int count=1;
    //     int elementsProcessed=0;

    //     boolean vis[]=new boolean[nums.length];

    //     while (elementsProcessed!=nums.length) {
            
    //         for(int i=0;i<nums.length;i++){
    //             if (!vis[i]) {
    //                 min.add(nums[i]);
    //                 max.add(nums[i]);
    //                 elementsProcessed++;
    //                 if(max.peek()-min.peek()>k){
    //                     if(max.peek()==nums[i]) max.poll();
    //                     if(min.peek()==nums[i]) min.poll();
    //                     elementsProcessed--;
    //                     count++;
    //                     vis[i]=false;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public int maximumBeauty(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     int l=0;
    //     int r=0;
    //     int upperBound=nums[0]+k;
    //     int max=0;
    //     while (l<nums.length) {
    //         while (nums[r]<=upperBound) {
    //             r++;
    //         }
    //         max=Math.max(max,l-r);
    //         l=r;
    //         upperBound=nums[r]+k;
    //     }
    //     return max;
    // }
    // public int maximumBeauty(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     int l=0;
    //     int max=0;
    //     for(int r=0;r<nums.length;r++){
    //         while (nums[r]-nums[l]>2*k) {
    //             j++;
    //         }
    //         max=Math.max(max, l-r+1);
    //     }
    //     return max;
    // }
    // public int lengthOfLongestSubstring(String s) {
    //     int l=0;
    //     int max=0;
    //     HashMap<Char,Integer> hm=new 
    //     for(int i=0;i<s.length();i++){

    //         while () {
                
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(minimumOperations(nums));
    }
    
}
