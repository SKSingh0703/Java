import java.util.*;

import GraphsDSA.edge;

public class GraphLeetCodeQuestions {
    // public static int minIncrementForUnique(int[] nums) {
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         hm.put(nums[i],hm.getOrDefault(hm.get(nums[i]),0)+1);
    //     }
    //     int count=0;
    //     int idx=0;
    //     for(int i=0;i<nums.length;i++){
    //         if (hm.get(nums[i])==1) {
    //             continue;
    //         }
    //         else{
    //             int curr=nums[i];
    //             hm.put(nums[i],hm.get(nums[i])-1);
    //             while (hm.containsKey(curr)) {
    //                 count++;
    //                 curr+=1;
    //             }
    //             nums[i]=curr;
    //             hm.put(curr,1);
    //         }
    //     }
    //     return count;
    // }
    // public static int minIncrementForUnique(int[] nums) {
    //     HashSet<Integer> hs=new HashSet<>();
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         if (hs.contains(nums[i])) {
    //             int curr=nums[i];
    //             while (!hs.contains(curr)) {
    //                 count+=1;
    //                 curr+=1;
    //             }
    //             hs.add(curr);
    //             nums[i]=curr;
    //         }
    //         else{
    //             hs.add(nums[i]);
    //         }
    //     }
    //     return count;
    // }
    // public static int maximalNetworkRank(int n, int[][] roads) {
    //     int indeg[]=new int[n];
    //     boolean isEdge[][]=new boolean[n][n];
    //     for (int[] edge : roads) {
    //         indeg[edge[0]]++;
    //         indeg[edge[1]]++;
    //         isEdge[edge[0]][edge[1]]=true;
    //         isEdge[edge[1]][edge[0]]=true;
    //     }
    //     int max=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             int curr=-1;
    //             if(i==j) continue;
    //             else if(isEdge[i][j]){
    //                 curr=indeg[i]+indeg[j]-1;
    //                 max=Math.max(max,curr);
    //             }
    //             else{
    //                 curr=indeg[i]+indeg[j];
    //                 curr=Math.max(max, curr);
    //             }
    //         }
    //     }
    //     return max;
    // }
    // public int findCenter(int[][] edges) {
    //     int indeg[]=new int[edges.length+2];
    //     for (int[] edge : edges) {
    //         indeg[edge[0]]++;
    //         indeg[edge[1]]++;
    //     }
    //     for(int i=1;i<edges.length+2;i++){
    //         if(indeg[i]==edges.length) return i;
    //     }
    //     return -1;
    // }
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int i=0,j=0,k=0;
    //     int ans[]=new int[m+n];
    //     while (i<m && j<n) {
    //         if (nums1[i]<nums2[j]) {
    //             ans[k]=nums1[i];
    //             i++;
    //         }
    //         else{
    //             ans[k]=nums2[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while (i<m) {
    //         ans[k]=nums1[i];
    //         i++;
    //         k++;
    //     }
    //     while (j<n) {
    //         ans[k]=nums2[j];
    //         j++;
    //         k++;
    //     }
    //     for(int i=0;i<m+n;i++){
    //         nums1[i]=ans[i];
    //     }
    // }
    // public static class Pair implements Comparator<Pair>{
    //     int n;
    //     int wt;
    //     public Pair(int n,int wt){
    //         this.n=n;
    //         this.wt=wt;
    //     }
    //     @Override
    //     public int compareTo(Pair e){
    //         return this.wt-e.wt;
    //     }
    // }
    // public static class Edge implements Comparator<Edge>{
    //     int src;
    //     int des;
    //     int wt;
    //     public Edge(int s,int d,int w){
    //         this.src=s;
    //         this.des=d;
    //         this.wt=w;
    //     }
    //     @Override
    //     public int compareTo(Edge e){
    //         return this.wt-e.wt;
    //     }
    // }
    // public static int count=0;
    // public static int countRestrictedPaths(int n, int[][] edges) {
    //     ArrayList<Edge> graph[]=new ArrayList[n+1];
    //     for(int i=0;i<n+1;i++){
    //         graph[i]=new ArrayList<>();
    //     }
        
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
    //         graph[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));
    //     }
    //     int dis[]=new int[n+1];
    //     Arrays.fill(dis, Integer.MAX_VALUE);
    //     dis[n]=0;
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     boolean vis[]=new boolean[n+1];
    //     pq.add(new Pair(n, 0));
    //     while (!pq.isEmpty()) {
    //         Pair curr=pq.poll();
    //         if(!vis[curr.n]){
    //             vis[curr.n]=true;
    //             for(int i=0;i<graph[curr.n].size();i++){
    //                 Edge e=graph[curr.n].get(i);
    //                 int u=e.src;
    //                 int v=e.des;
    //                 int wt=e.wt;
    //                 if(dis[u]+wt<dis[v]){
    //                     dis[v]=dis[u]+wt;
    //                     pq.add(new Pair(v,dis[v]));
    //                 }
    //             }
    //         }
    //     }
    //     ArrayList<Integer> reqGraph[]=new ArrayList[n+1];
    //     for (int[] edge : edges) {
    //         int src=edge[0];
    //         int des=edge[1];
    //         if(dis[src]>dis{des}){
    //             reqGraph[src].add(des);
    //         }
    //         else{
    //             reqGraph[des].add(src);
    //         }
    //     }
    //     return dfs(1, n, vis, reqGraph);
    // }
    // public static void dfs(int src,int des, boolean vis[],ArrayList<Integer> reqGraph[]){
    //     if(vis[src]) return;
    //     vis[src]=true;
    //     if(src==des){
    //         count++;
    //         return;
    //     }
    //     for(int i=0;i<reqGraph[src].size();i++){
    //         int dest=reqGraph[src].get(i);
    //         dfs(dest, des, vis, reqGraph);
    //     }
    // }
    // public static boolean validPath(int n, int[][] edges, int source, int destination) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     boolean vis[]=new boolean[n];
    //     return dfs(source, destination, vis, graph);
    // }
    // public static boolean dfs(int src,int des,boolean vis[],ArrayList<Integer> graph[]){
    //     if(vis[src]) return false;
    //     vis[src]=true;
    //     if(src==des) return true;
    //     else{
    //         for(int i=0;i<graph[src].size();i++){
    //             int dest=graph[src].get(i);
    //             if(dfs(dest, des, vis, graph)) return true;
    //         }
    //     }
    //     return false;
    // }
    // public static class Pair implements Comparable<Pair>{
    //     int n;
    //     int wt;
    //     public Pair(int n,int wt){
    //         this.n=n;
    //         this.wt=wt;
    //     }

    //     @Override
    //     public int compareTo(Pair p){
    //         return this.wt-p.wt;
    //     }
        
    // }
    // public static int networkBecomesIdle(int[][] edges, int[] patience) {
    //     ArrayList<Integer> graph[]=new ArrayList[patience.length];
    //     for(int i=0;i<graph.length;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     int dist[]=new int[patience.length];
    //     Arrays.fill(dist, Integer.MAX_VALUE);
    //     dist[0]=0;
    //     pq.add(new Pair(0, 0));
    //     boolean vis[]=new boolean[patience.length];
    //     while (!pq.isEmpty()) {
    //         Pair curr=pq.poll();
    //         if(!vis[curr.n]){
    //             vis[curr.n]=true;
    //             for(int i=0;i<graph[curr.n].size();i++){
    //                 int des=graph[curr.n].get(i);
    //                 if(dist[curr.n]+2<dist[des]){
    //                     dist[des]=dist[curr.n]+2;
    //                     pq.add(new Pair(des,dist[des]));
    //                 }
    //             }
    //         }
    //     }
    //     int maxTime=0;
    //     int currTime=0;
    //     for(int i=1;i<patience.length;i++){
    //         if (patience[i]>=dist[i]) {
    //             currTime=dist[i];
    //         }
    //         else currTime=(((dist[i]-1)/patience[i])*patience[i])+dist[i];
    //         maxTime=Math.max(maxTime, currTime);
    //     }
    //     return maxTime;
    // }
    // public static int maximumDetonation(int[][] bombs) {
    //     boolean dp[][]=new boolean[bombs.length][bombs.length];
    //     for(int i=0;i<bombs.length;i++){
    //         for(int j=0;j<bombs.length;j++){
    //             for(int k=0;k<bombs.length;k++){
    //                 int
    //             }
    //         }
    //     }
    // }
    // public int minPartitions(String n) {
    //     int max=0;
    //     for(int i=0;i<n.length();i++){
    //         max=Math.max(max,n.charAt(i)-'0');
    //     }
    //     return max;
    // }
    // public int[] getConcatenation(int[] nums) {
    //     int ans[]=new int[2*n];
    //     for(int i=0;i<n;i++){
    //         ans[i]=nums[i];
    //         ans[i+n]=nums[i];
    //     }
    //     return ans;
    // }
    // public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //     HashMap<Integer,PriorityQueue<Integer>> hm =new HashMap<>();
    //     for(int i=0;i<profits.length;i++){
    //         hm.putIfAbsent(capital[i],new PriorityQueue<>(Collections.reverseOrder()));
    //         hm.get(capital[i]).add(profits[i]);
    //     }
    //     for(int i=0;i<k;i++){
    //         boolean flag=true;
    //         int temp=w;
    //         while (flag) {
    //             if (temp<0) {
    //                 break;
    //             }
    //             if (hm.containsKey(temp)) {
    //                 w+=hm.get(temp).remove();
    //                 flag=false;
    //             }
    //             temp--;
    //         }
    //     }
    //     return w;
    // }
    // public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    //     List<String> ans=new ArrayList<>();
    //     HashMap<String,HashMap<String,Integer>> graph =new HashMap<>();
    //     HashSet<String> suppliesAvailable=new HashSet<>();

    //     for(int i=0;i<supplies.length;i++){
    //         suppliesAvailable.add(supplies[i]);
    //     }

    //     for(int i=0;i<recipes.length;i++){
    //         for(int j=0;j<ingredients.get(i).size();j++){
    //             graph.putIfAbsent(recipes[i], new HashMap<>());
    //             graph.putIfAbsent(ingredients.get(i).get(j), new HashMap<>());

    //             graph.get(recipes[i]).put(ingredients.get(i).get(j), j);
    //             graph.get(ingredients.get(i).get(j)).put(recipes[i], j);
    //         }
    //     }

    //     for(int i=0;i<recipes.length;i++){
    //         if(contains(recipes[i], graph, suppliesAvailable, " ")){
    //             ans.add(recipes[i]);
    //         }
    //     }
    //     return ans;
    // }
    // public static boolean contains(String src,HashMap<String,HashMap<String,Integer>> graph,HashSet<String> suppliesAvailable,String par){
    //     if(suppliesAvailable.contains(src)) return true;
    //     boolean flag=true;
    //     HashMap<String,Integer> curr=graph.get(src);
    //     for (String key : curr.keySet()) {
    //         if(!key.equals(par)){
    //             if(!contains(key, graph, suppliesAvailable, src)){
    //                 return false;
    //             }
    //         }
    //     }
    // public static class Pair implements Comparable<Pair>{
    //     int val;
    //     int indeg;
    //     public Pair(int v,int indeg){
    //         this.val=v;
    //         this.indeg=indeg;
    //     }
    //     @Override
    //     public int compareTo(Pair p){
    //         return this.indeg-p.indeg;
    //     }
    // }
    // public static long maximumImportance(int n, int[][] roads) {
    //     int indeg[]=new int[n];
    //     for (int[] road : roads) {
    //         indeg[road[0]]++;
    //         indeg[road[1]]++;
    //     }
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     for(int i=0;i<n;i++){
    //         pq.add(new Pair(i,indeg[i]));
    //     }
    //     int wt[]=new int[n];
    //     int k=n;
    //     while (!pq.isEmpty()) {
    //         Pair curr=pq.poll();
    //         wt[curr.val]=k;
    //         k--;
    //     }
    //     long ans=0;
    //     for (int[] road : roads) {
    //         ans+=(long)(wt[road[0]]+wt[road[1]]);
    //     }
    //     return ans;
    // }
    // public long countPairs(int n, int[][] edges) {
        
    // }
    // public int countCompleteDayPairs(int[] hours) {
    //     int count=0;
    //     for(int i=0;i<hours.length;i++){
    //         for(int j=i+1;j<hours.length;j++){
    //             if((hours[i]+hours[j])%24==0) count++;
    //         }
    //     }
    //     return count;
    // }
    // public static int countCompleteDayPairs(int[] hours) {
    //     int count = 0;
    //     Map<Integer, Integer> remainderCount = new HashMap<>();
        
    //     for (int hour : hours) {
    //         int remainder = (hour) % 24;
    //         int complement = (24 - remainder)%24;
    //         if (complement == 24) {
    //             complement = 0; // Adjust complement to handle remainder == 0 case
    //         }
    //         count += remainderCount.getOrDefault(complement, 0);
    //         remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
    //     }
        
    //     return count;
    // }
//     public static int minPatches(int[] nums, int n) {
//         HashSet<Integers> hs=new HashSet<>();

//         int prefix[]=new int[nums.length];
//         prefix[0]=nums[0];

//         for(int i=1;i<nums.length;i++){
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 if (i==0) {
//                     hs.
//                 }
//             }
//         }
//    }
    public static void main(String[] args) {
        int[] hours = {10000000, 99999976, 99999952, 99999928, 99999904};
        System.out.println(countCompleteDayPairs(hours));
    }
}
