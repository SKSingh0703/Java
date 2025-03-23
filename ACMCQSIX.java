import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.w3c.dom.Node;

public class ACMCQSIX {

    public int gcd(int a ,int b){
        if (a%b==0) {
            return b;
        }
        return gcd(b, a%b);
    }

    public String fractionAddition(String expression) {
        ArrayList<Integer> numerator=new ArrayList<>();
        ArrayList<Integer> denominator=new ArrayList<>();
        int i=0;
        while (i<expression.length()) {
            StringBuilder nr=new StringBuilder("");
            StringBuilder dr=new StringBuilder("");
            while (i<expression.length() && expression.charAt(i)!='/') {
                nr.append(expression.charAt(i));
                i++;
            }
            i++;
            numerator.add(Integer.parseInt(nr.toString()));
            while (i<expression.length() && (expression.charAt(i)!='+' || expression.charAt(i)!='-') ) {
                dr.append(expression.charAt(i));
                i++;
            }
            denominator.add(Integer.parseInt(dr.toString()));
        }
        int totalDr=denominator.get(0);
        for(int i=1;i<denominator.size();i++){
            totalDr=(totalDr*denominator.get(i))/(gcd(totalDr, denominator.get(i)));
        }
        int totalNr=0;
        for(int i=0;i<numerator.size();i++){
            totalNr+=numerator.get(i)*(totalDr/denominator.get(i));
        }
        if (totalNr==0) {
            return "0/1";
        }
        totGcd=gcd(totalDr, totalNr);
        totalNr=totalNr/totGcd;
        totalDr=totalDr/totGcd;

        String N=Integer.toString(totalNr);
        String D=Integer.toString(totalDr);

        String f=N+"/"+D;
        return f;
    }

