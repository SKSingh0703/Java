// import java.util.*;

import java.util.PriorityQueue;

public class bit {
    public static void check(int n){
        int bitmask=1;
        if((n & bitmask) == 0){
            System.out.println("The number is EVEN.");
        }
        else System.out.println("The number is Odd.");
        return;
    }

    public static int getIthbit(int n,int i){
        int bitmask=1<<i;
        if((n & bitmask)==0){
            return 0;
        }
        else return 1;
    }
    public class Pair implements Comparable<Pair>{
        int val;
        int row;
        int col;
        int parRow;
        int parCol;
        public Pair(int v,int r,int c,int pr,int pc){
            val=v;
            row=r;col=c;parRow=pr;parCol=pc;
        }
        @Override
        public int compareTo(Pair p2){
            return this.val-p2.val
        }
    }

    public int minimumTime(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        int time=0;
        pq.add(new Pair(grid[0][0], 0, 0, -1, -1) );
        int x[]={1,0,0,-1};
        int y[]={0,-1,1,0};
        while (!pq.isEmpty()) {
            Pair curr=pq.poll();
            if (curr.val>time) {
                continue;
            }
            vis[curr.row][curr.col]=true;
            if (curr.row==m-1 && curr.col==n-1) {
                return time;
            }
            for(int i=0;i<4;i++){
                int newX=curr.row+x[i];
                int newY=curr.col+y[i];
                if (newX>0 && newX<m && newY>0 && newY<n && vis[newX][newY]==false) {
                    pq.add(new Pair(grid[newX][newY], newX, newY, curr.row, curr.col));
                }
            }
            time++;
        }
        return -1;
    }

    public static int setIthbit(int n,int i){
        int bitmask=1<<i;
        return n | bitmask;
    }

    public static int clearIthbit(int n,int i){
        int bitmask=~(1<<i);
        return n&bitmask;
    }

    public static int updateIthbit(int n,int i,int newbit){
        n=clearIthbit(n, i);
        int bitmask=newbit<<i;
        return n|bitmask;
    }

    public static int clearItoJthbits(int n,int i,int j ){
        int a=(~0)<<j+1;
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n&bitmask;
    }
    public static int clearlastIthbits(int n,int i){
        int bitmask=(~0)<<i;
        return n&bitmask;
    }

    public static boolean checkifpoweroftwoornot(int n){
        return ((n&(n-1))==0);
    }

    public static int countsetbits(int n){
        int count=0;
        while(n>0){
            if((n&1)==1) count++;
            n=(n>>1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a=5,b=6;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a +" "+ b);
    }
}
    

