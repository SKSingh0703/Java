public class IEEEcontest {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char ch1=coordinate1.charAt(0);
        char ch2=coordinate1.charAt(1);

        int one=ch1-'a'+1;
        int two=Integer.parseInt(ch2);
        boolean isBlack=false;
        boolean isWhite=true;
        if ((one%2==0 && two%2==0) || (one%2!=0 && two%2!=0)  ) {
            isBlack=true;
            isWhite=false;
        }
        char ch11=coordinate2.charAt(0);
        char ch22=coordinate2.charAt(1);

        int onee=ch11-'a'+1;
        int twoo=Integer.parseInt(ch22);
        boolean flag=false;
        if (isWhite) {
            if ((one%2==0 && two%2!=0) || (one%2!=0 && two%2==0)) {
                flag=true;
            }
        }
        if (isBlack) {
            if ((onee%2==0 && twoo%2==0) || (onee%2!=0 && twoo%2!=0)) {
                flag=true;
            }
        }
        if (flag) {
            return true;
        }
        else return false;
    }
    import java.util.*;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        Set<Integer> hs = new HashSet<>();
        int max = 0;
        for (List<Integer> row : grid) {
            Collections.sort(row, Collections.reverseOrder());
        }

        for (List<Integer> row : grid) {
            for (int value : row) {
                if (!hs.contains(value)) {
                    max += value;  
                    hs.add(value);  
                    break; 
                }
            }
        }

        return max;
    }
}

    public static void main(String[] args) {
        
    }
}