    public int findComplement(int num) {
        String s=Integer.toBinaryString(num);
        int mul=1;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='0') {
                ans+=mul;
            }
            mul*=2;
        }
        return ans;
    }
    public String nearestPalindromic(String s) {
        int n=s.length();
        int val=Integer.parseInt(s);
        if (n==1) {
            int ans = Integer.parseInt(s)-1;
            return Integer.toString(ans);
        }
        StringBuilder firstHalf=new StringBuilder();
        StringBuilder secondHalf=new StringBuilder();
        if (n%2==0) {
            for(int i=1;i<=n;i++){
                if (i<=n/2) {
                    firstHalf.append(s.charAt(i-1));
                }
                else secondHalf.append(s.charAt(i-1));
            }
            StringBuilder s1=new StringBuilder("");
            s1.append(firstHalf.toString()).append(firstHalf.reverse().toString());

            StringBuilder s2=new StringBuilder("");
            s2.append(secondHalf.toString()).append(secondHalf.reverse().toString());

            int val1=Integer.parseInt(s1.toString());
            int val2=Integer.parseInt(s2.toString());

            int one=Math.abs(val1-val);
            int two=Math.abs(val2-val);
            if (one>two) {
                return Integer.toString(val1);
            }
            else return Integer.toString(val2);
        }
        else{
            char mid=s.charAt((n+1)/2 - 1);
            for(int i=1;i<=n;i++){
                if (i<=n/2){
                    firstHalf.append(s.charAt(i-1));
                }
                else if (i>(n+1)/2) {
                    secondHalf.append(s.charAt(i-1));
                }
            }
            StringBuilder s1=new StringBuilder("");
            s1.append(firstHalf.toString()).append(mid).append(firstHalf.reverse().toString());

            StringBuilder s2=new StringBuilder("");
            s2.append(secondHalf.toString()).append(mid).append(secondHalf.reverse().toString());

            int val1=Integer.parseInt(s1.toString());
            int val2=Integer.parseInt(s2.toString());

            int one=Math.abs(val1-val);
            int two=Math.abs(val2-val);
            if (one>two) {
                return Integer.toString(val1);
            }
            else return Integer.toString(val2);
            
        }
        System.out.println();
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int j=0;j<k;j++){
            int minimun=Integer.MAX_VALUE;
            int idx=-1;
            for(int i=0;i<nums.length;i++){
                if (nums[i]<minimun) {
                    minimun=nums[i];
                    idx=i;
                }
            }
            nums[idx]*=multiplier;
        }
        return nums;
    }
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }

    private boolean check(int x,int y){
        char num1[] = String.valueOf(x).toCharArray();
        char num2[] = String.valueOf(y).toCharArray();
        
        if (num1.length != num2.length) {
            return false;
        }
        
        for(int i=0;i<num1.length;i++){
            char temp2[]=String.valueOf(y).toCharArray();
            for(int j=i+1;j<num1.length;i++){
                char temp=temp2[j];
                temp2[j]=num1[i];
                num1[i]=temp;
            }
            if (areAlmostEqual(num1, temp2)) {
                return true;
            }
        }
        for(int i=0;i<num2.length;i++){
            char temp1[]=String.valueOf(x).toCharArray();
            for(int j=i+1;j<num2.length;i++){
                char temp=temp1[j];
                temp1[j]=num2[i];
                num2[i]=temp;
            }
            if (areAlmostEqual(num2, temp1)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean areAlmostEqual(char num1[],char num2[]) {
        if (num1.length != num2.length) {
            return false;
        }
        
        for(int i=0;i<num1.length;i++){
            if(num1[i]!=num2[i]) return false;
        }
        
        return true;
    }

    public int min(int nums[]){
        int minimun=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minimun=Math.min(minimun, nums[i]);
        }
        return minimun;
    }
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(nums[i], nums[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean check(int x, int y) {
        char[] num1 = String.valueOf(x).toCharArray();
        char[] num2 = String.valueOf(y).toCharArray();

        if(num1.length==1 && num1[0]==num2[0]) return true;
        for (int i = 0; i < num1.length; i++) {
            for (int j = i + 1; j < num1.length; j++) {
                char[] temp1 = num1.clone();

                char temp = temp1[j];
                temp1[j] = temp1[i];
                temp1[i] = temp;

                if (areAlmostEqual(temp1,num2)) {
                    
                    return true;
                }
                System.out.println();
            }
        }
        for (int i = 0; i < num1.length; i++) {
            for (int j = i + 1; j < num1.length; j++) {
                char[] temp2 = num2.clone();
                
                char temp = temp2[j];
                temp2[j] = temp2[i];
                temp2[i] = temp;

                if (areAlmostEqual(num1, temp2)) {
                    
                    return true;
                }
            }
        }

        return false;
    }

    private boolean areAlmostEqual(char[] num1, char[] num2) {
        if (num1.length != num2.length) {
            return false;
        }

        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }

        return true;
    }
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    private void helper(Node root,List<Integer> ans){
        if(root==null) return;
        for(int i=0;i<root.children.size();i++){
            helper(root.children.get(i),ans);
        }
        ans.add(root.val);
    }
    
 
        public static void main(String[] args) {
            System.out.println("Java version: " + System.getProperty("java.version"));
        }
    
 class Solution {

    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        while (end < word.length()) {
            char newLetter = word.charAt(end);

            if (isVowel(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            while (vowelCount.size() == 5 && consonantCount >= k) {
                numValidSubstrings += word.length() - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            end++;
        }

        return numValidSubstrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    class Solution {
        public int numberOfSubstrings(String s) {
            int freq[] = new int[3];
            int l =0;
            int n = s.length();
            int count = 0;
    
            for(int r = 0;r<n;r++){
                freq[s.charAt(r)-'a']++;
                while(l<n && freq[0]>0 && freq[1]>0 && freq[2]>0){
                    count +=n-r;
                    freq[s.charAt(l++)-'a']--;
                }
            }
            return count;
        }
    }
} 
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }
}
class Solution {
    public static int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        long maxCandies = 0;
        
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
            totalCandies += candy;
        }
        
        if (k > totalCandies) return 0; // Not enough candies for each kid to get one
        
        long min = 1;
        long max = maxCandies;
        
        while (min < max) {
            long mid = min + (max - min + 1) / 2;
            if (isPossible(mid, k, candies)) {
                min = mid; // Try for a larger possible number of candies per kid
            } else {
                max = mid - 1; // Reduce the maximum possible number of candies per kid
            }
        }
        
        return (int) min;
    }

    public static boolean isPossible(long capacity, long k, int[] candies) {
        long requiredKids = 0;
        
        for (int candy : candies) {
            requiredKids += candy / capacity;
            if (requiredKids >= k) return true; // Early exit if we can satisfy the condition
        }
        
        return requiredKids >= k;
    }
}
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long h = 0;
        long l = 1;

        for(int rank : ranks){
            h = Math.max(h,(long)rank);
        }
        h = h*cars*cars;

        while(l<h){
            long mid = l + (h-l)/2;
            if(possible(mid,cars,ranks)){
                h = mid;
            }
            else l = mid+1;
        }

        return l;
    }

    private boolean possible(long limit,int n,int ranks[]){
        for(int rank : ranks){
            n-=Math.floor(Math.sqrt(limit/(rank*1.0)));
        }

        return n<=0;
    }
}
class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int freq[] = new int[501];

        for(int num : nums){
            freq[num]++;
        }

        for(int f : freq){
            if(f%2!=0) return false;
        }

        return true;
    }
}
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int left = 0;
        int usedBits = 0;
        
        for (int right = 0; right < n; right++) {
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left];
                left++;
            }
            
            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length - 2;i++){
            if(nums[i] == 0){
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count += 1;
            }
        }
        if(nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0){
            return -1;
        }
        
        return count;
    }
}
class Solution {
    int rank[];
    int parent[];
    int and[];

    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        else return parent[x]=find(parent[x]);
    }

    private boolean union(int x,int y,int wt){
        int parX = find(x);
        int parY = find(y);

        if(parX==parY){
            and[parX]=and[parX]&wt;
            return false;
        }

        if(rank[parX]==rank[parY]){
            rank[parX]++;
            parent[parY]=parX;
            and[parX]=and[parX]&and[parY]&wt;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY]=parX;
            and[parX]=and[parX]&and[parY]&wt;
        }
        else{
            parent[parX]=parY;
            and[parY]=and[parY]&and[parX]&wt;
        }

        return true;
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        rank = new int[n];
        parent = new int[n];
        and = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            and[i] = -1;
        }

        for(int[] edge : edges){
            union(edge[0],edge[1],edge[2]);
        }

        int ans[] = new int[query.length];
        int k = 0;

        for(int[] q : query){
            int parX = find(q[0]);
            int parY = find(q[1]);

            if(parX!=parY){
                ans[k++]=-1;
            }
            else ans[k++] = and[parX];
        }

        return ans;
    }
}
class Solution {

