import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class wrhgwrbwrvweher {
    // public String losingPlayer(int x, int y) {
    //     int tot = x*75 + y*10;
    //     int nOfPlaysPossible =tot/115;
    //     if (nOfPlaysPossible%2==0) {
    //         return "Bob";
    //     }
    //     else return ""
    // }
    public int minimumLength(String s){
        HashSet<Integer> hs=new HashSet<>();
        HashMap<Character,Integer> hm=new HashMap<>();
        HashSet<Integer> exclude =new HashSet<>();

        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if (!exclude.contains(i)) {
                char c=s.charAt(i);
                arr[c-'a']--;
                if (!hm.containsKey(c)) {
                    hs.add(i);
                    hm.put(c, i);                
                }
                else if (arr[c-'a']>0) {
                    hs.remove(i);
                    hm.re
                }
            }
        }
        return hs.size();
    }
    public int minimumLength(String s){
        Queue<Integer> queue = new LinkedList<>();
        int[] lastOccurrence = new int[26];

        int[] futureOccurence=new int[26];
        for(int i=0;i<s.length();i++){
            futureOccurence[s.charAt(i)-'a']++;
        }
        int count=0;
        s.substring(i).indexOf()
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            futureOccurence[index]--;
            if (lastOccurrence[index] > 0 && !queue.isEmpty() && futureOccurence[index]>0  ) {
                // Remove the closest character to the left
                int leftIndex = queue.peek();
                if (leftIndex > 0 && s.charAt(leftIndex - 1) == c) {
                    queue.poll();
                }
                // Remove the closest character to the right
                while (!queue.isEmpty() && queue.peek() < i) {
                    queue.poll();
                }
            }
            // Add the current index to the queue
            queue.offer(i);
            count++;
            // Update the last occurrence of the character
            lastOccurrence[index] = i + 1; // +1 to handle the case when the index is 0
        }
        
        // The size of the queue will give us the minimum length
        return queue.size();
    }
    // public class Pair implements Comparable<Pair> {
    //     int num;
    //     int freq;
    //     public Pair(int n,int f){
    //         this.num=n;
    //         this.freq=f;
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         if (this.freq==p2.freq) {
    //             return p2.num-this.num;
    //         }
    //         else return this.freq-p2.freq;
    //     }
    // }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<names.length;i++){
            pq.add(new Pair(names[i], heights[i]));
        }
        String ans[]=new String[names.length];
        for(int i=0;i<pq.size();i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
    public int[] frequencySort(int[] nums) {
        int freq[]=new int[201];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]+100]++;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<freq.length;i++){
            if (freq[i]!=0) {
                pq.add(new Pair(i-100, freq[i]));
            }
        }
        int i=0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int num=curr.num;
            int freq=curr.freq;
            for(int j=i;j<freq;j++){
                nums[i]=num;
            }
        }
        return nums;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<mapping.length;i++){
            hm.put(i, mapping[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=convert(nums[i],hm);
        }
        return nums;
    }
    
    private int convert(int n,HashMap<Integer,Integer> hm){
        int temp=0;
        while (n>0) {
            int x=hm.get(n%10);
            temp=temp*10+x;
            n=n%10;
        }
        return temp;
    }
}
