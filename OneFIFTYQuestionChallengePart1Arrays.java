import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class OneFIFTYQuestionChallengePart1Arrays {
    // class RandomizedSet {
    //     HashSet<Integer> hs;
    //     public RandomizedSet() {
    //         hs=new HashSet<>();
    //     }
        
    //     public boolean insert(int val) {
    //         if (hs.contains(val)) {
    //             return false;
    //         }
    //         else{
    //             hs.add(val);
    //             return true;
    //         }
    //     }
        
    //     public boolean remove(int val) {
    //         if(hs.contains(val)){
    //             hs.remove(val);
    //             return true;
    //         }
    //         else return false;
    //     }
        
    //     public int getRandom() {
    //         return getRandomElement(hs);
    //     }
    // }
    // public Integer getRandomElement(HashSet<Integer> set) {
    //     // Convert HashSet to ArrayList
    //     ArrayList<Integer> list = new ArrayList<>(set);
    //     list.set
    //     // Generate a random index
    //     Random rand = new Random();
    //     int randomIndex = rand.nextInt(list.size());
        
    //     // Return the random element
    //     return list.get(randomIndex);
    // }
    // public int canCompleteCircuit(int[] gas, int[] cost) {
        
    // }
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
    //  public List<String> fullJustify(String[] words, int maxWidth) {
    //     List<String> ans=new ArrayList<>();
    //     List<String> currLineWords=new ArrayList<>();
    //     StringBuilder lineWordsInASingleString=new StringBuilder("");
    //     for (int i = 0; i < words.length; i++) {
    //         if (lineWordsInASingleString.length()+currLineWords.size()+words[i].length()>maxWidth) {
    //             assign(currLineWords,maxWidth);
    //             lineWordsInASingleString="";
    //             currLineWords=new ArrayList<>();
    //         }
    //         currLineWords.add(words[i]);
    //         lineWordsInASingleString.append(words[i]);
    //     }
    //     return ans;
    // }

    // public String convert(String s, int numRows) {
    //     char arr[][]=new char[numRows][s.length()];
    //     int idx=0;
    //     int col=0;
    //     int midRowIdx=numRows-1;
    //     while (idx<s.length()) {
    //         for (int i = 0; i < numRows; i++) {
    //             arr[i][col]=s.charAt(idx);
    //             idx++;
    //         }
    //         if(midRowIdx==0) midRowIdx=numRows-1;
    //         col++;
    //         arr[midRowIdx][col]=s.charAt(idx);
    //         idx++;
    //         col++;
    //     }
    //     StringBuilder sb=new StringBuilder("");
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr[0].length;j++){
    //             if (arr[i][j]!=null) {
    //                 sb.append(arr[i][j]);
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     HashMap<Character,Integer> hm=new HashMap<>();
    //     for (int i = 0; i < magazine.length(); i++) {
    //         hm.put(magazine.charAt(i),hm.getOrDefault(magazine.charAt(i),0)+1);
    //     }
    //     for (int i = 0; i < ransomNote.length(); i++) {
    //         if (!hm.containsKey(ransomNote.charAt(i))) {
    //             return false;
    //         }
    //         if (hm.get(ransomNote.charAt(i))-1<=0) {
    //             hm.remove(ransomNote.charAt(i));
    //         }
    //         hm.put(ransomNote.charAt(i),hm.getOrDefault(ransomNote.charAt(i),0)-1);
    //     }
    //     return true;
    // }
    // public boolean isIsomorphic(String s, String t) {
    //     if (s.length()!=t.length()) {
    //         return false;
    //     }
    //     HashMap<Character,Character> hm =new HashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))!=t.charAt(i)) {
    //             return false;
    //         }
    //         else hm.put(s.charAt(i),t.charAt(i));
    //     }
    //     return true;
    // }
    // public boolean isValidSudoku(char[][] board) {
    //     for(int i=0;i<board.length;i++){
    //         for(int j=0;j<board[i].length;j++){
    //             if(Character.isDigit(board[i][j])){
    //                 if(!check(board,i,j,board[i][j])) return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // private boolean check(char[][] board,int row,int column,char n){
    //     for(int i=0;i<board[0].length;i++){
    //         if (i!=column) {
    //             if (board[row][i]==n) {
    //                 return false;
    //             }
    //         }
    //     }
    //     for(int i=0;i<board.length;i++){
    //         if (i!=row) {
    //             if (board[i][column]==n) {
    //                 return false;
    //             }
    //         }
    //     }
    //     int stcol=(column/3)*3;
    //     int strow=(row/3)*3;
    //     for(int i=strow;i<strow+3;i++){
    //         for(int j=stcol;j<stcol+3;j++){
    //             if (i!=row && j!=column) {
    //                 if (board[i][j]==n) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    public List<Integer> spiralOrder(int[][] matrix) {
        int strow=0;
        int stcol=0;

        int endrow=matrix
    }
    public static void main(String[] args) {
        
    }
}
