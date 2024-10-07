import java.util.*;
public class sumof10suri {
    public List<Integer> stableMountains(int[] height, int threshold) {
        int count=0;
        for (int i = 0; i < height.length; i++) {
            if (height[i-1]>threshold) {
                count++;
            }
        }    
    }
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        String arr[][]=new String[timePoints.size()][2];
        for(int i=0;i<n;i++){
            arr[i]=timePoints.get(i).split(':');
        }
        int minutes[]=new int[n];
        for(int i=0;i<n;i++){
            minutes[i]=Integer.parseInt(arr[i][0])*60+nteger.parseInt(arr[i][1]);
        }
        Arrays.sort(minutes);
        int minDiff=minutes[1]-minutes[0];
        for(int i=2;i<n;i++){
            minDiff=Math.min(minDiff, minutes[i]-minutes[i-1]);
        }
        return minDiff;
    }
    public int findKthNumber(int n, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<=9;i++){
            generate(i, n, arr);
        }
        return arr.get(k-1);
    }
    public void generate(int num,int n,ArrayList<Integer> arr){
        if (x>n) {
            return;
        }
        arr.add(num);
        for(int i=0;i<=9;i++){
            int newNum=num*10+i;
            if (newNum>n) {
                return;
            }
            generate(newNum,n, arr);
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int m=arr1.length,n=arr2.length;
        HashSet<String> one =new HashSet<>();
        HashSet<String> two=new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            String curr=Integer.toString(arr1[i]);
            for(int j=0;j<curr.length();j++){
                one.add(curr.substring(0, i+1));
            }
        }
        int maxLength=0;
        for (int i = 0; i < arr2.length; i++) {
            String curr=Integer.toString(arr2[i]);
            for(int j=0;j<curr.length();j++){
                String pre=curr.substring(0, i+1);
                if (one.contains(pre)) {
                    maxLength=Math.max(maxLength, pre.length());
                }
            }
        }
        return maxLength;
    }
    public int[] sumPrefixScores(String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String curr=words[i];
            for(int j=0;j<curr.length();j++){
                String sub=curr.substring(0, j+1);
                hm.put(sub, hm.getOrDefault(sub,0)+1);
            }
        }
        int ans[]=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String curr=words[i];
            int count=0;
            for(int j=0;j<curr.length();j++){
                String sub=curr.substring(0, j+1);
                count+=hm.get(sub);
            }
            ans[i]=count;
        }
        return ans;
    }
    public class Pair implements Comparable<Pair>{
        int start;
        int end;
        public Pair(Int s,int e){
            start=s;
            end=e;
        }
        @Override
        public int compareTo(Pair p2){
            return this.start-this.end;
        }
    }
    class MyCalendar {
        ArrayList<Pair> arr;
        public MyCalendar() {
            arr=new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            Pair newcurr=new Pair(start, end);
            arr.add(newcurr);
            Collections.sort(arr);
            for(int i=1;i<arr.size();i++){
                Pair curr=arr.get(i);
                if (curr.start<arr.get(i-1).end) {
                    return false;
                }
            }
            return true;
        }
    }
    public long maximumTotalSum(int[] maximumHeight) {
        HashSet<Integer> hs=new HashSet<>();
        long ans=0;
        for(int i=0;i<maximumHeight.length;i++){
            int currH=maximumHeight[i];
            if (!hs.contains(currH)) {
                ans+=currH;
            }
            else{
                while (hs.contains(currH)) {
                    currH--;
                }
                ans+=currH;
            }
            hs.add(currH);
        }
        return ans;
    }
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr=String.join(" ", s1,s2).split(" ");
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            boolean flag=true;
            if (flag && i>0 && arr[i].equals(arr[i-1]) ) {
                flag=false;
            }
            if (flag && i<arr.length-1 && arr[i].equals(arr[i+1]) ) {
                flag=false;
            }
            if (flag) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.toString().equals("")?new String[1]:sb.toString().trim().split(" ");
    }
    public int findTheLongestSubstring(String s) {
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                count[ch-'a']++;
            }
        }
        if (count[0]%2!=0) {
            
        }s.indexOf(, 0)

    }
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a"); 
        while (sb.length() < k) {
            for(int i=0;i<sb.length();i++){
                char curr=sb.charAt(i);
                int cu=(int)curr;
                char nextChar=(char)(cu+1);
                if (curr=='z') {
                    nextChar='z';
                }
                sb.append(nextChar);
            }
        }
        
        return sb.charAt(k - 1);
    }
    public int countOfSubstrings(String word, int k) {
        int count=0;
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<=word.length();j++){
                String substr=word.substring(i,j);
                if (check(substr)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean check(String word,int k){
        boolean a=false,e=false,i=false,o=false,u=false;
        int count=0;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if (!a && curr=='a') {
                a=true;
            }
            if (!e && curr=='e') {
                e=true;
            }if (!i && curr=='i') {
                i=true;
            }if (!o && curr=='o') {
                o=true;
            }if (!u && curr=='u') {
                u=true;
            }
            else count++;
        }
        if (a && e && i && o && u && count==k) {
            return true;
        }
        else return false;
    }
    class AllOne {
        HashMap<String,Integer> hm=new HashMap<>();
        
        public AllOne() {
            
        }
        
        public void inc(String key) {
            
        }
        
        public void dec(String key) {
            
        }
        
        public String getMaxKey() {
            
        }
        
        public String getMinKey() {
            
        }
    }
    public static void main(String[] args) {
        
    }
    
}