public class ACMCQSIX {

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
    public static void main(String[] args) {
        
    }
}
