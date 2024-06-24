import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.html.StyleSheet.ListPainter;
import javax.swing.tree.TreeNode;

public class wedkjgbdgvoidnvw {
    // public static int countCompleteDayPairs(int[] hours) {
    //     if (hours == null || hours.length == 0) {
    //         return 0;
    //     }
    //     int[] remainderCount = new int[24];
    //     int count = 0;
        
    //     for (int hour : hours) {
    //         long remainder = (long) hour % 24; 
    //         System.out.println("Remainder :"+remainder);
    //         int complement = (int) ((24 - remainder) % 24); 
    //         count += remainderCount[complement];
    //         remainderCount[(int) remainder]++;
    //     }
        
    //     return count;
    // }
//     public static int minPatches(int[] nums, int n) {
//         HashSet<Integer> hs=new HashSet<>();

//         int prefix[]=new int[nums.length];
//         prefix[0]=nums[0];

//         for(int i=1;i<nums.length;i++){
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 if (i==0) {
//                     hs.add(prefix[j]);
//                 }
//                 else{
//                     hs.add(prefix[j]-prefix[i-1]);
//                 }
//             }
//         }
//         int count=0;
//         for(int i=1;i<=n;i++){
//             if(!hs.contains(i)){
//                 count++;
//                 HashSet<Integer> toAdd=new HashSet<>();
//                 for (Integer element : hs) {
//                     int x=element+2;
//                     toAdd.add(x);
//                 }
//                 hs.addAll(toAdd);
//             }
//         }
//         return count;
//    }
    // public static long countPairs(int n, int[][] edges) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     int count=0;
    //     Boolean dp[][]=new Boolean[n][n];
    //     for(int i=0;i<n;i++){
    //         boolean vis[]=new boolean[n];;
    //         int totalVisited=dfs(i, vis, graph);
    //         count+=(n-totalVisited);
    //     }
    //     return count/2;
    // }
    // public static int dfs(int src,boolean vis[],ArrayList<Integer> graph[]){
    //     vis[src]=true;
    //     int count=1;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         if (!vis[des]) {
    //             count+=dfs(des, vis, graph);
    //         }
    //     }
    //     return count;
    // }
    // public static int closestMeetingNode(int[] edges, int node1, int node2) {
    //     HashSet<Integer> hs=new HashSet<>();
    //     dfs(node1, edges,new boolean[edges.length], hs);
    //     return check(node2, edges,new boolean[edges.length], hs);
    // }
    // public static int check(int src,int[] edges,boolean vis[],HashSet<Integer> hs){
    //     vis[src]=true;
    //     if (hs.contains(src)) {
    //         return src;
    //     }
    //     if (edges[src]!=-1 && !vis[src]) {
    //         return check(edges[src], edges, vis, hs);
    //     }
    //     return -1;
    // }
    // public static void dfs(int src,int[] edges,boolean vis[],HashSet<Integer> hs){
    //     vis[src]=true;
    //     hs.add(src);
    //     if(edges[src]!=-1 && !vis[edges[src]]){
    //         dfs(edges[src], edges, vis, hs);
    //     }
    // }
    // public static int reachableNodes(int n, int[][] edges, int[] restricted) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     int count[]=new int[n];
    //     for(int i=0;i<restricted.length;i++){
    //         count[restricted[i]]=-1;
    //     }
    //     int max=-1;
    //     boolean vis[]=new boolean[n];
    //     for(int i=0;i<n;i++){
    //         if(count[i]!=-1){
    //             int curr=dfs(i, graph, count, vis);
    //             max=Math.max(max, curr);
    //         }
    //     }
    //     return max;
    // }
    // public static int dfs(int src,ArrayList<Integer> graph[],int count[],boolean vis[]){
    //     if(count[src]==-1) return 0;
    //     if(count[src]!=0) return count[src];
    //     vis[src]=true;
    //     int coun=1;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         if(!vis[des]){
    //             coun+=dfs(des, graph, count, vis);
    //         }
    //     }
    //     vis[src]=false;
    //     return count[src]=coun;
    // }
    // public static int edgeScore(int[] edges) {
    //     int indeg[]=new int[edges.length];
    //     for(int i=0;i<edges.length;i++){
    //         indeg[edges[i]]+=i;
    //     }
    //     int max=-1;
    //     for(int i=0;i<edges.length;i++){
    //         if(indeg[i]>max){
    //             max=indeg[i];
    //         }
    //     }
    //     return max;
    // }
    // public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    //     int n=amount.length;
    //     int dist[]=new int[n];
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     dfs
    // }
    // public static void dfs(int src,boolean vis[],int dis[],ArrayList<Integer> graph[],int amount[],int currAmount){

    // }
    // public static class Pair implements Comparable<Pair>{
    //     int des;
    //     int wt;
    //     public Pair(int d,int w){
    //         this.des=d;
    //         this.wt=w;
    //     }
    //     @Override
    //     public int compareTo(Pair p){
    //         return this.wt-p.wt;
    //     }
    // }
    // public static int minScore(int n, int[][] roads) {
    //     ArrayList<Pair> graph[]=new ArrayList[n+1];
    //     for(int i=0;i<n+1;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] road : roads) {
    //         int src=road[0];
    //         int des=road[1];
    //         int wt=road[2];
    //         graph[src].add(new Pair(des, wt));
    //         graph[des].add(new Pair(src, wt));
    //     }
    //     boolean vis[]=new boolean[n+1];
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     int min=Integer.MAX_VALUE;
    //     pq.add(new Pair(1,0));
    //     while (!pq.isEmpty()) {
    //         Pair curr=pq.poll();
    //         if (!vis[curr.des]) {
    //             vis[curr.des]=true;
    //             for(int i=0;i<graph[curr.des].size();i++){
    //                 Pair d=graph[curr.des].get(i);
    //                 min=Math.min(min, d.wt);
    //                 pq.add(new Pair(d.des, d.wt));
    //             }
    //         }
    //     }
    //     return min;
    // }
    // public static class Pair implements Comparable<Pair>{
    //     int src;
    //     int val;
    //     public Pair(int s,int v){
    //         this.src=s;
    //         this.val=v;
    //     }
    //     @Override
    //     public int compareTo(Pair p){
    //         return -this.val-p.val;
    //     }
    // }
    // public static int maxStarSum(int[] vals, int[][] edges, int k) {
    //     int n=vals.length;
    //     ArrayList<Pair> graph[]=new ArrayList[n];
    //     int indeg[]=new int[n];
        
    //     for (int[] edge : edges) {
    //         int src=edge[0];
    //         int des=edge[1];
    //         graph[src].add(new Pair(des,vals[des]));
    //         graph[des].add(new Pair(src, vals[src]));
    //         indeg[src]++;
    //         indeg[des]++;
    //     }
        
    //     int maxAmount=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         if (indeg[i]>=k) {
    //             int currAmount=0;
    //             PriorityQueue<Pair> pq=new PriorityQueue<>();
    //             currAmount+=vals[i];
    //             int temp=k;
    //             for(int j=0;j<graph[i].size();j++){
    //                 pq.add(graph[i].get(j));
    //             }
    //             while (temp>0) {
    //                 currAmount+=pq.poll().val;
    //                 temp--;
    //             }
    //             maxAmount=Math.max(currAmount, maxAmount);
    //         }
    //     }
    //     return maxAmount;
    // }
    // public static int maxProfit(int[] prices) {
    //     int buyprice=prices[0];
    //     int maxProfit=0;
    //     for(int i=0;i<prices.length;i++){
    //         if(prices[i]>buyprice){
    //             maxProfit=Math.max(maxProfit,prices[i]-buyprice);
    //         }else{
    //             buyprice=prices[i];
    //         }
    //     }
    //     return maxProfit;
    // }
    // public static class Pair{
    //     int nodes;
    //     int edges;
    //     public Pair(int n,int e){
    //         this.nodes=n;
    //         this.edges=e;
    //     }
    // }
    // public static int countCompleteComponents(int n, int[][] edges) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     boolean vis[]=new boolean[n];
    //     int count=0
    //     for(int i=0;i<n;i++){
    //         if(!vis[i]){
    //             Pair curr=dfs(i, vis, graph);
    //             int e=curr.edges,v=curr.nodes;
    //             if(e==((v)*(v-1))/2) count++;
    //         }
    //     }
    //     return count;
    // }
    // public static Pair dfs(int src,boolean vis[],ArrayList<Integer> graph[]){
    //     vis[src]=true;
    //     int nodes=1;
    //     int edges=0;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         if(!vis[des]){
    //             edges++;
    //             Pair curr=dfs(des, vis, graph);
    //             nodes+=curr.nodes;
    //             edges+=curr.edges;
    //         }
    //     }
    //     return new Pair(nodes, edges);
    // }
    
    // public static List<TreeNode> generateTrees(int n) {
    //     List<TreeNode> ans=new ArrayList<>();
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp, -1);
    //     catalan(n, dp);
    //     return ans;
    // }
    // public static int catalan(int n,int dp[]){
    //     if (n==0 || n==1) return 1;
    //     if (dp[n]!=-1) return dp[n];
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         ans+=catalan(i, dp)*catalan(n-i-1, dp);
    //     }
    //     return dp[n]=ans;
    // }
    // public static List<TreeNode> generateTrees(int n) {
    //     return generate(1,n);
    // }
    // public static List<TreeNode> generate(int start,int end){
    //     List<TreeNode> ans=new ArrayList<>();
    //     if (start>end) {
    //         ans.add(null);
    //         return ans;
    //     }
    //     for(int i=start;i<=end;i++){
    //         List<TreeNode> left=generate(start,i-1);
    //         List<TreeNode> righList=generate(i+1, end);

