// import java.util.*;
import java.util.Arrays;
public class sorting {
    public static void bubblesort(int num[]){
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-1-i;j++){
                if(num[j]>num[j+1]){
                    int temp=num[j+1];
                    num[j+1]=num[j];
                    num[j]=temp;
                }
            }
        }
    }
    public static void selectionsort(int num[]){
        for(int i=0;i<num.length-1;i++){
            int min=i;
            for(int j=i;j<num.length;j++){
                if(num[j]<num[min]){
                    min=j;
                }
                
            }
            int temp=num[min];
            num[min]=num[i];
            num[i]=temp;

        }
    }
    public static void insertionsort(int num[]){
        for(int i=1;i<num.length;i++){
            int curr=num[i];
            int prev=i-1;
            while(prev>=0 && num[prev]>curr){
                num[prev+1]=num[prev];
                prev--;
            }
            num[prev+1]=curr;

        }
    }
    public static void countingsort(int num[]){
        int max=Integer.MIN_VALUE;
        for(int j=0;j<num.length;j++){
            max=Math.max(max,num[j]);
        }
        int count[]=new int[max+1];
        for(int i=0;i<num.length;i++){
            // count[num[i]]=0;
            count[num[i]]++;
        }
        int x=0;
        for(int k=0;k<=max;k++){
           while(count[k]>0){
            num[x]=k;
            x++;
            count[k]--;
           }
        }
    }
    public static void main(String[] args) {
        int num[]={9,8,7,4,3,2,1};
        // countingsort(num);
        Arrays.sort(num,0,6);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
