public class kadanealogritm {
    public static void kadanesubarray(int num[]){
        int currsum=0,maxscum=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            currsum=currsum+num[i];
            if(currsum<0){
                currsum=0;
            }
            maxscum=Math.max(currsum,maxscum);
        }
        if(maxscum==0){
            maxscum=Integer.MIN_VALUE;
            for(int i=0;i<num.length;i++){
                if(maxscum<num[i]){
                    maxscum=num[i];
                }
            }

        }
        System.out.println(maxscum);

    }
    public static void main(String[] args) {
        int numbers[]={-6,-52,-78,-10,-56};
        kadanesubarray(numbers);
    }
}