    public List<String> findAllRecipes(
        String[] recipes,
        List<List<String>> ingredients,
        String[] supplies
    ) {
        Set<String> availableSupplies = new HashSet<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        Map<String, List<String>> dependencyGraph = new HashMap<>();

        for (String supply : supplies) {
            availableSupplies.add(supply);
        }

        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }

        int[] inDegree = new int[recipes.length];

        for (int recipeIdx = 0; recipeIdx < recipes.length; recipeIdx++) {
            for (String ingredient : ingredients.get(recipeIdx)) {
                if (!availableSupplies.contains(ingredient)) {
                    dependencyGraph.putIfAbsent(
                        ingredient,
                        new ArrayList<String>()
                    );
                    dependencyGraph.get(ingredient).add(recipes[recipeIdx]);
                    inDegree[recipeIdx]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int recipeIdx = 0; recipeIdx < recipes.length; recipeIdx++) {
            if (inDegree[recipeIdx] == 0) {
                queue.add(recipeIdx);
            }
        }

        List<String> createdRecipes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int recipeIdx = queue.poll();
            String recipe = recipes[recipeIdx];
            createdRecipes.add(recipe);

            if (!dependencyGraph.containsKey(recipe)) continue;

            for (String dependentRecipe : dependencyGraph.get(recipe)) {
                if (--inDegree[recipeToIndex.get(dependentRecipe)] == 0) {
                    queue.add(recipeToIndex.get(dependentRecipe));
                }
            }
        }

        return createdRecipes;
    }
}
class Solution {

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            graph.get(startNode).add(new int[] { endNode, travelTime });
            graph.get(endNode).add(new int[] { startNode, travelTime });
        }

        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );

        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        int[] pathCount = new int[n];

        shortestTime[0] = 0; 
        pathCount[0] = 1; 

        minHeap.offer(new long[] { 0, 0 }); 

        while (!minHeap.isEmpty()) {
            long[] top = minHeap.poll();
            long currTime = top[0]; 
            int currNode = (int) top[1];

            // Skip outdated distances
            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int neighborNode = neighbor[0], roadTime = neighbor[1];

                if (currTime + roadTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = currTime + roadTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    minHeap.offer(
                        new long[] { shortestTime[neighborNode], neighborNode }
                    );
                }
                else if (currTime + roadTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] =
                        (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }

        return pathCount[n - 1];
    }
}
class Solution {
    public int maximumCount(int[] nums) {
        int p = 0;
        int n = 0;

        for(int num : nums){
            if(num>0) p++;
            if(num<0) n++;
        }

        return Math.max(p,n);
    }
}
}
