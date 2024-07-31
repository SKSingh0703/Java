// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import java.util.Scanner;
// import java.util.Stack;

// import javax.swing.tree.TreeNode;

public class BFS {
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
    //     }
    // }
    // public static boolean isSymmetric(TreeNode root) {
    //     // Queue<TreeNode> q=new LinkedList();/
    //     ArrayList<TreeNode> q=new ArrayList<>();
    //     q.add(root);
    //     q.add(null);
    //     while (!q.isEmpty()) {
    //         TreeNode curr=q.removeFirst();
    //         if(curr==null){
    //             if(!check(q)) return false;
    //             if(!q.isEmpty()) q.add(null);
    //             else break;
    //         }
    //         else{
    //             if(curr.left!=null) q.add(curr.left);
    //             else q.add(new TreeNode(-1));
    //             if(curr.right!=null) q.add(curr.right);
    //             else q.add(new TreeNode(-1));
    //         }
    //     }
    // }
    // public static boolean check(ArrayList<TreeNode> q){
    //     if(q.size()==0) return true;
    //     int i=0;
    //     int j=q.size()-1;
    //     while (i<j) {
    //         if(q.get(i).val!=q.get(j).val) return false;
    //         i++;
    //         j++;
    //     }
    //     return true;
    // }
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> currList=new ArrayList<>();
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     q.add(null);
    //     while (!q.isEmpty()) {
    //         TreeNode curr=q.poll();
    //         if(curr==null){
    //             ans.add(new ArrayList<>(currList));
    //             currList.clear();
    //             if(!q.isEmpty()){
    //                 q.add(null);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         else{
    //             currList.add(curr.val);
    //             if(root.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }
    //     }
    //     return ans;
    // }
    // public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     if(root==null) return ans;
    //     List<Integer> currList=new ArrayList<>();
    //     Queue<TreeNode> q=new LinkedList<>();
    //     int level=0;
    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int n=q.size();
    //         currList=new ArrayList<>();
    //         level++;
    //         for(int i=0;i<n;i++){
    //             TreeNode curr=q.poll();

    //             if(level%2!=0){
    //                 currList.add(curr.val);
    //             }
    //             else{
    //                 currList.addFirst(curr.val);
    //             }

    //             if(curr.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }
    //         ans.add(new ArrayList<>(currList));
    //     }
    // }
    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     if(root==null) return ans;
    //     List<Integer> currlList=new ArrayList<>();
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int n=q.size();
    //         currlList=new ArrayList<>();
    //         for(int i=0;i<n;i++){
    //             TreeNode curr=q.poll();
    //             currlList.add(curr.val);
    //             if(curr.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }
    //         ans.addFirst(new ArrayList<>(currlList));
    //     }
    //     return ans;
    // }
    // public int minDepth(TreeNode root) {
    //     if(root==null) return 0;
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     int level=1;
    //     while (!q.isEmpty()) {
    //         int size=q.size();
    //         level++;
    //         for(int i=0;i<size;i++){
    //             TreeNode curr=q.poll();

    //             if(curr.left==null && curr.right==null) return level;
    //             if(curr.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }
    //     }
    //     return level;
    // }
    // public TreeNode invertTree(TreeNode root) {
    //     if(root==null) return null;
    //     TreeNode left=invertTree(root.right);
    //     TreeNode right=invertTree(root.left);

