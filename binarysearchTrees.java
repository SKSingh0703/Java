import java.util.*;
public class binarysearchTrees {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val) root.left=insert(root.left, val);
        else root.right=insert(root.right, val);
        return root;
    }
    public static Node build(int arr[]){
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root, arr[i]);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root,int val){
        if(root==null) return false;
        if(root.data==val) return true;
        else if(root.data>val) return search(root.left, val);
        else return search(root.right, val);
    }

    public static Node delete(Node root,int val){
        if(root.data>val) root.left= delete(root.left, val);
        else if(root.data<val) root.right= delete(root.right, val);
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS=findnextinordernode(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data );
        }
        return root;
        
    }
    public static Node findnextinordernode(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    } 

    // public static void     helper(Node root,int k1,int k2){
    //     if(root==null) return;
    //     if(root.data<k2 && root.data>k1){
    //         helper(root.left, k1, k2);
    //         System.out     sum(root.data+" ");
    //         helper(root.right, k1, k2);
    //     }
    //     else if(root.data>k2){
    //         helper(root.left, k1, k2);
    //     }
    //     else{
    //         helper(root.right, k1, k2);
    //     }
    // }
    // public static void     sum(ArrayList<Integer> arr){
    //     for(int i=0;i<arr.size();i++){
    //         System.out     sum(arr.get(i)+"--");
    //     }
    //     System.out     sumln("NULL");
    // }

    // public static void     sumPath(Node root,ArrayList<Integer> arr){
    //     if(root==null) return;
    //     arr.add(root.data);
    //     if(root.left==null && root.right==null){
    //         sum(arr);
    //     }
    //     sumPath(root.left, arr);
    //     sumPath(root.right, arr);
    //     arr.remove(arr.size()-1);
    //     return;
    // }

    // public static boolean isValidBSTHelper(Node root,Node min ,Node max){
    //     if(root==null) return true;
    //     if(min!=null && min.data>root.data) return false;
    //     else if(max!=null && max.data<root.data) return false;
    //     else{
    //         return isValidBSTHelper(root.left, min, root) && isValidBSTHelper(root.right,root, max);
    //     }
    // }
    // public static void isValidateBST(Node root){
    //     boolean flag=isValidBSTHelper(root, null, null);
    //     if(flag) System.out    sumln("VALID");
    //     else System.out    sumln("False");
    // }
    // public static Node mirrorBST(Node root){
    //     if(root==null) return null;
    //     Node left=mirrorBST(root.left);
    //     Node right=mirrorBST(root.right);
    //     root.left=right;
    //     root.right=left;
    //     return root;
    // }
    // public static Node createBST(int arr[],int start,int end){
    //     if(start>end) return null;
    //     int mid=(start+end)/2;
    //     Node root=new Node(arr[mid]);
    //     root.left=createBST(arr, start, mid-1);
    //     root.right=createBST(arr, mid+1, end);
    //     return root;
    // }
    // public static Node getInOrder(ArrayList<Integer> arr,int start,int end){
    //     if(start>end) return null;
    //     int mid=(start+end)/2;
    //     Node root=new Node(arr.get(mid));
    //     root.left=getInOrder(arr, start, mid-1);
    //     root.right=getInOrder(arr, mid+1, end);
    //     return root;
    // }
    // public static void arrayListsequence(ArrayList<Integer> arr,Node root){
    //     if(root==null) return ;
    //     arrayListsequence(arr, root.left);
    //     arr.add(root.data);
    //     arrayListsequence(arr, root.right);
    //     return;
    // }
    // public static Node balancedBST(Node root){
    //     ArrayList<Integer> inorder=new ArrayList<>();
    //     arrayListsequence(inorder, root);
    //     root=getInOrder(inorder, 0, inorder.size()-1);
    //     return root;
    // }
    // public static void preOrder(Node root){
    //     if(root==null) return;
    //     System.out     sum(root.data+" ");
    //     preOrder(root.left);
    //     preOrder(root.right);
    //     return;
    // }
    public static class Info{
        boolean flag;
        int size;
        int min;
        int max;
        public Info(boolean flag,int size,int min,int max){
            this.flag=flag;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxsize=0;
    // boolean falg,int size,int min,int max
    public static Info sizeOfLargestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info left=sizeOfLargestBST(root.left);
        Info right=sizeOfLargestBST(root.right);
        int size=left.size+right.size+1;
        int min=Math.min(root.data, Math.min(left.min, right.min));
        int max=Math.max(root.data,Math.max(left.max,right.max));
        if(root.data>=left.max || root.data<=right.min){
            return new Info(false, size, min, max);
        }
        if(left.flag && right.flag){
            maxsize=Math.max(maxsize,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
        ArrayList<Integer> finalarr=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }
            else {
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalarr.add(arr1.get(i));
                i++;
        }
        while(j<arr2.size()){
            finalarr.add(arr2.get(j));
            j++; 
        }
        return finalarr;
    }

    // public static Node merge2BST(Node root1,Node root2){
    //     ArrayList<Integer> arr1=new ArrayList<>();
    //     arrayListsequence(arr1, root1);
    //     ArrayList<Integer> arr2=new ArrayList<>();
    //     arrayListsequence(arr2, root2);
    //     ArrayList<Integer> finalArr=merge(arr1, arr2);
    //     Node root=getInOrder(finalArr, 0, finalArr.size()-1);
    //     return root;

    // }
    public static int sum=0;
    public static void helper(Node root,int k1,int k2){
        if(root==null) return;
        if(root.data<=k2 && root.data>=k1){
            helper(root.left, k1, k2);
            // System.out.print(root.data+" ");
            sum+=root.data;
            helper(root.right, k1, k2);
        }
        else if(root.data>k2){
            helper(root.left, k1, k2);
        }
        else{
            helper(root.right, k1, k2);
        }
    }
    public static void sumInRange(Node root,int L,int R){
        helper(root, L, R);
        System.out.println("The Sum is : "+ sum);
    }
    public static int val=0;
    public static void mindifferencehelper(Node root,int key,int minDiffernce){
        if(root==null) return;
        int curDiff=Math.abs(root.data-key);
        if(curDiff<minDiffernce){
            minDiffernce=curDiff;
            val=root.data;
        }
        mindifferencehelper(root.left, key, minDiffernce);
        mindifferencehelper(root.right, key, minDiffernce);
        return;
    }
    
    public static void mindifference(Node root,int key){
        // int val=0;
        int mindiff=Integer.MAX_VALUE;
        mindifferencehelper(root, key, mindiff);
        System.out.println("The required Answer is :"+val);
    }

    public static void getArrayList(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        getArrayList(root.left, arr);
        arr.add(root.data);
        getArrayList(root.right, arr);
        return;
    }
    public static void getIthelement(Node root,int K){
        ArrayList<Integer> arr=new ArrayList<>();
        getArrayList(root, arr);
        System.out.println(arr.get(arr.size()-K));
    }
    public static class Info3{
        boolean flag;
        int sum;
        int leftmax;
        int rightmin;
        public Info3(boolean flag,int sum,int leftmax,int rightmin){
            this.flag=flag;
            this.sum=sum;
            this.leftmax=leftmax;
            this.rightmin=rightmin;
        }
    }
    public static int maxsubsum=0;
    public static Info3 maxSumBSTHelper(Node root){
        if(root==null) return new Info3(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Info3 left=maxSumBSTHelper(root.left);
        Info3 right=maxSumBSTHelper(root.right);
        int currsum=left.sum+right.sum+root.data;
        int leftmax=Math.max(root.data,Math.max(left.leftmax,right.leftmax));
        int rightsum=Math.min(root.data,Math.min(left.rightmin,right.rightmin));
        if(root.data>right.rightmin || root.data<left.leftmax){
            return new Info3(false, currsum, leftmax, rightsum);
        }
        if(left.flag && right.flag){
            maxsubsum=Math.max(maxsubsum,currsum);
            return new Info3(true, currsum, leftmax, rightsum);
        }

        return new Info3(false, currsum, leftmax, rightsum);

    }
    // public static void maxSubSum(Node root){
    //     Info3 I=maxSumBSTHelper(root);
        

    //     System.out.println("The max sum is :"+ maxsubsum);

    // }
    public static void main(String[] args) {
        // int arr[]={8,5,3,6,11,20};
        // Node root=build(arr);
        // preOrder(root);
        // System.out      sumln();
        // root=delete(root, 3);
        // inorder(root);
        //     helper(root, 3, 6);
        //     sumPath(root, new ArrayList<>());
        // isValidateBST(root);
        // inorder(mirrorBST(root));
        // root=balancedBST(root);
        // preOrder(root);
        // System.out      sumln();

        Node root=new Node(5);
        root.left=new Node(9);
        root.right=new Node(2);
        root.left.left=new Node(6);
        root.left.right=new Node(3);
        root.left.left.left=new Node(8);
        root.left.left.right=new Node(7);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);
        // Info x=sizeOfLargestBST(root);
        // System.out      sumln("Size of largest BST: "+maxsize);
        // Node root1=new Node(2);
        // root1.left=new Node(1);
        // root1.right=new Node(4);

        // Node root2=new Node(9);
        // root2.left=new Node(3);
        // root2.right=new Node(12);

        // Node root=merge2BST(root1, root2);
        // preOrder(root);

        // sumInRange(root, 3, 8);
        // mindifference(root, 3);

        // getIthelement(root, 3);
        // maxSubSum(root);



    }
}
