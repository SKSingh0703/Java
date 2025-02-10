import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class abc {
    public static int solve(int[] a, int b) {
        int n = a.length;
        int prefix[] = new int[n];
        prefix[0]=a[0];
        
        for(int i=1;i<n;i++){
            prefix[i]=(prefix[i-1]^a[i]);
        }                 
        int count =0;    
          
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                if(i==0) xor=prefix[j];
                else xor = (prefix[i-1]^prefix[j]);
                if(i==j) xor=a[i];
                System.out.println(i+"  "+j+"  "+xor);
                  if(xor==b) count++;
            }    
        }         
        
        return count;
    }
    public int reversePairs(int[] nums) {
        
    }  
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int inc = 0;
            int dec = 0;
            int ans = 1;
    
            for(int i = 1;i<nums.length;i++){
                if(nums[i]>nums[i-1]){
                    inc++;
                }
                else inc=0;
                if(nums[i]<nums[i-1]){
                    dec++;
                }
                else dec=0;
    
                ans = Math.max(ans,1+Math.max(inc,dec));
            }
    
            return ans;
        }
    }
    class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                hm.put(nums[i]*nums[j],hm.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            int curr = entry.getValue();
            ans += (curr*(curr-1))*4;
        }

        return ans;
    }
}
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> ball = new HashMap<>();
        HashMap<Integer,Integer> color = new HashMap<>();
        int n = queries.length;

        int ans[] = new int[n];
        for(int i = 0 ;i<n;i++){
            
            int currBall = queries[i][0];
            int currColor = queries[i][1];

            if(ball.containsKey(currBall)){
                int prevColor = ball.get(currBall);
                color.put(prevColor,color.get(prevColor)-1);

                if(color.get(prevColor)==0){
                    color.remove(prevColor);
                }
            }
            ball.put(currBall,currColor);
            color.put(currColor,color.getOrDefault(currColor,0)+1);
            ans[i] = color.size();
        }

        return ans;
    }
}
class NumberContainers {

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
        // Update index to number mapping
        indexToNumbers.put(index, number);

        // Add index to the min heap for this number
        numberToIndices
            .computeIfAbsent(number, k -> new PriorityQueue<>())
            .add(index);
    }

    public int find(int number) {
        // If number doesn't exist in our map
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }

        // Get min heap for this number
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);

        // Keep checking top element until we find valid index
        while (!minHeap.isEmpty()) {
            int index = minHeap.peek();

            // If index still maps to our target number, return it
            if (indexToNumbers.get(index) == number) {
                return index;
            }

            // Otherwise remove this stale index
            minHeap.poll();
        }

        return -1;
    }

    // Map to store number -> min heap of indices
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;
    // Map to store index -> number
    private Map<Integer, Integer> indexToNumbers;
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
class Solution {

    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];

            // Count of previous positions with same difference
            int goodPairsCount = diffCount.getOrDefault(diff, 0);

            // Total possible pairs minus good pairs = bad pairs
            badPairs += pos - goodPairsCount;

            // Update count of positions with this difference
            diffCount.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }
}
import java.util.Stack;

public class Solution { 
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                    break; 
                }
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()); 
        }
        
        return sb.toString();
    }

}


    class Solution {
        public int maxAscendingSum(int[] nums) {
            int sum = nums[0];
            int ans = nums[0];
            for(int i = 1;i<nums.length;i++){
                if(nums[i]<=nums[i-1]){
                    sum=nums[i];
                }
                else sum+=nums[i];
    
                ans=Math.max(ans,sum);  
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9};
        int B = 5;
        System.out.println(solve(A, B));
    }
}






