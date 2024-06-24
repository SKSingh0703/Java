import java.util.*;

public class PriOriTyQueUe {
    public static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int p=(x-1)/2;
            while(arr.get(x)<arr.get(p)){
                int temp=arr.get(x);
                arr.set(x,arr.get(p) );
                arr.set(p, temp);
                x=p;
                p=(x-1)/2;
            }
        }
        public int peek(){
            int data=arr.get(0);
            return data;
        }
        public void heapify(int idx){
            int leftidx=2*idx+1;
            int rightidx=2*idx+2;
            int minidx=idx;
            if(leftidx<arr.size() && arr.get(minidx)>arr.get(leftidx)){
                minidx=leftidx;
            }
            if(rightidx<arr.size() && arr.get(minidx)>arr.get(rightidx)){
                minidx=rightidx;
            }
            if(minidx!=idx){
                int temp=arr.get(idx);
                arr.set(idx, arr.get(minidx));
                arr.set(minidx, temp);
                heapify(minidx);
            }
            // return;
        }
        public int remove(){
            int data=arr.get(0);

            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);

            heapify(0);

            return data;     
            
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void heapify(int arr[],int i,int size){
        int leftidx=2*i+1;
        int rightidx=2*i+2;
        int maxidx=i;
        //find max element then swap repeat
        if(leftidx<arr.length && arr[leftidx]<arr[maxidx]){
            maxidx=leftidx;
        }
        if(rightidx<arr.length && arr[rightidx]<arr[maxidx]){
            maxidx=rightidx;
        }
        if(maxidx!=i){
            int temp=arr[maxidx];
            arr[maxidx]=arr[i];
            arr[i]=temp;

            heapify(arr, maxidx, size);
        }
    }
    public static void heapSort(int arr[]){
        int n=arr.length;
        //max heap generation till n/2 element heapify from bottom to top
        for(int i=n/2;i>=0;i--){
            heapify(arr, i, n);
        }

        //push element to the bottom the heapify initial

        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, 0, i);
        }
        return;

    }
    public static class point implements Comparable<point>{
        int data;
        int distance;
        public point(int data,int distance){
            this.data=data;
            this.distance=distance;
        }
        @Override
        public int compareTo(point p2){
            if(this.data==p2.data){
                return this.distance-p2.distance;
            }
            else{
                return this.data=p2.data;
            }
        }
    }
    public static void KthLargestElement(int arr[]){

    }
    public static int time=0;
    public static boolean allTrue(boolean flag[]){
        for(int i=0;i<flag.length;i++){
            if(flag[i]==false){
                return false;
            }
        }
        return true;
    }
    public static void countime(int arr[],boolean flag[]){
        while(!allTrue(flag)) {
                time++;
                for(int i=0;i<arr.length;i++){
                    if(flag[i]==true){
                        
                        if(i+1<arr.length) flag[i+1]=true;
                        flag[i-1]=true;
                        i++;
                    }
                }
        }
    }

    
    public static void main(String[] args) {
        // PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student("A", 5));
        // pq.add(new Student("B", 4));
        // pq.add(new Student("C", 2));
        // pq.add(new Student("D", 12));
        
        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name+"->"+pq.peek().rank);
        //     pq.remove();
        // }

        // Heap hp=new Heap();
        // hp.add(3);
        // hp.add(4);
        // hp.add(1);
        // hp.add(5);
        
        // while(!hp.isEmpty()){
        //     System.out.println(hp.peek()+" ");
        //     hp.remove();
        // }

        // int arr[]={1,4,67,9,237};
        // heapSort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }

        //Kth largest element code here:
        // Scanner sc=new Scanner(System.in);
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // int x=1;
        // System.out.println("Enter which largest element to be entered:");
        // int z=sc.nextInt();
        // System.out.println("Enter Number  or press 0 to exit:");
        // while(x!=0){
        //     int k=z;
        //     x=sc.nextInt();
        //     pq.add(x);
        //     if(pq.size()<k){
        //         System.out.println("_");
        //     }
        //     else{
        //         int arr[]=new int[z];
        //         while(k!=0){
        //             arr[k-1]=pq.peek();
        //             pq.remove();
        //             k--;
        //         }
        //         System.out.println(arr[0]);
        //         for(int i=0;i<z;i++){
        //             pq.add(arr[i]);
        //         }
        //     }
        // }
        // sc.close();
        
        Scanner sc=new Scanner(System.in);
        int n,k;
        
        System.out.println("Enter N");
        n=sc.nextInt();
        System.out.println("Enter K");
        k=sc.nextInt();

        int arr[]=new int[k];
        System.out.println("Enter arrayelements:");
        boolean flag[]=new boolean[n+1];
        for(int i=0;i<n;i++){
            flag[i]=false;
        }
        for(int i=0;i<k;i++){
            arr[i]=sc.nextInt();
            flag[arr[i]]=true;
        }
        countime(arr, flag);
        System.out.println(time);
        sc.close();
    }
}
