import java.util.Scanner;

public class ASDFGH {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("1");
            } else if (n == 2) {
                System.out.println("1 2");
            } else if (n == 3) {
                System.out.println("1 3 2");
            } else if (n == 4) {
                System.out.println("1 3 2 4");
            } else if (n == 5) {
                System.out.println("1 4 3 5 2");
            } else {
                StringBuilder result = new StringBuilder();
                result.append("1 3 2 4 5 ");
                
                for (int i = 6; i <= n; i++) {
                    result.append(i).append(" ");
                }
                
                System.out.println(result.toString().trim());
            }
        }
        
        sc.close();
    }
    // public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    //     int ans[][]=new int[rows*cols][2];
    //     int count=0;
    //     while (count<=rows*cols) {
    //         for(int i=cStart;i<cols;i++){
    //             if () {
                    
    //             }
    //         }
    //         for(int i=rStart;i<rows;i++){
    //             if () {
                    
    //             }
    //         }
    //     }
    // }
    public int[][] generateMatrix(int n) {
        int ans[][]=new int[n][n];
        int strow=0,endRow=n-1;
        int stcol=0,endCol=n-1;
        int number=1;
        while (number<=n) {
            for(int i=stcol;i<=endCol;i++){
                ans[strow][i]=number;
                number++;
            }
            strow++;
            for(int i=strow;i<=endRow;i++){
                ans[i][endCol]=number;
                number++;
            }
            endCol--;
            for(int i=endCol;i>=stcol;i--){
                ans[endRow][i]=number;
                number++;
            }
            endRow--;
            for(int i=endRow;i>=strow;i--){
                ans[i][stcol]=number;
                number++;
            }
            stcol++;
        }
        return ans;
    }
}