import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class NewPractice {
    // public static String longestCommonPrefix(String[] strs) {
    //     StringBuilder prefix=new StringBuilder(strs[0]);
    //     for(int i=1;i<strs.length;i++){
    //         prefix=compare(strs[i],prefix);
    //         if(prefix.length()==0){
    //             return "";
    //         }
    //     }
    //     return prefix.toString();
    // }
    // public static StringBuilder compare(String s,StringBuilder currprefix){
    //     StringBuilder newPrefix=new StringBuilder("");
    //     int i=0,j=0;
    //     while (i<s.length() && j<currprefix.length()) {
    //         if(s.charAt(i)==currprefix.charAt(j)){
    //             newPrefix.append(s.charAt(i));
    //         }
    //         else break;
    //         i++;
    //         j++;
    //     }
    //     return newPrefix;
    // }
    // public static boolean isValid(String s) {
    //     if(s.length()%2!=0) return false;
    //     Stack<Character> stac=new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
    //             stac.push(s.charAt(i));
    //         }
    //         else{
    //             if(!check(stac,s.charAt(i))) return false;
    //         }
    //     }
    //     // stac.pop();
    //     return stac.isEmpty();
    // }
    // public static boolean check(Stack<Character> stac,char curr){
    //     char ch=stac.pop();
    //     if(curr==')'){
    //         if(ch=='(') return true;
    //         else return false;
    //     }
    //     else if(curr=='}'){
    //         if(ch=='{') return true;
    //         else return false;
    //     }
    //     else if(curr==']'){
    //         if(ch=='[') return true;
    //         else return false;
    //     }
    //     else return false;
    // }
    // public static List<Integer> eventualSafeNodes(int[][] graph) {
    //     boolean terminalEdge[]=new boolean[graph.length];
    //     for(int k=0;k<graph.length;k++){
    //         if(graph[k].length==0) terminalEdge[k]=true;
    //     }
    //     boolean safeEdge[]=new boolean[graph.length];
    //     boolean vis[]=new boolean[graph.length];
    //     for(int i=0;i<graph.length;i++){
    //         if (helper(i, terminalEdge, safeEdge, vis, graph)) {
    //             safeEdge[i]=true;
    //         }
    //     }
    //     List<Integer> ans=new ArrayList<>();
    //     for(int j=0;j<graph.length;j++){
    //         if(safeEdge[j]==true){
    //             ans.add(j);
    //         } 
    //     }
    //     return ans;
    // }
    // public static boolean helper(int src,boolean terminalEdge[],boolean safeEdge[],boolean vis[],int[][] graph){
    //     vis[src]=true;
    //     boolean flag=false;
    //     if(terminalEdge[src] || safeEdge[src]){
    //         flag=true;
    //     }
    //     else{
    //         for(int i=0;i<graph[src].length;i++){
    //             int des=graph[src][i];
    //             if(!vis[des]){
    //                 flag=helper(des, terminalEdge, safeEdge, vis, graph);
    //                 if(flag==false) break;
    //             }
    //         }
    //     }
    //     vis[src]=false;
    //     return flag;
    // }
    // public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    //     boolean vis[]=new boolean[rooms.size()];
    //     dfs(0, rooms, vis);;
    //     for(int i=0;i<rooms.size();i++){
    //         if(vis[i]==false) return false;
    //     }
    //     return true;
    // }
    // public static void dfs(int src,List<List<Integer>> rooms,boolean vis[]){
    //     vis[src]=true;
    //     for(int i=0;i<rooms.get(src).size();i++){
    //         int des=rooms.get(src).get(i);
    //         if(!vis[des]){
    //             dfs(des, rooms, vis);
    //         }
    //     }
    //     return;
    // }
    // public static int[] loudAndRich(int[][] richer, int[] quiet) {
    //     int ans[]=new int[quiet.length];
    //     boolean vis[]=new boolean[quiet.length];
    //     for(int i=0;i<quiet.length;i++){
    //         ans[i]=dfs(i, richer, vis, Integer.MAX_VALUE, quiet,-1);
    //     }
    //     return ans;
    // }
    // public static int dfs(int src,int[][] richer,boolean vis[],int minq,int[] quiet, int reqIdx){
    //     vis[src]=true;
    //     if(minq>quiet[src]){
    //         minq=quiet[src];
    //         reqIdx=src;
    //     }
    //     for (int[] arr : richer) {
    //         if(arr[1]==src){
    //             int des=arr[0];
    //             if(!vis[des]){
    //                reqIdx=dfs(des, richer, vis, minq, quiet,reqIdx);
    //             }
    //         }
    //     }
    //     vis[src]=false;
    //     return reqIdx;
    // }
    // public static int removeDuplicates(int[] nums) {
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     int curr=0,prev=101;
    //     for(int i=0;i<nums.length;i++){
    //         curr=nums[i];
    //         if(curr==prev) continue;
    //         else{
    //             arr.add(curr);
    //         }
    //         prev=curr;
    //     }
    //     int k=arr.size();
    //     for(int i=0;i<k;i++){
    //         nums[i]=arr.get(i);
    //     }
    //     return k;
    // }
    // public static String replaceWords(List<String> dictionary, String sentence) {
    //     String derivative[]=sentence.split(" ");
    //     String ans[]=new String[derivative.length];
    //     HashSet<String> hs=new HashSet<>();
    //     for(int i=0;i<dictionary.size();i++){
    //         hs.add(dictionary.get(i));
    //     }
    //     for(int j=0;j<derivative.length;j++){
    //         String curr=derivative[j];
    //         for(int k=1;k<=curr.length();k++){
    //             if(hs.contains(curr.substring(0, k))){
    //                 ans[j]=curr.substring(0, k);
    //                 break;
    //             }
    //             else if(k==curr.length()){
    //                 ans[j]=curr;
    //             }
    //         }
    //     }
    //     StringBuilder sb=new StringBuilder("");
    //     for(int l=0;l<ans.length;l++){
    //         if(sb.length()!=0){
    //             sb.append(" ");
    //         }
    //         sb.append(ans[l]);
    //     }
    //     return sb.toString();
    // }
    // public static boolean possibleBipartition(int n, int[][] dislikes) {
    //     int col[]=new int[n+1];
    //     for(int i=1;i<=n;i++){
    //         if(col[i]==0){
    //             if(!check(i, 1, dislikes, col)){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean check(int src,int nextcol,int[][] dislikes,int col[]){
    //     col[src]=nextcol;
    //     for(int i=0;i<dislikes.length;i++){
    //         if(dislikes[i][0]==src){
    //             int des=dislikes[i][1];
    //             int nextcolor=(nextcol==1)?2:1;
    //             if(col[des]==0){
    //                 if(!check(des, nextcolor, dislikes, col)) return false;
    //             }
    //             else if (col[des]==nextcol) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static int removeElement(int[] nums, int val) {
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=val){
    //             arr.add(nums[i]);
    //         }
    //     }
    //     int k=arr.size();
    //     for(int j=0;j<k;j++){
    //         nums[j]=arr.get(j);
    //     }
    //     return k;
    // }
    // public static List<List<Integer>> largeGroupPositions(String s) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     int start=0,end=0;
    //     char curr=s.charAt(0),prev=s.charAt(0);
    //     for(int i=1;i<s.length();i++){
    //         curr=s.charAt(i);
    //         if(curr==prev) end++;
    //         else{
    //             if(end-start>=3){
    //                 ans.add(new ArrayList<>());
    //                 ans.get(ans.size()-1).add(start);
    //                 ans.get(ans.size()-1).add(end);
    //             }
    //             start=i;
    //             end=i;
    //         }
    //         prev=curr;
    //     }
    //     return ans;
    // }
    // public static int findJudge(int n, int[][] trust) {
    //     ArrayList<Integer> graph[]=new ArrayList[n+1];
    //     for(int i=0;i<n+1;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<trust.length;i++){
    //         int src=trust[i][0];
    //         int des=trust[i][1];
    //         graph[src].add(des);
    //     }
    //     for(int i=1;i<n+1;i++){
    //         if (graph[i].size()==0) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // public static boolean check(int des,ArrayList<Integer> graph[],int n){
    //     for(int i=1;i<n;i++){
    //         if(i!=des){
    //             if(dfs(i, des,new boolean[n+1], graph)){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean dfs(int src,int des,boolean vis[],ArrayList<Integer> graph[]){
    //     vis[src]=true;
    //     boolean flag=false;
    //     if(src==des) flag=true;
    //     else{
    // //         for(int i=0;i<graph[src].size();i++){
    // //             int d=graph[src].get(i);
    // //             if(!vis[d]){
    // //                 flag=dfs(i, des, vis, graph);
    // //                 if(flag==false) break;
    // //             }
    // //         }
    // //     }
    // //     vis[src]=false;
    // //     return flag;
    // // }
    //     public int[] gardenNoAdj(int n, int[][] paths) {
    //         int col[]=new int[n];
    //         ArrayList<Integer> graph[]=new ArrayList[n+1];
    //         for(int i=0;i<n+1;i++){
    //             graph[i]=new ArrayList<>();
    //         }
    //         for(int i=0;i<paths.length;i++){
    //             int src=paths[i][0];
    //             int des=paths[i][1];
                
    //             graph[src].add(des);
    //             graph[des].add(src);
    //         }
    //         for(int i=1;i<=n;i++){
    //             if(col[i-1]==0){
    //                 dfs(i,1, graph, col);
    //             }
    //         }
    //         return col;
    //     }
    //     public static void dfs(int src,int currcol,ArrayList<Integer> graph[],int col[]){
    //         col[src-1]=currcol;
    //         int nextcol=currcol==4?0:currcol+1;
    //         for(int i=0;i<graph[src].size();i++){
    //             int des=graph[src].get(i);
    //             if(col[des-1]==0){
    //                 dfs(des, nextcol, graph, col);
    //             }
    //         }
    //     }
    // public static class edge{
    //     int src;
    //     int des;
    //     int col;
    // }
    // public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    //     int cost[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         cost[i]=Integer.MAX_VALUE;
    //     }
    //     cost[0]=0;
    //     ArrayList<edge> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<redEdges.length;i++){
    //         edge e=new edge();
    //         e.src=redEdges[i][0];
    //         e.des=redEdges[i][1];
    //         e.col=1;
    //         graph[e.src].add(e);
    //     }
    //     for(int i=0;i<blueEdges.length;i++){
    //         edge e=new edge();
    //         e.src=blueEdges[i][0];
    //         e.des=blueEdges[i][1];
    //         e.col=2;
    //         graph[e.src].add(e);
    //     }
    //     dfs(0,new boolean[n], graph, cost, 0);
    //     for(int i=0;i<n;i++){
    //         if(cost[i]==Integer.MAX_VALUE){
    //             cost[i]=-1;
    //         }
    //     }
    //     return cost;
    // }
    // public static void dfs(int sc,boolean vis[],ArrayList<edge> graph[],int cost[],int currPathcolor){
    //     vis[sc]=true;
    //     for(int i=0;i<graph[sc].size();i++){
    //         edge d=graph[sc].get(i);
    //         if(!vis[d.des] && currPathcolor!=d.col){
    //             cost[d.des]=Math.min(cost[d.des], cost[sc]+1);
    //             dfs(d.des, vis, graph, cost,d.col);
    //         }
    //     }
    //     vis[sc]=false;
    //     return;
    // }
    // public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    //     ArrayList<Integer> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<n;i++){
    //         if(leftChild[i]!=-1) graph[i].add(leftChild[i]);
    //         if(rightChild[i]!=-1) graph[i].add(rightChild[i]);
    //     }
    //     boolean vis[]=new boolean[n];
    //     int components=0;
    //     for(int i=0;i<n;i++){
    //         if(!vis[i]){
    //             components++;
    //             if(!dfs(i,-1, graph, vis,new boolean[n])) return false;
    //         }
    //     }
    //     if(components!=1) return false;
    //     return true;
    // }
    // public static boolean dfs(int src,int par,ArrayList<Integer> graph[],boolean vis[],boolean sta[]){
    //     if(sta[src]) return false;
    //     vis[src]=true;
    //     sta[src]=true;
    //     boolean flag=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         int des=graph[src].get(i);
    //         if(vis[des]==true && par!=des){
    //             flag=false;
    //             break;
    //         } 
    //         else if(!vis[src]){
    //             flag=dfs(des,src, graph, vis,sta);
    //             if(!flag){
    //                 break;
    //             }
    //         }
    //     }
    //     // sta[src]=false;
    //     return flag;
    // }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum[]=new int[nums.length+1];
        prefixSum[0]=0;
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=nums[i-1]+prefixSum[i-1];
        }
        for(int i=0;i<nums.length+1;i++){
            for(int j=i+1;j<nums.length+1;j++){
                if(j-i>1){
                    int subarrSum=prefixSum[j]-prefixSum[i];
                    if(subarrSum%k==0) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n=2;
        int trust[][]={{1,2},{2,3}};
        System.out.println(findJudge(n, trust));
    }
}
