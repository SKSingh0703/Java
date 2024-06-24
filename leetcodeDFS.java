import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

// import GraphsDSA.edge;

public class leetcodeDFS {

    public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            public TreeNode() {}
            TreeNode(int val){
                this.val = val;
            }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
    }
    // class Node {
    //     public int val;
    //     public Node left;
    //     public Node right;
    //     public Node next;

    //     public Node() {}
    
    //     public Node(int _val) {
    //         val = _val;
    //     }

    //     public Node(int _val, Node _left, Node _right, Node _next) {
    //         val = _val;
    //         left = _left;
    //         right = _right;
    //         next = _next;
    //     }
    // }
    public static int idx=-1;
    public static TreeNode buildTreePreOrder(int arr[]){
        ++idx;
        if(idx>=arr.length) return null;
        if(arr[idx]==-1) return null;
        TreeNode newNode=new TreeNode(arr[idx]);
        newNode.left=buildTreePreOrder(arr);
        newNode.right=buildTreePreOrder(arr);
        return newNode;
    }
    public static void printRoot(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            TreeNode curr=que.remove();
            if(curr==null){
                if(que.isEmpty()){
                    break;
                }
                else{
                    que.add(null);
                }
            }
            else{
                System.out.println(curr.val);
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
            }
        } 
    }
    // public static void helper(TreeNode root,ArrayList<Integer> arr){
    //     if(root==null) return;
    //     helper(root.left, arr);
    //     arr.add(root.val);
    //     helper(root.right, arr);
    //     return;
    // }
    // public static List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     helper(root, arr);
    //     return arr;
    // }
    // public static int leftmostData(TreeNode root){
    //     if(root.left==null) return root.val;
    //     return leftmostData(root.left);
    // }
    // public static int rightMostData(TreeNode root){
    //     if(root.right==null) return root.val;
    //     return rightMostData(root.right);
    // }
    // public static boolean isValidBST(TreeNode root) {
    //     if(root==null || (root.left==null && root.right==null)) return true;
    //     int leftMax=Integer.MIN_VALUE;
    //     int rightMin=Integer.MAX_VALUE;
    //     if(root.left!=null){
    //         leftMax=rightMostData(root.left);
    //         if(root.val<=leftMax) return false;
    //     }
    //     if(root.right!=null) {
    //         rightMin=leftmostData(root.right);
    //         if(root.val>=rightMin) return false;
    //     }
    //     if(root.left!=null){
    //         if(!isValidBST(root.left)) return false;
    //     }
    //     if(root.right!=null) {
    //         if(!isValidBST(root.right)) return false;
    //     }
    //     return true;
    // }
    
    
    // public static int compareLeft(TreeNode root,int val){
    //     if(root==null) return -1;
    //     if(root.val>val){
    //         int ans=root.val;
    //         root.val=val;
    //         return ans;
    //     }
    //     return Math.max(compareLeft(root.left, val), compareLeft(root.right, val));
    // }
    // public static int compareRight(TreeNode root,int val){
    //     if(root==null) return -1;
    //     if(root.val<val){
    //         int ans=root.val;
    //         root.val=val;
    //         return ans;
    //     }
    //     return Math.max(compareRight(root.left, val), compareRight(root.right, val));
    // }
    // public static TreeNode helper(TreeNode root){
    //     if(root==null) return null;
    //     if(root.left!=null){
    //         int num=compareLeft(root.left, root.val);
    //         if(num!=-1){
    //             root.val=num;
    //             return root;
    //         } 
    //     }
    //     if(root.right!=null){
    //         int num=compareRight(root.left, root.val);
    //         if(num!=-1){
    //             root.val=num;
    //             return root;
    //         } 
    //     }
    //     root.left=helper(root.left);
    //     root.right=helper(root.right);
    //     return root;
    // }
    // public static void recoverTree(TreeNode root) {
    //     root=helper(root);
    //     printRoot(root);
    // }
    // public static void helper(TreeNode root,int ans ,int targetSum,List<List<Integer>> arr,ArrayList<Integer> currList){
    //     if(root==null) return;
    //     ans+=root.val;
    //     currList.add(root.val);
    //     if(root.left==null && root.right==null){
    //         if(ans==targetSum){
    //             arr.add(new ArrayList<>(currList));
    //         }
    //     }
    //     else{
    //         if(root.left!=null){
    //             helper(root.left, ans, targetSum, arr, currList);
    //         }
    //         if(root.right!=null){
    //             helper(root.right, ans, targetSum, arr, currList);
    //         }
    //     }
    //     ans-=root.val;
    //     currList.remove(currList.size()-1);
    //     return; 
    // }
    // public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    //     List<List<Integer>> arr=new ArrayList<>();
    //     ArrayList<Integer> currList=new ArrayList<>();
    //     if(root==null && targetSum!=0){
    //         return arr;
    //     }
    //     helper(root,0, targetSum, arr, currList);
    //     return arr;
    // }
    // public static void preOrder(TreeNode root,TreeNode temp){
    //     if(root==null) return;
    //     temp=new TreeNode(root.val);
    //     if(root.left!=null){
    //         preOrder(root.left, temp.right);
    //     }
    //     if(root.right!=null){
    //         while (temp.right!=null) {
    //             temp=temp.right;
    //         }
    //         preOrder(root.right, temp.right);
    //     }
    //     return;
    // }
    // public static void flatten(TreeNode root) {
    //     if(root== null) return;
    //     TreeNode temp=new TreeNode();
    //     preOrder(root, temp);
    //     root=temp;
    //     return;
    // }
    // public static Node connect(Node root) {
    //     if(root==null) return null;
    //     Queue<Node> que=new LinkedList<>();
    //     que.add(root);
    //     que.add(null);
    //     Node prev=new Node();
    //     prev=null;
    //     while (!que.isEmpty()) {
    //         Node curr=que.remove();
    //         if(curr==null){
    //             prev.next=null;
    //             if(que.isEmpty()){
    //                 break;
    //             }
    //             else{
    //                 que.add(null);
    //             }
    //         }
    //         else{
    //             if(prev!=null){
    //                 prev.next=curr;
    //             }
    //             if(curr.left!=null){
    //                 que.add(curr.left);
    //             }
    //             if(curr.right!=null){
    //                 que.add(curr.right);
    //             }
    //         }
    //         prev=curr;
    //     }
    //     return root;
    // }
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};/* */
//   public static int scoreOfString(String s) {
//         int ans=0;
//         for(int i=0;i<s.length()-1;i++){
//             ans+=Math.abs(s.charAt(i)-s.charAt(i+1));
//         }
//         return ans;
//     }
// public int helper(TreeNode root, int currSum) {
//     if (root == null) return 0;
    
