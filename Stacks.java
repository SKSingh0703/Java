import java.util.*;
public class Stacks {
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int i=0;
        while(str.length()!=i){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder sb=new StringBuilder("");
        while(!s.isEmpty()){
            char top=s.pop();
            sb.append(top);

        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int currdata=s.pop();
        reverseStack(s);
        pushAtBottom(s, currdata);
    }

    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int currdata=s.pop();
        pushAtBottom(s,data);
        s.push(currdata);
        return;
    }
    public static void printstack(Stack<Integer> s){
        while(!s.empty()){
            System.out.print(" "+s.pop());
            
        }
        return;
    }

    public static void stockspan(int stockprices[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        for(int i=0;i<stockprices.length;i++){
            int currprice=stockprices[i];
            while(!s.isEmpty() && currprice>stockprices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) span[i]=i+1;
            else{
                int prevhigh=s.peek();
                span[i]=i-prevhigh;
            } 

            s.push(i);
        }
    }
    public static void nextgreater(int arr[]){
        int nextarr[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()) nextarr[i]=-1;
            else{
                nextarr[i]=arr[s.peek()];
                
            } 
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+nextarr[i]);
        }
    }

    public static boolean check(String str){
        char ch=' ';
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('|| str.charAt(i)=='['|| str.charAt(i)=='{'){
                s.push(str.charAt(i));
            }
            else{
                if(s.isEmpty()) return false;
                else if((s.peek()=='(' && ch==')')|| (s.peek()=='{' && ch=='}')|| (s.peek()=='[' && ch==']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()) return true;
        else return false;
    }

    public static boolean duplicateBracket(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int count=0;
            if(ch==')'){
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1) return true;
                else s.pop();
            }
            else{
                s.push(ch);
            }
            
            
        }
        return false;

    }

    public static int maxarea(int arr[]){
        int lmax[]=new int[arr.length];
        int rmax[]=new int[arr.length];

        Stack<Integer> s=new Stack<>();
        //right smaller

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                rmax[i]=arr.length-1;
            }
            else{
                rmax[i]=s.peek();
            }
            s.push(i);
        }

        //left smaller
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                lmax[i]=-1;
            }
            else{
                lmax[i]=s.peek();
            }
            s.push(i);
        }

        //area
        int maxarea=-1;
        for(int i=0;i<arr.length;i++){
            int h=arr[i];
            int w=rmax[i]-lmax[i]-1;
            int currarea=w*h;
            maxarea=Math.max(maxarea, currarea);
        }

        return maxarea;
    }

    // class Node{
    //     char data;
    //     Node next;
    //     public Node(char data){
    //         this.data=data;
    //         this.next=null;
    //     }
    // }
    // public static Node Head;
    // public static Node Tail;
    // public static int count;

    // public  void addfirst(char data){
    //     if(Head==null){
    //         Node newnode=new Node(data);
    //         Head=Tail=newnode;
    //         return;
    //     }
    //     Node newnode=new Node(data);
    //     count++;
    //     newnode.next=Head;
    //     Head=newnode;
    // }
    
    
    public static String convert(String str,char number){
        StringBuilder sc=new StringBuilder();
        // char num=(number-'0');
        // int n=(int)num;
        // for(int i=0;i<n;i++){
        //     sc.append(str);
        // }

        return sc.toString();
    }

    public static void main(String[] args) {
        // String str="Sachin Kumar Singh";
        // System.out.println(reverseString(str));

        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // s.push(6);
        // s.push(7);
        // s.push(8);
        // s.push(9);

        // reverseStack(s);
        // printstack(s);
        // int arr[]={6,8,0,1,3};
        // nextgreater(arr);

        // String str="({[[)]]})";
        // int ar[]={2,1,5,6,2,3};
        char number='2'-'0';
        int n=(int)number;
        System.out.println(n);

    }
}
