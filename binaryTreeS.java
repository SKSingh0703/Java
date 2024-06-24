import java.util.*;
import java.util.LinkedList;
public class binaryTreeS {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            }
    }

    static class Info{
        int diam;
        int height;
        public Info(int diam,int height){
            this.diam=diam;
            this.height=height;
        }
    }

    static class Information{
        Node node;
        int hd;
        public Information(int hd,Node node){
            this.hd=hd;
            this.node=node;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node binarypreorder(int node[]){
            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newnode=new Node(node[idx]);
            newnode.left=binarypreorder(node);
            newnode.right=binarypreorder(node);

            return newnode;
        }
        static int id=-1;
        public static Node binarypreorder2(int node[]){
            id++;
            if(node[id]==-1){
                return null;
            }
            Node newnode=new Node(node[id]);
            newnode.left=binarypreorder2(node);
            newnode.right=binarypreorder2(node);

            return newnode;
        }

        public static void preorder(Node head){
            if(head==null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(head.data+" ");
            preorder(head.left);
            preorder(head.right);
        }

        public static void inorder(Node root){
            if(root==null) return;
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder( root.right);
        }
        public static void postorder(Node root){
            if(root==null) return;
            inorder(root.left);
            
            inorder( root.right);
            System.out.print(root.data+" ");
        }
        public static void levelorder(Node root){
            if(root==null) return;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!=null) q.add( currNode.right);
                } 
        }
    }
    public static int height(Node root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static int count(Node root){
        if(root==null) return 0;
        int lc=count(root.left);
        int rc=count(root.right);
        return lc+rc +1;
    }
    public static int sumofNodes(Node root){
        if(root==null) return 0;
        int lc=sumofNodes(root.left);
        int rc =sumofNodes(root.right);
        return lc+rc+root.data;
    }

    public static int maxdiameter(Node root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        int ld=maxdiameter(root.left);
        int rd=maxdiameter(root.right);
        int selfdiameter=lh+rh+1;
        return Math.max(selfdiameter,Math.max(ld,rd));
    }

    public static Info diameter(Node root){
        if(root==null) return new Info(0, 0);
        Info leftInfo=diameter(root.left);
        Info rInfo=diameter(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rInfo.diam),leftInfo.height+rInfo.height+1);
        int ht=Math.max(leftInfo.height,rInfo.height)+1;
        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node root,Node subroot){
        if(root==null && subroot==null){
            return true;
        }
        else if(root==null || subroot==null || root.data!=subroot.data){
            return false;
        }
        if(!isIdentical(root.left, subroot.left)) return false;
        if(!isIdentical(root.right, subroot.right)) return false;

        return true;
    }

    public static boolean isSubtree(Node root ,Node subroot){
        if(root==null) return false;
        if(root.data==subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    

    public static void topview(Node root){
        Queue<Information> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        q.add(new Information(0, root));
        q.add(null);
        int min=0,max=0;
        while(!q.isEmpty()){
            Information currinfo=q.remove();
            if(currinfo==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(currinfo.hd)){
                    map.put(currinfo.hd, currinfo.node);
                }
                if(currinfo.node.left!=null){
                    q.add(new Information(currinfo.hd-1,currinfo.node.left));
                    min=Math.min(min, currinfo.hd-1);
                }
                if(currinfo.node.right!=null){
                    q.add(new Information(currinfo.hd+1,currinfo.node.right));
                    max=Math.max(max, currinfo.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(" "+map.get(i).data);
        }
    }
    public static void Klevel(Node root,int level,int k){
        if(root==null) return;
        if(level==k){
            System.out.print(" "+root.data);
            return;
        }
        Klevel(root.left, level +1, k);
        Klevel(root.right, level+1, k);
        return;
    }
    public static boolean getpath(Node root,int n1,ArrayList<Node> l){
        if(root==null) return false;
        l.add(root);
        if(root.data==n1 ) return true;
        
        boolean left=getpath(root.left, n1, l);
        boolean right=getpath(root.right, n1, l);
        if(left || right){
            return true;
        }
        l.remove(l.size()-1);
        return false;
    }

    public static Node  lowestCommonAncestor(Node root,int n1,int n2){
        ArrayList<Node> l1=new ArrayList<>();
        ArrayList<Node> l2=new ArrayList<>();

        getpath(root, n1, l1);
        getpath(root, n2, l2);

        int i=0;
        for(;i<l1.size() &&i<l2.size();i++){
            if(l1.get(i)!=l2.get(i)){
                break;
            }
        }

        return l1.get(i-1);
        
    }

    public static Node lca(Node root,int n1,int n2){
        if(root==null) return root;
        if(root.data==n1 || root.data==n2) return root;
        Node lefNode=lca(root.left, n1, n2);
        Node rightNode=lca(root.right, n1, n2);

        if(lefNode==null) return rightNode;
        if(rightNode==null) return lefNode;
        return root;
    }

    public static int lcaDistance(Node root,int n){
        if(root==null) return -1;
        if(root.data==n) return 0;
        int left=lcaDistance(root.left, n);
        int right=lcaDistance(root.right, n);
        if(left==-1 && right==-1) return -1;
        else if(left==-1) return right+1;
        else return left+1;
    }

    public static int mindistance(Node root,int n1,int n2){
        if(root==null) return 0;
        Node lca=lca(root, n1, n2);
        int left=lcaDistance(lca, n1);
        int right=lcaDistance(lca, n2);
        return left+right;

    }

    public static int kthAncestor(Node root ,int n,int k){
        if (root==null) return -1;
        if(root.data==n) return 0;
        int left=kthAncestor(root.left, n, k);
        int right=kthAncestor(root.right, n, k);
        if(left==-1 && right==-1) return -1;
        int max=Math.max(left,right);
        if(max+1==k){
            System.out.println("The Kth Ancestor is:"+root.data);

        }
        return max+1;
    }

    public static int sumtree(Node root){
        if(root==null) return 0;
        // if(root.left==null && root.right==null) return root.data;
        int left=sumofNodes(root.left);
        int right=sumofNodes(root.right);
        int data=root.data;
        int newleft=root.left==null?0:root.left.data;
        int newright=root.right==null?0:root.right.data;
        root.data=left+newleft+newright+right;
        return data;
    }

    public static boolean isUnivalued(Node root,int k){
        if(root== null) return true;
        if(root.data!=k) return false;
        boolean left=isUnivalued(root.left,k);
        boolean right=isUnivalued(root.right,k);

        // boolean self=(root.data==root.left.data) &&(root.data==root.right.data);
        if(left && right ){
            return true;
        }
        else return false;
    }

    public static void isUnivaluedHelper(Node root){
        System.out.println(isUnivalued(root, root.data));
    }

    public static boolean isInverse(Node root1,Node root2){
        if(root1==null && root2==null) return true;
        if(root1.data!=root2.data) return false;
        boolean left=isInverse(root1.left, root2.right);
        boolean right=isInverse(root1.right, root2.left);

        return left && right;

    }
    public static int del(Node root, int key){
        if(root==null) return -1;
        int left=del(root.left, key);
        int right=del(root.right, key);
        if(root.data==key && root.left==null && root.right==null){
            return 0;
        }
        if(left==0) {
            root.left=null;
        }
        if(right==0) root.right=null;

        return -1;
    }

//     public static void deleteleafs(Node root,int key){
//         int x=del(root, key);
//     }
//     static int maxsum=0;
//     public static int maxpathsum(Node root){
//         if(root==null) return maxsum+=0;
//         if(root.data<0) {
//             if(root.left!=null && root.right!=null){
//                 int left=root.left.data;
//                 int right=root.right.data;
//                 if(left>right){
//             // maxsum+=root.left.data;
//                         return maxpathsum(root.left);
//                 }
//                 if(right>left){
//             // maxsum+=root.right.data;
//                         return maxpathsum(root.right);
//                 }
//                 }
//         }
//         maxsum+=root.data;
//         if(root.left!=null && root.right!=null){
//             int left=root.left.data;
//         int right=root.right.data;
//         if(left>right){
//             // maxsum+=root.left.data;
//             return maxpathsum(root.left);
//         }
//         if(right>left){
//             // maxsum+=root.right.data;
//             return maxpathsum(root.right);
//         }
//         }

//         return maxsum;
//     }


    
// }
    


//     public static void main(String[] args) {
//         int node[]={-10,9,-1,-1,20,15,-1,-1,7,-1,-1};
//         BinaryTree tree =new BinaryTree();
        
//         Node root=tree.binarypreorder(node);
//         // int node2[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
//         // Node root2=tree.binarypreorder2(node2);
//         // Node subroot=new Node(2);
//         // subroot.left=new Node(4);
//         // subroot.right=new Node(5);
        
//         // System.out.println(root.data);
//         // tree.levelorder(root);
 
//         // System.out.println(tree.isSubtree(root, subroot));

//         // tree.topview(root);

//         // tree.Klevel(root, 1, 3);

//         // System.out.println(tree.kthAncestor(root, 04, 1));

//         System.out.print(tree.maxpathsum(root));
//         // tree.isUnivaluedHelper(root);
//         // tree.deleteleafs(root, 3);
//         // tree.preorder(root);



    }
}

