public class Recursion1 {
    public static void printincreasing(int n){
        if(n==1){
            System.out.print(" "+1);
            return;
        }

        printincreasing(n-1);
        System.out.print(" "+n);


    }

    public static int factorial(int n){
        int factorial=1;
        if(n==1) return n;
        factorial=n*factorial(n-1);
        return factorial;
    }
    public static int sumofn(int n){
        int sum=0;
        if(n==1) return 1;
        sum=n+sumofn(n-1);
        return sum;

    }

    public static int fibonacci(int n){
        int fibo=0;
        if(n==0) return 0;
        if(n==1) return 1;
        fibo=fibonacci(n-1)+fibonacci(n-2);
        return fibo;
    }

    public static boolean checksorted(int num[],int i){
        if(i==num.length-1) return true;
        if(num[i]>num[i+1]) return false;
        return checksorted(num, i+1);

    }

    public static int search(int num[],int target,int i){

        if(i==num.length) return -1;
        if(num[i]==target) return i;
        int x=search(num, target, i+1);
        return x;
    }

    public static int lastoccurence(int num[],int target,int i){
        if(i==num.length) return -1;
        int isFound=lastoccurence(num, target, i+1);
        if(isFound==-1 && num[i]==target) return i;
        return isFound;
    }

    public static int power(int x,int n){
        if(n==0) return 1;
        return x*power(x, n-1);
    }
    public static int poweroptimized(int x,int n){
        if(n==0) return 1;
        if(n==1) return x;
        int y;
        if(n%2==0){
            y=poweroptimized(x,n/2)*poweroptimized(x,n/2);
        } 
        else y=poweroptimized(x,n/2)*poweroptimized(x,n/2)*poweroptimized(x,1);
        return y;
    }
    public static void main(String[] args) {
        // int nums[]={1,2,3,10,5,6,7,8,9,10};
        System.out.println(poweroptimized(2, 20));
    }
}
