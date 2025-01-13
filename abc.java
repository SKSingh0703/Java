import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
                int xor = prefix[i]^prefix[j];
                if(i==j) xor=a[i];
                System.out.println(i+"  "+j+"  "+xor);
                if(xor==b) count++;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
    }
}






