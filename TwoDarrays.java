import java.util.*;
public class TwoDarrays {
    public static void input(int num[][]){
        Scanner sc =new Scanner(System.in);
        int m=num.length,n=num[0].length;
        System.out.println("Enter number:");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                num[i][j]=sc.nextInt();
            }
        }
        sc.close();
    }

    public static int minvalue(int num[][]){
        int min=Integer.MAX_VALUE;
        int m=num.length,n=num[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                min=Math.min(min,num[i][j]);
            }
        }
        return min;
    }

    public static int maxvalue(int num[][]){
        int max=Integer.MIN_VALUE;
        int m=num.length,n=num[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,num[i][j]);
            }
        }
        return max;
    }

    public static void printSpiral(int num[][]){
        int startrow=0,endrow=num.length-1;
        int startcol=0,endcol=num[0].length-1;
        while(startrow<=endrow && startcol<=endcol){
            for(int i=startcol;i<=endcol;i++){
                System.out.print(num[startrow][i]+ " ");
            }
            startrow++;
            for(int j=startrow;j<=endrow;j++){
                if(startcol==endcol) break;
                System.out.print(num[j][endcol]+ " ");
            }
            endcol--;
            for(int i=endcol;i>=startcol;i--){
                if(startrow==endrow) break;
                System.out.print(num[endrow][i]+ " ");
            }
            endrow--;
            for(int j=endrow;j>=startrow;j--){
                System.out.print(num[j][startcol]+ " ");
            }
            startcol++;
        }
    }

    public static int diagnolsum(int num[][]){
        int sum=0;
        for(int i=0;i<num.length;i++){
            sum+=num[i][i];
            if(i!=num.length-1-i) sum+=num[i][num.length-1-i];
        }
        return sum;

    }

    public static void staircasesearch(int num[][],int key){
        int row=num.length-1,col=0;
        while(row>=0 && col<=num[0].length-1){
            if(num[row][col]==key){
                System.out.println("Key Found at ("+row+","+col+")");
                return;
            }
            else if(key>num[row][col]) col++;
            else row--;
        }
        System.out.println("Key not found!!");
    }
    public static int countrepeatingkey(int num[][],int key){
        int count=0;
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[0].length;j++){
                if(num[i][j]==key) count++;
            }
        }
        return count;
    }
    public static int sumofrow(int num[][],int row){
        int sum=0;
        for(int i=0;i<num[row-1].length;i++){
            sum+=num[row-1][i];
        }
        return sum;
    }

    public static void printarray(int num[][]){
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[0].length;j++){
                System.out.print(num[i][j] +" ");
            }
            System.out.println();
        }
    }


    public static void transpose(int num[][]){
        int trans[][]=new int [num[0].length][num.length];
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[0].length;j++){
                trans[j][i]=num[i][j];
            }
        }
        printarray(trans);
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows");
        int m=sc.nextInt();
        System.out.println("Enter the no. of column");
        int n=sc.nextInt();
        int num[][]=new int[m][n];
        input(num);
        transpose(num);
        // staircasesearch(num, n);
        sc.close();
        // int[][] array={{1,4,9},{11,4,3},{2,2,3}};
        // System.out.println(countrepeatingkey(array, 7));
        // System.out.println(sumofrow(array, 2));

    }
}
