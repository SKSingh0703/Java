import java.util.HashMap;
import java.util.HashSet;

public class LCDailyOne {

    class CustomStack {
        int arr[];
        int top;
        int size;
        int currsize;
        public CustomStack(int maxSize) {
            arr=new int[maxSize];
            size=maxSize;
            top=-1;
            currsize=0;
        }
        
        public void push(int x) {
            if (top==size-1) {
                return;
            }
            else if (top==-1) {
                top=0;
            }
            else top++;
            arr[top]=x;
            currsize++;
        }
        
        public int pop() {
            if (top==-1) {
                return -1;
            }
            else{
                int x=arr[top];
                top--;
                currsize--;
                return x;
            }
        }
        
        public void increment(int k, int val) {
            int n=Math.min(k,currsize);
            for(int i=0;i<n;i++){
                arr[i]+=val;
            }
        }
    }

    public boolean check(String one[],String two[]){
        int i=0,j=0;
        int m=one.length,n=two.length;
        boolean flag=false;
        while (one[i].equals(two[j]) && j<n) {
            i++,j++;
        }
        if (j==n) {
            return true;
        }
        while (!one[i].equals(two[j])) {
            i++;
        }
        while (one[i].equals(two[j]) && j<n) {
            i++,j++;
        }
        if (i!=m || j!=n) {
            return false;
        }
        return true;

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String one[]=sentence1.split(" ");
        String two[]=sentence2.split(" ");
        if (one.length>two.length) {
            return check(one, two);
        }
        else return check(two,one);
    }
    public int minLength(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        while (i<sb.length()-1) {
            if (sb.charAt(i)=='A' && sb.charAt(i+1)=='B') {
                sb.delete(i, i+2);
                i=0;
            }
            else if (sb.charAt(i)=='C' && sb.charAt(i)=='D') {
                sb.delete(i, i+2);
                i=0;
            }
            else i++;
        }
        return sb.length();
    }


    class AllOne {
    HashMap<String,Integer> hm;
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    StringBuilder maxStr;
    StringBuilder minStr;
    
    public AllOne() {
        hm=new HashMap<>();
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        maxStr=new StringBuilder("");
        minStr=new StringBuilder("");
    }
    
    public void inc(String key) {
        hm.put(key,hm.getOrDefault(key,0)+1);
        if (max<hm.get(key)) {
            max=hm.get(key);
            maxStr=new StringBuilder(key);
        }
    }
    
    public void dec(String key) {
        hm.put(key,hm.getOrDefault(key,0)-1);
        if (hm.get(key)==0) {
            hm.remove(key);
            return;
        }
        if (min<hm.get(key)) {
            min=hm.get(key);
            minStr=new StringBuilder(key);
        }
    }
    
    public String getMaxKey() {
        return maxStr.toString();
    }
    
    public String getMinKey() {
        return minStr.toString();
    }
}

}
