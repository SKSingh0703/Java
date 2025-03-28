import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

import GraphsDSA.info;

public class sdgdgadgegwetqerfqsac {
    // private HashMap<Integer.Integer> hm;
    // private centerIndex;
    public class TreeNode {
        *     int val;
        *     TreeNode left;
        *     TreeNode right;
        *     TreeNode() {}
        *     TreeNode(int val) { this.val = val; }
        *     TreeNode(int val, TreeNode left, TreeNode right) {
        *         this.val = val;
        *         this.left = left;
        *         this.right = right;
        *     }
        * }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int centerIndex=0;
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i],i);
        }
        return build(preorder,hm,centerIndex,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,HashMap<Integer,Integer> hm,int centerIndex,int left,int right){
        if (left>right) {
            return null;
        }
        int rootVal=preorder[centerIndex];
        centerIndex++;
        TreeNode root=new TreeNode(rootVal);

        int inOrderIndex=hm.get(rootVal);

        root.left=build(preorder, hm, centerIndex, left, inOrderIndex-1);
        root.right=build(preorder, hm, centerIndex, inOrderIndex+1, right);

        return root;
    }
    // class SubrectangleQueries {
    //     int arr[][];
    //     public SubrectangleQueries(int[][] rectangle) {
    //         arr=new int[rectangle.length][rectangle[0].length];
    //         for (int i = 0; i < rectangle.length; i++) {
    //             for (int j = 0; j < rectangle[0].length; j++) {
    //                 arr[i][j]=rectangle[i][j];
    //             }
    //         }
    //     }
        
    //     public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    //         for (int i = row1; i <=row2; i++) {
    //             for(int j=col1;j<=col2;j++){
    //                 arr[i][j]=newValue;
    //             }
    //         }
    //     }
        
    //     public int getValue(int row, int col) {
    //         return arr[row][col];
    //     }
    // }
    public class ListNode {
        *     int val;
        *     ListNode next;
        *     ListNode() {}
        *     ListNode(int val) { this.val = val; }
        *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        * }
    // public ListNode insertGreatestCommonDivisors(ListNode head) {
    //     ListNode dummyHead=new ListNode(0,head);
    //     ListNode temp=head;
    //     while (temp.next!=null) {
    //         ListNode curr=temp;
    //         ListNode next=temp.next;
    //         int gcd=curr.val>next.val?gcd(curr.val,next.val):gcd(next.val,curr.val);
    //         ListNode g=new ListNode(gcd);
    //         temp.next=g;
    //         temp=temp.next;
    //         temp.next=next;
    //         temp=temp.next;
    //     }
    //     return dummyHead.next;
    // }
    // private int gcd(int a, int b) {
    //     while (b != 0) {
    //         int temp = b;
    //         b = a % b;
    //         a = temp;
    //     }
    //     return a;
    // }
    // public int countNodes(TreeNode root) {
    //    if(root==null) return 0;
    //    int count=1;
    //    if (root.left!=null) {
    //         count+=countNodes(root.left);
    //    } 
    //    if (root.right!=null) {
    //         count+=countNodes(root.right);
    //    }
    //    return count;
    // }
    // public List<Double> averageOfLevels(TreeNode root) {
    //     List<Double> ans=new ArrayList<>();
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int size=q.size();
    //         double avg=0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode curr=q.poll();
    //             avg+=(double)curr.val;
    //             if (curr.left!=null) {
    //                 q.add(curr.left);
    //             }
    //             if (curr.right!=null) {
    //                 q.add(curr.right);
    //             }
    //         }
    //         ans.add(avg/size);
    //     }
    //     return ans;
    // }
    // public int getMinimumDifference(TreeNode root) {
    //     if (root==null || (root.left==null && root.right==null)) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int minDIff=Integer.MAX_VALUE;
    //     int l=Integer.MAX_VALUE;
    //     int r=Integer.MAX_VALUE;

    //     if root.left!=null {
    //         l=Math.abs(root.val-root.left.val);
    //     }
    //     if (root.right!=null) {
    //         r=Math.abs(root.val-root.right.val);
    //     }

    //     minDIff=Math.min(l, r);
    //     int leftMin=getMinimumDifference(root.left);
    //     int rightMin=getMinimumDifference(root.right);

    //     minDIff=Math.min(minDIff,Math.min(leftMin, rightMin));

    //     return minDIff;
    // }
    // public int hammingWeight(int n) {
    //     int count=0;
    //     int bitmask=1;
    //     while (n>0) {
    //         if (n&1) {
    //             count++;
    //         }
    //         n=n>>1;
    //     }
    //     return count;
    // }
    // public int singleNumber(int[] nums) {
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
    //     }
    //     for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
    //         if (entry.getValue()==1) {
    //             return entry.getKey();
    //         }
    //     }
    //     return -1;
    // }
    // public int[] nodesBetweenCriticalPoints(ListNode head) {
    //     ArrayList<Integer> arr =new ArrayList<>();
    //     ListNode temp=head;

    //     while (temp!=null) {
    //         arr.add(temp.val);
    //         temp=temp.next;
    //     }
    //     boolean isCritical[]=new boolean[arr.size()];
    //     for(int i=1;i<arr.size()-1;i++){
    //         if(check(i,arr)) isCritical[i]=true;
    //     }
    //     int iMin=-1;
    //     int iMax=-1;
    //     int min=Integer.MAX_VALUE;
    //     for (int i = 0; i < isCritical.length; i++) {
    //         if (isCritical[i]) {
    //             iMin=Math.min(iMin, i);
    //             iMax=Math.max(iMax, i);
    //         }
    //     }
    //     for(int i=1;i<arr.size()-1;i++){
    //         if (isCritical[i]) {
    //             if (iMin==-1) {
    //                 iMin=i;
    //             }
    //             iMax=i;
    //             int l=i;
    //             int r=i;
    //             while (!isCritical[i+1]) {
    //                 r++;
    //                 i++;
    //             }
    //             min=Math.min(min,r-l+2);
    //         }
    //     }
    //     // for(int i=1;i<isCritical.length-1;i++){
    //     //     if (isCritical[i]) {
    //     //         for(int j=i+1;j<isCritical.length-1;j++){
    //     //             if (isCritical[j]) {
    //     //                 min=Math.min(min,j-i);
    //     //             }
    //     //         }
    //     //     }
            
    //     // }
    //     int ans[]=new int[2];
    //     ans[0]=min;
    //     ans[1]=iMax-iMin+1;
    //     return ans;
    // }

    // private boolean check(int idx,ArrayList<Integer> arr){
    //     int curr=arr.get(idx);
    //     int next=arr.get(idx+1);
    //     int prev=arr.get(idx-1);
    //     if (curr>next && curr>prev) {
    //         return true;
    //     }
    //     if (curr<next && curr<prev) {
    //         return true;
    //     }
    //     return false;
    // }
    // public int numberOfAlternatingGroups(int[] colors) {
    //     int n = colors.length;
    //     int count = 0;
    
    //     for (int i = 0; i < n; i++) {
    //         if (colors[i] != colors[(i + 1) % n] && colors[(i + 1) % n] != colors[(i + 2) % n]) {
    //             count++;
    //         }
    //     }
    
    //     return count;
    // }

    // public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
    //     long min=Long.MAX_VALUE;
    //     long energy=(long)currentEnergy;
    //     for (int i = 0; i < enemyEnergies.length; i++) {
    //         energy+=(long)enemyEnergies[i];
    //         min=Math.min(min,(long)enemyEnergies[i]);
    //     }
    //     energy-=min;
    //     if (currentEnergy<min) {
    //         return 0;
    //     }
    //     long count=energy/min;
    //     return count;
    // }
    // public int numberOfAlternatingGroups(int[] colors, int k) {
    //     int n = colors.length;
    //     int count = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (check(i,k,colors,n)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // private boolean check(int idx,int k,int[] colors,int n){
    //     for(int i=idx+1;i<idx+k-1;i++){
    //         int curr=i%n;
    //         int next=(i+1)%n;
    //         int prev=(i-1)%n;
    //         if (colors[curr]==colors[next || colors[curr]==colors[prev]]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public String getEncryptedString(String s, int k) {
    //     int n=s.length();
    //     StringBuilder sb=new StringBuilder("");
    //     for(int i=0;i<s.length();i++){
    //         sb.append(s.charAt((i+k)%n));
    //     }
    //     return sb.toString();
    // }
    // public List<String> validStrings(int n) {
    //     List<String> ans=new ArrayList<>();
    //     StringBuilder curr=new StringBuilder("");
    //     helper(sb,"",n,ans);
    //     return ans;
    // }
    // private void helper(StringBuilder curr,String prevChar,int n,List<String> ans){
    //     if (curr.length()==n) {
    //         ans.add(curr);
    //     }
    //     helper(curr.append("1"), "1", n, ans);
    //     if(!prevChar.equals("0")){
    //         helper(curr.append("0"),"0", n, ans);
    //     }
    // }
    // public int findTheWinner(int n, int k) {
    //     LinkedList<Integer> ll=new LinkedList<>();
    //     for(int i=1;i<=n;i++){
    //         ll.addLast(i);
    //     }
    //     while (ll.size()!=1) {
    //         for(int i=1;i<=k;i++){
    //             int curr=ll.removeFirst();
    //             ll.addLast(curr);
    //         }
    //         ll.removeLast();
    //     }
    //     return ll.removeFirst();
    // }
    // public List<String> letterCombinations(String digits) {
    //     List<String> ans=new ArrayList<>();
    //     StringBuilder sb =new StringBuilder("");
    //     String s[]=new String[digits.length()];
    //     for(int i=0;i<digits.length();i++){
    //         s[i]=convert(digits.charAt(i));
    //     }
    //     helper(0, sb, ans, s);
    //     return ans;
    // }
    // private String convert(char c){
    //     if(c=='2') return "abc";
    //     if(c=='3') return "def";
    //     if(c=='4') return "ghi";
    //     if(c=='5') return "jkl";
    //     if(c=='6') return "mno";
    //     if(c=='7') return "pqrs";
    //     if(c=='8') return "tuv";
    //     if(c=='9') return "wxyz";
    //     return "";
    // }
    // private void helper(int idx,StringBuilder sb,List<String> ans,String s[]){
    //     if (idx==s.length) {
    //         ans.add(sb.toString());
    //     }
    //     String curr=s[idx];
    //     for(int i=0;i<curr.length();i++){
    //         sb.append(curr.charAt(i));
    //         helper(idx+1, sb, ans, s);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    //     return;
    // }
    // public List<List<Integer>> combine(int n, int k) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> curr=new ArrayList<>();
    //     helper(1, n, k, ans, curr);;
    //     return ans;
    // }
    // private void helper(int idx,int n,int k,List<List<Integer>> ans,List<Integer> curr){
    //     if (curr.size()==k) {
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }
    //     for(int i=idx;i<=n;i++){
    //         curr.add(i);
    //         helper(idx+1, n, k, ans, curr);
    //         curr.remove(curr.size()-1);
    //     }
    //     return;
    // }
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> curr=new ArrayList<>();
    //     HashSet<Integer> hs=new HashSet<>();
    //     helper(curr, ans, nums, hs);
    //     return;
    // }
    // private void helper(List<Integer> curr,List<List<Integer>> ans,int[] nums,HashSet<Integer> hs){
    //     if (curr.size()==nums.length) {
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if (!hs.contains(nums[i])) {
    //             hs.add(nums[i]);
    //             curr.add(nums[i]);
    //             helper(curr, ans, nums, hs);
    //             curr.removeLast();
    //             hs.remove(nums[i]);
    //         }
    //     }
    //     return;
    // }
    // public boolean exist(char[][] board, String word) {
    //     for(int i=0;i<board.length;i++){
    //         for(int j=0;j<board[0].length;j++){
    //             if (board[i][j]==word.charAt(0)) {
    //                 if (check(i, j, 0, board, word)) {
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
    // private boolean check(int i,int j,int idx,char[][] board, String word){
    //     if (idx==word.length()) {
    //         return true;
    //     }
    //     if (i<0 || i==board.length || j<0 || j==board[0].length) {
    //         return false;
    //     }
    //     if (board[i][j]!=word.charAt(idx)) {
    //         return false;
    //     }
    //     return check(i-1, j, idx+1, board, word) || check(i+1, j, idx+1, board, word) || check(i, j-1, idx+1, board, word) || check(i, j+1, idx+1, board, word);
    // }
    // class Node {
    // public boolean val;
    // public boolean isLeaf;
    // public Node topLeft;
    // public Node topRight;
    // public Node bottomLeft;
    // public Node bottomRight;

    
    // public Node() {
    //     this.val = false;
    //     this.isLeaf = false;
    //     this.topLeft = null;
    //     this.topRight = null;
    //     this.bottomLeft = null;
    //     this.bottomRight = null;
    // }
    
    // public Node(boolean val, boolean isLeaf) {
    //     this.val = val;
    //     this.isLeaf = isLeaf;
    //     this.topLeft = null;
    //     this.topRight = null;
    //     this.bottomLeft = null;
    //     this.bottomRight = null;
    // }
    
    // public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
    //     this.val = val;
    //     this.isLeaf = isLeaf;
    //     this.topLeft = topLeft;
    //     this.topRight = topRight;
    //     this.bottomLeft = bottomLeft;
    //     this.bottomRight = bottomRight;
    // }
    // }
    // public Node construct(int[][] grid) {
    //     return helper(0, grid.length-1, 0,grid[0].length-1, grid);
    // }
    // private Node helper(int i1,int i2,int j1,int j2,int grid[][]){
    //     if (i1>i2 || j1>j2) {
    //         return null;
    //     }
    //     boolean one=true;
    //     boolean zero=true;
    //     for(int i=i1;i<=i2;i++){
    //         for(int j=j1;j<=j2;j++){
    //             if (one) {
    //                 if (grid[i][j]!=1) {
    //                     one =false;
    //                 }
    //             }
    //             if (zero) {
    //                 if (grid[i][j]!=0) {
    //                     zero=false;
    //                 }
    //             }
    //         }
    //         if (!(zero && one)) {
    //             break;
    //         }
    //     }
    //     Node curr=new Node();
    //     if (one) {
    //         curr.isLeaf=true;
    //         curr.val=true;
    //         return curr;
    //     }
    //     if (zero) {
    //         curr.isLeaf=true;
    //         curr.val=false;
    //         return curr;
    //     }
    //     int midi=(i1+i2)/2;
    //     int mid2=(j1+j2)/2;
    //     curr.isLeaf=false;
    //     curr.val=true;
    //     curr.topLeft=helper(i1, midi-1, j1, mid2-1, grid);
    //     curr.topRight=helper(i1, midi-1, mid2,j2, grid);
    //     curr.bottomLeft=helper(midi, i2, j1, mid2-1, grid);
    //     curr.bottomRight=helper(midi, i2, mid2, j2, grid);
    //     return curr;
    // }
    // public int maxSubarraySumCircular(int[] nums) {
    //     int maxSum=Integer.MIN_VALUE;
    //     int currSum=0;
    //     for(int i=0;i<2*nums.length;i++){
    //         currSum+=nums[i%nums.length];
    //         maxSum=Math.max(maxSum, currSum);
    //         if (currSum<0) {
    //             currSum=0;
    //         }
    //     }
    //     return maxSum;
    // }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int i=helper(0,matrix.length-1,matrix,target);
    //     if (i==-1) {
    //         return false;
    //     }
    //     return check(i,matrix,target,0,matrix[0].length-1);
    // }
    // private int helper(int i1,int i1,int matrix[][],int target){
    //     if (i1>i2) {
    //         return -1;
    //     }
    //     int mid=(i1+i2)/2;
    //     if (matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target) {
    //         return mid;
    //     }
    //     else if(target>matrix[mid][matrix[0].length-1]){
    //         return helper(mid+1, i1, matrix, target);
    //     }
    //     else if (target<matrix[mid][0]) {
    //         return helper(i1, mid-1, matrix, target);
    //     }
    //     else return -1;
    // }
    // private boolean check(int i,int matrix[][],int target,int j1,int j2){
    //     if (j1>j2) {
    //         return false;
    //     }
    //     int mid=(j1+j2)/2;
    //     if (target==matrix[i][mid]) {
    //         return true;
    //     }
    //     else if (target>matrix[i][mid]) {
    //         return check(i, matrix, target, mid+1, j2);
    //     }
    //     else{
    //         return check(i, matrix, target, j1, mid-1);
    //     }
    // }
    // public int search(int[] nums, int target) {
    //     int pivot=0;
    //     for(int i=0;i<nums.length-2;i++){
    //         if (nums[i]>nums[i+1]) {
    //             pivot=i;
    //             break;
    //         }
    //     }
    //     if (target>nums[pivot]) {
    //         return -1;
    //     }
    //     else if(target>rmax){
    //         int l=0;
    //         int r=pivot;
    //         while (l<r) {
    //             int mid=l+(r-l)/2;
    //             if (nums[mid]==target) {
    //                 return mid;
    //             }
    //             else if(nums[mid]>target){
    //                 r=mid-1;
    //             }
    //             else l=mid+1;
    //         }
    //     }
    //     else{
    //         int l=pivot+1;
    //         int r=nums.length-1;
    //         while (l<r) {
    //             int mid=l+(r-l)/2;
    //             if (nums[mid]==target) {
    //                 return mid;
    //             }
    //             else if(nums[mid]>target){
    //                 r=mid-1;
    //             }
    //             else l=mid+1;
    //         }
    //     }
    //     return -1;
    // }
    // public int[] searchRange(int[] nums, int target) {
    //     int ans[]={-1,-1};
    //     int l=0;
    //     int r=nums.length-1;
    //     while (l<=r) {
    //         int mid=l+(r-l)/2;
    //         if (nums[mid]==target) {
    //             ans[0]=mid;
    //             while (nums[mid+1]==target) {
    //                 mid++;
    //             }
    //             ans[1]=mid;
    //         }
    //         else if (nums[mid]>target) {
    //             r=mid-1;
    //         }
    //         else l=mid+1;
    //     }
    //     return ans;
    // }
    // public int findMin(int[] nums) {
    //     int l=0;
    //     int r=nums.length-1;
    //     if (nums[l]<nums[r]) {
    //         return nums[l];
    //     }
    //     while (l<=r) {
    //         int mid=l+(r-l)/2;
    //         if (mid<r && nums[mid]>nums[mid+1]) {
    //             return nums[mid+1];
    //         }
    //         if (mid>l nums[mid]<nums[mid-1]) {
    //             return nums[mid];
    //         }
    //         if (nums[l]>=nums[mid]) {
    //             r=mid-1;
    //         }
    //         else l=mid+1;
    //     }
    //     return -1;
    // }
    // public String addBinary(String a, String b) {
    //     int x=convertToDecimal(a);
    //     int y=convertToDecimal(b);
    //     int z=x+y;
    //     StringBuilder sb=new StringBuilder("");
    //     while (z>0) {
    //         int curr=z%2;
    //         char c=curr==1?'1':'0';
    //         sb.append(c);
    //         z=z/2;
    //     }
    //     sb.reverse();
    //     return sb.toString();
    // }
    // private int convertToDecimal(String s){
    //     int mul=1;
    //     int sum=0;
    //     for(int i=s.length()-1;i>=0;i--){
    //         int curr=s.charAt(i)=='1'?1:0;
    //         sum+=curr*mul;
    //         mul*=2;
    //     }
    //     return sum;
    // }
    // public int reverseBits(int n) {
    //     StringBuilder sb =new StringBuilder("");
    //     while (n>0) {
    //         int z=z%2;
    //         char ch=z==1?'1':'0';
    //         sb.append(ch);
    //         n=n/2;
    //     }
    //     return convertToDecimal(sb.toString());
    // }
    // public int reverseBits(int n) {
    //     StringBuilder sb=new StringBuilder("");
    //     while (n>0) {
    //         int curr=n%2;
    //         char ch=curr==1?'1':'0';
    //         sb.append(ch);
    //         n=n/2;
    //     }
    //     int sum=0;
    //     int mul=1;
    //     for(int i=0;i<s.length();i++){
    //         int curr=s.charAt(i)=='1'?1:0;
    //         sum+=curr*mul;
    //         mul*=2;
    //     }
    //     return sum;
    // }
    /**
     * Innersdgdgadgegwetqerfqsac
     */
    // public class Pair implements Comparable<Pair> {
    //     List<Integer> arr;
    //     int sum;
    //     public Pair(int x,int y){
    //         arr=new ArrayList<>();
    //         arr.add(x);
    //         arr.add(y);
    //         this.sum=x+y;
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         return -this.sum+p2.sum;
    //     }        
    // }
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     PriorityQueue<Pair> pq=new PriorityQueue<>();

    //     for(int i=0;i<nums1.length;i++){
    //         for(int j=0;j<nums2.length;j++){
    //             int sum=nums1[i]+nums2[j];
    //             if (pq.size()>=k && sum>pq.peek().sum) {
    //                 break;
    //             }
    //             pq.add(new Pair(nums1[i],nums2[j]));
    //             if (pq.size()>k) {
    //                 pq.poll();
    //             }
    //         }
    //     }
    //     while (!pq.isEmpty()) {
    //         ans.add(new ArrayList<>(pq.poll().arr));
    //     }
    //     return ans;
    // }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     ArrayList<Integer> path1=new ArrayList<>();
    //     ArrayList<Integer> path2=new ArrayList<>();
    //     findPath(path1,)
    // }
    // public double averageWaitingTime(int[][] customers) {
    //     int time=customers[0][0];
    //     double waitTime=0;
    //     for(int i=0;i<customers.length;i++){
    //         time+=customers[i][1];
    //         waitTime+=time-customers[i][0];
    //     }
    //     return waitTime/customers.length;
    // }
    public class TreeNode {
        *     int val;
        *     TreeNode left;
        *     TreeNode right;
        *     TreeNode(int x) { val = x; }
        * }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     ArrayList<Integer> arr1=new ArrayList<>();
    //     ArrayList<Integer> arr2=new ArrayList<>();
    //     path(root, p, arr1);
    //     path(root, q, arr2);
    //     int n=Math.min(arr1.size(), arr2.size());
    //     int common=root.val;
    //     for(int i=0;i<n;i++){
    //         if (arr1.get(i)==arr2.get(i)) {
    //             common=arr1.get(i);
    //         }
    //     }
    //     return common;
    // }
    // private boolean path(TreeNode root,TreeNode p,ArrayList<Integer> arr){
    //     if (root==null) {
    //         return false;
    //     }
    //     arr.add(root.val);
    //     if (root.val==p.val) {
    //         return true;
    //     }
    //     boolean flag=(path(root.left, p, arr) || path(root.right, p, arr));
    //     if (flag==false) {
    //         arr.remove(arr.size()-1);
    //     }
    //     return flag;
    // }
    // public int rangeBitwiseAnd(int left, int right) {
        
    // }
    // public int minOperations(String[] logs) {
    //     Stack<String> s=new Stack<>();
    //     for(int i=0;i<logs.length;i++){
    //         if (logs[i].equals("../")) {
    //             if (!s.isEmpty()) {
    //                 s.pop();
    //             }
    //         }
    //         else if(logs[i].equals("./")) continue;
    //         else{
    //             s.push(logs[i]);
    //         }
    //     }
    //     return s.size();
    // }
    // public static boolean isPrime(long n) {
    //     if (n <= 1) return false;
    //     if (n <= 3) return true;

    //     if (n % 2 == 0 || n % 3 == 0) return false;

    //     for (long i = 5; i * i <= n; i += 6) {
    //         if (n % i == 0 || n % (i + 2) == 0) return false;
    //     }
    //     return true;
    // }
    // public static boolean isForm2xMinus1(int num) {
    //     return (num & (num + 1)) == 0 && num != 0;
    // }
    // // public String reverseParentheses(String s) {
    // //     StringBuilder sb =new StringBuilder("");
    // //     Stack<StringBuilder> stack=new Stack<>();
    // //     for(int i=0;i<s.length();i++){
    // //         if (s.charAt(i)=='(') {
    // //             if(!sb.isEmpty()) stack.push(sb);
    // //             sb=new StringBuilder("");
    // //         }
    // //         else if(s.charAt(i)==')'){
    // //             StringBuilder temp=sb.reverse();
    // //             if (!stack.isEmpty()) {
    // //                 sb=new StringBuilder(stack.pop());
    // //                 sb.append(temp);
    // //             }
    // //             else{
    // //                 sb=new StringBuilder("");
    // //                 sb.append(temp);
    // //             }
    // //         }
    // //         else{
    // //             sb.append(s.charAt(i));
    // //         }
    // //     }
    // // }
    // public int maximumGain(String s, int x, int y) {
    //     int count=0;
    //     if (x>y) {
    //         while (s.contains("ab")) {
    //             count+=search(s,"ab",x);
    //         }
    //         while (s.contains("ba")) {
    //             count+=search(s,"ba",y);
    //         }
    //     }
    //     else{
    //         while (s.contains("ba")) {
    //             count+=search(s,"ba",y);
    //         }
    //         while (s.contains("ab")) {
    //             count+=search(s,"ab",x);
    //         }

    //     }
    //     return count;
    // }

    // private int search(String s,String req,int cost){
    //     StringBuilder sb=new StringBuilder(s);
        

    //     for(int i=0;i<s.length();i++){
    //         if (i!=s.length()-1) {
    //             if (s.charAt(i)==req.charAt(0) && s.charAt(i+1)==req.charAt(1) ) {
    //                 sb.delete(i, i+2);
    //                 s=sb.toString();
    //                 return cost;
    //             }
    //         }
    //     }
    //     return 0;
    // }
    
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    public class Pair{
        TreeNode n;
        int freq;
        int left;
        int right;
        public Pair(int n){
            this.n.val=n;
            freq=1;
        }
    }
    //extra lines for git
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,Pair> hm =new HashMap<>();
        for(int i=0;i<descriptions.length;i++){
            int curr=descriptions[i][0];
            if (!hm.containsKey(curr)) {
               
                
            }
        }
    }
}


