public class arrayhomework {
    public static boolean checkifsame(int num[]){
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]==num[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static int searchforpivoted(int num[]){
        int x=0;
        for(int i=0;i<num.length;i++){
            if(num[i+1]<num[i]){
                return x=i+1;
            }
        }
        return x;
    }
    public static int arraysearch(int num[],int target){
        int x=searchforpivoted(num);
        int y=num.length;
        int z=Integer.MAX_VALUE;
        if(num[y-1]>target){
            int start=x,end=y-1;
            while(start<end){
                int mid=(start+end)/2;
                if(num[mid]==target){
                    z= mid;
                    break;
                }
                else if(num[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        else if(num[y-1]<target){
            int start=0,end=x-1;
            while(start<end){
                int mid=(start+end)/2;
                if(num[mid]==target){
                    z=mid;
                    break;
                }
                else if(num[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        else{
            z=-1;
        }
        return z;

    }
    //{1,2,3,4,5,6,7,8,9,10}
    public static int stockprices(int prices[]){
        int buyprice=prices[0];
        int currprofit=0;
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            if(buyprice<prices[i]){
                currprofit=buyprice-prices[i];
                maxprofit=Math.max(maxprofit,currprofit);
                
            }
            else{
                buyprice=prices[i];
                
            }
            
        }
        return maxprofit;
    }

    public static int rainwater(int num[]){
        //leftmax
        int leftmax[]=new int[num.length];
        leftmax[0]=num[0];
        for(int i=1;i<num.length;i++){
            leftmax[i]=Math.max(leftmax[i-1],num[i]);
        }
        //rightmax
        int rightmax[]=new int[num.length];
        rightmax[num.length-1]=num[num.length-1];
        for(int i=num.length-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],num[i]);
        }
        int waterstored=0;
        for(int i=0;i<num.length;i++){
            int waterlevel=0;
            waterlevel=Math.min(leftmax[i],rightmax[i]);
            waterstored+=waterlevel-num[i];
        }
        return waterstored;
    }
    public static void triplets(int num[]){
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                for(int k=j+1;k<num.length;k++){
                    if(num[i]+num[j]+num[k]==0){
                        System.out.println("["+num[i]+","+num[j]+","+num[k]+"]");
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        int numbers[]={-1,0,1,2,-1,-4};
        int target=3;
        
        // System.out.println(checkifsame(numbers));
        // System.out.println(stockprices(numbers));
        System.out.println(arraysearch(numbers, target));
        // System.out.print(rainwater(numbers));
        // 
        // int min=minSearch(numbers);
        // System.out.println(min);
    }
}
