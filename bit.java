// import java.util.*;
public class bit {
    public static void check(int n){
        int bitmask=1;
        if((n & bitmask) == 0){
            System.out.println("The number is EVEN.");
        }
        else System.out.println("The number is Odd.");
        return;
    }

    public static int getIthbit(int n,int i){
        int bitmask=1<<i;
        if((n & bitmask)==0){
            return 0;
        }
        else return 1;
    }

    public static int setIthbit(int n,int i){
        int bitmask=1<<i;
        return n | bitmask;
    }

    public static int clearIthbit(int n,int i){
        int bitmask=~(1<<i);
        return n&bitmask;
    }

    public static int updateIthbit(int n,int i,int newbit){
        n=clearIthbit(n, i);
        int bitmask=newbit<<i;
        return n|bitmask;
    }

    public static int clearItoJthbits(int n,int i,int j ){
        int a=(~0)<<j+1;
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n&bitmask;
    }
    public static int clearlastIthbits(int n,int i){
        int bitmask=(~0)<<i;
        return n&bitmask;
    }

    public static boolean checkifpoweroftwoornot(int n){
        return ((n&(n-1))==0);
    }

    public static int countsetbits(int n){
        int count=0;
        while(n>0){
            if((n&1)==1) count++;
            n=(n>>1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a=5,b=6;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a +" "+ b);
    }
}
    

