import java.util.ArrayList;
import java.util.Arrays;
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
    // public List<Integer> spiralOrder(int[][] matrix) {
    //     int strow=0;
    //     int stcol=0;
    //     List<Integer> ans=new ArrayList<>();
    //     int endrow=matrix.length;
    //     int endcol=matrix[0].length;
    //     while (stcol<=endcol && strow<=endrow) {
    //         for(int i=stcol;i<=endcol;i++){
    //             ans.add(matrix[strow][i]);
    //         }
    //         strow++;
    //         for(int i=strow;i<=endrow;i++){
    //             ans.add(matrix[i][endcol]);
    //         }
    //         endcol--;
    //         for(int i=endcol;i>=stcol;i--){
    //             ans.add(matrix[endrow][i]);
    //         }
    //         endrow--;
    //         for(int i=endrow;i>=strow;i--){
    //             ans.add(matrix[i][stcol]);
    //         }
    //         stcol++;
    //     }
    //     return ans;
    // }
    // public boolean wordPattern(String pattern, String s) {
    //     String st[]=s.split("\\s+");
    //     HashMap<Character,String> hm=new HashMap<>();
    //     HashSet<String> hs=new HashSet<>();

    //     if (pattern.length()!=st.length) {
    //         return false;
    //     }
    //     for (int i = 0; i < st.length; i++) {
    //         if (hm.containsKey(pattern.charAt(i))) {
    //             if (!hm.get(pattern.charAt(i)).equals(st[i])) {
    //                 return false;
    //             }
    //         }
    //         else if(hs.contains(st[i])) return false;
    //         else{
    //             hm.put(pattern.charAt(i),st[i]);
    //             hs.add(st[i]);
    //         }
    //     }
    //     return true;
    // }
    // public List<Integer> findSubstring(String s, String[] words) {
    //     List<Integer> ans=new ArrayList<>();

    //     int size=0;
    //     HashMap<String,Integer> hm=new HashMap<>();
    //     for (int i = 0; i < words.length; i++) {
    //         size+=words[i].length();
    //         hm.put(words[i],hm.getOrDefault(words[i],0)+1);
    //     }

    //     int l=0;
    //     int n=words[0].length();

    //     StringBuilder currWord=new StringBuilder("");

    //     for(int i=0;i<s.length();i+=n){
    //         if(i>=s.length()-n-1) break;
    //         String wordInConsideration=s.substring(i,i+n);
    //         if (!checkIfcanTakeInWindow(wordInConsideration,currWord,hm,n)) {
    //             l=i;
    //         }
    //         else{
    //             currWord.append(wordInConsideration);
    //         }
    //         if (currWord.length()==size) {
    //             if (checkIfPermutation(currWord,words)) {
    //                 ans.add(l);
    //                 l=i;
    //                 currWord=new StringBuilder("");
                    
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // private boolean checkIfcanTakeInWindow(String toCheck,String currWindow,HashMap<String,Integer> hm,int n){
    //     if (!hm.containsKey(toCheck)) {
    //         return false;
    //     }
    //     int freq=1;
    //     for(int i=0;i<currWindow.length();i+=n){
    //         String c=currWindow.substring(i,i+n);
    //         if (c.equals(toCheck)) {
    //             freq++;
    //         }
    //     }
    //     if (hm.get(toCheck)<=freq) {
    //         return true;
    //     }
    //     else return false;
    // }
    // private boolean checkIfPermutation(String currWindow,HashMap<String,Integer> hm,int n){
    //     HashMap<String,Integer> tempHm=new HashMap<>();
    //     for (int i = 0; i < currWindow.length(); i++) {
    //         String curr=currWindow.substring(i, i+n);
    //         tempHm.put(curr,tempHm.getOrDefault(curr,0)+1);
    //         if (!hm.containsKey(curr)) {
    //             return false;
    //         }
    //         else{
    //             if (!(tempHm.get(curr)<=hm.get(curr))) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
        
    // }
    // public boolean isAnagram(String s, String t) {
    //     int n=s.length();
    //     int m=t.length();
    //     if (n!=m) {
    //         return false;            
    //     }
    //     int freq[]=new int[26];
    //     for (int i = 0; i < n; i++) {
    //         freq[s.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<m;i++){
    //         if (freq[t.charAt(i)]==0) {
    //             return false;
    //         }
    //         else freq[t.charAt(i)]--;
    //     }
    //     return true;
    //   }
    // public void rotate(int[][] matrix) {
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = i+1; j < matrix[0].length; j++) {
    //             int temp=matrix[j][i];
    //             matrix[j][i]=matrix[i][j];
    //             matrix[i][j]=temp;
    //         }
    //     }
    //     for (int i = 0; i < matrix.length; i++) {
    //         int l=0;
    //         int r=matrix[0].length-1;
    //         while (l<r) {
    //             int temp=matrix[i][r];
    //             matrix[i][r]=matrix[i][l];
    //             matrix[i][l]=temp;

    //             l++;
    //             r--;
    //         }
    //     }
    // }
    // public void setZeroes(int[][] matrix) {
    //     int clone[][]=matrix.clone();
    //     for (int i = 0; i < clone.length; i++) {
    //         for (int j = 0; j < clone[0].length; j++) {
    //             if (matrix[i][j]==0) {
    //                 for (int j2 = 0; j2 < clone.length; j2++) {
    //                     clone[i][j2]=0;
    //                 }
    //                 for (int j2 = 0; j2 < clone.length; j2++) {
    //                     clone[j2][j]=0;
    //                 }
    //             }
    //         }
    //     }
    //     matrix=clone.clone();
    // }
    // public void setZeroes(int[][] matrix) {
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if (matrix[i][j]==0) {
    //                 matrix[i][0]=0;
    //                 matrix[0][j]=0;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < matrix.length; i++) {
    //         if (matrix[i][0]==0) {
    //             for (int j = 0; j < matrix[0].length; j++) {
    //                 matrix[i][j]=0;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < matrix[0].length; i++) {
    //         if (matrix[0][j]==0) {
    //             for (int j = 0; j < matrix[0].length; j++) {
    //                 matrix[j][i]=0;
    //             }
    //         }
    //     }
    // }
    // public void setZeroes(int[][] matrix) {
    //     int ans[][]=matrix.clone();
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if (matrix[i][j]==0) {
    //                 for (int j2 = 0; j2 < ans.length; j2++) {
    //                     ans[j2][j]=0;
    //                 }
    //                 for (int j2 = 0; j2 < ans[0].length; j2++) {
    //                     ans[i][j2]=0;
    //                 }
    //             }
    //         }
    //     }
    //     for (int i = 0; i < ans.length; i++) {
    //         for (int j = 0; j < ans.length; j++) {
    //             matrix[i][j]=ans[i][j];
    //         }
    //     }   
    // }
    // public int[] plusOne(int[] digits) {
    //     int carry=0;
    //     if (digits[digits.length-1]+1>9) {
    //         digits[digits.length-1]=0;
    //         carry=1;
    //         for (int i = digits.length-2; i >=0; i--) {
    //             if (digits[i]+carry>9) {
    //                 digits[i]=0;
    //                 carry=(digits[i]+carry)-9;
    //                 if (carry<0) {
    //                     carry==0;
    //                 }
    //             }
    //         }
    //         if (carry>0) {
    //             int ans[]=new int[digits.length+1];
    //             ans[0]=1;
    //             for (int j = 1; j < ans.length; j++) {
    //                 ans[j]=digits[j-1];
    //             }
    //             return ans;
    //         }
    //     }
    //     else{
    //         digits[digits.length-1]++;
    //     }
        
    //     return digits;
    // }
    // public void gameOfLife(int[][] board) {
    //     int neighbours=0;
    //     for (int i = 0; i < board.length; i++) {
    //         for (int j = 0; j < board.length; j++) {
    //             neighbours=0;
    //             if(i-1>=0){
    //                 if (board[i-1][j]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (i-1>=0 && j-1>=0) {
    //                 if (board[i-1][j-1]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (i-1>=0 && j+1<board[0].length) {
    //                 if (board[i-1][j+1]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (j-1>=0) {
    //                 if (board[i][j-1]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (j+1<board[0].length) {
    //                 if (board[i][j+1]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (i+1<board.length && j-1>=0) {
    //                 if (board[i+1][j-1]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (i+1<board.length) {
    //                 if (board[i+1][j]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (i+1<board.length && j+1<board[0].length) {
    //                 if (board[i-1][j]==1) {
    //                     neighbours++;
    //                 }
    //             }
    //             if (board[i][j]==1) {
    //                 if (neighbours<2) {
    //                     board[i][j]=0;
    //                 }
    //                 else if(neighbours<=3){
    //                     board[i][j]=1;
    //                 }
    //                 else{
    //                     board[i][j]=0;
    //                 }
    //             }
    //             else{
    //                 if (neighbours==3) {
    //                     board[i][j]=1;
    //                 }
    //             }
    //         }
    //     }
    // }
    // public class UnionFind{
    //     int rank[];
    //     int parent[];

    //     public UnionFind(int n){
    //         rank=new int[n];
    //         parent=new int[n];
    //         for (int i = 0; i < parent.length; i++) {
    //             parent[i]=i;
    //             rank[i]=1;
    //         }
    //     }

    //     public int find(int x){
    //         if (parent[x]!=x) {
    //             parent[x]=find(parent[x]);
    //         }
    //         return parent[x];
    //     }

    //     public boolean union(int x,int y){
    //         int rootX=find(x);
    //         int rootY=find(y);

    //         if (rootX==rootY) {
    //             return false;
    //         }
    //         if (rank[rootX]>rank[rootY]) {
    //             parent[rootY]=rootX;
    //         }
    //         else if(rank[rootX]<rank[rootY]){
    //             parent[rootX]=rootY;
    //         }
    //         else{
    //             parent[rootY]=rootX;
    //             rank[rootX]++;
    //         }
    //         return true;
    //     }
    // }
    // public int maxNumEdgesToRemove(int n, int[][] edges){
    //     UnionFind ufA=new UnionFind(n+1);
    //     UnionFind ufB=new UnionFind(n+1);
    //     int edgesAdded=0;

    //     for (int[] edge : edges) {
    //         if (edge[0]==3) {
    //             if (ufA.union(edge[1],edge[2])==true && ufB.union(edge[1],edge[2])==true) {
    //                 edgesAdded++;
    //             }
    //         }
    //     }

    //     for (int[] edge : edges) {
    //         if (edge[0]==1) {
    //             if (ufA.union(edge[1],edge[2])){
    //                 edgesAdded++;
    //             }
    //         }
    //         else if (edge[0]==2) {
    //             if (ufB.union(edge[1],edge[2])) {
    //                 edgesAdded++;
    //             }
    //         }
    //     }

    //     int compA=0,compB=0;

    //     for (int i = 1; i <= n; i++) {
    //         if(ufA.find(i)==i) compA++;
    //         if(ufB.find(i)==i) compB++; 
    //     }

    //     if (compA!=1 || compB!=1) {
    //         return -1;
    //     }

    //     return edges.length-edgesAdded;
    // }
    // public List<String> summaryRanges(int[] nums) {
    //     List<String> ans=new ArrayList<>();
    //     int l=nums[0];
    //     int r=nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i]!=r+1) {
    //             if (l==r) {
    //                 String x=l;
    //                 ans.add(x);
    //             }
    //             else{
    //                 String c=l+"->"+r;
    //                 ans.add(c);
    //             }
    //             l=r=nums[i];
    //         }
    //         else{
    //             r+=1;
    //         }
    //     }
    //     return ans;
    // }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans=new ArrayList<>();
        int l=0;
        int r=0;
        for (int i = 0; i < intervals.length; i++) {
            l=intervals[i][0];
            r=intervals[i][1];
            while (i<intervals.length && r>intervals[i+1][0]) {
                r=intervals[i+1][1];
                i++;
            }
            ans.add(new int[]{l,r});
        }
        int a[][]=new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            for(int j=0;j<ans.get(i).length;i++){
                a[i][j]=ans.get(i)[j];
            }
        }
        return a;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr=new ArrayList<>();
        int l=0;
        int r=0;
        int startOfnew=newInterval[0];
        int endOfnew=newInterval[1];
        for(int i=0;i<intervals.length;i++){
            l=intervals[i][0];
            r=intervals[i][1];

            if (l>startOfnew) {
                
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(curr);
    }
}
