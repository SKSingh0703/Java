import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class AaSampleLCDaily {
    public int smallestDistancePair(int[] nums, int k) {
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);
        while (i<j) {
            int count=0;
            for(int k=i;i<=k;i++){

            }
        }
    }
    /**
     * Pair
     */
    // public class Pair implements Comparable<Pair>{
    //     int x;
    //     int y;
    //     int val;
    //     public Pair(int x,int y){
    //         this.x=x;
    //         this.y=y;
    //         this.val=Math.abs(x-y);
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         return -this.val+p2.val;
    //     }
    // }
    public int smallestDistancePair(int[] nums, int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                Pair curr=new Pair(i, j);
                if (pq.size()<k) {
                    pq.add();
                }
                else if (number>pq.peek()) {
                    pq.poll();
                    pq.add(curr);
                }
                else{
                    continue;
                }
            }
        }
        return pq.peek().val;
    }
    public int maxDistanced(List<List<Integer>> arrays) {
        int n=arrays.size();
        int maxDistance =0;
        int curr=0;
        for(int i=0;i<n;i++){
            int cmin=arrays.get(i).get(0);
            int cmax=arrays.get(i).get(arrays.get(i).size()-1);
            for(int j=0;j<n;j++){
                if (i!=j) {
                    int pmin=arrays.get(j).get(0);
                    int pmax=arrays.get(j).get(arrays.get(j).size()-1);

                    curr=Math.max(Math.abs(cmin-pmax), Math.abs(cmax-pmin));
                    maxDistance=Math.max(curr, maxDistance);
                }
            }
        }
        return maxDistance;
    }
    
    /**
     * InnerAaSampleLCDaily
     */
    // public class Pair implements Comparable<Pair> {
    //     int val;
    //     int idx;
    //     public Pair(int val,int idx){
    //         this.val=val;
    //         this.idx=idx;
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         return this.val-p2.val;
    //     }
    // }
    public int maxDistance(List<List<Integer>> arrays){
        PriorityQueue<Pair> min=new PriorityQueue<>();
        PriorityQueue<Pair> max=new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<arrays.size();i++){
            
            min.add(new Pair(arrays.get(i).get(0), i));
            max.add(new Pair(arrays.get(i).get(arrays.get(i).size()-1), i));
        }
        int maxDistance=max.peek().val-min.peek().val;
        if (min.peek().idx==max.peek().idx) {
            Pair currMin=min.poll();
            Pair currMax=max.poll();
            maxDistance=Math.max(currMax.val-min.peek().val, max.peek().val-currMin.val);
        }
        return maxDistance;
    }

    
    public long maxPoints(int[][] points) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.reverseOrder());
        long count=0;
        for(int i=0;i<points.length;i++){

        }

    }
    public class Pair {
        int val;
        boolean isTrue;
        public Pair(int val,boolean j){
            this.val=val;
            this.isTrue=false;
        }
    }

   
    public Pair isConsecutive(int nums[],int i,int j,Pair prev){
        if (prev.isTrue) {
            if (nums[j]!=nums[j-1]) {
                return new Pair(-1, false);
            }
            int max=nums[i];
            if (prev.val==nums[i-1]) {
                for(int k=i+1;k<=j;k++){
                    max=Math.max(max, nums[k]);
                }
                return new Pair(max, true);
            }
            return new Pair(Math.max(prev.val, nums[j]),true);
        }
        Pair curr=new Pair(-1, false);
        int max=nums[i];
        for(int k=i+1;k<=j;k++){
            if (nums[k]!=nums[k-1]+1) {
                return curr;
            }
            max=Math.max(max, nums[k]);
        }
        curr.val=max;
        curr.isTrue=true;
        return curr;
    }
    public int[] resultsArray(int[] nums, int k) {
        int i=0;
        int j=k-1;
        int ans[]=new int[nums.length-k+1];
        Pair prev=new Pair(0, false);
        while (i<nums.length-k && j<nums.length) {
            Pair curr=isConsecutive(nums, i, j,prev);
            ans[i]=curr.val;
            i++;
            j++;
            prev=curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
