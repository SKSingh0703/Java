import java.util.*;
public class linearsearch {
    public static int search(int num[],int n){
        for(int i=0;i<num.length;i++){
            if(num[i]==n){
                return i;
            }
        }
        return -1;
    }
    public static void arrayinput(int num[]){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<num.length;i++){
            num[i]=sc.nextInt();
        }
        sc.close();
        return;
        
    }
    public static void arrayprint(int num[]){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        return;
    }
    public static int largestnumbersearch(int num[]){
        int x=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            if(x<num[i]){
                x=num[i];
            }
        }
        return x;

    }
    public static int binarysearch(int num[],int key){
        int start=0,end=num.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]==key){
                return mid;
            }
            else if(num[mid]>key){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void reverse(int num[]){
        int start=0,end=num.length-1;
        while(start<end){
            int temp=num[end];
            num[end]=num[start];
            num[start]=temp;
            start++;
            end--;
        }
    }
    public static void printpairs(int num[]){
        for(int i=0;i<num.length;i++){
            int curr=num[i];
            for(int j=i+1;j<num.length;j++){
                System.out.print("("+curr+","+num[j]+")"+" ");
            }
            System.out.println();
        }
    }
    public static void subarray(int num[]){
        int y=(num.length*(num.length+1))/2+1;
        int sum[]=new int[y];
        int count=0;
        for(int i=0;i<num.length;i++){
            int start=i;
            for(int j=i;j<num.length;j++){
                int end=j;
                int sumofsubarray=0;
                for(int k=start;k<=end;k++){
                    sumofsubarray+=num[k];
                    System.out.print(num[k]+" ");
                }
                sum[count]=sumofsubarray;
                count++;
                System.out.print("Sum:"+sumofsubarray);
                System.out.println();
            }
            System.out.println();
        }
        int x=Integer.MIN_VALUE;
        for(int i=0;i<sum.length;i++){
            if(x<sum[i]){
                x=sum[i];
            }
        }
        System.out.println("The maximum sum of the subarray is :"+x);
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter the space of the array to be created:");
        // int x=sc.nextInt();
        // int num[]=new int[x];
        // System.out.println("Enter Numbers:");
        // arrayinput(num);
        // arrayprint(num);
        // reverse(num);
        // arrayprint(num);
        // int y=binarysearch(num, x);
        // System.out.println("The largest number is :"+ num[y]);
        int numbers[]={1,2,3,4};
        subarray(numbers);
    }
}
