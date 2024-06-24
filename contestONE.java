import java.util.Arrays;
import java.util.*;


public class contestONE {
    public static void maxAlternatingSum(int A[]){
        Arrays.sort(A);
        int i,j,k;
        int B[]=new int[A.length];
        i=0;j=A.length-1;k=0;
        for(k=0;k<A.length;k++){
            if(i>j) break;
            if(k%2==0){
                B[k]=A[j];
                j--;
            }
            else{
                B[k]=A[i];
                i++;
            }
        }
        int ans=0;
        for(int l=0;l<A.length;l++){
            if(l%2==0) ans+=B[l];
            else ans-=B[l];
        }
        System.out.println(ans);
    
    }
    public static boolean checkSubsequence(String S){
        int x=-1,y=-1,z=-1;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='a'){
                x=i;
                for(int j=i;j<S.length();j++){
                    if(S.charAt(j)=='b'){
                        y=j;
                        for(int k=j;k<S.length();k++){
                            if(S.charAt(k)=='c'){
                                z=k;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        if(x==-1 || y==-1 ||z==-1 ) return false;
        else return true;
    }
    
    public static void countMoves(String S){
        int x=0,y=0;


        //new
        // int n=0;
        // int b[]=new int[S.length()];
        // for(int k=0;k<S.length();k++){
        //     b[k]=-1;
        // }
        // for(int i=0;i<S.length();i++){
        //     if(S.charAt(i)=='b'){
        //         b[n]=i;
        //         n++;
        //     }
        // }
        // int idxreq=-1;
        // int diff=Integer.MAX_VALUE;
        // for(int a=0;a<S.length();a++){
        //     if(b[a]!=-1){
        //         if(Math.abs(b[a]-(S.length()/2))<=diff) idxreq=a;
        //     }
        // }
        // for(int i=0;i<idxreq;i++){
        //     if(S.charAt(i)=='a') x++;
        // }
        // for(int j=idxreq;j<S.length();j++){
        //     if(S.charAt(j)=='c') y++;
        // }
        //ṇ
        // for(int i=0;i<S.length();i++){
        //     if(S.charAt(i)=='b'){
        //         for(int j=0;j<i;j++){
        //             if(S.charAt(j)=='a') x++;
        //         }
        //         for(int k=i;k<S.length();k++){
        //             if(S.charAt(k)=='c') y++;
        //         }
        //         if(x!=0 && y!=0) break;
        //     }
        // }
        int count=0;
        int z=0;
        while(checkSubsequence(S)){
            int a[]=new int[S.length()];
            int b[]=new int[S.length()];
            int acount=0,bcount=0;
            for(int i=0;i<S.length();i++){
                    if(S.charAt(i)=='b'){
                        for(int j=0;j<i;j++){
                            if(S.charAt(j)=='a'){
                                acount++;
                            } 
                        }
                        x[i]=acount;
                        for(int k=i;k<S.length();k++){
                            if(S.charAt(k)=='c') {
                                bcount++;
                            }
                        }
                        
                        if(x!=0 && y!=0) break;
                    }
                }
            
            if(x<=y){
                count++;
                for(int i=0;i<S.length();i++){
                    if(S.charAt(i)=='a'){
                        z=i;
                        break;
                    }
                }
                S=S.substring(0,z)+S.substring(z+1);
            }
            else{
                count++;
                for(int i=S.length()-1;i>=0;i--){
                    if(S.charAt(i)=='c'){
                        z=i;
                        break;
                    }
                }
                S=S.substring(0,z)+S.substring(z+1);
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int T,N;
        Scanner sc=new Scanner(System.in);
        
        T=sc.nextInt();
        
        String S=new String(" ");
        for(int i=0;i<T;i++){
            
            N=sc.nextInt();
            
            S=sc.next();
            
            countMoves(S);
        }
    }
}