    //         for (TreeNode l : left) {
    //             for (TreeNode r : righList) {
    //                 TreeNode temp=new TreeNode(i);
    //                 temp.left=l;
    //                 temp.right=r;
    //                 ans.add(temp);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public static List<Integer> getRow(int rowIndex) {
    //     int dp[][]=new int[rowIndex][rowIndex];
    //     for(int i=0;i<=rowIndex;i++){
    //         for(int j=0;j<=i;j++){
    //             if(j==0 || j==i) dp[i][j]=1;
    //             else{
    //                 dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    //             }
    //         }
    //     }
    //     List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<=rowIndex;i++){
    //         ans.add(dp[rowIndex][i]);
    //     }
    //     return ans;
    // }
    // public static boolean wordBreak(String s, List<String> wordDict) {
    //     HashSet<String> hs=new HashSet<>();
    //     for (String str : wordDict) {
    //         hs.add(str);
    //     }
    //     Boolean dp[]=new Boolean[s.length()];`
    //     return check(new StringBuilder(""), s, hs, 0, dp);
    // }
    // public static boolean check(StringBuilder curr,String s,HashSet<String> hs,int idx,Boolean dp[]){
    //     if(dp[idx]!=null) return dp[idx];
    //     if(idx==s.length()){
    //         if(curr.length()==0) return dp[idx]=true;
    //         else return dp[idx]=false;
    //     }
    //     else{
    //         curr.append(s.charAt(idx));
    //         if(hs.contains(curr)){
    //             return dp[idx]=(check(curr, s, hs, idx+1,dp) || check(curr.delete(0), s, hs, idx,dp));
    //         }
    //         else{
    //             return dp[idx]=check(curr, s, hs, idx+1,dp);
    //         }
    //     }
    // }
    // public static class Pair implements Comparable<Pair> {
    //     int difficulty;
    //     int profit;
    //     public Pair(int d,int p){
    //         this.difficulty=d;
    //         this.profit=p;
    //     }
    //     @Override
    //     public int compareTo(Pair P){
    //         return this.difficulty-P.difficulty;
    //     }
    // }
    // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    //     int profit=0;
    //     for(int i=0;i<worker.length;i++){
    //         int currDifficulty=worker[i];
    //         PriorityQueue<Pair> pq=new PriorityQueue<>();
    //         for(int j=0;j<difficulty.length;j++){
    //             if(difficulty[j]>=currDifficulty){
    //                 pq.add(new Pair(difficulty[j], profit));
    //             }
    //         }
    //         profit+=pq.poll().profit;
    //     }
    //     return profit;
    // }
    // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     for(int i=0;i<difficulty.length;i++){
    //         pq.add(new Pair(difficulty[i], profit[i]));
    //     }
    //     int idx=0;
    //     Arrays.sort(worker);
    //     Stack<Integer> s=new Stack<>();
    //     for(int i=0;i<worker.length;i++){
    //         s.push(worker[i]);
    //     }
    //     int amount=0;
    //     while (!pq.isEmpty() && !s.isEmpty()) {
    //         Pair curr=pq.poll();
    //         while (s.pop()>=curr.difficulty) {
    //             amount+=curr.profit;
    //         }
    //     }
    //     return amount;
    // }
    // public static boolean contains(int arr[]){

