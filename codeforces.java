import java.util.Arrays;
import java.util.Scanner;

public class codeforces {
    import java.util.*;

class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x){
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
    
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        parent = new int[n];
        rank  = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int[] outdegree = new int[n];

        int mstWeight = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (outdegree[u] < threshold) {
                if (union(u, v)) {
                    mstWeight = Math.max(mstWeight, weight);
                    edgesUsed++;
                    outdegree[u]++;
                }
            }
        }

        int root0 = 0;
        for (int i = 1; i < n; i++) {
            if (find(i) != root0) {
                return -1;
            }
        }
        return edgesUsed == n - 1 ? mstWeight : -1;
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt(); // Length of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Sort the array
            Arrays.sort(a);

            // Check if all elements are equal
            if (a[0] == a[n - 1]) {
                result.append("NO\n");
            } else {
                result.append("YES\n");
            }
        }

        System.out.print(result.toString());
    }
}