    //     root.left=left;
    //     root.right=right;
    //     return root;
    // }
    // public static int numSquares(int n) {
    //     int count=0;
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     for(int i=n;i>=0;i==){
    //         if(check(i)) arr.add(i);
    //     }
    //     int dp[]=new int[arr.size()];
    //     Arrays.fill(dp,-1);
    //     return dfs(0, n, arr, dp, count,0);
    // }
    // public static boolean check(int n){
    //     int sqrt=(int)Math.sqrt(n);
    //     if(sqrt*sqrt==n) return true;
    //     els4 return false;
    // }
    // public static int dfs(int curIdx,int target,ArrayList<Integer> arr, int dp[],int count,int currSum){
    //     if(curIdx>=arr.size()) return Integer.MAX_VALUE;
    //     if(currSum==target) return dp[curIdx]=count;
    //     if(dp[curIdx]!=-1) return dp[curIdx];
    //     if(currSum+arr.get(curIdx)<=target){
    //         return dp[curIdx]=Math.min(dfs(curIdx, target, arr, dp, count, currSum+arr.get(curIdx)),dfs(curIdx+1, target, arr, dp, count, currSum));
    //     }
    //     else{
    //         return dp[curIdx]=dfs(curIdx+1, target, arr, dp, count, currSum);
    //     }
    // }
    // public static int coinChange(int[] coins, int amount) {
    //     if(amount==0) return 0;
    //     int count=0;
    //     Arrays.sort(coins);
    //     for(int i=coins.length;i>=0;i==){
    //         if(amount==0) return count;
    //         if(amount<0){
    //             amount+=coins[i+1];
    //             count--;
    //         }
    //         while (coins[i]<=amount) {
    //             amount-=coins[i];
    //             count++;
    //         }
    //     }
    //     return -1;
    // }
    // public static int searchInsert(int[] nums, int target) {
    //     return helper(0,nums.length-1, nums, target);
    // }
    // public static int helper(int strart,int end,int nums[],int target){
    //     int mid=(strart+end)/2;
    //     if(nums[mid]==target) return mid;
    //     else if(strart==end){
    //         if (target>nums[mid]) {
    //             return strart+1;
    //         }
    //         else return strart;
    //     }
    //     else if(nums[mid]>target) return helper(strart,mid-1, nums, target);
    //     else return helper(mid+1, end, nums,target);
    // }
    // public int heightChecker(int[] heights) {
    //     if(heights.length==0 || heights.length==1) return 0;
    //     int expected[]=new int[heights.length];
    //     for(int i=0;i<heights.length;i++){
    //         expected[i]=heights[i];
    //     }
    //     Arrays.sort(expected);
    //     int count=0;
    //     for(int i=0;i<heights.length;i++){
    //         if(expected[i]!=heights[i]) count++;
    //     }
    //     return count;
    // }
//     public static class pairsss {
//         int nodes;
//         int edges;
//         public pairsss(int n,int p){
//             this.nodes=n;
//             this.edges=p;
//         }
//     }
//     public static int makeConnected(int n, int[][] connections) {
//         ArrayList<Integer> graph[]=new ArrayList[n];
//         for(int i=0;i<n;i++){
//             graph[i]=new ArrayList<>();
//         }
//         for (int[] edge : connections) {
//             graph[edge[0]].add(edge[1]);
//             graph[edge[1]].add(edge[0]);
//         }
//         boolean vis[]=new boolean[n];
//         int totalComponents=0;
//         int noOfExtraEdges=0;

//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 totalComponents++;
//                 pairsss curr=dfs(i, vis, graph,0,0);
//                 if(curr.edges%2==0){
//                     noOfExtraEdges+=( (curr.edges)/2 - curr.nodes + 1);
//                 }
//                 else{
//                     noOfExtraEdges+=( (curr.edges)/2 - curr.nodes + 2);
//                 }
//             }
//         }
//         if(totalComponents==1) return -1;
//         if(totalComponents<=noOfExtraEdges+1){
//             return totalComponents-1;
//         }
//         else return -1;
//     }
//     public static pairsss dfs(int src,boolean vis[], ArrayList<Integer> graph[],int edges,int nodes){
//         vis[src]=true;
//         nodes++;
//         for(int i=0;i<graph[src].size();i++){
//             edges++;
//             int des=graph[src].get(i);
//             if(!vis[des]){
//                 dfs(des, vis, graph, edges, nodes);
//             }
//         }
//         return new pairsss(nodes,edges);
//     }
    // public static class edge {
    //     int src;
    //     int des;
    //     int wt;
    //     public edge(int s,int d,int w){
    //         this.src=s;
    //         this.des=d;
    //         this.wt=w;
    //     }
    // }
    // public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
    //     ArrayList<edge> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++)[
    //         graph[i]=new ArrayList<>();
    //     ]
    //     for (int[] ed : edges) {
    //         graph[ed[0]].add(new edge(ed[0],ed[1], ed[2]));
    //         graph[ed[1]].add(new edge(ed[1],ed[0], ed[2]));
    //     }
    //     int nodes[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         nodes[i]=dfs(i, distanceThreshold, graph,new boolean[], 0);
    //     }
    //     int minIdx=0;
    //     for(int i=1;i<n;i++){
    //         if(nodes[i]<=nodes[minIdx]) minIdx=i;
    //     }
    //     return minIdx;
    // }
    // public static int dfs(int src,int distanceThreshold,ArrayList<edge> graph[],boolean vis[],int count){
    //     vis[src]=true;
    //     for(int i=0;i<graph[src].size()){
    //         edge curr=graph[src].get(i);
    //         if(!vis[curr.des]){
    //             if(distanceThreshold-curr.wt>0){
    //                 count=count+1;
    //                 dfs(curr.des, distanceThreshold-curr.wt, graph, vis, count);
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    //     int ans[]=new int[arr1.length];
    //     int k=0;
    //     boolean vis[]=new boolean[arr1.length];
    //     Arrays.sort(arr1);
    //     for(int i=0;i<arr2.length;i++){
    //         int curr=arr2[i];
    //         int j=0;
    //         while (arr1[j]<=curr) {
    //             if(arr1[j]==curr){
    //                 ans[k]=curr;
    //                 vis[j]=true;
    //                 k++;
    //             }
    //             j++;
    //         }
    //     }
    //     for(int i=0;i<arr1.length;i++){
    //         if(!vis[i]){
    //             ans[k]=arr1[i];
    //             k++;
    //         }
    //     }
    //     return ans;
    // }
    // public void sortColors(int[] nums) {
    //     int color[]=new int[3];
    //     for(int i=0;i<nums.length;i++){
    //         color[nums[i]]++;
    //     }
    //     int k=0;
    //     for(int i=0;i<3;i++){
    //         while(color[i]!=0){
    //             color[i]--;
    //             nums[k]=i;
    //             k++;
    //         }
    //     }
    // }
    // public static String[] spellchecker(String[] wordlist, String[] queries) {  
    //     HashMap<String,Integer> hm=new HashMap<>();
    //     for(int i=0;i<wordlist.length;i++){
    //         hm.put(wordlist[i].toLowerCase(),i);
    //     }
    //     String ans[]=new String[queries.length];
    //     for(int i=0;i<queries.length;i++){
    //         if(hm.containsKey(queries[i].toLowerCase())){
    //             ans[i]=wordlist[hm.get(queries[i].toLowerCase())];
    //         }
    //         else{
    //             ans[i]=helper();
    //         }
    //     }
    // }
    // public int minMovesToSeat(int[] seats, int[] students) {
    //     Arrays.sort(seats);
    //     Arrays.sort(students);
    //     int ans=0;
    //     for(int i=0;i<seats.length;i++){
    //         ans+=Math.abs(seats[i]-students[i])
    //     }
    //     return ans;
    // }
    // public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    //     ArrayList<Integer> graph[]=new ArrayList[numCourses];
    //     boolean isInGraph[]=new boolean[numCourses];
    //     for(int i=0;i<numCourses;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : prerequisites) {
    //         graph[edge[0]].add(edge[1]);
    //         isInGraph[edge[0]]=true;
    //         isInGraph[edge[1]]=true;
    //     }
    //     boolean vis[]=new boolean[numCourses];
        
    //     Stack<Integer> s=new Stack<>();
    //     for(int i=0;i<n;i++){
    //         if (!vis[i] && isInGraph[i]) {
    //             dfs(i, graph, vis, s);
    //         }
    //     }
    //     idx=0;
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     while (!s.isEmpty()) {
    //         hm.putIfAbsent(s.pop(), idx);
    //         idx++;
    //     }
    //     List<Boolean> ans=new ArrayList<>();
    //     for(int i=0;i<queries.length;i++){
    //         if(isInGraph[queries[0]] && isInGraph[queries[1]]){
    //             if(hm.get(queries[i][0])<hm.get(queries[i][1])){
    //                 ans.add(true);
    //             }
    //             else ans.add(false);
    //         }
    //         else{
    //             ans.add(false);
    //         }
    //     }
    //     return ans;

    // }
    // public static void dfs(int src,ArrayList<Integer> graph[],boolean vis[],Stack<Integer> s){
    //     vis[src]=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         if (!vis[des]) {
    //             dfs(des, graph, vis, s);
    //         }
    //     }
    //     s.push(src);
    // }
    // public static int minReorder(int n, int[][] connections) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<connections.length;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for (int[] edge : connections) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     HashMap<Integer,Integer> reqConnections=new HashMap<>();
    //     boolean vis[]=new boolean[n];
        
    //     for(int i=1;i<n;i++){
    //         if(!vis[i]){
    //             vis[0]=false;
    //             dfs(i, graph, vis, reqConnections);
    //         }
    //     }
    //     int count=0;
    //     for (int[] edge : connections) {
    //         if(reqConnections.containsKey(edge[0]) && reqConnections.get(edge[0])==edge[1]){
    //             continue;
    //         }
    //         else{
    //             count++;
    //         }
    //     }
    //     return count;

    // }
    // public static boolean dfs(int src,ArrayList<Integer> graph[],boolean vis[],HashMap<Integer,Integer> reqConnections){
    //     vis[src]=true;
    //     boolean flag=false;
    //     if(src==0){
    //         flag=true;
    //     }
    //     else{
    //         for(int i=0;i<graph[src].size();i++){
    //             int des=graph[src].get(i);
    //             if(!vis[des]){
    //                 if (dfs(des, graph, vis, reqConnections)) {
    //                     reqConnections.put(src,des);
    //                     flag=true;
    //                 }
    //             }
    //         }
    //     }
    //     vis[src]=false;
    //     return flag;
    // }
    // public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    //     ArrayList<Integer> graph[]=new ArrayList[edges.size()];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<edges.size();i++){
    //         int src=edges.get(i).get(0);
    //         int des=edges.get(i).get(1);
    //         graph[src].add(des);
    //     }
    //     boolean vis[]=new boolean[n];
    //     List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if (!vis[i]) {
    //             ans.add(i);
    //             dfs(i, vis, graph);
    //         }
    //     }
    //     return ans;
    // }
    // public static void dfs(int src,boolean vis[],ArrayList<Integer> graph[]){
    //     if(vis[src]) return;
    //     vis[src]=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         dfs(des, vis, graph);
    //     }
    //     return;
    // }
    // public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    //     int indeg[]=new int[n];
    //     for(int i=0;i<edges.size();i++){
    //         indeg[edges.get(i).get(1)]++;
    //     }
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if (indeg[i]==0) {
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }
    // public static class Node implements Comparable<Node>{
    //     int data;
    //     int x;
    //     int y;
    //     int cost;
    //     public Node(int d,int x,int y,int c){
    //         this.data=d;
    //         this.x=x;
    //         this.y=y;
    //         this.cost=c;
    //     }
    //     @Override
    //     public int compareTo(Node n){
    //         return this.cost-n.cost;
    //     }
    // }
    // public static int minCostConnectPoints(int[][] points) {
    //     PriorityQueue<Node> pq=new PriorityQueue<>();
    //     pq.add(new Node(0,points[0][0],points[0][1],0));
    //     int ans=0;
    //     boolean vis[]=new boolean[points.length];
    //     int count=0;
    //     while (!pq.isEmpty() && count<points.length) {
    //         Node curr=pq.poll();
    //         if(vis[curr.data]) continue;
    //         vis[curr.data]=true;
    //         // int minCost=Integer.MAX_VALUE;
    //         ans+=curr.cost;
    //         count++;
    //         for(int i=0;i<points.length;i++){
    //             if (!vis[i]){
    //                 int currCost=Math.abs(curr.x-points[i][0])+Math.abs(curr.y-points[i][1]);
    //                 pq.add(new Node(i,points[i][0],points[i][1], currCost));
                    
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public int theMaximumAchievableX(int num, int t) {
    //     return (num+2*t);
    // }
//     public static int minIncrementForUnique(int[] nums) {
//         HashMap<Integr,Integer> hm =new HashMap<>();
    
//         for(int i=0;i<nums.length;i++){
            
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         HashMap<Integr,Integer> hm =new HashMap<>();
        
//         int T = sc.nextInt();
//         while (T-- > 0) {
//             int N = sc.nextInt();
//             int K = sc.nextInt();

//             // Calculate the minimum required length
//             int minLength = (K * (K + 1)) / 2 + K + 1;

//             if (N < minLength) {
//                 System.out.println("NO");
//             } else {
//                 System.out.println("YES");
//             }
//         }
//     }
    public static void main(String[] args) {
        System.out.println("Sachin Kumar");
    }

}
