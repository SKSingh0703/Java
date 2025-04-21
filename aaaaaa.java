import java.util.PriorityQueue;

public class aaaaaa {
    private static String helper(String str){
        char arr[] = str.toCharArray();
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < arr.length-1; i++) {
            PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->b-a);
            pq.add(arr[i]);

            while (arr[i]%2==arr[i+1]%2) {
                pq.add(arr[i+1]);
                i++;
            }
            i--;
            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }

        }

        return arr.toString();
    }

    public static void main(String[] args) {
        String arr = "7596801";

        System.out.println(helper(arr));
    }
}
class Solution {

    // Represents a cell in the grid with row index, column index, and value
    record Cell(int row, int col, int value) {}

    // Represents a query with its original index and value
    record Query(int index, int value) {}

    // Right, Left, Down, Up
    private static final int[] ROW_DIRECTIONS = { 0, 0, 1, -1 };
    // Corresponding column moves
    private static final int[] COL_DIRECTIONS = { 1, -1, 0, 0 };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int rowCount = grid.length, colCount = grid[0].length;
        int totalCells = rowCount * colCount;

        // Store queries with their original indices to maintain result order
        Query[] sortedQueries = new Query[queries.length];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new Query(i, queries[i]);
        }
        // Sort queries in ascending order
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a.value, b.value));

        // Store all grid cells and sort them by value
        Cell[] sortedCells = new Cell[totalCells];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                sortedCells[row * colCount + col] = new Cell(
                    row,
                    col,
                    grid[row][col]
                );
            }
        }
        // Sort cells by value
        Arrays.sort(sortedCells, (a, b) -> Integer.compare(a.value, b.value));

        // Union-Find to track connected components
        UnionFind uf = new UnionFind(totalCells);
        int[] result = new int[queries.length];
        int cellIndex = 0;

        // Process queries in sorted order
        for (Query query : sortedQueries) {
            // Process cells whose values are smaller than the current query value
            while (
                cellIndex < totalCells &&
                sortedCells[cellIndex].value < query.value
            ) {
                int row = sortedCells[cellIndex].row;
                int col = sortedCells[cellIndex].col;
                // Convert 2D position to 1D index
                int cellId = row * colCount + col;

                // Merge the current cell with its adjacent cells that have already been
                // processed
                for (int direction = 0; direction < 4; direction++) {
                    int newRow = row + ROW_DIRECTIONS[direction];
                    int newCol = col + COL_DIRECTIONS[direction];

                    // Check if the new cell is within bounds and its value is smaller than the
                    // query value
                    if (
                        newRow >= 0 &&
                        newRow < rowCount &&
                        newCol >= 0 &&
                        newCol < colCount &&
                        grid[newRow][newCol] < query.value
                    ) {
                        uf.union(cellId, newRow * colCount + newCol);
                    }
                }
                cellIndex++;
            }
            // Get the size of the connected component containing the top-left cell (0,0)
            result[query.index] = query.value > grid[0][0] ? uf.getSize(0) : 0;
        }
        return result;
    }
}

class UnionFind {

