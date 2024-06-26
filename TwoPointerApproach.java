import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class TwoPointerApproach {
    // public int maxArea(int[] height) {
    //     int i=0;
    //     int j=height.length-1;
    //     int max=0;
    //     int curr=0;
    //     while (i<j) {
    //         curr=(j-i)*Math.min(height[i],height[j]);
    //         max=Math.max(max, curr);
    //         if (height[i]<height[j]) {
    //             i++;
    //         }
    //         else j--;
    //     }
    //     return max;
    // }
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> currList=new ArrayList<>();
    //     if (nums.length<3) {
    //         return ans;
    //     }
    //     if (nums.length==3) {
    //         if (nums[0]+nums[1]+nums[2]==0) {
    //             currList.add(nums[0]);
    //             currList.add(nums[1]);
    //             currList.add(nums[2]);
    //             ans.add(new ArrayList<>(currList));
    //         }
    //         return ans;

    //     }
    //     Arrays.sort(nums);
    //     int i=0;
    //     int j=nums.length-1;
    //     int target=0;
    //     while (i<j) {
    //         int maxAvaiable=nums[j-1];
    //         int minAvailable=nums[i+1];
    //         currList=new ArrayList<>();
    //         target=-(nums[i]+nums[j]);
    //         if (target>maxAvaiable) {
    //             i++;
    //         }
    //         else if(target<minAvailable){
    //             j--;
    //         }
    //         else{
    //             currList.add(nums[i]);
    //             currList.add(nums[j]);
    //             for(int k=i+1;k<=j-1;k++){
    //                 if (target==nums[k]) {
    //                     currList.add(nums[k]);
    //                     ans.add(new ArrayList<>(currList));
    //                     break;
    //                 }
    //             }
                
    //             if (nums[i]<minAvailable*(-2) && nums[j]>maxAvaiable*(-2)) {
    //                 i++;
    //                 j--;
    //             }
    //             else if(nums[i]<minAvailable*(-2)) j--;
    //             else i++;
                
    //         }
    //     }
    //     return ans;
    // }
    // public int threeSumClosest(int[] nums, int target) {
    //     int sumClosestToTarget=0;
    //     int minDiff=Integer.MAX_VALUE;
    //     Arrays.sort(nums);
    //     int currSum=0;
    //     int currDiff=0;
    //     for(int i=0;i<nums.length-2;i++){
    //         if (i>0 && nums[i]==nums[i-1]) continue;
            
    //         int j=i+1;
    //         int k=nums.length-1;
    //         while (j<k) {
    //             currSum=nums[i]+nums[j]+nums[k];
    //             if (currSum==target) {
    //                 return target;
    //             }
    //             currDiff=Math.abs(currSum-target);
    //             if (currDiff<minDiff) {
    //                 minDiff=currDiff;
    //                 sumClosestToTarget=currSum;
    //             }
    //             if (currSum>target) {
    //                 j--;
    //             }
    //             else{
    //                 i++;
    //             }
    //         }
    //     }
    //     return sumClosestToTarget;
    // }
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> currList=new ArrayList<>();
    //     int currSum=0;
    //     for (int i = 0; i < nums.length-3; i++) {
    //         if(i>0 && nums[i]==nums[i-1]) continue;

    //         for (int j =i+1; j < nums.length; j++) {
    //             if(j>0 && nums[j]==nums[j-1]) continue;

    //             int k=j+1;
    //             int l=nums.length-1;

    //             while (k<l) {
    //                 currSum=nums[i]+nums[j]+nums[k]+nums[l]
    //                 if (currSum==target) {
    //                     currList.add(nums[i]);
    //                     currList.add(nums[j]);
    //                     currList.add(nums[k]);
    //                     currList.add(nums[l]);
    //                     ans.add(new ArrayList<>(currList));
    //                     currList=new ArrayList<>();
    //                     break;
    //                 }
    //                 else if(currSum<target) k++;
    //                 else l--;

    //             }
    //         }
    //     }
    //     return ans;
    // }public ListNode removeNthFromEnd(ListNode head, int n) {
        
    // }
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode temp=head;
    //     int count=0;
    //     while (temp!=null) {
    //         count++;
    //         temp=temp.next;
    //     }
    //     int idxReq=count-n+1;
    //     ListNode curr=head;
    //     ListNode prev=null;
    //     while (idxReq!=1) {
    //         curr=curr.next;
    //         prev=curr;
    //         idxReq--;
    //     }
    //     prev.next=curr.next;
    //     curr.next=null;
    //     return head;
    // }
    // public int trap(int[] height) {
    //     int n=height.length;
    //     int leftmax[]=new int[n];
    //     leftmax[0]=height[0];
    //     int rightMax[]=new int[n];
    //     rightMax[n-1]=height[n-1];
    //     for(int i=1;i<height.length;i++){
    //         leftmax[i]=Math.max(height[i],leftmax[i-1]);
    //         rightMax[n-1-i]=Math.max(height[n-i-1],rightMax[n-i]);
    //     }
    //     int waterHeight=0;
    //     int total=0;
    //     for (int i = 0; i < rightMax.length; i++) {
    //         waterHeight=Math.min(leftmax[i],rightMax[i]);
    //         if(waterHeight>=height[i]) total+=waterHeight-height[i];
    //     }
    //     return total;
    // }
    // public boolean isPalindrome(String s) {
    //     if(s.length()<2) return true;
    //     int i=0;
    //     int j=s.length()-1;
    //     while (i<j) {
    //         if (!Character.isLetter(s.charAt(i))) {
    //             i++;
    //             continue;
    //         }
    //         if (!Character.isLetter(s.charAt(j))) {
    //             j++
    //             continue;
    //         }
    //         char x=Character.toLowerCase(s.charAt(i));
    //         char y=Character.toLowerCase(s.charAt(j));
    //         if (x!=y) {
    //             return false;
    //         }
    //     }
    //     return true;

    // }
    // public ListNode rotateRight(ListNode head, int k) {
    //     int count=0;
    //     ListNode dummy=new ListNode(0);
    //     dummy.next=head;
    //     ListNode first=head;
    //     ListNode second=head;
    //     while (first.next!=null) {
    //         first=first.next;
    //         count++;
    //     }
    //     int reqK=k%count;
    //     for (int i = 0; i <reqK; i++) {
    //         second=second.next;
    //     }
    //     first.next=dummy.next;
    //     dummy.next=second.next;
    //     second.next=null;
    //     return dummy.next;
    // }
    // public ListNode deleteDuplicates(ListNode head) {
    //     if (head==null || head.next==null) {
    //         return head;
    //     }
    //     ListNode curNode=head;
    //     ListNode prev=new ListNode(101);
    //     while (curNode.next!=null) {
    //         if (curNode.val==curNode.next.val) {
    //             while (curNode.next!=null && curNode.val!=curNode.next.val) {
    //                 curNode=curNode.next;
    //             }
    //             curNode=curNode.next;
    //         }
    //         prev.next=curNode;
    //         curNode=curNode.next;
    //     }
    //     return prev.next;
    // }
    // public ListNode partition(ListNode head, int x) {
    //     if (head==null || head.next==null) {
    //             return head;
    //     }
    //     ListNode dummyhead=new ListNode(0);
    //     ListNode dummy=dummyhead;
    //     ListNode temp=head;
    //     while (temp.next!=null) {
    //         if (temp.val<x) {
    //             dummy.next=temp;
    //             dummy=dummy.next;
    //         }
    //         temp=temp.next;
    //     }
    //     temp=head;
    //     while (temp.next!=null) {
    //         if (temp.val>=x) {
    //             dummy.next=temp;
    //             dummy=dummy.next;
    //         }
    //         temp=temp.next;
    //     }
    //     return dummyhead.next;
    // }
    // public boolean hasCycle(ListNode head) {
    //     if(head==null) return false; 
    //     ListNode slow=head;
    //     ListNode fast=head;
    //     while(fast.next!=null && fast.next.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //         if(slow==fast) return true;
    //     }
    //     return false;
    // }
    // public String reverseWords(String s) {
    //     String words[]=s.split("\\s+");
    //     StringBuilder sb=new StringBuilder("");
    //     for (int i = 0; i < words.length; i++) {
    //         if(words[words.length-1-i]!=" ") sb.append(words[words.length-1-i]);
    //         sb.append(" ");
    //     }
    //     return sb.toString();
    // }
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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();

    }
    public void inorderTraversal(TreeNode root,ArrayList<Integer> arr){
        
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int t=sc.nextInt();
        // for (int i = 0; i < t; i++) {
        //     int n=sc.nextInt();//boxes
        //     int m=sc.nextInt();//children

        //     int candy[]=new int[n];
        //     int choclate[]=new int[n];

        //     for (int j = 0; j < candy.length; j++) {
        //         candy[j]=sc.nextInt();
        //     }

        //     for (int j = 0; j < choclate.length; j++) {
        //         choclate[j]=sc.nextInt();
        //     }

        //     int count=0;
        //     for (int j = 0; j <candy.length; j++) {
        //         int x=candy[j];
        //         for (int k = 0; k < choclate.length; k++) {
        //             int y=choclate[k];
        //             if ((x+y)%m==0) {
        //                 count++;
        //             }
        //         }
        //     }
        //     System.out.println(count);
        // }
    }
}
