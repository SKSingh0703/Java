import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class LeetCodePracticeA {
    // public static class edge{
    //     int src;
    //     int des;
    //     double wt;
    //     public edge(int s,int d,double w){
    //         this.src=s;
    //         this.des=d;
    //         this.wt=w;
    //     }
    // }
    // public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
    //     ArrayList<edge> graph[]=new ArrayList[n];
    //     for(int i=0;i<n;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<edges.length;i++){
    //         int src=edges[i][0];
    //         int des=edges[i][1];
    //         double wt=succProb[i];

    //         edge e1=new edge(src, des, wt);
    //         edge e2=new edge(des,src, wt);

    //         graph[e1.src].add(e1);
    //         graph[e2.src].add(e2);
    //     }
    //     double prob[]=new double[n];
    //     for(int i=0;i<n;i++){
    //         if(i!=start_node) prob[i]=Integer.MIN_VALUE;
    //     }
    //     prob[start_node]=1;
    //     dfs(start_node,new boolean[n], graph, prob);
    //     if(prob[end_node]==Integer.MIN_VALUE) prob[end_node]=0;
    //     return prob[end_node];
    // }
    // public static void dfs(int src,boolean vis[],ArrayList<edge> graph[],double prob[]){
    //     vis[src]=true;
    //     for(int i=0;i<graph[src].size();i++){
    //         edge e=graph[src].get(i);
    //         prob[e.des]=Math.max(prob[e.des],prob[e.src]*e.wt);
    //         if(!vis[src]) dfs(e.des, vis, graph, prob);
    //     }
    // }
    // public static int strStr(String haystack, String needle) {
    //     if(needle.length()>haystack.length()) return -1;
    //     for(int i=0;i<haystack.length();i++){
    //         if(haystack.charAt(i)==needle.charAt(0)){
    //             if(check(haystack, needle, i)) return i;
    //         }
    //     }
    //     return -1;
    // }
    // public static boolean check(String h,String ne,int j){
    //     if((h.length()-i)<ne.length()) return false;
    //     for(int i=0;i<ne.length();i++){
    //         if(h.charAt(j)!=ne.charAt(i)) return false;
    //         j++;
    //     }
    //     return true;
    // }
    // public static List<List<Integer>> getAncestors(int n, int[][] edges) {
    //     List<List<Integer>> graph=new ArrayList<>();
    //     HashSet<Integer> ans[]=new HashSet[n];
    //     List<List<Integer>> fin=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         ans[i]=new HashSet<>();
    //         graph.add(new ArrayList<>());
    //         fin.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<edges.length;i++){
    //         graph.get(edges[i][0]).add(edges[i][1]);
    //     }
    //     for(int i=0;i<n;i++){
    //         dfs(i, graph, ans, new HashSet<>());
    //     }
    //     for(int i=0;i<n;i++){
    //         if(!ans[i].isEmpty()){
    //             for (Integer li : ans[i]) {
    //                 fin.get(i).add(li);
    //             }
    //             Collections.sort(fin.get(i));
    //         }
    //     }
    //     return fin; 
    // }

 
//   public static class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
    // public static TreeNode sortedArrayToBST(int[] nums) {
    //     return form(nums, 0, nums.length);
    // }
    // public static TreeNode form(int nums[],int start,int end){
    //     int mid=start+(end-start)/2;
    //     if(nums[start+(end-start)/2]==null) return null;
    //     if(start>end) return null;
    //     TreeNode newnNode=new TreeNode();
    //     newnNode.val=nums[mid];
    //     newnNode.left=form(nums,mid+1, end);
    //     newnNode.right=form(nums, start, end-1);
    //     return newnNode;
    // }
 
    // public static void dfs(int src,List<List<Integer>> graph,HashSet<Integer> ans[],HashSet<Integer> curr){
    //     curr.add(src);
    //     for(int i=0;i<graph.get(src).size();i++){
    //         int des=graph.get(src).get(i);
    //         for (Integer iter : curr) {
    //             ans[i].add(iter);
    //         }
    //         dfs(des, graph, ans, curr);;
    //     }
    // }
    // public static  List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
    //      HashMap<String,Integer> hm=new HashMap<>();
    //      dfs(id,level,0, watchedVideos, friends,new boolean[watchedVideos.size()], hm);
    //      List<String> ans=new ArrayList<>();
    //      return sortHashMapByValue(hm);
    // }
    // public static List<String> sortHashMapByValue(HashMap<String, Integer> map) {
    //     // Step 1: Extract the entries
    //     List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

    //     // Step 2: Sort the entries based on values, and then lexicographically on keys if values are equal
    //     Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
    //         @Override
    //         public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
    //             // Compare values first
    //             int valueComparison = e1.getValue().compareTo(e2.getValue());
    //             if (valueComparison != 0) {
    //                 return valueComparison;
    //             }
    //             // If values are equal, compare keys lexicographically
    //             return e1.getKey().compareTo(e2.getKey());
    //         }
    //     });

    //     // Step 3: Store the sorted keys in a List<String>
    //     List<String> sortedKeys = new ArrayList<>();
    //     for (Map.Entry<String, Integer> entry : entryList) {
    //         sortedKeys.add(entry.getKey());
    //     }

    //     return sortedKeys;
    // }
    // public static void dfs(int src,int k,int curr,List<List<String>> watchedVideos,int[][] friends,boolean vis[],HashMap<String,Integer> hm){
    //     if(curr>k) return;
    //     vis[src]=true;
    //     if (curr==k) {
    //         for(int i=0;i<watchedVideos.get(src).size();i++){
    //             String s=watchedVideos.get(src).get(i);
    //             hm.putIfAbsent(s,hm.getOrDefault(s,0)+1);
    //         }
    //     }
    //     else{
    //         for(int i=0;i<friends[src].length;i++){
    //             int des=friends[src][i];
    //             if(!vis[des]){
    //                 dfs(des, k, curr+1, watchedVideos, friends, vis, hm);
    //             }
    //         }
    //     }
    //     return;
    // }
    public static void main(String[] args) {
        List<String> ans=new ArrayList<>();
    }
}