    private final int[] parent;
    private final int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        // Initialize all parents to -1 (disjoint sets)
        Arrays.fill(parent, -1);
        // Each component starts with size 1
        Arrays.fill(size, 1);
    }

    // Find with path compression
    public int find(int node) {
        // If negative, it's the root
        if (parent[node] < 0) return node;
        // Path compression
        return parent[node] = find(parent[node]);
    }

    // Union by size (merge smaller tree into larger tree)
    public boolean union(int nodeA, int nodeB) {
        int rootA = find(nodeA), rootB = find(nodeB);
        // Already connected
        if (rootA == rootB) return false;

        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return true;
    }
    class Solution {
        public List<Integer> partitionLabels(String s) {
    
            ArrayList<Integer> arr = new ArrayList<>();
            int freq[] = new int[26];
            char st[] = s.toCharArray();
    
            for(char ch : st){
                freq[ch-'a']++;
            }
    
            int isPresent[] = new int[26];
            int count=0;
            boolean flag = true;
    
            for(char ch : st){
                
                freq[ch-'a']--;
                isPresent[ch-'a']++;
                count++;
                flag = true;
    
                for(int i = 0;i<26;i++){
                    if(isPresent[i]>0 && freq[i]>0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    Arrays.fill(isPresent,0);
                    arr.add(count);
                    count=0;
                }
            }
    
            return arr;
        }
    }
    class Solution {

        public long putMarbles(int[] weights, int k) {
            int n = weights.length;
            int[] pairWeights = new int[n - 1];
            for (int i = 0; i < n - 1; ++i) {
                pairWeights[i] = weights[i] + weights[i + 1];
            }
            Arrays.sort(pairWeights, 0, n - 1);
    
            long answer = 0l;
            for (int i = 0; i < k - 1; ++i) {
                answer += pairWeights[n - 2 - i] - pairWeights[i];
            }
    
            return answer;
        }
    }
    class Solution {
        public long mostPoints(int[][] questions) {
            long dp[] = new long[questions.length];
            Arrays.fill(dp,-1);
            return helper(0,questions,dp);
        }
    
        private long helper(int idx,int q[][],long dp[]){
            if(idx>=dp.length){
                return 0;
            }
            if(dp[idx]!=-1){
                return dp[idx];
            }
            long ch1 = helper(idx+1,q,dp);
            long ch2 = helper(idx+q[idx][1]+1,q,dp)+q[idx][0];
    
            return dp[idx] = Math.max(ch1,ch2);
        }
    }
    class Solution {

        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            long res = 0, imax = 0, dmax = 0;
            for (int k = 0; k < n; k++) {
                res = Math.max(res, dmax * nums[k]);
                dmax = Math.max(dmax, imax - nums[k]);
                imax = Math.max(imax, nums[k]);
            }
            return res;
        }
    }
    // Get the size of the component containing a given node
    public int getSize(int node) {
        return size[find(node)];
    }
    public class Solution {

        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
                rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
            }
            long res = 0;
            for (int j = 1; j < n - 1; j++) {
                res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
            }
            return res;
        }
    }
    class Solution {

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).getKey();
        }
    
        private Pair<TreeNode, Integer> dfs(TreeNode root) {
            if (root == null) {
                return new Pair<>(null, 0);
            }
    
            Pair<TreeNode, Integer> left = dfs(root.left);
            Pair<TreeNode, Integer> right = dfs(root.right);
    
            if (left.getValue() > right.getValue()) {
                return new Pair<>(left.getKey(), left.getValue() + 1);
            }
            if (left.getValue() < right.getValue()) {
                return new Pair<>(right.getKey(), right.getValue() + 1);
            }
            return new Pair<>(root, left.getValue() + 1);
        }
    }
    class Solution {
        public int subsetXORSum(int[] nums) {
            int result = 0;
            // Capture each bit that is set in any of the elements
            for (int num : nums) {
                result |= num;
            }
            // Multiply by the number of subset XOR totals that will have each bit set
            return result << (nums.length - 1);
        }
    }
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
        // Step 1: Initialize variables and arrays
        int[] dp = new int[nums.length];   // dp array to store the size of the largest divisible subset ending at each index
        Arrays.fill(dp, 1);                // Initialize dp array with 1, as minimum subset size is at least 1 (the number itself)
        Arrays.sort(nums);                 // Sort nums array in ascending order
        
        int[] hash = new int[nums.length]; // To keep track of the previous index contributing to the largest subset
        int maxSize = 1;                   // Initialize maximum subset size
        int maxIndex = 0;                  // Initialize index of the element that ends the largest subset
        
        // Step 2: Build the dp array and hash array
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;  // Initialize hash[i] with i, indicating the subset ends with itself initially
            
            for (int j = 0; j < i; j++) {
                // Check if nums[i] is divisible by nums[j]
                if (nums[i] % nums[j] == 0) {
                    // Update dp[i] and hash[i] if we found a larger subset ending at index i
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        hash[i] = j;
                    }
                }
            }
            
            // Update the maximum subset size and the index of the element ending the largest subset found so far
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        
        // Step 3: Construct the largest divisible subset
        List<Integer> result = new ArrayList<>();
        int index = maxIndex;
        while (index != hash[index]) {
            result.add(nums[index]);
            index = hash[index];
        }
        result.add(nums[index]); // Add the last element of the subset
        
        return result;
    }
    }
    class Solution {
        //Recursion

    // public boolean canPartition(int[] nums) {
    //     int sum=0;
    //     int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         sum+=nums[i];
    //     }
    //     if(sum%2!=0) return false;
    //     sum=sum/2;
    //     return helper(0,sum,nums);
    // }
    // public boolean helper(int i,int target,int nums[]){
    //     if(target==0) return true;
    //     if(i==nums.length) return false;
    //     boolean ch1=false,ch2=false;
    //     if(target>=nums[i]){
    //        ch1= helper(i+1,target-nums[i],nums);
    //     }
    //     ch2=helper(i+1,target,nums);

    //     return (ch1|ch2);
    // }

        //Memorization

    //  public boolean canPartition(int[] nums) {
    //     int sum=0;
    //     int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         sum+=nums[i];
    //     }
    //     if(sum%2!=0) return false;
    //     sum=sum/2;
    //     Boolean dp[][]=new Boolean[n][sum+1];
    //     return helper(0,sum,nums,dp);
    // }
    // public boolean helper(int i,int target,int nums[],Boolean dp[][]){
    //     if(target==0) return true;
    //     if(i==nums.length) return false;
    //     if(dp[i][target]!=null) return dp[i][target];
    //     boolean ch1=false,ch2=false;
    //     if(target>=nums[i]){
    //        ch1= helper(i+1,target-nums[i],nums,dp);
    //     }
    //     ch2=helper(i+1,target,nums,dp);

    //     return dp[i][target]=(ch1|ch2);
    // }

        //Tabulation

     public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        Boolean dp[][]=new Boolean[n+1][sum+1];
        for(int i=0;i<=sum;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                boolean x=false,y=false;
                if(j>=nums[i-1]){
                    x=dp[i-1][j-nums[i-1]];
                }
                y=dp[i-1][j];
                dp[i][j]=(x|y);
            }
        }
        return dp[n][sum];
    }
    import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums); 
        int n = nums.length;
        boolean containsK = false;
        for (int num : nums) {
            if (num < k) {
                containsK = true;
                break;
            }
        }
        if (containsK) return -1;

        int operations = 0;
        int h = nums[n - 1];

        for (int i = n - 1; i >= 0 && nums[i] > k; ) {
            operations++;
            h = nums[i]; 
            while (i >= 0 && nums[i] > k && nums[i] == h) {
                nums[i] = k; 
                i--;
            }
        }

        for (int num : nums) {
            if (num != k) return -1;
        }

        return operations;
    }
}
class Solution {

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int a = low; a <= high; ++a) {
            if (a < 100 && a % 11 == 0) {
                res++;
            } else if (1000 <= a && a < 10000) {
                int left = a / 1000 + (a % 1000) / 100;
                int right = (a % 100) / 10 + (a % 10);
                if (left == right) {
                    res++;
                }
            }
        }
        return res;
    }
}
class Solution {

