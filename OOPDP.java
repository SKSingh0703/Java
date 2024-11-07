import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class OOPDP {
    public static abstract class Accounts {
        double balance;
        int accountNumber;
        String accountName;
        public Accounts(double d,int ac,String a){
            balance=d;accountNumber=ac;accountName=a;
        }
        public abstract void withdrawl(int amount);
        public abstract void deposit(int amount);
        public void display(){
            System.out.println("Balance : "+this.balance);
        }
    }
    public static class SavingAccount extends Accounts {
        double rateOfIntrest;
        public SavingAccount(double b,int num,String name,double roi){
            super(b, num, name);
            rateOfIntrest=roi;
        }
        public void withdrawl(int amount){
            if (balance<amount) {
                System.out.println("Insufficient Balance!!!");
            }
            else{
                balance-=amount;
                System.out.println("Withdrawl Successfull !!! . Available Balance : "+balance);
            }
        }
        public void deposit(int amount){
            balance+=amount;
            System.out.println("Deposit SuccessFull !!! . Available Balance : "+ balance);
        }
        public void display(){
            
            System.out.println("Balance : "+this.balance);
            System.out.println("Rate of Intrest : "+this.rateOfIntrest);
            System.out.println("Account Name : "+this.accountName);
            System.out.println("Account Number : "+this.accountNumber);
        }            

    }
    public List<String> removeSubfolders(String[] folder) {
        List<String> arr = new ArrayList<>();
        Stack<String> s = new Stack<>();
        Arrays.sort(folder);
        for(int i=0;i<folder.length;i++){
            String curr = folder[i];
            if(s.isEmpty()) s.push(curr);
            else{
                if(curr.contains(s.peek()+"/")) continue;
                arr.add(s.pop());
                s.push(curr);
            }
        }
        return arr;
    }
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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int ans[]=new int[queries.length];
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        for(int i=0;i<queries.length;i++){
            TreeNode temp=root;
            temp=removeSubRoot(temp,queries[i]);
            ans[i]=height(temp);
        }
        return ans;
    }
    public TreeNode removeSubRoot(TreeNode root,int target){
        if (root==null || root.val==target) {
            return root;
        }
        root.left=removeSubRoot(root.left, target);
        root.right=removeSubRoot(root.right, target);
        return root;
    }
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int maxSize=-1;
        int currSize=1;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if (!hs.contains(curr)) {
                continue;
            }
            else{
                currSize=0;
                while (hs.contains(curr)) {
                    currSize++;
                    hs.remove(curr);
                    curr=curr*curr;
                }
                if (currSize>2) {
                    maxSize=Math.max(maxSize, currSize);
                }
            }
        }
        return maxSize;
    }
    public int maxMoves(int[][] grid) {
        int max=0;
        int curr=0;
        for(int i=0;i<grid.length;i++){
            curr=helper(i, 0, grid, grid.length, grid[0].length, 0);
            max=Math.max(max, curr);
        }
        return max;
    }
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1) && s.charAt(i-2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public boolean isCircularSentence(String sentence) {
        String arr[]=sentence.split(" ");
        int n=arr.length;
        if (sentence.charAt(0)!=sentence.charAt(sentence.length()-1)) {
            return false;
        }
        for(int i=1;i<n;i++){
            if (arr[i].charAt(0)!=arr[i-1].charAt(arr[i-1].length()-1)) {
                return false;
            }
        }
        return true;
    }
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        char curr = word.charAt(0);
        for(int i=1;i<word.length();i++){
            if (curr==word.charAt(i)) {
                count++;
            }
            else{
                sb.append(Integer.toString(count));
                sb.append(curr);
                curr=sb.charAt(i);
                count=1;
            }
        }
        return sb.toString();
    }
    public boolean canSortArray(int[] nums) {
        int arr[]=new int[nums.length];
        int n = nums.length;
        for(int i=0; i<n;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (arr[i]>arr[i+1] && Integer.bitCount(arr[i])>Integer.bitCount(arr[i+1])) {
                    int temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=nums[i]) return false;
        }
        return true;
    }
    public int largestCombination(int[] candidates) {
        int arr[]=new int[24];
        for(int i=0;i<24;i++){
            for(int j=0;j<candidates.length;j++){
                arr[i]+=(candidates[i]&1);
                candidates[i]=candidates[i]>>1;
            }
        }
        int max=0;
        for(int i=0;i<24;i++){
            max=Math.max(max, arr[i]);
        }
        return max;
    }
    public int helper(int row,int col,int grid[][],int m,int n,int prev){
        if (row>=m || col>=n || grid[row][col]<=prev) {
            return 0;
        }
        int one = helper(row-1, col+1, grid, m, n,grid[row][col]);
        int two = helper(row, col+1, grid, m, n,grid[row][col]);
        int three = helper(row+1, col+1, grid, m, n,grid[row][col]);
        return 1+Math.max(two, Math.max(one, three));
    }
    public int height(TreeNode root){
        if (root==null) {
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public interface Queue {
        public void add(int num);
        public void delete();
        public boolean isEmpty();
        
    }
    public static void main(String[] args) {
        SavingAccount acc = new SavingAccount(1000, 101,"SK", 1.3);
        acc.display();
        acc.deposit(500);
        acc.display();
        acc.withdrawl(125);
        acc.display();
    }
}
