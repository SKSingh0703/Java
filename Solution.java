import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    static int count;
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int m=pairs.length,n=pairs[0].length;
        HashMap<Integer,Boolean> vis = new HashMap<>();
        for(int i=0;i<m;i++){
            int start=pairs[i][0];
            int end = pairs[i][1];
            hm.put(start, hm.getOrDefault(start, new ArrayList<>()).add(end));

            vis.put(start,false);
            vis.put(end, false);
        }
        for(int i=0;i<m;i++){
            if (!vis.get(pairs[i][0])) {
                count=0;

                dfs();
                
            }
        }
    }
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        HashMap<Integer,ArrayList> hm = new HashMap<>();

        for (int num : nums) {
            totalSum += num;
            hs.add(num);
        }
        for (int i = 0; i < n; i++){
            totalSum+=nums[i];
            hm.put(nums[i], hm.getOrDefault(nums[i], new ArrayList<>()).add(i));
        }
        

        int largestOutlier = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int specialElement = nums[i];
            int specialSum = totalSum - specialElement;
            if (specialSum%2==0 && hm.containsKey(specialSum/2) && helper(hm,specialSum/2,i)) {
                largestOutlier=Math.max(largestOutlier, specialElement);
            }
        }
        return largestOutlier;
    }
    public boolean helper(HashMap<Integer,ArrayList> hm,int target ,int idx){
        ArrayList<Integer> arr = hm.get(target);
        for (Integer integer : arr) {
            if (integer!=idx) {
                return true;
            }
        }
        return false;
    }
    public boolean checkIfExist(int[] arr) {
        return true;
    }
    static Node root;
    public class Node{
        Node arr[];
        boolean EOW;
        public Node(){
            arr=new Node[26];
            for(int i=0;i<26;i++){
                arr[i]=null;
            }
            EOW=false;
        }
    }
    public void insert(String str){
        Node temp=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if (temp.arr[idx]==null) {
                temp.arr[idx]=new Node();
            }
            temp=temp[idx];
        }
        temp.EOW=true;
    }
    public boolean search(String str){
        Node temp=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if (temp.arr[idx]==null) {
                return false;
            }
            temp=temp[idx];
        }
        return true;
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        String arr[]=sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
            if (search(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
