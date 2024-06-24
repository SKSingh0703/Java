import java.util.*;
// import java.util.LinkedList;
public class HadhIngDatAtypes {
    public static void majorityElement(int arr[]){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        Set<Integer> key=hm.keySet();
        for (Integer i : key) {
            if(hm.get(i)>(arr.length/3)){
                System.out.println(i);
            }
        }

    }
    public static boolean isAngrams(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0)+1);
        }
        for(int i=0;i<s2.length();i++){
            if(!hm.containsKey(s2.charAt(i))) return false;
            else{
                if(hm.get(s2.charAt(i))==1){
                    hm.remove(s2.charAt(i));
                }
            }
        }
        if(!hm.isEmpty()) return false;
        return true;
    }
    public static void intersection(int arr1[],int arr2[]){
        HashSet<Integer> hs=new HashSet<>();
        int count=0;
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(hs.contains(arr2[i])){
                count++;
                int x=arr2[i];
                System.out.println(x);
                hs.remove(arr2[i]);
            }
        }
        System.out.println(count);
    }
    public static String startingPoint(HashMap<String,String> hm){
        HashMap<String,String> revhm=new HashMap<>();
        for (String key : hm.keySet()) {
            revhm.put(hm.get(key), key);
        }
        for (String key : hm.keySet()) {
            if(!revhm.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static class info{
        Node root;
        int idx;
        public info(Node root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    // // public static HashMap<Integer,Node> hm=new HashMap<>();
    // public static int max=0,min=0;
    // public static void bottomViewhelper(Node root,int idx){
    //     // HashMap<Integer,Integer> hm=new HashMap<>();
    //     Queue<info> q=new LinkedList<>();
    //     info i1=new info(root, 0);
    //     info l2=new info(null, Integer.MIN_VALUE);
    //     q.add(i1);
    //     q.add(l2);
    //     System.out.println("Sachin3");
        
    //     while(!q.isEmpty()){
    //         info curr=q.remove();
    //         System.out.println("Sachin4");
    //         if(curr.root==null){
    //             System.out.println("Sachin5");
    //             if(!q.isEmpty()){
    //                 q.add(l2);
    //             }
    //             else{
    //                 break;
    //             }
                
    //         }
    //         else{
    //             System.out.println("Sachin6");
    //             hm.put(curr.idx, curr.root);
                
                
    //             if(curr.root.left!=null){
    //                 info left=new info(curr.root.left, curr.idx-1);
    //                 q.add(left);
    //                 min=Math.min(min, curr.idx-1);
    //             }
    //             if(curr.root.right!=null){
    //                 info right=new info(curr.root.right, curr.idx+1);
    //                 q.add(right);
    //                 max=Math.min(max, curr.idx+1);
    //             }
                
    //         }
    //     }
    //     return;



    // }
    // public static void bottomView(Node root){
    //     System.out.println("Sachin1");
    //     bottomViewhelper(root, 0);
    //     System.out.println("Sachin2");
    //     for (Integer i : hm.keySet()) {
    //         System.out.print(hm.get(i).data+" ");
    //     }
    //     // for(int i=min;i<=max;i++){
    //     //     System.out.println(hm.get(i));
    //     // }
    // }


    public static void main(String[] args) {
    //     Node root=new Node(20);
    // root.left=new Node(8);
    // root.right=new Node(22);
    // root.left.left=new Node(5);
    // root.left.right=new Node(3);
    // root.right.right=new Node(25);
    // root.left.right.left=new Node(10);
    // root.left.right.right=new Node(14);
    // System.out.println("Sachin");
    // bottomView(root);
        int arr[]={2,7,11,15};
        int k=9;
        //ai+aj=k
        //aj=k-ai
        //check if it contains it yes get its index
    HashMap<Integer,Integer> hm=new HashMap<>();
    for(int i=0;i<arr.length;i++){
        hm.put(arr[i],i);
    }
    
    for (int j : hm.keySet()) {
        int z=k-j;
        if(z!=j){
            if(hm.containsKey(z)){
                System.out.println(hm.get(z)+" "+hm.get(j));
                break;
            }
        }
        
    }
    }
}
