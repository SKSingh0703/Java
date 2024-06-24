import java.util.*;
import java.util.LinkedList;
public class Que {
    public static void interleave(Queue<Integer> q){
        Queue<Integer> q1=new LinkedList<>();
        int size=q.size()/2;
        for(int i=0;i<size;i++){
            q1.add(q.remove());

        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
    }

    public static void generate(int n){
        Stack<Integer> s=new Stack<>();
        for(int i=1;i<=n;i++){
            int x=i;

            while(x>0){
                s.push(x%2);
                x=x/2;
            }

            System.out.print(" "+i+"->");
            while(!s.isEmpty()){
                System.out.print(s.pop());
            }
        }

        
    }
    public static void main(String[] args) {
        generate(5);
    }

    
    
}
