import java.util.*;

public class DivideAndConquer {
    public static void MergeSort(int arr[],int si,int ei){
        if(si>=ei) return;
        int mid=si+(ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr,si,mid,ei);
        return;
    }

    public static void Merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si,k=0,j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k]=arr[i];
            k++;i++;
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(i=si,k=0;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    // Time Complexity of Merge Sort is O(logN)
    public static void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        return;
    }

    public static void printarray(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        return;
    }

    public static void QuickSort(int arr[],int si,int ei){
        if(si>=ei) return;
        int pivot=Partition(arr, si, ei);
        QuickSort(arr, si, pivot-1);
        QuickSort(arr, pivot+1, ei);
        return;
    }

    public static int Partition(int arr[],int si,int ei){
        int i=si-1;
        int pivot=arr[ei];
        for(int j=si;j<ei;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=arr[ei];
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static int search(int arr[],int target,int si,int ei){
        if(si>ei) return -1;
        int mid=si+(ei-si)/2;
        if(arr[mid]==target) return mid;
        //On line l1
        if(arr[mid]>arr[si]){
            if(arr[mid] >=target && arr[si]<=target){
                return search(arr, target, si, mid-1);
            }
            else{
                return search(arr, target, mid+1, ei);
            }
        }
        else{
            if(arr[mid]<=target && arr[ei]>=target){
                return search(arr, target, mid +1, ei);
            }
            else{
                return search(arr, target, si, mid-1);
            }
        }


    }



    public static void MergeSort(String arr[],int si,int ei){
        if(si>=ei) return;
        int mid=si+(ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr,si,mid,ei);
        return;
    }

    public static void Merge(String arr[],int si,int mid,int ei){
        String temp[]=new String[ei-si+1];
        int i=si,k=0,j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i].compareTo(arr[j])<0){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k]=arr[i];
            k++;i++;
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(i=si,k=0;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }

    public static int Majority(int nums[]){
        for(int i=0;i<nums.length;i++){
            int count=1;
            for(int j=i+1;j<nums.length;j++ ){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>(nums.length/2)) return nums[i];
        }
        return -1;
    }
    public static int MajorityOn(int nums[]){
        Arrays.sort(nums);
        int maxelement=nums[nums.length-1];
        int temp[]=new int[maxelement+1];
        for(int i=0;i<nums.length;i++){
            temp[nums[i]]++;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]>(nums.length/2)){
                return i;
            }
        }
        return -1;
    }

    public static int InversionCount(int nums[]){
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    count++;
                }
            }
        }
        return count;
    }
    public static int Count(int nums[],int target,int si,int ei){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) count++;
        }
        return count;
    }

    public static int MajorityCount(int nums[],int si,int ei){
        if(si==ei) return nums[si];
        int mid=si+(ei-si)/2;
        int left=MajorityCount(nums, si, mid);
        int right=MajorityCount(nums, mid+1, ei);
        if(left==right) return left;
        int leftcount=Count(nums, left, si, ei);
        int rightcount=Count(nums, right, si, ei);
        return leftcount>rightcount?left:right;
    }

    public static void main(String[] args) {
        int nums[]={2,2,1,1,1,2,2};
        // String arr[]={"sun","earth","mars","mercury"};
        // Arrays.sort(nums);
        System.out.println(MajorityCount(nums, 0, nums.length-1));
        // MergeSort(arr, 0, arr.length-1);
        // printarray(arr);

    }
}