    // }
    // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    //     List<Pair> li=new ArrayList<>();
    //     int maxDifficulty=-1;
    //     for(int i=0;i<profit.length;i++){
    //         li.add(new Pair(difficulty[i],profit[i]));
    //         maxDifficulty=Math.max(maxDifficulty, difficulty[i]);
    //     }
    //     Collections.sort(li);
    //     int maxProfitTillDifficulty[]=new int[maxDifficulty+1];
    //     for(int i=0;i<li.size();i++){
    //         maxProfitTillDifficulty[li.get(i).difficulty]=li.get(i).profit;
    //     }
    //     for(int i=1;i<=maxDifficulty;i++){
    //         maxProfitTillDifficulty=Math.max(maxProfitTillDifficulty[i],maxProfitTillDifficulty[i-1]);
    //     }
    //     int amount=0;
    //     for(int i=0;i<worker.length;i++){
    //         if(difficulty[i]>maxDifficulty){
    //             amount+=maxProfitTillDifficulty[maxDifficulty];
    //         }
    //         else{
    //             amount+=maxProfitTillDifficulty[difficulty[i]];
    //         }
    //     }
    //     return amount;
    // }
    // public static int maxProfit(int[] prices) {
    //     return helper(prices, 2, 0, Integer.MAX_VALUE, 0);
    // }
    // public static int helper(int prices[],int k,int idx,int currBuyPrice,int maxAmount){
    //     if (idx==prices.length) {
    //         return 0;
    //     }
    //     if (k==0) {
    //         return 0;
    //     }
    //     if (currBuyPrice==Integer.MAX_VALUE) {
    //         return Math.max(helper(prices, k, idx+1, prices[idx], maxAmount), helper(prices, k, idx+1, currBuyPrice, maxAmount));
    //     }
    //     else if(currBuyPrice<prices[idx]){
    //         return Math.max(helper(prices, k-1, idx+1,Integer.MAX_VALUE, maxAmount+prices[idx]), helper(prices, k, idx+1, currBuyPrice, maxAmount));
    //     }
    //     else{
    //         return Math.max(helper(prices, k, idx+1, prices[i], maxAmount), helper(prices, k, idx+1, currBuyPrice, maxAmount));
    //     }
    // }
    // public static int maxProfit(int k, int[] prices) {
    //     int dp[][][]=new int[prices.length+1][k+1][2];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<dp[i].length;k++){
    //             for(int k=0;k<dp[i][j].length;k++){
    //                 dp[i][j][k]=-1;
    //             }
    //         }
    //     }
    //     return helper(0, k, prices, 1);
    // }
    // public static int helper(int idx,int k, int[] prices,int buy){
    //     if(idx==prices.length || k==0) return 0;
    //     if(dp[idx][k][buy]!=-1) return dp[idx][k][buy];
    //     if(buy==1){
    //         int buy=-prices[idx]+helper(idx+1, k, prices,0);
    //         int skip=helper(idx+1, k, prices,1);
    //         dp[idx][k][buy]=Math.max(skip, buy);
    //     }
    //     else{
    //         int sell=prices[idx]+helper(idx+1, k-1, prices,1);
    //         int skip=helper(idx+1, k, prices,0);
    //         dp[idx][k][buy]=Math.max(skip, buy);
    //     }
    //     return dp[idx][k][buy];
    // }
    // public static int lengthOfLIS(int[] nums) {
    //     HashSet<Integer> hs=new HashSet<>(nums);
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     for (Integer num : hs) {
    //         arr.add(num);
    //     }
    //     Collections.sort(arr);
    //     return lcs(0, 0, nums, arr);
    // }
    // public static int lcs(int i,int j,int nums[],ArrayList<Integer> arr){
    //     if(i==nums.length || j==arr.size()) return 0;
    //     if(nums[i]==arr.get(j)){
    //         return 1+lcs(i+1, j+1, nums, arr);
    //     }
    //     else{
    //         return Math.max(lcs(i+1, j, nums, arr), lcs(i, j+1, nums, arr));
    //     }
    // }
    // public static int maxProduct(int[] nums) {
    //     int dp[][]=new int[nums.length][nums.length];
    //     for(int i=0;i<dp.length;i++){
    //        Arrays.fill(dp[],1);
    //     }
    //     int totMax=Integer.MIN_VALUE;
    //     int lineMax=Integer.MIN_VALUE;
    //     for(int i=0;i<nums.length;i++){
    //         dp[i][i]=lineMax=nums[i];
    //         for(int j=i+1;j<nums.length;j++){
    //             dp[i][j]=nums[j]*dp[i][j-1];
    //             lineMax=Math.max(lineMax, dp[i][j]);
    //         }
    //         totMax=Math.max(lineMax, totMax);
    //     }
    //     return totMax;
    // }
    // public static int maxProduct(int[] nums) {
    //     int dp[]=new int[nums.length];
    //     int totMax=Integer.MIN_VALUE;
    //     int lineMax=Integer.MIN_VALUE;
    //     for(int i=0;i<nums.length;i++){
    //         dp[i]=lineMax=nums[i];
    //         for(int j=i+1;j<nums.length;j++){
    //             dp[j]=nums[j]*dp[j-1];
    //             lineMax=Math.max(lineMax, dp[j]);
    //         }
    //         totMax=Math.max(lineMax, totMax);
    //     }
    //     return totMax;
    // }
    // public int nthUglyNumber(int n) {
    //     HashSet<Integer> hs =new HashSet<>();
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     int primes[]={2,3,5};
    //     pq.add(2);
    //     pq.add(3);
    //     pq.add(5);
    //     int curr=0;
    //     while (n>0) {
    //         curr=pq.poll();
    //         n--;
    //         for(int i=0;i<3;i++){
    //             int newUgly=curr*primes[i];
    //             if(!hs.contains(newUgly)){
    //                 pq.add(newUgly);
    //                 hs.add(newUgly);
    //             }
    //         }
    //     }
    //     return curr;
    // }
    // public boolean isUgly(int n) {
    //     while (n%2==0) {
    //         n=n/2;
    //     }
    //     while (n%3==0) {
    //         n=n/3;
    //     }
    //     while (n%5==0) {
    //         n=n/5;
    //     }
    //     return n==1;
    // }
    // public static int countPrimes(int n) {
    //     boolean notvis[]=new boolean[n+1];
    //     for(int i=0;i<notvis.length;i++){
    //         notvis[i]=true;
    //     }
    //     check(n, notvis);
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         if(notvis[i]) count++;
    //     }
    //     return count;
    // }
    // public static void check(int n,boolean notvis[]){
    //     notvis[0]=false;
    //     notvis[1]=false;

    //     for(int i=2;i*i<n;i++){
    //         if(notvis[i]){
    //             for(int j=i*i;j<n;j+=i){
    //                 notvis[j]=true;
    //             }
    //         }
    //     }
    //     return;
    // }
    // public static int maxProfit(int[] prices) {
    //     int dp[][]=new int[prices.length][2];
    //     for(int i=0;i<prices.length;i++){
    //         for(int j=0;j<2;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return helper(0, prices, 0, Integer.MAX_VALUE, dp,1);
    // }
    // public static int helper(int idx,int prices[],int freeze,int buyprice,int dp[][],int buyOrsell){
    //     if (idx==prices.length) {
    //         return 0;
    //     }
    //     if (dp[idx][buyOrsell]!=-1) {
    //         return dp[idx][buyOrsell];
    //     }
    //     int profit=0;
    //     if(buyOrsell==0){
    //         int sell=prices[idx]+helper(idx+2, prices,1,Integer.MAX_VALUE,dp,1);
    //         int keep=helper(idx+1, prices,0, buyprice, dp,0);
    //         profit=Math.max(keep,sell);
    //     }
    //     else{
    //         int buy=-prices[idx]+helper(idx+1, prices, 0,prices[idx], dp,0);
    //         int stay=helper(idx+1, prices, freeze, buyprice, dp,1);
    //         Math.max(stay, buy);
    //     }
    //     return dp[idx][buyOrsell]=profit;
    // }
    // public static int minDays(int[] bloomDay, int m, int k) {
    //     if(m*k>bloomDay.length) return -1;
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     for(int i=0;i<bloomDay.length;i++){
    //         pq.add(bloomDay[i]);
    //     }
    //     int till=0;
    //     for(int i=0;i<m*k;i++){
    //        till=pq.poll();
    //     }
    //     boolean bloomed[]=new boolean[bloomDay.length];
    //     makeTrue(bloomed, till, bloomDay);
    //     if (check(m, k, bloomed)) {
    //         return till;
    //     }
    //     else{
    //         while (!pq.isEmpty()) {
    //             till=pq.poll();
    //             System.out.println(till);
    //             makeTrue(bloomed, till, bloomDay);
    //             if (check(m, k, bloomed)) {
    //                 return till;
    //             }
    //         }
    //     }
    //     return -1;
    // }
    // public static void makeTrue(boolean bloomed[],int till,int bloomDay[]){
    //     for(int i=0;i<bloomDay.length;i++){
    //         if (bloomDay[i]<=till) {
    //             bloomed[i]=true;
    //         }
    //     }
    //     return;
    // }
    // public static boolean check(int m,int k,boolean bloomed[]){
    //     int idx=0;
    //     while (m>0 && idx<bloomed.length) {
    //         System.out.println(idx);
    //         if (bloomed[idx]) {
    //             int temp=idx;
    //             boolean flag=false;
    //             for(int i=temp+1;i<=k+temp && i<bloomed.length;i++){
    //                 idx++;
    //                 flag=bloomed[i];
    //                 if(!bloomed[i]) break;
    //             }
    //             if(flag){
    //                 m--;
    //             }
    //             // idx--;
    //         }
    //         else idx++;
    //     }
    //     return m==0;
    // }
    // public static int nthSuperUglyNumber(int n, int[] primes) {
        
    // }
    // public static int nthSuperUglyNumber(int n, int[] primes) {
    //     if(n<2) return n;
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     pq.add(1);
    //     for(int i=0;i<primes.length;i++){
    //         pq.add(primes[i]);
    //     }
    //     HashSet<Integer> hs=new HashSet<>();
    //     int curr=0;
    //     while (n>1 && !pq.isEmpty()) {
    //         curr=pq.poll();
    //         n--;
    //         for(int i=0;i<primes.length;i++){
    //             int newnum=curr*primes[i];
    //             if(!hs.contains(newnum)){
    //                 pq.add(newnum);
    //             }
    //         }
    //     }
    //     return curr;
    // }
    // public int[] countBits(int n) {
    //     int ans[]=new int[n+1];
    //     ans[0]=0;
    //     for(int i=1;i<=n;i++){
    //         ans[i]=ans[i>>1]+i&1;
    //     }
    //     return ans;
    // }
    // public static class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode() {}
    //     TreeNode(int val) { this.val = val; }
    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //         this.val = val;
    //         this.left = left;
    //         this.right = right;
    //    }
    // }
    // public static int rob(TreeNode root) {
    //     int dp[][]=new int[1e4][2];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<2;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return helper(root,1 ,dp);
    // }
    // public static int helper(TreeNode root,int canBuy,int dp[][]){
    //     if(root==null) return 0;
    //     if(dp[])
    //     int l=0,r=0,tot=0;
    //     if(canBuy==1){
    //         int buy=root.val+helper(root.left,0)+helper(root.right,0);
    //         int skip=helper(root.left,1)+helper(root.right,1);
    //         tot=Math.max(skip, buy);
    //     }
    //     else{
    //         int skip=helper(root.left,1)+helper(root.right,1);
    //         tot=skip;
    //     }
    //     return tot;
    }
    // public static int countNumbersWithUniqueDigits(int n) {
    //     if(n==1) return 10;
    //     if(n==0) return 1;
    //     if(n==2) return 91;
        
    //     int dp[]=new int[n+1];
    //     dp[1]=10;
    //     dp[2]=81;
    //     for(int i=3;i<=n;i++){
    //         dp[i]=Numbers(i);
    //     }
    //     int ans=0;
    //     for(int i=0;i<=n;i++){
    //         ans+=dp[i];
    //     }
    //     return ans;
    // }
    // public static int Numbers(int n){
    //     int product=9;
    //     n--;
    //     int temp=9;
    //     while (n>0) {
    //         product*=temp;
    //         temp--;
    //         n--;
    //     }
    //     return product;
    // }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min, nums[i]);
        }
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.add(min);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%min==0) q.add(nums[i]);
        }

    }
    public static List<Integer> helper(PriorityQueue<Integer> q){
        List<Integer> ans=new ArrayList<>();
        ans.add(q.poll());
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int
    }
    public static void main(String[] args) {
        // int bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
        int b[]={7,7,7,7,12,7,7};
        int m=2;
        int k=3;
        System.out.println(minDays(b, m, k));
    }
}
