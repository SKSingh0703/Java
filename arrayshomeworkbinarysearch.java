public class arrayshomeworkbinarysearch {
    public static int minsearch(int num[]){
        int start=0,end=num.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]>num[mid+1]){
                return mid+1;
            }
            else if(num[start]<=num[mid] && num[end]<num[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
    public static int search(int num[],int target,int start,int end){
        int l=start,r=end;
        while(l<=r){
            int mid=(l+r)/2;
            if(num[mid]==target){
                return mid;
            }
            else if(target>num[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
    public static int binarysearch(int num[],int target){
        int min=minsearch(num);
        if(num[min]<=target && target<num[num.length-1]){
            return search(num, target,min,num.length-1);
        }
        else{
            return search(num, target,0,min-1);
        }
    }

    public static void main(String[] args) {
        int number[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(binarysearch(number, target));

    }
}
