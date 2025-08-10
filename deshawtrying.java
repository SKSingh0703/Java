public class deshawtrying {

    private static String helper(String str){
        String arr[] = str.split("/");

        if (arr.length != 2) {
            return "Invalid input";
        }

        try {
            int numerator = Integer.parseInt(arr[0]);
            int denominator = Integer.parseInt(arr[1]);

            if (denominator == 0) {
                return "Denominator cannot be zero";
            }

            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }

            return numerator + "/" + denominator;

        } catch (NumberFormatException e) {
            return "Invalid number format";
        }

        return "";
    } 
    
    public static void main(String[] args) {
        String arr = "123";
        
        helper("-134/112");
    }

    class Solution {
    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int curr = 1;
        hs.add(curr);

        while(curr<1_000_000_000){
            curr*=2;
            hs.add(curr);
        }

        while(n>0){
            arr.add(n%10);
            n/=10;
        }

        return helper(arr,new StringBuilder(),hs);
    }

    private boolean helper(ArrayList<Integer> arr , StringBuilder sb,HashSet<Integer> hs){
        if(arr.size()==0){ 
            if(sb.charAt(0)=='0') return false;
            int n = Integer.parseInt(sb.toString());
            // System.out.println(hs.contains(n)+"    "+sb);
            return hs.contains(n);
        }

        for(int i = 0;i<arr.size();i++){
            

            int digit = arr.remove(i);
            sb.append( digit );

            if(helper(arr,sb,hs)) return true;
            sb.deleteCharAt(sb.length()-1);
            arr.add(i ,digit);
        }

        return false;
    }
}
}
