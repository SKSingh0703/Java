public class subarraysum {
    public static void prefixmethod(int num[]){
        int currsum=0,maxsum=Integer.MIN_VALUE;
        int prefix[]=new int[num.length];
        prefix[0]=num[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+num[i];
        }
        for(int i=0;i<num.length;i++){
            for(int j=i;j<num.length;j++){
                currsum=i==0?prefix[j]:prefix[j]-prefix[i-1];
                System.out.println("SUM:"+ currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("Max sum is ;"+maxsum);
    }

    public static void main(String[] args){
        int number[]={1,2,3,4,-25};
        prefixmethod(number);
    }
}

