public class contest2 {
    public boolean satisfiesConditions(int[][] grid) {
        if(grid.length==1 && grid[0].length==1 ) return true;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i+1<grid.length){
                    if(!(grid[i][j]==grid[i+1][j])){
                        return false;
                    }
                }
                
                if(j+1<grid[i].length){
                    if((grid[i][j]==grid[i][j+1])){
                        return fale;
                    }
                }
                
                
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Sachin");
    }
}
