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
    public static void main(String[] args) {
        
    }
}
