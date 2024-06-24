public class TrieeDSA {
    public static class Node{
        Node children[]=new Node[26];
        boolean endOfWord=false;
        int frequency;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            frequency=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(root.children[idx]==null){
                root.children[idx]=new Node();
            }
            else{
                root.children[idx].frequency++;
            }
            curr=root.children[idx];
        }
        curr.endOfWord=true;
    }

    public static boolean search(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(root.children[idx]==null){
                return false;
            }
            curr=root.children[idx];
        }
        if(curr.endOfWord!=true) return false;
        return true;
    }
    public static boolean wordBreak(String str){
        if(str.length()==0) return true;
        for(int i=1;i<=str.length();i++){
            if(search(str.substring(0,i)) && wordBreak(str.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void findprefix(Node root,String ans){
        if(root==null) return ;
        if(root.frequency==1) {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findprefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static int count(Node root){
        if(root==null) return 0;
        int c=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                c+=count(root.children[i]);
            }
        }
        return c+1;
    }
    public static void main(String[] args) {
        // String st[]={"zebra","dog","duck","dove"};
        // for(int i=0;i<st.length;i++){
        //     insert(st[i]);
        // }
        // root.frequency=-1;
        // search("thee");
        // System.out.println(search("zet"));
        // // findprefix(root, "");

        String str="ababa";
        for(int i=0;i<str.length();i++){
            String suffix=str.substring(i);
            insert(suffix);
        }
        System.out.println(count(root));

    }
}
