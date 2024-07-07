import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
    
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i + 1) % n] && colors[(i + 1) % n] != colors[(i + 2) % n]) {
                count++;
            }
        }
    
        return count;
    }

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long min=Long.MAX_VALUE;
        long energy=(long)currentEnergy;
        for (int i = 0; i < enemyEnergies.length; i++) {
            energy+=(long)enemyEnergies[i];
            min=Math.min(min,(long)enemyEnergies[i]);
        }
        energy-=min;
        if (currentEnergy<min) {
            return 0;
        }
        long count=energy/min;
        return count;
    }
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
    public String getEncryptedString(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt((i+k)%n));
        }
        return sb.toString();
    }
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder curr=new StringBuilder("");
        helper(sb,"",n,ans);
        return ans;
    }
    private void helper(StringBuilder curr,String prevChar,int n,List<String> ans){
        if (curr.length()==n) {
            ans.add(curr);
        }
        helper(curr.append("1"), "1", n, ans);
        if(!prevChar.equals("0")){
            helper(curr.append("0"),"0", n, ans);
        }
    }


}