    public long countGoodIntegers(int n, int k) {
        Set<String> dict = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;
        /* Enumerate the number of palindrome numbers of n digits */
        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);
            /* If the current palindrome number is a k-palindromic integer */
            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        long ans = 0;
        for (String s : dict) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            /* Calculate permutations and combinations */
            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            ans += tot;
        }

        return ans;
    }
}
class Solution {

    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((quickmul(5, (n + 1) / 2) * quickmul(4, n / 2)) % mod);
    }

    // use fast exponentiation to calculate x^y % mod
    public long quickmul(int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret = (ret * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y /= 2;
        }

        return ret;
    }
}
class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (
                        Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c
                    ) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
    class FenwickTree {

        private int[] tree;
    
        public FenwickTree(int size) {
            tree = new int[size + 1];
        }
    
        public void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }
    
        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }
    
    class Solution {
    
        public long goodTriplets(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] pos2 = new int[n], reversedIndexMapping = new int[n];
            for (int i = 0; i < n; i++) {
                pos2[nums2[i]] = i;
            }
            for (int i = 0; i < n; i++) {
                reversedIndexMapping[pos2[nums1[i]]] = i;
            }
            FenwickTree tree = new FenwickTree(n);
            long res = 0;
            for (int value = 0; value < n; value++) {
                int pos = reversedIndexMapping[value];
                int left = tree.query(pos);
                tree.update(pos, 1);
                int right = (n - 1 - pos) - (value - left);
                res += (long) left * right;
            }
            return res;
        }
    }
    class Solution {

        public long countGood(int[] nums, int k) {
            int n = nums.length;
            int same = 0, right = -1;
            HashMap<Integer, Integer> cnt = new HashMap<>();
            long ans = 0;
            for (int left = 0; left < n; ++left) {
                while (same < k && right + 1 < n) {
                    ++right;
                    same += cnt.getOrDefault(nums[right], 0);
                    cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
                }
                if (same >= k) {
                    ans += n - right;
                }
                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                same -= cnt.get(nums[left]);
            }
            return ans;
        }
    }
}
}
class Solution {

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int res = 0; // number of pairs meeting the requirements
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((i * j) % k == 0 && nums[i] == nums[j]) {
                    ++res;
                }
            }
        }
        return res;
    }
}
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count).append(res.charAt(res.length() - 1));
            res = temp.toString();
        }
        return res;
    }
}
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
     
      Arrays.sort(nums);
      return countLess(nums, upper) - countLess(nums, lower - 1);
    }
  
    private long countLess(int[] nums, int sum) {
      long res = 0;
      for (int i = 0, j = nums.length - 1; i < j; ++i) {
        while (i < j && nums[i] + nums[j] > sum)
          --j;
        res += j - i;
      }
      return res;
    }
  }
  class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i : answers) mpp.put(i, mpp.getOrDefault(i, 0) + 1);

        int total = 0;
        for (Map.Entry<Integer, Integer> p : mpp.entrySet())
            total += Math.ceil((double)p.getValue() / (p.getKey() + 1)) * (p.getKey() + 1);

        return total;
    }
}
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, maxi = 0, mini = 0;
        for (int x : differences) {
            sum += x;
            maxi = Math.max(maxi, sum);
            mini = Math.min(mini, sum);
        }
        return (int)Math.max(0, upper - lower - maxi + mini + 1);
    }
}
}
