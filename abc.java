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

    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        // Iterate through each character in the string
        for (int index = 0; index < strLength; index++) {
            // Push current character to stack
            stk.push(s.charAt(index));

            // If stack size is greater than or equal to the part length, check for match
            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                // Pop the characters matching 'part' from the stack
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }

        // Convert stack to string with correct order
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        result.reverse();

        return result.toString();
    }

    // Helper function to check if the top of the stack matches the 'part'
    private boolean checkMatch(
        Stack<Character> stk,
        String part,
        int partLength
    ) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk); // Copy the stack to avoid modifying the original

        // Iterate through part from right to left
        for (int partIndex = partLength - 1; partIndex >= 0; partIndex--) {
            // If current stack top doesn't match expected character
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}

import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = sumDigits(num);

            if (map.containsKey(sum)) {
                ans = Math.max(ans, num + map.get(sum)); // Check max pair sum
                map.put(sum, Math.max(map.get(sum), num)); // Keep the max value
            } else {
                map.put(sum, num);
            }
        }
        return ans;
    }

    private int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); 
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProduct.size();
        
        if (k >= n) return 0; 
        return prefixProduct.get(n - 1) / prefixProduct.get(n - 1 - k);
    }
}
class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            if (canPartition(String.valueOf(sq), i, 0, 0)) {
                ans += sq;
            }
        }
        return ans;
    }

    private boolean canPartition(String str, int target, int currSum, int idx) {
        int n = str.length();
        if (idx == n) {
            return currSum == target;
        }

        int num = 0;
        for (int i = idx; i < n; i++) {
            num = num * 10 + (str.charAt(i) - '0');
            
            if (num > target) break; 

            if (canPartition(str, target, currSum + num, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean vis[] = new boolean[2*n];
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        helper(0,n,ans,vis,n);
        return ans;
    }

    private boolean helper(int idx,int n,int ans[],boolean vis[],int max){
        if(idx==max) return;
        for(int i = max;i>=1;i--){
            if(!vis[i]){
                int nextIdx = idx+i;
                if(nextIdx<2*n-1 && idx<2*n-2 && ans[idx]==-1 && ans[nextIdx]==-1){
                    ans[idx]=i;
                    ans[nextIdx]=i;
                    vis[idx]=true;
                    helper(idx+1,n,ans,vis,max);
                }
            }
        }
        return;
    }
}
class Solution {
    private int count;
    private HashSet<String> hs;

    public int numTilePossibilities(String tiles) {
        count = 0;
        hs = new HashSet<>();

        helper(tiles,new StringBuilder(),new boolean[tiles.length()]);
        return hs.size();  
    }

    private void helper(String str , StringBuilder sb,boolean vis[]){
        for(int i = 0 ;i<str.length();i++){
            if(vis[i]) continue;
            sb.append(str.charAt(i));
            hs.add(sb.toString());
            vis[i] = true;
            helper(str,sb,vis);
            vis[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
class Solution {
    private String ans;
    public String smallestNumber(String pattern) {
        ans = new String("9999999999");
        helper(pattern,new StringBuilder(""),-1,-1,new boolean[10]);
        return ans;
    }
    private void helper(String p, StringBuilder curr,int idx,int prev,boolean vis[]){
        if(idx==p.length()){
            ans = ans.compareTo(curr.toString())<0?ans:curr.toString();
            return ;
        }
        boolean inc = true;
        boolean dec = true;
        if(idx!=-1){
            if(p.charAt(idx)=='I'){
                dec = false;
            }
            else inc = false;
        }
        
        for(int i = 1;i<10;i++){
            if(vis[i]) continue;
            if((inc && i>prev) || (prev==-1) || (dec && i<prev)){
                vis[i] = true;
                curr.append((char)(i+'0'));
                helper(p,curr,idx+1,i,vis);
                vis[i] = false;
                curr.deleteCharAt(curr.length()-1);
            }
        }

        return;
    }
}

class Solution {
    private int count ;
    private String ans;
    private char arr[] = {'a','b','c'};

    public String getHappyString(int n, int k) {
        count = 0;
        ans = new String("");
        helper(-1,n,k,new StringBuilder(""));
        return ans;
    }

    private void helper(int prev,int n,int k,StringBuilder curr){
        if(ans.length()!=0) return;

        if(curr.length()==n){
            count++;
            if(count==k){
                ans = curr.toString();
            }
            return;
        }
        for(int i = 0;i<3;i++){
            if(i!=prev){
                curr.append(arr[i]);
                helper(i,n,k,curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }
        return;
    }
}
class Solution {
    private String ans;
    private HashSet<String> hs;
    private boolean flag=false;

    public String findDifferentBinaryString(String[] nums) {
        ans = new String("");
        hs = new HashSet<>();
        for(String num : nums){
            hs.add(num);
        }
        helper(nums[0].length(),new StringBuilder());
        return ans;
    }

    private void helper(int n,StringBuilder sb){
        if(flag) return;
        if(sb.length()==n){
            if(!hs.contains(sb.toString())){
                ans = sb.toString();
                flag = true;
            }
            return;
        }
        for(int i = 0;i<2;i++){
            sb.append((char)(i+'0'));
            helper(n,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }
}

class FindElements {
    private TreeNode root;
    private Set<Integer> values;

    public FindElements(TreeNode root) {
        this.root = root;
        values = new HashSet<>();
        root.val = 0;  
        recover(root); 
    }

    private void recover(TreeNode node) {
        if (node == null) return;

        values.add(node.val); 

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            recover(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recover(node.right);
        }
    }

    public boolean find(int target) {
        return values.contains(target); 
    }
}
public class Solution {

    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);
    }

    private TreeNode helper(String traversal, int depth) {
        if (index >= traversal.length()) return null;
        // Count the number of dashes
        int dashCount = 0;
        while (
            (index + dashCount) < traversal.length() &&
            traversal.charAt(index + dashCount) == '-'
        ) {
            dashCount++;
        }

        // If the number of dashes doesn't match the current depth, return null
        if (dashCount != depth) return null;

        // Move index past the dashes
        index += dashCount;

        // Extract the node value
        int value = 0;
        while (
            index < traversal.length() &&
            Character.isDigit(traversal.charAt(index))
        ) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        // Create the current node
        TreeNode node = new TreeNode(value);

        // Recursively build the left and right subtrees
        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int preIndex = 0;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIndex >= preorder.length || postStart > postEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        if (postStart == postEnd || preIndex >= preorder.length)
            return root;
        
        // The next element in preorder is the left child.
        // Find that value in the postorder to determine the left subtree range.
        int leftChildVal = preorder[preIndex];
        int leftIndex = postStart;
        while (leftIndex <= postEnd && postorder[leftIndex] != leftChildVal) {
            leftIndex++;
        }
        
        root.left = build(preorder, postorder, postStart, leftIndex);
        root.right = build(preorder, postorder, leftIndex + 1, postEnd - 1);
        
        return root;
    }
}
class pair{
    boolean val;
    int time;
    pair(){
        val=false;
    }
    pair(boolean a,int b){
        val=a;
        time=b;
    }
}
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>(); // creating adjacency list

        int n=amount.length;   // number of nodes in graph
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int st=edges[i][0];
            int dst=edges[i][1];
            adj.get(st).add(dst);   // adding edge in both the nodes
            adj.get(dst).add(st);
        }

        pair[]vis=new pair[n];    // this pair will help the alice to check if bob has visited this node or not and at what time he visited it.

        boolean[]visitedBob=new boolean[n];// visited array for bob

        boolean[]visitedAlice=new boolean[n]; // visited for alice
        for(int i=0;i<n;i++){
            vis[i]=new pair();  //initializing pair array
        }

        dfsbob(adj,vis,0,bob,visitedBob); // dfs traversal call for bob
        return dfsalice(adj,vis,0,visitedAlice,0,amount);  // dfs traversal for alice
    }
    public int dfsbob(ArrayList<ArrayList<Integer>>adj,pair[]vis,int time,int st,boolean[]visited){
        visited[st]=true;  // marking the node to visited
        if(st==0)return 0;  // base case,if bob comes to node 0
        for(int it:adj.get(st)){  // traversing adjacent nodes

            if(!visited[it]){  // we should not visit the 
                int vri=dfsbob(adj,vis,time+1,it,visited); // giving call to adjacent node
                if(vri==0){  // if the above traversal returns 0,we will mark this node and time in pair class for alice future use
                    vis[st]=new pair(true,time);
                    return 0;
                }
            }
        }
        return -1;  // returning -1 as we have not found the node 0
    }
    public int dfsalice(ArrayList<ArrayList<Integer>>adj,pair[]vis,int time,boolean[]visited,int st,int[]amount){
        visited[st]=true;  // marking node as visited
        int cost=0;

        if(vis[st].val==false){  // if the node is not visited by bob,alice has to pay full price
                cost=amount[st];
        }else{
            int bobtime=vis[st].time;  // time at which bob visited this node

            if(time>bobtime){   // if bob visited the node before alice it means gate was already open,alice has to pay no price
                cost=0;
            }else if(time==bobtime){ // if they visited the node at same time,they will pay half the price
                cost=amount[st]/2;
            }else{
                cost=amount[st]; // in this case,bob visited the node but after alice,so alice has to pay full price
            }
        }
        int ans=(int)(-1e9);
        for(int it:adj.get(st)){  // traversing adjacent nodes
            if(!visited[it]){ 
                ans=Math.max(ans,dfsalice(adj,vis,time+1,visited,it,amount));  
            }
        }
        if(ans==(int)(-1e9))return cost;
        return cost+ans;   // returning the maximum cost
    }
}
class Solution {

    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int n = arr.length;

        // Convert elements to 0 (even) or 1 (odd)
        for (int num = 0; num < n; num++) {
            arr[num] %= 2;
        }

        int[] dpEven = new int[n], dpOdd = new int[n];

        // Initialization based on the last element
        // The last element is even
        if (arr[n - 1] == 0) dpEven[n - 1] = 1;
        else dpOdd[n - 1] = 1; // The last element is odd

        for (int num = n - 2; num >= 0; num--) {
            if (arr[num] == 1) {
                // Odd element contributes to odd subarrays
                dpOdd[num] = (1 + dpEven[num + 1]) % MOD;
                // Even element continues the pattern
                dpEven[num] = dpOdd[num + 1];
            } else {
                // Even element contributes to even subarrays
                dpEven[num] = (1 + dpEven[num + 1]) % MOD;
                // Odd element continues the pattern
                dpOdd[num] = dpOdd[num + 1];
            }
        }

        // Sum all the odd subarrays
        int count = 0;
        for (int oddCount : dpOdd) {
            count += oddCount;
            count %= MOD;
        }
        return count;
    }
}
class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = 0, maxPrefixSum = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }

        return maxPrefixSum - minPrefixSum;
    }
}
class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        // dp[prev][curr] stores length of Fibonacci sequence ending at indexes prev,curr
        int[][] dp = new int[arr.length][arr.length];

        // Map each value to its index for O(1) lookup
        Map<Integer, Integer> valToIdx = new HashMap<>();

        // Fill dp array
        for (int curr = 0; curr < arr.length; curr++) {
            valToIdx.put(arr[curr], curr);

            for (int prev = 0; prev < curr; prev++) {
                // Find if there exists a previous number to form Fibonacci sequence
                int diff = arr[curr] - arr[prev];
                int prevIdx = valToIdx.getOrDefault(diff, -1);

                // Update dp if valid Fibonacci sequence possible
                // diff < arr[prev] ensures strictly increasing sequence
                if (diff < arr[prev] && prevIdx >= 0) {
                    dp[prev][curr] = dp[prevIdx][prev] + 1;
                } else {
                    dp[prev][curr] = 2;
                }

                maxLen = Math.max(maxLen, dp[prev][curr]);
            }
        }

        // Return 0 if no sequence of length > 2 found
        return maxLen > 2 ? maxLen : 0;
    }
}
class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        // Base case: both strings are empty
        if (str1.isEmpty() && str2.isEmpty()) {
            return "";
        }

        // Base case: one string is empty, append the other string
        if (str1.isEmpty()) {
            return str2;
        }

        if (str2.isEmpty()) {
            return str1;
        }

        // If the first characters match, include it in the supersequence
        if (str1.charAt(0) == str2.charAt(0)) {
            return (
                str1.charAt(0) +
                shortestCommonSupersequence(
                    str1.substring(1),
                    str2.substring(1)
                )
            );
        } else {
            // Try both options: picking from str1 or str2, and choose the shorter one
            String pickStr1 =
                str1.charAt(0) +
                shortestCommonSupersequence(str1.substring(1), str2);
            String pickStr2 =
                str2.charAt(0) +
                shortestCommonSupersequence(str1, str2.substring(1));

            return (pickStr1.length() < pickStr2.length())
                ? pickStr1
                : pickStr2;
        }
    }
}
class Solution {
    public int[] applyOperations(int[] nums) {
        int ans[] = new int[nums.length];
        int j=0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                ans[j++]=nums[i];
            }
        }
        return ans;
    }
}
class Solution {
    public int[][] mergeArrays(int[][] num1, int[][] num2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int n = num1.length,m=num2.length;
        int ans[][] = new int[n+m][2];
        while(i<n && j<m){
            int x[] = num1[i];
            int y[] = num2[j];

            if(x[0]==y[0]){
                ans[k] = new int[]{x[0],x[1]+y[1]};
                i++;j++;
            }
            else if(x[0]<y[0]){
                ans[k] = new int[]{x[0],x[1]};
                i++;
            }
            else{
                ans[k] = new int[]{y[0],y[1]};
                j++;
            }
            k++;
        }
        for(;i<n;i++){
            ans[k] = new int[]{num1[i][0],num1[i][1]};
            k++;
        }
        for(;j<m;j++){
            ans[k] = new int[]{num2[j][0],num2[j][1]};
            k++;
        }
        int[][] res = new int[k][2];
        for (int index = 0; index < k; index++) {
            res[index] = ans[index];
        }
        
        return res;
    }
}
class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        LinkedList<Integer> less = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        LinkedList<Integer> greater = new LinkedList<>();
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }
        less.addAll(equal);
        less.addAll(greater);

        int i = 0;
        int[] ans = new int[nums.length];
        for (int num : less) {
            ans[i++] = num;
        }
        return ans;
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






