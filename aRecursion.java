import java.util.ArrayList;
import java.util.List;

public class aRecursion {
    public static int maxSubArray(int[] nums) {
        int currmax = Integer.MIN_VALUE , max = Integer.MIN_VALUE , n = nums.length;

        List<Integer> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
 
        for(int i = 0;i<n;i++){
            currmax = currmax+nums[i];
            if(currmax<0){
                currmax = 0;
                curr = new ArrayList<>(); 
            }  
            curr.add(nums[i]);
            if(currmax>max){
                max = currmax;
                ans = curr;
            }
        }

        for(Integer num : ans){
            System.out.print(num+"  ");
        }

        return max;
    }


    public static void main(String[] args) {
        int ans[] = {2, 3, 5, -2, 7, -4};
        System.out.println(maxSubArray(ans));
    }     
}  
    