//     currSum = currSum * 10 + root.val;
    
//     if (root.left == null && root.right == null) {
//         return currSum;
//     }
    
//     int leftSum = helper(root.left, currSum);
//     int rightSum = helper(root.right, currSum);
    
//     return leftSum + rightSum;
// }

// public int sumNumbers(TreeNode root) {
//     return helper(root, 0);
// }
    // public static boolean checkIsValid(char[][] board,int i,int j,int m,int n,Boolean dp[][],boolean vis[][]){
    //     if(i>=m-1 || j>=n-1 ||i==0 || j==0) return false;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(vis[i][j]==true) return true;
    //     vis[i][j]=true;
    //     boolean top=false,bottom=false,left=false,right=false;
    //     System.out.println("Check One");
    //     if(board[i-1][j]=='X'){
    //         top=true;
    //     }
    //     else{
    //         return top=checkIsValid(board, i+1, j, m, n, dp, vis);
    //     }
    //     System.out.println("Check TWO");
    //     if(board[i][j-1]=='X'){
    //         left=true;
    //     }
    //     else{
    //         return left=checkIsValid(board, i-1, j, m, n, dp, vis);
    //     }
    //     System.out.println("Check THREE");
    //     if(board[i+1][j]=='X'){
    //         bottom=true;
    //     }
    //     else{
    //         bottom=checkIsValid(board, i+1, j, m, n, dp,vis);
    //     }
    //     System.out.println("Check FOUR");
    //     if(board[i][j+1]=='X'){
    //         right=true;
    //     }
    //     else{
    //         right=checkIsValid(board, i, j+1, m, n, dp,vis);
    //     }
    //     System.out.println("Check FIVE");
    //     vis[i][j]=false;
    //     dp[i][j]=top && bottom && left && right;
    //     System.out.println("The value of "+"( "+i+" , "+j+" )"+"is "+dp[i][j]);
    //     System.out.println(top);
    //     System.out.println(left);
    //     System.out.println(bottom);
    //     System.out.println(right);
        
    //     return dp[i][j]=top && bottom && left && right;
    // }
    // public static int helper(int i,int j,int m,int n,String s,String t){
    //     if(i==m) return (n-j);
    //     if(j==n) return 0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         return helper(i+1, j+1, m, n, s, t);
    //     }
    //     else{
    //         return helper(i+1, j, m, n, s, t);
    //     } 
    // }
    // public static int appendCharacters(String s, String t) {
    //     int m=s.length();
    //     int n=t.length();
    //     int ans=helper(0, 0, m, n, s, t);
    //     return ans;
    // }
    // public static void solve(char[][] board) {
    //     int m=board.length;
    //     int n=board[0].length;
    //     Boolean dp[][]=new Boolean[m+1][n+1];
    //     boolean vis[][]=new boolean[m+1][n+1];
    //     for(int i=0;i<board.length;i++){
    //         for(int j=0;j<board[0].length;j++){
    //             vis[i][j]=false;
    //         }
    //     }
    //     for(int i=1;i<m-1;i++){
    //         for(int j=1;j<n-1;j++){
    //             if(board[i][j]=='0'){
    //                 if(checkIsValid(board, i, j, m, n, dp,vis)){
    //                     board[i][j]='X';
    //                 }
    //             }
    //         }
    //     }
    // }
    // public static class Node {
    //     public int val;
    //     public List<Node> neighbors;
    //     public Node() {
    //         val = 0;
    //         neighbors = new ArrayList<Node>();
    //     }
    //     public Node(int _val) {
    //         val = _val;
    //         neighbors = new ArrayList<Node>();
    //     }
    //     public Node(int _val, ArrayList<Node> _neighbors) {
    //         val = _val;
    //         neighbors = _neighbors;
    //     }
    // }
    // public static void helper(Node node,Node newNode,boolean vis[],ArrayList<Node> graph){
    //     if(node==null) return;
    //     vis[node.val]=true;
    //     newNode.val=node.val;
    //     for(int i=0;i<node.neighbors.size();i++){
    //         newNode.neighbors.add(node.neighbors.get(i));
    //     }
    //     graph.add(node.val-1,newNode);
    //     for(int i=0;i<node.neighbors.size();i++){
    //         Node curr=node.neighbors.get(i);
    //         if(curr!=null){
    //             if(!vis[node.neighbors.get(i).val]){
    //                 helper(curr,new Node(), vis,graph);
    //             }
    //         }
    //     }
    //     return;
    // }
    // public static Node cloneGraph(Node node) {
    //     if(node==null) return null;
    //     boolean vis[]=new boolean[101];
    //     Node newNode=new Node();
    //     ArrayList<Node> graph=new ArrayList<>();
    //     helper(node,newNode, vis, graph);
    //     return newNode;
    // }
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p==null && q==null) return true;
    //     if(p==null || q==null) return false;
    //     if(p.val!=q.val) return false;
    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }
    // public static int numIslands(char[][] grid) {
    //     int ans=0;
    //     int m=grid.length,n=grid[0].length;
    //     boolean vis[][]=new boolean[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(!vis[i][j] && grid[i][j]=='1'){
    //                 if(check(i, j, m, n, grid, vis)){
    //                     ans++;
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public static boolean check(int i,int j,int m,int n,char grid[][],boolean vis[][]){
    //     if(i>m || j>n || i<0 || j<0){
    //         return true;
    //     }
    //     if(grid[i][j]!='1') return true;
    //     vis[i][j]=true;
    //     grid[i][j]='T';
    //     return check(i-1, j, m, n, grid, vis) && check(i+1, j, m, n, grid, vis) && check(i, j-1, m, n, grid, vis) && check(i, j+1, m, n, grid, vis);
    // }
    // public static void helper(TreeNode root,ArrayList<Integer> arr){
    //     if(root==null) return;
    //     arr.add(root.val);
    //     if(root.right!=null){
    //         helper(root.right, arr);
    //     }
    //     else if(root.left!=null){
    //         helper(root.left, arr);
    //     }
    //     return;
    // }
    // public static List<Integer> rightSideView(TreeNode root) {
    //     ArrayList<Integer> arr= new ArrayList<>();
    //     helper(root, arr);
    //     return arr;
    // }
    // public static List<Integer> rightSideView(TreeNode root) {
    //         if(root==null) return null;
    //         Queue<TreeNode> que=new LinkedList<>();
    //         ArrayList<Integer> arr=new ArrayList<>();
    //         que.add(root);
    //         que.add(null);
    //         TreeNode prev=new TreeNode();
    //         prev=null;
    //         while (!que.isEmpty()) {
    //             Node curr=que.remove();
    //             if(curr==null){
    //                 arr.add(prev.val);
    //                 if(que.isEmpty()){
    //                     break;
    //                 }
    //                 else{
    //                     que.add(null);
    //                 }
    //             }
    //             else{
    //                 if(curr.left!=null){
    //                     que.add(curr.left);
    //                 }
    //                 if(curr.right!=null){
    //                     que.add(curr.right);
    //                 }
    //             }
    //             prev=curr;
    //         }
    //         return arr;
    //     }
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if(prerequisites.length==0) return true;
    //     for(int i=0;i<numCourses;i++){
    //         if(hasPre(i, prerequisites)){
    //             boolean vis[]=new boolean[numCourses];
    //             if(!check(i, prerequisites, vis)){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean hasPre(int key,int prerequisites[][]){
    //     for(int i=0;i<prerequisites.length;i++){
    //         if(prerequisites[i][0]==key) return true;
    //     }
    //     return false;
    // }
    // public static boolean check(int key,int[][] prerequisites,boolean vis[]){
    //     if(vis[key]) return false;
    //     vis[key]=true;
    //     for(int i=0;i<prerequisites.length;i++){
    //         if(prerequisites[i][0]==key){
    //             if(!check(prerequisites[i][1], prerequisites, vis)) return false;
    //         }
    //     }
    //     return true;
    // }
    // public static void helper(TreeNode root,ArrayList<Integer> arr){
    //     if(root==null) return;
    //     if(root.left!=null){
    //         helper(root.left, arr);
    //     }
    //     arr.add(root.val);
    //     if(root.right!=null) {
    //         helper(root.right, arr);
    //     }
    //     return;
    // }
    // public static int kthSmallest(TreeNode root, int k) {
    //     ArrayList<Integer> arr= new ArrayList<>();
    //     helper(root, arr);
    //     return arr.get(i);
    // }
    public static void main(String[] args) {

    }
}
