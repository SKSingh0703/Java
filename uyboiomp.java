import java.util.ArrayList;

public class uyboiomp {
    public static void main(String[] args) {
        ArrayList<Integer> curr=new ArrayList<>();

        int ans[] = curr.toArray()
    }

    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            int m = queries.length;
            int prefix[] = new int[n+1];
            prefix[0]=0;
            
            for(int i=0;i<n;i++){
                prefix[i+1] = prefix[i] + words[i].charAt(0)==words[i].charAt(words[i].length()-1)?1:0;
            }
    
            int ans[] = new int[m];
            for(int i=0;i<m;i++){
                int q[]=queries[i];
                ans[i]=prefix[q[1]+1]-prefix[q[0]];
            }
    
            return ans;
        }
    }
}
