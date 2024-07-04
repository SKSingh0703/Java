import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;

import TwoPointerApproach.ListNode;

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
    // public int[][] merge(int[][] intervals) {
    //     Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    //     ArrayList<int[]> ans=new ArrayList<>();
    //     int l=0;
    //     int r=0;
    //     for (int i = 0; i < intervals.length; i++) {
    //         l=intervals[i][0];
    //         r=intervals[i][1];
    //         while (i<intervals.length && r>intervals[i+1][0]) {
    //             r=intervals[i+1][1];
    //             i++;
    //         }
    //         ans.add(new int[]{l,r});
    //     }
    //     int a[][]=new int[ans.size()][2];
    //     for (int i = 0; i < ans.size(); i++) {
    //         for(int j=0;j<ans.get(i).length;i++){
    //             a[i][j]=ans.get(i)[j];
    //         }
    //     }
    //     return a;
    // }
    // public int[][] insert(int[][] intervals, int[] newInterval) {
    //     ArrayList<int[]> arr=new ArrayList<>();
    //     int l=0;
    //     int r=0;
    //     int startOfnew=newInterval[0];
    //     int endOfnew=newInterval[1];
    //     boolean flag=true;
    //     if (intervals.length==0) {
    //         int x[][]=new int[1][2];
    //         x[0][1]=startOfnew;
    //         x[0][2]=endOfnew;
    //         return x;
    //     }
    //     for(int i=0;i<intervals.length;i++){
    //         l=intervals[i][0];
    //         r=intervals[i][1];

    //         if (l>endOfnew ) {
    //             if (flag) {
    //                 arr.add(new int[]{startOfnew,endOfnew});
    //                 flag=false;
    //             }
    //             arr.add(new int[]{l,r});
                
    //         }
    //         else if (r<startOfnew) {
    //             arr.add(new int[]{l,r});
    //         }
    //         else{
    //             if (startOfnew>l) {
    //                 r=Math.max(endOfnew,r);
    //                 while (i<intervals.length-1 && intervals[i+1][0]<=r) {
    //                     r=Math.max(r, intervals[i+1][0]);
    //                     i++;
    //                 }
    //                 arr.add(new int[]{l,r});
    //             }
    //         }
    //     }
    //     int ans[][]=new int[arr.size()][2];
    //     for(int i=0;i<arr.size();i++){
    //         for (int j = 0; j <2; j++) {
    //             ans[i][j]=arr.get(i)[j];
    //         }
    //     }
    //     return ans;
    // }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> ans=new ArrayList<>();
    //     boolean vis[]=new boolean[strs.length];
    //     for(int i=0;i<strs.length;i++){
    //         if (!vis[i]) {
    //             vis[i]=true;
    //             ans.add(strs[i]);
    //             for(int j=i+1 ;j<strs.length;j++){
    //                 if (!vis[j]) {
    //                     if (isAnagram(strs[i],strs[j])) {
    //                         vis[j]=true;
    //                         ans.add(strs[j]);
    //                     }
    //                 }
    //             }                
    //         }
    //     }
    //     return ans;
    // }
    // private boolean isAnagram(String s1,String s2){
    //     if(s1.length()!=s2.length()) return false;
    //     int str1[]=new int[26];
    //     for(int i=0;i<s1.length();i++){
    //         str1[s1.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<s2.length();i++){
    //         if (str1[s2.charAt(i)-'a']<=0) {
    //             return false;
    //         }
    //         str1[s2.charAt(i)-'a']--;
    //     }
    //     return true;
    // }
    // public String simplifyPath(String path) {
    //     String arr[]=path.split("/");
    //     Stack<String> s=new Stack<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         s.push(arr[i]);
    //     }
    //     Stack<String> r=new Stack<>();
    //     while (!s.isEmpty()) {
    //         String curr=s.pop();
    //         if (curr.equals(".")) {
    //             continue;
    //         }
    //         else if(curr.equals("..")){
    //             s.pop();
    //         }
    //         else{
    //             if(!curr.isBlank()) r.push(curr);
    //         }
    //     }
    //     StringBuilder sb=new StringBuilder("/");
    //     while (r.isEmpty()) {
    //         String curr=r.pop();
    //         sb.append(curr);
    //         sb.append("/");
    //     }
    //     if (sb.length()>1) {
    //         return sb.toString().substring(0,sb.length()-1);
    //     }
    //     else return sb.toString();
    // }
    // public boolean threeConsecutiveOdds(int[] arr) {
    //     int l=0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i]%2==0) {
    //             l=i;
    //         }
    //         if (i-l>=2) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // class MinStack {
    //     Stack<Integer> s;
    //     Stack<Integer> min;
    //     public MinStack() {
    //         this.s=new Stack<>();
    //         this.min=new Stack<>();
    //     }
        
    //     public void push(int val) {
    //         s.push(val);
    //         while(!min.isEmpty() && min.peek()>=val){
    //             min.pop();
    //         }
    //         min.push(val);
    //     }
        
    //     public void pop() {
    //         int x=s.pop();
    //         if (x<=min.peek()) {
    //             while(!min.isEmpty() && min.peek()>=val){
    //                 min.pop();
    //             } 
    //         }
    
    //     }
        
    //     public int top() {
    //         return s.peek();
    //     }
        
    //     public int getMin() {
    //         return min.peek();
    //     }
    // }
    // public int evalRPN(String[] tokens) {
    //     Stack<Integer> s=new Stack<>();
    //     for (String token : tokens) {
    //         if (check(token)) {
    //             int b=s.pop();
    //             int a=s.pop();
    //             int c=evaluate(a, b, token);
    //             s.push(c);
    //         }
    //         s.push(Integer.parseInt(token));
    //     }
    //     return s.pop();
    // }
    // private boolean check(String s){
    //     if(s.equals("+")) return true;
    //     if(s.equals("-")) return true;
    //     if(s.equals("/")) return true;
    //     if(s.equals("*")) return true;
    //     return false;
    // }
    // private int evaluate(int a,int b,String op){
    //     if(op.equals("+")) return a+b;
    //     if(op.equals("-")) return a-b;
    //     if(op.equals("/")) return a/b;
    //     if(op.equals("*")) return a*b;
    //     return 1;
    // }
    // public boolean equalFrequency(String word) {
    //     for (int i = 0; i < word.length(); i++) {
    //         if (check(word, i)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // private boolean check(String word,int idx){
    //     int freq[]=new int[26];
    //     for(int i=0;i<word.length();i++){
    //         if (i!=idx) {
    //             freq[word.charAt(i)-'a']++;
    //         }
    //     }
    //     int constant=freq[word.charAt(0)-'a'];
    //     for (int i = 0; i < freq.length; i++) {
    //         if (freq[i]!=0) {
    //             if (freq[i]!=constant) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    //     List<Boolean> ans=new ArrayList<>();
    //     int max=Integer.MIN_VALUE;
    //     for (int i = 0; i < candies.length; i++) {
    //         max=Math.max(max, candies[i]);
    //     }
    //     for (int i = 0; i < candies.length; i++) {
    //         if (candies[i]+extraCandies>=max) {
    //             ans.add(true);
    //         }
    //         else ans.add(false);
    //     }
    //     return ans;
    // }
    // class Node {
    // int val;
    // Node next;
    // Node random;

    // public Node(int val) {
    //     this.val = val;
    //     this.next = null;
    //     this.random = null;
    // }
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     if (head==null || head.next==null) {
    //         return head;
    //     }
    //     int position=1;
    //     ListNode x=new ListNode(0);
    //     ListNode y=new ListNode(0);
    //     ListNode prevX=null;
    //     ListNode prevY=null;

    //     ListNode temp=head;

    //     while (temp.next!=null) {
    //         if (position==left-1) {
    //             prevX=temp;
    //         }
    //         if (position==left) {
    //             x=temp;
    //         }
    //         if (position==right-1) {
    //             prevY=temp;
    //         }
    //         if (position==right) {
    //             y=temp;
    //         }
    //         position++;
    //         temp=temp.next;
    //     }

    //     ListNode nextX=x.next;
    //     ListNode nextY=y.next;

    //     prevX.next=y;
    //     prevY.next=x;

    //     x.next=nextY;
    //     y.next=nextX;

    //     return head;
    // }
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode dummyHead=new ListNode(0);
    //     dummyHead.next=head;
    //     ListNode dummy=dummyHead.next;

    //     while (dummy.next!=null) {
    //         ListNode prev=null;
    //         ListNode curr=dummy;

    //         for(int i=0;i<k;i++){
    //             ListNode next=curr.next;
    //             curr.next=prev;
    //             prev=curr;
    //             curr=next;
    //         }

    //     }
    //     return dummyHead.next;
    // }
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     int freq[]=new int[1001];
    //     for(int i=0;i<nums1.length;i++){
    //         freq[nums1[i]]++;
    //     }
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     for (int i = 0; i < nums2.length; i++) {
    //         if (freq[nums2[i]]>0) {
    //             ans.add(nums2[i]);
    //             freq[nums2[i]]--;
    //         }
    //     }
    //     return ans.toArray(int[] a);
    // }
    // public int getLastMoment(int n, int[] left, int[] right) {
    //     boolean l=true;
    //     boolean r=true;
    //     int time=0;
    //     while (l || r) {
    //         time++:
    //         if (l) {
    //             for(int i=0;i<left.length;i++){
    //                 left[i]--;
    //             }
    //             boolean check=true;
    //             for (int i = 0; i < left.length; i++) {
    //                 if (left[i]>0) {
    //                     check=false;
    //                     break;
    //                 }
    //             }
    //             if (check) {
    //                 l=false;
    //             }
    //         }
    //         if (r) {
    //             for(int i=0;i<right.length;i++){
    //                 right[i]++;
    //             }
    //             boolean check=true;
    //             for (int i = 0; i < right.length; i++) {
    //                 if (right[i]<n) {
    //                     check=false;
    //                     break;
    //                 }
    //             }
    //             if (check) {
    //                 r=false;
    //             }
    //         }
    //     }
    //     return time;
    // }
    // public double myPow(double x, int n) {
    //     return helper(x,n);
    // }
    // private int helper(int x,int n){
    //     if (n==1) {
    //         return x;
    //     }
    //     if (n==0) {
    //         return 1;
    //     }
    //     int xpowNby2=helper(x, n/2);
    //     if (n%2==0) {
    //         return xpowNby2*xpowNby2
    //     }
    //     else return xpowNby2*xpowNby2*x;
    // }
    // public class LRUCache {
    //     HashMap<Integer,Integer> hm;
    //     int capacity;
    //     HashMap<Integer,Integer> freq;
    //     public LRUCache(int capacity) {
    //         this.capacity=capacity;
    //         hm=new HashMap<>();
    //         freq=new HashMap<>();
    //     }
        
    //     public int get(int key) {
    //         if (hm.containsKey(key)) {
    //             freq.put(key,freq.getOrDefault(key,0)+1);
    //             return hm.get(key);
    //         }
    //         else return -1;
    //     }
        
    //     public void put(int key, int value) {
    //         if (key<=capacity) {
    //             hm.put(key,value);
    //             freq.put(key,freq.getOrDefault(key,0)+1);
    //         }
    //         else{
    //             int minValue=Integer.MAX_VALUE;
    //             for (Map.Entry(Integer,Integer) entry : freq.entrySet()) {
    //                 if (entry.keySet) {
                        
    //                 }
    //             }

    //         }
    //     }
    // }
    public class ListNode {
        *     int val;
        *     ListNode next;
        *     ListNode() {}
        *     ListNode(int val) { this.val = val; }
        *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        * }
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode dummyHead=new ListNode(0,head);
    //     ListNode dummy=dummyHead.next;

    //     while (head.next!=null) {
    //         dummy=head;
    //         while (head.val==head.next.val) {
    //             head=head.next;
    //         }
    //         dummy=dummy.next;
    //     }

    //     return dummyHead.next;
    // }
    // public ListNode reverseList(ListNode head) {
    //     if (head==null || head.next==null) {
    //         return head;
    //     }
    //     ListNode prev=null;
    //     ListNode dummyHead=new ListNode(0,head);
    //     ListNode next=head.next;
    //     while (head.next!=null) {
    //         next=head.next;
    //         head.next=prev;
    //         prev=head;
    //         head=next;
    //     }

    //     return dummyHead.next;
    // }
    // public boolean isPalindrome(ListNode head) {
    //     ListNode slow=head;
    //     ListNode fast=head;
    //     //To find th midPoint
    //     while (fast!=null && fast.next!=null) {
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     //To reverse the second half
    //     ListNode prev=null;
    //     ListNode curr=slow;
    //     ListNode next=curr.next;

    //     while (curr!=null) {
    //         next=curr.next;
    //         curr.next=prev;
    //         prev=next;
    //         curr=next;
    //     }
    //     //To check
    //     ListNode head2=prev;
    //     while (head2.next!=null) {
    //         if (head.val!=head2.val) {
    //             return false;
    //         }
    //         head=head.next;
    //         head2=head2.next;
    //     }

    //     return true;
    // }
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode dummy1=headA;
    //     ListNode dummy2=headB;

    //     while (dummy1!=null) {
    //         ListNode curr=dummy2;
    //         while (curr!=null) {
    //             if (dummy1.val==curr.val) {
    //                 return dummy1;
    //             }
    //             curr=curr.next;
    //         }
    //         dummy2=dummy2.next;
    //     }
    //     return null;
    // }
    // public int minDifference(int[] nums) {
    //     if(nums.length<5) return 0;
    //     Arrays.sort(nums);

    //     int min=Integer.MAX_VALUE;
    //     int max=Integer.MAX_VALUE;

    //     int minRemoval=0;
    //     for(int i=3;i<nums.length;i++){
    //         min=Math.min(min, nums[i]);
    //         max=Math.max(max, nums[i]);
    //     }
    //     minRemoval=max-min;

    //     min=Integer.MAX_VALUE;
    //     max=Integer.MIN_VALUE;

    //     int maxRemoval=0;
    //     for(int i=0;i<nums.length-2;i++){
    //         min=Math.min(min, nums[i]);
    //         max=Math.max(max, nums[i]);
    //     }
    //     maxRemoval=max-min;

    //     return Math.min(minRemoval, maxRemoval);
    // }
    // public int minDifference(int[] nums) {
    //     if(nums.length<5) return 0;
    //     Arrays.sort(nums);

    //     int l=nums.length;
    //     int r=2;
    //     int minAbsDiff=Integer.MAX_VALUE;
    //     while (r>=0) {
    //         int min=Integer.MAX_VALUE;
    //         int max=Integer.MIN_VALUE;
    //         for(int i=r+1;i<l;i++){
    //             min=Math.min(min, nums[i]);
    //             max=Math.max(max, nums[i]);
    //         }
    //         int minDiff=max-min;
    //         r--;
    //         l--;
    //         minAbsDiff=Math.min(minDiff, minAbsDiff);
    //     }
    //     return minAbsDiff;
    // }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        ListNode curr=slow;
        ListNode next=null;

        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode head2=prev;
        ListNode head1=head;

        while (head2!=null) {
            head=new ListNode(head1.val);
            head.next=new ListNode(head2.val);

            head=head.next.next;
            head1=head1.next;
            head2=head2.next;
        }
    }

    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int t=sc.nextInt();
        // for(int j=0;j<t;j++){
        //     int n=sc.nextInt();
        //     int k=sc.nextInt();
        //     int h=sc.nextInt();

        //     long minDisInOneJump=h/k;
        //     if (h%k!=0) {
        //         minDisInOneJump+=1;
        //     }           
        //     long ways=0;
        //     for(int i=1;i<=n;i++){
        //         long jumpPower=i;
        //         long slippinessALlowed=i-minDisInOneJump;
        //         if (jumpPower>=h) {
        //             ways+=n;
        //         }
        //         else if (slippinessALlowed>0) {
        //             ways+=slippinessALlowed;
        //         }
        //     }
        //     System.out.println(ways);
        // }
}
