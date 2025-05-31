/**
 * primsAlgo
 */
public class primsAlgo {
    public int strangePrinter(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                i++;
            }
        }
        int max=0;
        char ch='a';
        for(int i=0;i<26;i++){
            if (arr[i]>max) {
                max=arr[i];
                ch=(char)(i+'a');
            }
        }
        int count=1;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)!=ch) {
                count++;
                while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
          
    }
    class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String> ans1 = new ArrayList<>();
        ArrayList<String> ans2 = new ArrayList<>();

        int ch1 = 0;
        int ch2 = 1;

        for(int i = 0;i<words.length;i++){
            if(groups[i]==ch1){
                ans1.add(words[i]);
                ch1 = (ch1+1)%2;
            }
            if(groups[i]==ch2){
                ans2.add(words[i]);
                ch2 = (ch2+1)%2;
            }
        }
        System.out.println();

        return ans1.size()>=ans2.size()?ans1:ans2;
    }
    class Solution {
    public void sortColors(int[] nums) {
        int col[] = new int[3];

        for(int num : nums){
            col[num]++;
        }
        
        int k = 0;
        for(int i = 0;i<3;i++){
            while(col[i]!=0){
                nums[k++]=i;
                col[i]--;
            }
        }
        
        return;
    }
}
    
}
}

public class Solution {
    static class Cell {
        int row, col, moves;
        Set<Character> used;

        Cell(int row, int col, int moves, Set<Character> used) {
            this.row = row;
            this.col = col;
            this.moves = moves;
            this.used = new HashSet<>(used);
        }

        String getKey() {
            return row + "," + col + "," + used.toString();
        }
    }

    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] grid = new char[m][n];
        Map<Character, List<int[]>> portalMap = new HashMap<>();
        
        for (int i = 0; i < m; i++) {

            grid[i] = matrix[i].toCharArray();
            for (int j = 0; j < n; j++) {
                
                char c = grid[i][j];
                if (c != '.' && c != '#') {
                    
                    portalMap.putIfAbsent(c, new ArrayList<>());
                    portalMap.get(c).add(new int[]{i, j});
                }
            }
        }

        Queue<Cell> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(new Cell(0, 0, 0, new HashSet<>()));
        vis.add("0,0,[]");

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            Cell curr = q.poll();
            int r = curr.row, c = curr.col;
} 
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int pre[] = new int[n+1];

        for(int[] q:queries){
            pre[q[0]]--;
            pre[q[1]+1]++;
        }

        for(int i = 1;i<n;i++){
            pre[i] =pre[i]+pre[i-1];
        }

        for(int i = 0 ;i<n;i++){
            if(pre[i]+nums[i]>0) return false;
        }

        return true;
    }
}
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long dp[][] = new long[nums.length][2];
        for(long[] x : dp){
            Arrays.fill(x,-1);
        }
        return helper(0,nums,k,1,dp);
    }

    public long helper(int idx , int nums[],int k,int isEven,long dp[][]){
        if(idx==nums.length){
            return isEven==1?0:Integer.MIN_VALUE;
        }
        if(dp[idx][isEven]!=-1){
            return dp[idx][isEven];
        }

        long cost1 = nums[idx] + helper(idx+1,nums,k,isEven,dp);
        long cost2 = (nums[idx]^k) + helper(idx+1,nums,k,isEven^1,dp);

        return dp[idx][isEven]=Math.max(cost1,cost2);
    }
}
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int freq[] = new int[26];

            for(char ch : words[i].toCharArray()){
                freq[ch-'a']++;
            }

            if(freq[x-'a']>0) ans.add(i);
        }

        return ans;
    }
}
class Solution {
    public int longestPalindrome(String[] words) {
        int ans=0;
        int arr[][]=new int[26][26];
        for(String s:words){
            int a=s.charAt(0)-'a',b=s.charAt(1)-'a';
            if(arr[b][a]!=0){
                arr[b][a]--;
                ans+=4;
            }
            else arr[a][b]++;
        }
        for(int i=0;i<26;i++) if(arr[i][i]!=0){ans+=2; break;}
        return ans;
    }
}
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }

        int[][] colFreq = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int processed = 0;
        int maxColorCount = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            processed++;

            int colorIndex = colors.charAt(node) - 'a';
            colFreq[node][colorIndex]++;
            maxColorCount = Math.max(maxColorCount, colFreq[node][colorIndex]);

            for (int nei : graph[node]) {
                for (int c = 0; c < 26; c++) {
                    colFreq[nei][c] = Math.max(colFreq[nei][c], colFreq[node][c]);
                }

                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return processed == n ? maxColorCount : -1;
    }
}
class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 1;i<=n;i++){
            if(i%m==0){
                num2+=i;
            }
            else num1+=i;
        }

        return num1-num2;
    }
}
class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);
        int maxCount2 = 0;
        for (int c : count2) {
            if (c > maxCount2) {
                maxCount2 = c;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }
        return res;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, children, k);
        }
        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> children, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 1;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, children, k - 1);
        }
        return res;
    }
}
class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private int[] build(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private int dfs(
        int node,
        int parent,
        int depth,
        List<List<Integer>> children,
        int[] color
    ) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int square = curr[0], moves = curr[1];
            if (square == n * n) return moves;

            for (int next = square + 1; next <= Math.min(square + 6, n * n); next++) {
                int r = n - 1 - (next - 1) / n;
                int c = ((n - 1 - r) % 2 == 0) ? (next - 1) % n : n - 1 - (next - 1) % n;

                int dest = board[r][c] == -1 ? next : board[r][c];
                if (!vis[dest]) {
                    vis[dest] = true;
                    q.add(new int[]{dest, moves + 1});
                }
            }
        }

        return -1;
    }
}

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int m = queries.length;
        int n = nums.length;
        int[] end = new int[n + 1];
        int val = 0;
        int j = 0;
        
        for(int i = 0; i < n; ++i) {
            val -= end[i];
            while(j < m && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }

            while(val < nums[i]) {
                if(pq.isEmpty() || pq.peek() < i) return -1;
                end[pq.poll() + 1]++;
                val++;
            }
        }

        return pq.size();
    }
}
 