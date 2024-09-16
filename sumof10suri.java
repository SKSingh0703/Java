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
    public static void main(String[] args) {
        
    }
    
}