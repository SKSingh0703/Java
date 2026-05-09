public class aRecursion {
    public static double pow(double x , int n){
        if(n==1) return x;

        double hp = pow(x, n/2);

        return n%2==0?hp*hp:(hp*hp*x);
    }

    public static void main(String[] args) {
        System.out.println(pow(1.5, 2));
    }  
}
