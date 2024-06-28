import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class OneFIFTYQuestionChallengePart1Arrays {
    class RandomizedSet {
        HashSet<Integer> hs;
        public RandomizedSet() {
            hs=new HashSet<>();
        }
        
        public boolean insert(int val) {
            if (hs.contains(val)) {
                return false;
            }
            else{
                hs.add(val);
                return true;
            }
        }
        
        public boolean remove(int val) {
            if(hs.contains(val)){
                hs.remove(val);
                return true;
            }
            else return false;
        }
        
        public int getRandom() {
            return getRandomElement(hs);
        }
    }
    public Integer getRandomElement(HashSet<Integer> set) {
        // Convert HashSet to ArrayList
        ArrayList<Integer> list = new ArrayList<>(set);
        list.set
        // Generate a random index
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        
        // Return the random element
        return list.get(randomIndex);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    }
    // public int lengthOfLastWord(String s) {
    //     String st=s.trim();
    //     String arr[]=st.split("\\s+");
    //     return arr[arr.length-1].length();
    // }
    // class Solution {
    //     public int lengthOfLastWord(String s) {
    //         int res = 0;
    //         for(int i = s.length() - 1; i >= 0; i--) {
    //             if (s.charAt(i) != ' ') res++;
    //             else {
    //                 if (res != 0) return res;
    //             }
    //         }
    //         return res;
    //     }
    // }
     
    public String convert(String s, int numRows) {
        char arr[][]=new char[numRows][s.length()];
        int idx=0;
        int col=0;
        int midRowIdx=numRows-1;
        while (idx<s.length()) {
            for (int i = 0; i < numRows; i++) {
                arr[i][col]=s.charAt(idx);
                idx++;
            }
            if(midRowIdx==0) midRowIdx=numRows-1;
            col++;
            arr[midRowIdx][col]=s.charAt(idx);
            idx++;
            col++;
        }
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if (arr[i][j]!=null) {
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        
    }
}
