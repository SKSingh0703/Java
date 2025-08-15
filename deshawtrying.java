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
}
