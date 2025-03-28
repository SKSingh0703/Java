public class Backtracking {
    public static int gridways(int board[][],int row,int column){
        if(column==board.length-1 && row==board[0].length-1){
            return 1;
        } 
        else if(column==board.length) return 0;
        else if(row==board[0].length) return 0;
        int w1=gridways(board,row+1,column);
        int w2=gridways(board, row, column+1);
        return w1+w2;

    }

    public static void printsubsets(String str,String ans,int i){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        printsubsets(str, ans+str.charAt(i), i+1);
        printsubsets(str, ans, i+1);
    }

    public static void permutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curchar=str.charAt(i);
            //remove that character
            String newstr=str.substring(0, i)+str.substring(i+1,str.length());
            permutation(newstr, ans+curchar);

        }
    }

    public static boolean isSafeQueen(char board[][],int row,int column){
        for(int i=row-1;i>=0;i--){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        for(int i=row-1 ,j=column-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=column+1; i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void printboard(char board[][]){
        System.out.println("------CHESS BOARD-------");
        System.out.println();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void NQueens(char board[][],int row){
        if(row==board.length){
            printboard(board);
            return;
        }
        for(int j=0;j<board[0].length;j++){
            if(isSafeQueen(board, row, j)){
                board[row][j]='Q';
                NQueens(board, row+1);
                board[row][j]='x';
            }
        }
    }
    public static void NQueensCountWays(char board[][],int row){
        if(row==board.length){
            count++;
            return;
        }
        for(int j=0;j<board[0].length;j++){
            if(isSafeQueen(board, row, j)){
                board[row][j]='Q';
                NQueens(board, row+1);
                board[row][j]='x';
            }
        }
        return ;
    }

    public static Boolean NQueensBool(char board[][],int row){
        if(row==board.length){
            return true;
        }
        for(int j=0;j<board[0].length;j++){
            if(isSafeQueen(board, row, j)){
                board[row][j]='Q';
                if(NQueensBool(board, row+1)) return true;
                board[row][j]='x';
            }
        }
        return false;
    }

    public static Boolean IsSafeSudoku(int sudoku[][],int row,int column,int target){
        for(int i=0;i<9;i++){
            if(sudoku[i][column]==target){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==target){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(column/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==target){
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean SudokuSolver(int sudoku[][],int row,int column){
        if(row==9) return true;
        int nextrow=0,nextcolumn=column+1;
        if(nextcolumn==9){
            nextcolumn=0;
            nextrow=row+1;
        }

        if(sudoku[row][column]!=0){
            SudokuSolver(sudoku, nextrow, nextcolumn);
        }
        for(int i=1;i<=9;i++){
            if(IsSafeSudoku(sudoku,row,column,i)){
                sudoku[row][column]=i;
                if(SudokuSolver(sudoku,nextrow,nextcolumn)){
                    return true;
                }
                sudoku[row][column]=0;
            }
        }
        return false;
    }
    public static void printpathway(int nums[][]){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static Boolean IsMazeSafe(int nums[][],int i,int j){
        //x,y lies inside the maze
        return(i>=0 && i<nums.length && j>=0 && j<nums[0].length && nums[i][j]==1);
    }

    public static Boolean MazePathway(int nums[][],int temp[][],int i,int j){
        if(i==nums.length-1 && j==nums[0].length-1 && nums[i][j]==1){
            temp[i][j]=1;
            return true;
        }

        if(IsMazeSafe(nums, i, j)==true){
            if(temp[i][j]==1) return false;
            temp[i][j]=1;
            if(MazePathway(nums, temp, i +1, j)) return true;
            if(MazePathway(nums, temp, i, j+1)) return true;
            temp[i][j]=0;
            return false;
        }

        return false;
        
        
    }
    final static char L[][]={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public static void KeyPadCombinations(StringBuilder sb,String D,int pos,int len){
        if(pos==len){
            System.out.println(sb.toString());
            return;
        }
        char letters[]=L[Character.getNumericValue(D.charAt(pos))];
        for(int i=0;i<letters.length;i++){
            KeyPadCombinations(sb.append(letters[i]), D, pos, len);
        }

    }
    static int count=0;
    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
    public static void main(String[] args){
        // int nums[][]={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        // int temp[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        // System.out.println(MazePathway(nums, temp, 0, 0));
        // printpathway(temp);
        int nums[]={2,5,3,4,6};
        bubblesort(nums);
        System.out.println(count);
    }
}

// For tommorow 
// 1)Wake up the BIO Notes
// 2)Shower at 12:30 + washroom + cloth washing + Lunch
// 3)BEE + Revision + time paas till 6:30
// 4)BIO till night 2nd Module Notes

