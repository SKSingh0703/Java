import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class leetCodeA {
    // public static int[] findOrder(int numCourses, int[][] prerequisites) {
    //     ArrayList<Integer> graph[]=new ArrayList[numCourses];
    //     for(int i=0;i<numCourses;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<prerequisites.length;i++){
    //         graph[prerequisites[i][0]].add(prerequisites[i][1]);
    //     }
    //     Queue<Integer> s=new LinkedList<>();
    //     boolean vis[]=new boolean[numCourses];
    //     for(int i=0;i<numCourses;i++){
    //         if(!vis[i]){
    //             helper(i,vis, graph, s);
    //         }
    //     }
    //     int[] ans=new int[numCourses];
    //     int i=0;
    //     while (!s.isEmpty()) {
    //         ans[i]=s.remove();
    //         i++;
    //     }
    //     return ans;
    // }
    // public static void helper(int val,boolean vis[],ArrayList<Integer> graph[],Queue<Integer> s){
    //     vis[val]=true;
    //     for(int i=0;i<graph[val].size();i++){
    //         int curr=graph[val].get(i);
    //         if(vis[curr]!=true){
    //             helper(curr, vis, graph,s);
    //         }
    //     }
    //     s.add(val);
    //     return;
    // }
    // public static int helper(ArrayList<ArrayList<Integer>> graph,int root,int height){
    //     height++;
    //     for(int i=0;i<graph.get(root).size();i++){
    //         int curr=graph.get(root).get(i);
    //         if(!graph.get(root).isEmpty()){
    //            return helper(graph,curr, height);
    //         }
    //     }
    //     return height;
    // }
    // public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         arr.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<edges.length;i++){
    //         arr.get(edges[i][0]).add(edges[i][1]);
    //     }
    //     int height[]=new int[n];
    //     int minHeight=Integer.MAX_VALUE;
    //     for(int i=0;i<n;i++){
    //         height[i]=helper(arr, i,1);
    //         if(height[i]<=minHeight){
    //             minHeight=height[i];
    //         }
    //     }
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if(height[i]==minHeight){
    //             ans.add(i);
    //         }
    //     }
    //     return ans;      
    // }
    // public static int longestPalindrome(String s) {
    //     int n=s.length();
    //     if(n==0 || n==1 || n==2) return n;
    //     int upCase[]=new int[26];
    //     int lcase[]=new int[26];
    //     for(int i=0;i<s.length();i++){
    //         if(Character.isUpperCase(s.charAt(i))){
    //             upCase[s.charAt(i)-'A']++;
    //         }
    //         else{
    //             lcase[s.charAt(i)-'a']++;
    //         }
    //     }
    //     int ans=0;
    //     boolean containsOne=false;
    //     for(int i=0;i<26;i++){
    //         if(upCase[i]>=2){
    //             ans+=(upCase[i]/2)*2;
    //         }
    //         if(lcase[i]>=2){
    //             ans+=(lcase[i]/2)*2;
    //         }
    //         if(containsOne){
    //             continue;
    //         }
    //         else{
    //             if(upCase[i]%2==1 || lcase[i]%2==1) containsOne=true;
    //         }
    //     }
    //     if(containsOne){
    //         return ans+1;
    //     }
    //     else return ans;
    // }
    public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // public static void helper(ListNode l,ArrayList<Integer> arr){
    //     ListNode temp=l;
    //     Stack<Integer> s=new Stack<>();
    //     s.push(l.val);
    //     while(temp.next!=null){
    //         s.push(temp.next.val);
    //         temp=temp.next;
    //     }
    //     while (!s.isEmpty()) {
    //         arr.add(s.pop());
    //     }
    //     return;
    // }
    // public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode temp1=l1;
    //     ListNode temp2=l2;
    //     ArrayList<Integer> arr1=new ArrayList<>();
    //     ArrayList<Integer> arr2=new ArrayList<>();
    //     helper(l1, arr1);
    //     helper(l2, arr2);
    //     int i=arr1.size()-1;
    //     int j=arr2.size()-1;
    //     int num1=0,num2=0,carry=0;
    //     ListNode temp=new ListNode();
    //     while(i>=0 || j>=0){
    //         if(i<0){
    //             num1=0;
    //         }
    //         else{
    //             num1=arr1.get(i);
    //         }
    //         if(j<0){
    //             num2=0;
    //         }
    //         else{
    //             num2=arr2.get(j);
    //         }
    //         if(num1 + num2 +carry<=9){
    //             temp=new ListNode(num1+num2+carry);
    //             carry=0;
    //             temp=temp.next;
    //         }
    //         else{
    //             int val=(num1+num2+carry)%10;
    //             temp=new ListNode(val);
    //             temp=temp.next;
    //             carry=(num1+num2+carry)/10;
    //         }
    //         i--;
    //         j--;
    //     }
    //     return temp;
    // }
    // public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode ans=new ListNode();
    //     ans.val=-1;
    //     ans.next=null;
    //     int carry=0;
    //     int num1=0;
    //     int num2=0;
    //     ListNode temp=ans;
    //     while(l1!=null || l2!=null){
    //         if(l1!=null){
    //             num1=l1.val;
    //             l1=l1.next;
    //         }
    //         else num1=0;
    //         if (l2!=null) {
    //             num2=l2.val;
    //             l2=l2.next;
    //         }
    //         else num2=0;
    //         int curr=carry+num1+num2;
    //         System.out.println(num1+"  +  "+num2+"  +  C:"+carry);
    //         // System.out.println(temp.val+" Value");
    //         if(curr<=9){
    //             temp=new ListNode(curr,null);
    //             // temp.val=curr;
    //             temp=temp.next;
    //             carry=0;
    //         }
    //         else{
    //             temp=new ListNode(curr%10,null);
    //             // temp.val=curr%10;
    //             temp=temp.next;
    //             carry=curr/10;
    //         }
    //     }
    //     return ans;
    // }
    // public static boolean isPalindrome(int x) {
    //     int rev=0;
    //     int temp=x;
    //     while (temp>0) {
    //         rev=rev*10+temp%10;
    //         temp=temp/10;
    //     }
    //     if(rev==x) return true;
    //     else false;
    // }
    // public static class edge{
    //     String src;
    //     String  des;
    //     int wt;
    //     public edge(String  s,String  d,int wt){
    //         this.src=s;
    //         this.des=d;
    //         this.wt=wt;
    //     }
    // }
    // public static int pathValue(int src,int des,boolean vis[], ArrayList<Integer> graph[]){
    //     if()
    // }
    // public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    //     ArrayList<edge> graph[]=new ArrayList[26];
    //     for(int i=0;i<26;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<equations.size();i++){
    //         String src=equations.get(i).get(0);
    //         String des=equations.get(i).get(1);
    //         float wt=values[i];
            
    //     }
    // }I             
    // public static int convert(char c){
    //     if(c=='I') return 1;
    //     if(c=='V') return 5;
    //     if(c=='X') return 10;
    //     if(c=='L') return 50;
    //     if(c=='C') return 100;
    //     if(c=='D') return 500;
    //     if(c=='M') return 1000;
    //     else return -1;
    // }
    // public static boolean check(char c,char next){
    //     if(c=='I' && next=='V') return true;
    //     if(c=='I' && next=='X') return true;
    //     if(c=='X' && next=='L') return true;
    //     if(c=='X' && next=='C') return true;
    //     if(c=='C' && next=='D') return true;
    //     if(c=='C' && next=='M') return true;
    //     else return false;
    // }
    // public static int romanToInt(String s) {
    //     int ans=0;
    //     int curr=0;
    //     int next=0;
    //     for(int i=0;i<s.length();i++){
    //         curr=convert(s.charAt(i));
    //         if(i<s.length()-1){
    //             next=convert(s.charAt(i+1));
    //         }
    //         else next=Integer.MIN_VALUE;
    //         System.out.println("Curr :"+ curr+" Next :"+next);
    //         if(curr<next){
    //             if(check(s.charAt(i), s.charAt(i+1))) ans-=curr;
    //         }
    //         else ans+=curr;
    //     }
    //     return ans;
    // }
    // public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode head=new ListNode(0,next);
    //     ListNode temp=head;
    //     int curr=0;
    //     int num1=0,num2=0;
    //     while(list1!=null && list2!=null){
    //         if(list1!=null && list1.val>list2.val){
    //             temp.next=new ListNode(list1.val);
    //             temp=temp.next;
    //             list1=list1.next;
    //         }
    //         else if(list2!=null && list2>=list1){
    //             temp.next=new ListNode(list2.val);
    //             temp=temp.next;
    //             list2=list2.next;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return head.next;
    // }
    // public static int findCircleNum(int[][] isConnected) {
    //     ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    //     for(int i=0;i<=isConnected.length;i++){
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<isConnected.length;i++){
    //         for(int j=0;j<isConnected[0].length;j++){
    //             graph.get(i+1).add(j+1);
    //             graph.get(j+1).add(i+1);
    //         }
    //     }
    //     int count=0;
    //     boolean vis[]=new boolean[isConnected.length+1];
    //     for(int i=1;i<+isConnected.length;i++){
    //         if(!vis[i]){
    //             count++;
    //             dfs(i, graph, vis);
    //         }
    //     }
    //     return count;
    // }
    // public static boolean dfs(int curr,int par,HashMap<Integer,ArrayList<Integer>> graph,boolean vis[],int ans[]){

    //     vis[curr]=true;
    //     for(int i=0;i<graph.get(curr).size();i++){
    //         int des=graph.get(curr).get(i);
    //         if(vis[des]==true && des!=par){
    //             ans[0]=curr;
    //             ans[1]=des;
    //             return true;
    //         }
    //         else{
    //             if(!vis[des]) dfs(des,curr, graph, vis, ans);
    //         }
    //     }
    //     return false;
    // }
    // public static int[] findRedundantConnection(int[][] edges) {
    //     HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
    //     for(int i=0;i<edges.length;i++){
    //         int src=edges[i][0];
    //         int des=edges[i][1];

    //         graph.putIfAbsent(src,new ArrayList<>());
    //         graph.putIfAbsent(des,new ArrayList<>());

    //         graph.get(src).add(des);
    //         graph.get(des).add(src);
    //     }
    //     int ans[]=new int[2];
    //     for(int i=1;i<edges.length+1;i++){
    //         boolean vis[]=new boolean[edges.length+1];
    //         dfs(i, -1, graph, vis, ans);
    //     }
    //     return ans;
    // }

    // public static List<List<Integer>> generate(int numRows) {
    //     ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    //     for(int i=0;i<numRows;i++){
    //         arr.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<numRows;i++){
    //         for(int j=0;j<i;j++){
    //             if(j==0 || j==i-1) arr.get(i).add(1);
    //             else arr.get(i).add(arr.get(i-1).get(j-1)+arr.get(i-1).get(j));
    //         }
    //     }
    //     return arr.removeFirst();
    // }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length!=groupSize*groupSize) return false;
        Arrays.sort(hand);
        boolean vis[]=new boolean[hand.length];
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            hm.putIfAbsent(hand[i],new ArrayList<>());
            hm.get(hand[i]).add(i);
        }
        for(int j=0;j<hand.length;j++){
            if (!vis[i]) {
                vis[i]=true;
                if (!checkIfPresent(hand, hand[i], groupSize, hm, vis)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkIfPresent(int hand[],int src,int k,HashMap<Integer,ArrayList<Integer>> hm,boolean vis[]){
        if(k==0) return true;
        if(!hm.containsKey(src)) return false;
        else{
            vis[hm.get(src).removeLast()]=true;
            return checkIfPresent(hand, src+1, k-1, hm, vis);
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int arr[]=findRedundantConnection(edges);
        System.out.println(arr[0]+"  ,  "+arr[1]);
    }
}
