import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class abc {
    public static int solve(int[] a, int b) {
        int n = a.length;
        int prefix[] = new int[n];
        prefix[0]=a[0];
        
        for(int i=1;i<n;i++){
            prefix[i]=(prefix[i-1]^a[i]);
        }                 
        int count =0;    
          
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                if(i==0) xor=prefix[j];
                else xor = (prefix[i-1]^prefix[j]);
                if(i==j) xor=a[i];
                System.out.println(i+"  "+j+"  "+xor);
                  if(xor==b) count++;
            }    
        }         
        
        return count;
    }
    public int reversePairs(int[] nums) {
        
    }  
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int inc = 0;
            int dec = 0;
            int ans = 1;
    
            for(int i = 1;i<nums.length;i++){
                if(nums[i]>nums[i-1]){
                    inc++;
                }
                else inc=0;
                if(nums[i]<nums[i-1]){
                    dec++;
                }
                else dec=0;
    
                ans = Math.max(ans,1+Math.max(inc,dec));
            }
    
            return ans;
        }
    }
    class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                hm.put(nums[i]*nums[j],hm.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            int curr = entry.getValue();
            ans += (curr*(curr-1))*4;
        }

        return ans;
    }
}
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int sum = nums[0];
            int ans = nums[0];
            for(int i = 1;i<nums.length;i++){
                if(nums[i]<=nums[i-1]){
                    sum=nums[i];
                }
                else sum+=nums[i];
    
                ans=Math.max(ans,sum);  
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9};
        int B = 5;
        System.out.println(solve(A, B));
    }
}






