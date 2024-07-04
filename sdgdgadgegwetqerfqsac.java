import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size=q.size();
            double avg=0;
            for (int i = 0; i < size; i++) {
                TreeNode curr=q.poll();
                avg+=(double)curr.val;
                if (curr.left!=null) {
                    q.add(curr.left);
                }
                if (curr.right!=null) {
                    q.add(curr.right);
                }
            }
            ans.add(avg/size);
        }
        return ans;
    }
}
