import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 
                    
public class aRecursion { 
    public int lcs( String str1, String str2) {
        int m = str1.length() , n = str2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i = 1 ; i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder("");

        int i = m;
        int j = n;

        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }

        ans.reverse();

        for(int k = 0 ; k<ans.length();k++){
            System.out.print(ans.charAt(k)+"   ");
        }

        return ans.length();
    }
    public static void main(String[] args) {
        aRecursion solution = new aRecursion();
        System.out.println(solution.lcs("mnop", "mnq"));
        System.out.println();
    }     
}  
    