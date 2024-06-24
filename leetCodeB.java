import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.tree.TreeNode;

public class leetCodeB {
    // public static List<Character> helper(char curr[],List<Character> prev){
    //     int vis[]=new int[26];
    //     List<Character> ans=new ArrayList<>();
    //     HashMap<Character,Integer> hm=new HashMap<>();
    //     for(int i=0;i<prev.size();i++){
    //         hm.put(prev.get(i),hm.getOrDefault(prev.get(i),0)+1);
    //     }
    //     for(int i=0;i<curr.length;i++){
    //         if(hm.containsKey(curr[i])){
    //             if(hm.get(curr[i])!=0){
    //                 hm.put(curr[i],hm.get(curr[i])-1);
    //                 ans.add(curr[i]);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public static List<String> commonChars(String[] words) {
    //     List<Character> prev=new ArrayList<>();
    //     for(int i=0;i<words[0].length();i++){
    //         prev.add(words[0].charAt(i));
    //     }
    //     for(int i=1;i<words.length;i++){
    //         char curr[]=words[i].toCharArray();
    //         prev=helper(curr, prev);
    //     }
    //     List<String> ans=new ArrayList<>();
    //     for(int i=0;i<prev.size();i++){
    //         ans.add(Character.toString(prev.get(i)));
    //     }
    //     return ans;
    // }
    // public static int networkDelayTime(int[][] times, int n, int k) {
    //     HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
    //     for(int i=0;i<times.length;i++){
    //         int src=times[i][0],des=times[i][1],wt=times[i][2];

    //         graph.putIfAbsent(src,new HashMap<>());

    //         graph.get(src).put(des,wt);
    //     }
    //     boolean vis[]=new boolean[n+1];
    //     int maxwt=dfs(k,0, graph, vis,-1);
    //     for(int i=1;i<=n;i++){
    //         if(!vis[i]) return -1;
    //     }
    //     return maxwt;
    // }
    // public static int dfs(int root,int currwt,HashMap<Integer,HashMap<Integer,Integer>> graph,boolean vis[],int maxwt){
    //     vis[root]=true;
    //     maxwt=currwt;
    //     if(!graph.containsKey(root)) return currwt;
    //     HashMap<Integer,Integer> hm=graph.get(root);
    //     for (Map.Entry<Integer,Integer> d : hm.entrySet()) {
    //         Integer des=d.getKey();
    //         Integer wt=d.getValue();
    //         if (!vis[des]) {
    //             int currentwt=dfs(des,currwt+wt, graph, vis, maxwt);
    //         if(currentwt>maxwt){
    //             maxwt=currentwt;
    //         }
    //         }
    //     }
    //     return maxwt;
    // }
    // public static boolean isBipartite(int[][] graph) {
    //     int col[]=new int[graph.length];
    //     Arrays.fill(col,-1);
    //     Queue<Integer> q=new LinkedList<>();
    //     for(int i=0;i<graph.length;i++){
    //         col[i]=0;
    //         q.add(i);
    //         while (!q.isEmpty()) {
    //             int src=q.remove();
    //             for(int j=0;i<graph[src].length;j++){
    //                 int des=graph[src][j];
    //                 int nexcol=-1;
    //                 if(col[src]==1) nexcol=0;
    //                 else nexcol=1;
    //                 if(col[des]==-1){
    //                     col[des]=nexcol;
    //                     q.add(des);
    //                 }
    //                 else if(col[src]==col[des]) return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
//     class Solution {
//         public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//             HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
//             for(int i=0;i<flights.length;i++){
//                 int s=flights[i][0],d=flights[i][1],w=flights[i][2];
    
//                 graph.putIfAbsent(s,new HashMap<>());
//                 graph.get(s).put(d,w);
//             }
//             if(graph.containsKey(src)==false || graph.containsKey(dst)==false) return -1;
//             boolean vis[]=new boolean[n];
//             int ans=dfs(src, dst, k, graph, vis, 0, 0,Integer.MAX_VALUE);
//             return ans;
//         }
//         public static int dfs(int src,int des,int k,HashMap<Integer,HashMap<Integer,Integer>> graph,boolean vis[],int cost,int wt,int minCost){
//             vis[src]=true;
//             k--;
//             cost+=wt;
//             if(src==des) return cost;
//             if(k<0) return Integer.MAX_VALUE;
//             HashMap<Integer,Integer> hm=graph.get(src);
//             for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
//                 int d=entry.getKey();
//                 int weight=entry.getValue();
//                 if(!vis[d]){
//                     int currcost=dfs(d, des, k, graph, vis, cost, wt, minCost);
//                     minCost=Math.min(currcost,minCost);
//                 }
//             }
//             vis[src]=false;
//             return minCost;
//         }
//     }
//     public static class TreeNode {
//       int val;
//       TreeNode left;
//      TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
    // public static int maxDepth(TreeNode root) {
    //     if(root==null) return 0;
    //     int left=0;
    //     int right=0;
    //     if(root.left!=null){
    //         left=maxDepth(root.left);
    //     }
    //     if(root.right!=null){
    //         right=maxDepth(root.right);
    //     }
    //     return 1+Math.max(left, right);
    // }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> currList=new ArrayList<>();
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfs(i, graph.length-1, graph, arr, currList, vis);
            }
        }
        return arr;
        
    }
    public static void dfs(int src,int des,int[][] graph,List<List<Integer>> arr,List<Integer> currList,boolean vis[]){
        vis[src]=true;
        // currList.add(src);
        if(src==des){
            arr.add(currList);
            // currList.clear();
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            int dest=graph[src][i];
            if(!vis[dest]){
                currList.add(dest);
                dfs(dest, des, graph, arr, currList, vis);
            }
        }
        vis[src]=false;
        return;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int md=sc.nextInt();
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int l=0;l<n;l++){
                a[l]=sc.nextInt();
            }
            int sum=0;
            for(int j=0;j<n-1;j++){
                sum+=Math.abs(a[j]-a[j+1]);
            }
            int currmin=0,maxd=0,currmax=0,curr=0;
            for(int k=0;k<n;k++){
                currmin=a[k]-1;
                currmax=md-a[k];
                curr=Math.max(currmax, currmin);
                maxd=Math.max(maxd, curr);
            }
            System.out.println(sum+maxd);
        }
    }
    
}


