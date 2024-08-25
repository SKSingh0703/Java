import java.util.ArrayList;

public class ACMCQSIX {

    public int gcd(int a ,int b){
        if (a%b==0) {
            return b;
        }
        return gcd(b, a%b);
    }

    public String fractionAddition(String expression) {
        ArrayList<Integer> numerator=new ArrayList<>();
        ArrayList<Integer> denominator=new ArrayList<>();
        int i=0;
        while (i<expression.length()) {
            StringBuilder nr=new StringBuilder("");
            StringBuilder dr=new StringBuilder("");
            while (i<expression.length() && expression.charAt(i)!='/') {
                nr.append(expression.charAt(i));
                i++;
            }
            i++;
            numerator.add(Integer.parseInt(nr.toString()));
            while (i<expression.length() && (expression.charAt(i)!='+' || expression.charAt(i)!='-') ) {
                dr.append(expression.charAt(i));
                i++;
            }
            denominator.add(Integer.parseInt(dr.toString()));
        }
        int totalDr=denominator.get(0);
        for(int i=1;i<denominator.size();i++){
            totalDr=(totalDr*denominator.get(i))/(gcd(totalDr, denominator.get(i)));
        }
        int totalNr=0;
        for(int i=0;i<numerator.size();i++){
            totalNr+=numerator.get(i)*(totalDr/denominator.get(i));
        }
        if (totalNr==0) {
            return "0/1";
        }
        totGcd=gcd(totalDr, totalNr);
        totalNr=totalNr/totGcd;
        totalDr=totalDr/totGcd;

        String N=Integer.toString(totalNr);
        String D=Integer.toString(totalDr);

        String f=N+"/"+D;
        return f;
    }

    public int findComplement(int num) {
        String s=Integer.toBinaryString(num);
        int mul=1;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='0') {
                ans+=mul;
            }
            mul*=2;
        }
        return ans;
    }
    public String nearestPalindromic(String s) {
        int n=s.length();
        int val=Integer.parseInt(s);
        if (n==1) {
            int ans = Integer.parseInt(s)-1;
            return Integer.toString(ans);
        }
        StringBuilder firstHalf=new StringBuilder();
        StringBuilder secondHalf=new StringBuilder();
        if (n%2==0) {
            for(int i=1;i<=n;i++){
                if (i<=n/2) {
                    firstHalf.append(s.charAt(i-1));
                }
                else secondHalf.append(s.charAt(i-1));
            }
            StringBuilder s1=new StringBuilder("");
            s1.append(firstHalf.toString()).append(firstHalf.reverse().toString());

            StringBuilder s2=new StringBuilder("");
            s2.append(secondHalf.toString()).append(secondHalf.reverse().toString());

            int val1=Integer.parseInt(s1.toString());
            int val2=Integer.parseInt(s2.toString());

            int one=Math.abs(val1-val);
            int two=Math.abs(val2-val);
            if (one>two) {
                return Integer.toString(val1);
            }
            else return Integer.toString(val2);
        }
        else{
            char mid=s.charAt((n+1)/2 - 1);
            for(int i=1;i<=n;i++){
                if (i<=n/2){
                    firstHalf.append(s.charAt(i-1));
                }
                else if (i>(n+1)/2) {
                    secondHalf.append(s.charAt(i-1));
                }
            }
            StringBuilder s1=new StringBuilder("");
            s1.append(firstHalf.toString()).append(mid).append(firstHalf.reverse().toString());

            StringBuilder s2=new StringBuilder("");
            s2.append(secondHalf.toString()).append(mid).append(secondHalf.reverse().toString());

            int val1=Integer.parseInt(s1.toString());
            int val2=Integer.parseInt(s2.toString());

            int one=Math.abs(val1-val);
            int two=Math.abs(val2-val);
            if (one>two) {
                return Integer.toString(val1);
            }
            else return Integer.toString(val2);
            
        }
        System.out.println();
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int j=0;j<k;j++){
            int minimun=Integer.MAX_VALUE;
            int idx=-1;
            for(int i=0;i<nums.length;i++){
                if (nums[i]<minimun) {
                    minimun=nums[i];
                    idx=i;
                }
            }
            nums[idx]*=multiplier;
        }
        return nums;
    }
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }

    private boolean check(int x,int y){
        char num1[] = String.valueOf(x).toCharArray();
        char num2[] = String.valueOf(y).toCharArray();
        
        if (num1.length != num2.length) {
            return false;
        }
        
        for(int i=0;i<num1.length;i++){
            char temp2[]=String.valueOf(y).toCharArray();
            for(int j=i+1;j<num1.length;i++){
                char temp=temp2[j];
                temp2[j]=num1[i];
                num1[i]=temp;
            }
            if (areAlmostEqual(num1, temp2)) {
                return true;
            }
        }
        for(int i=0;i<num2.length;i++){
            char temp1[]=String.valueOf(x).toCharArray();
            for(int j=i+1;j<num2.length;i++){
                char temp=temp1[j];
                temp1[j]=num2[i];
                num2[i]=temp;
            }
            if (areAlmostEqual(num2, temp1)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean areAlmostEqual(char num1[],char num2[]) {
        if (num1.length != num2.length) {
            return false;
        }
        
        for(int i=0;i<num1.length;i++){
            if(num1[i]!=num2.[i]) return false;
        }
        
        return true;
    }

    public int min(int nums[]){
        int minimun=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minimun=Math.min(minimun, nums[i]);
        }
        return minimun;
    }
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(nums[i], nums[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean check(int x, int y) {
        char[] num1 = String.valueOf(x).toCharArray();
        char[] num2 = String.valueOf(y).toCharArray();

        if(num1.length==1 && num1[0]==num2[0]) return true;
        for (int i = 0; i < num1.length; i++) {
            for (int j = i + 1; j < num1.length; j++) {
                char[] temp1 = num1.clone();

                char temp = temp1[j];
                temp1[j] = temp1[i];
                temp1[i] = temp;

                if (areAlmostEqual(temp1,num2)) {
                    
                    return true;
                }
                System.out.println();
            }
        }
        for (int i = 0; i < num1.length; i++) {
            for (int j = i + 1; j < num1.length; j++) {
                char[] temp2 = num2.clone();
                
                char temp = temp2[j];
                temp2[j] = temp2[i];
                temp2[i] = temp;

                if (areAlmostEqual(num1, temp2)) {
                    
                    return true;
                }
            }
        }

        return false;
    }

    private boolean areAlmostEqual(char[] num1, char[] num2) {
        if (num1.length != num2.length) {
            return false;
        }

        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        
    }
}