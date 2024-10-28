import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        Has
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
