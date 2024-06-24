public class trappingrainwater {
    public static int trappingwater(int height[]){
        int n=height.length;
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }

        int trappedwater=0;
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(leftmax[i],rightmax[i]);
            int x=waterlevel-height[i];
            if(x<0){
                x=0;
            }
            trappedwater+=x;
        }
        return trappedwater;
    }
    public static void main(String[] args) {
        int height[]={5,0,3,2,7,9,1,0,9,9,5,3,5,1};
        System.out.println(trappingwater(height));
    }
}
