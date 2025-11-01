import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class deshawtrying {

    private static String helper(String str){
        String arr[] = str.split("/");

        if (arr.length != 2) {
            return "Invalid input";
        }

        try {
            int numerator = Integer.parseInt(arr[0]);
            int denominator = Integer.parseInt(arr[1]);

            if (denominator == 0) {
                return "Denominator cannot be zero";
            }

            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }

            return numerator + "/" + denominator;

        } catch (NumberFormatException e) {
            return "Invalid number format";
        }

        return "";
    } 
    
    public static void main(String[] args) {
        String arr = "123";
        
        helper("-134/112");
    }

    class Solution {
    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int curr = 1;
        hs.add(curr);

        while(curr<1_000_000_000){
            curr*=2;
            hs.add(curr);
        }

        while(n>0){
            arr.add(n%10);
            n/=10;
        }

        return helper(arr,new StringBuilder(),hs);
    }

    private boolean helper(ArrayList<Integer> arr , StringBuilder sb,HashSet<Integer> hs){
        if(arr.size()==0){ 
            if(sb.charAt(0)=='0') return false;
            int n = Integer.parseInt(sb.toString());
            // System.out.println(hs.contains(n)+"    "+sb);
            return hs.contains(n);
        }

        for(int i = 0;i<arr.size();i++){
            

            int digit = arr.remove(i);
            sb.append( digit );

            if(helper(arr,sb,hs)) return true;
            sb.deleteCharAt(sb.length()-1);
            arr.add(i ,digit);
        }

        return false;
    }
}
class Solution {
    static int mod = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int dp[][] = new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,1,n,x,dp);
    }

    private int helper(int curr,int i , int n , int x,int dp[][]){
        if(curr==n) return 1;
        if(curr>n || (int)Math.pow(i,x)>n) return 0;

        if(dp[curr][i]!=-1) return dp[curr][i];

        return dp[curr][i]=(helper(curr+(int)Math.pow(i,x),i+1,n,x,dp)+helper(curr,i+1,n,x,dp))%mod;
    }
}
class Solution {
    public boolean isPowerOfThree(int n) {
        long curr = 1;
        while(curr<=n){
            if(curr==n) return true;
            curr*=3;
        }

        return false;
    }
}
class Solution {
    public String largestGoodInteger(String num) {
        int sum = -1;
        String ans = "";
        int n = num.length();
        for(int i = 0;i<n-2;i++){
            char curr1 = num.charAt(i);
            char curr2 = num.charAt(i+1);
            char curr3 = num.charAt(i+2);

            if(curr1==curr2 && curr2==curr3 ){
                int y = curr1-'0';
                System.out.println(y+":");
                int curr = 100*y+10*y+y;
                System.out.println(curr+"  PP");
                if(curr>sum){
                    StringBuilder sb = new StringBuilder("");
                    sb.append(curr1);
                    sb.append(curr1);
                    sb.append(curr1);
                    sum = curr;
                    char x = curr1;
                    ans = sb.toString();
                    System.out.println(ans+"  "+x+"  aP");
                }
                
            }
        }

        return ans;
    }
}
class Solution {
    public boolean isPowerOfFour(int n) {
        long curr=1;
        while(curr<=n){
            if(curr==n) return true;
            curr*=4;
        }

        return false;
    }
}
class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder("");
        String str = Integer.toString(num);
        boolean change = false;

        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='6' && change==false){
                sb.append('9');
                change = true;
            }
            else sb.append(str.charAt(i));
        }

        return Integer.parseInt(sb.toString());
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long ans = 0;
        int n = nums.length;
        int l = 0 ;

        for(int r = 0; r<n;r++){
            while(r<n && nums[r]!=0){
                r++;
                l=r;
            }
            if(r==n) break;

            ans+=r-l+1;
            // System.out.println(ans+"     "+l+"   L   "+r+"      R    ");
        }

        return ans;
    }
}
}
class Solution {
    public int minimumArea(int[][] grid) {
        int minX = 1_000_000;
        int maxX = 0;
        int minY = 1_000_000;
        int maxY = 0;

        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    minX = Math.min(minX,j);
                    maxX = Math.max(maxX,j);

                    minY = Math.min(minY,i);
                    maxY = Math.max(maxY,i);
                }
            }
        }
        // System.out.println(minX + "    "+maxX + "    "+minY + "    "+maxY + "    ");

        return (maxX-minX+1)*(maxY-minY+1);
    }
    class Solution {
    public int longestSubarray(int[] nums) {

        int l = 0;
        int ans = 0;
        int zeros = 0;
        int n = nums.length;

        for(int r = 0; r<n ;r++){
            zeros+= nums[r]==0?1:0;

            while(l<r && zeros>1){
                zeros-= nums[l]==0?1:0;
                l++;
            }

            ans = Math.max(ans,r-l);
        }

        return ans;
    }
}

class Solution {
    private double helper(double pass, double total) {
        return (pass + 1.0) / (total + 1.0) - (pass / total);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[2], a[2]) 
        );

        for (int[] curr : classes) {
            double pass = curr[0];
            double total = curr[1];
            pq.offer(new double[]{pass, total, helper(pass, total)});
        }

        while (extraStudents-- > 0) {
            double[] curr = pq.poll();
            double pass = curr[0] + 1;
            double total = curr[1] + 1;
            pq.offer(new double[]{pass, total, helper(pass, total)});
        }

        double ans = 0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            ans += curr[0] / curr[1];
        }

        return ans / classes.length;
    }
}
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i!=j && check(points[i],points[j],points)) count++;
            }
        }

        return count;
    }

    private boolean check(int[] x , int[] y, int[][] points ){
        if( !(x[0]<=y[0] && x[1]>=y[1]) ) return false;
        int minX = x[0];
        int minY = y[1];

        int maxX = y[0];
        int maxY = x[1];

        for(int[] point:points){
            int x1 = point[0];
            int y1 = point[1];

            if((x1==x[0] && y1==x[1]) || (x1==y[0] && y1==y[1])) continue;

            if( (x1>=minX && x1<=maxX) && (y1>=minY && y1<=maxY) ){
                // System.out.println( x[0]+" , "+x[1]+"      "+y[0]+" , "+y[1] +"   "+x1+","+y1 );
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int findClosest(int x, int y, int z) {
        if(x-z==y-z){
            return 0;
        }
        else if(x-z>y-z){
            return 2;
        }
        else{
            return 1;
        }
    }
}
class Solution {

    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);

        int i = 0;
        int j = arr.size()-1;

        while(i<j){
            int x = arr.get(i);
            int y = arr.get(j);

            if(x+y==k) return true;
            else if(x+y>k) j--;
            else i++;
        }

        return false;
    }

    private void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null ) return;

        inorder(root.left , arr);
        arr.add(root.val);
        inorder(root.right,arr);

        return;
    }
}
    }
    class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length , m = potions.length;
        int ans[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            int minReq = (int)Math.ceil(success*1.0/spells[i]);

            int curr = helper(potions,minReq);
            ans[i] = m - curr;
        }

        return ans;
    }

    private int helper(int nums[] , int target){
        int l = 0;
        int r = nums.length;

        while(l<r){
            int mid = l + (r-l)/2;

            if(nums[mid]>=target){
                r = mid;
            }
            else l = mid +1;
        }

        return l;
    } 
}          
}     
}                    
