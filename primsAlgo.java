/**
 * primsAlgo
 */
public class primsAlgo {
    public int strangePrinter(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                i++;
            }
        }
        int max=0;
        char ch='a';
        for(int i=0;i<26;i++){
            if (arr[i]>max) {
                max=arr[i];
                ch=(char)(i+'a');
            }
        }
        int count=1;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)!=ch) {
                count++;
                while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
          
    }
    class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String> ans1 = new ArrayList<>();
        ArrayList<String> ans2 = new ArrayList<>();

        int ch1 = 0;
        int ch2 = 1;

        for(int i = 0;i<words.length;i++){
            if(groups[i]==ch1){
                ans1.add(words[i]);
                ch1 = (ch1+1)%2;
            }
            if(groups[i]==ch2){
                ans2.add(words[i]);
                ch2 = (ch2+1)%2;
            }
        }
        System.out.println();

        return ans1.size()>=ans2.size()?ans1:ans2;
    }
    class Solution {
    public void sortColors(int[] nums) {
        int col[] = new int[3];

        for(int num : nums){
            col[num]++;
        }
        
        int k = 0;
        for(int i = 0;i<3;i++){
            while(col[i]!=0){
                nums[k++]=i;
                col[i]--;
            }
        }
        
        return;
    }
}
    
}
}