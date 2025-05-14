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
}