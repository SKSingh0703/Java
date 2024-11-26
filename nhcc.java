import java.util.PriorityQueue;

public class nhcc {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr=matrix[i][j];
                if (curr<0) {
                    pq.add(Math.abs(curr));
                }
                ans+=Math.abs(curr);
            }
        }
        return pq.size()%2==0?ans:ans-pq.poll();
    }
    public static void main(String[] args) {
        int age = 15;
        
        // Check the condition
        assert age >= 18 : "Age must be 18 or older to proceed.";
        
        
        System.out.println("Age is valid.");
        
    }
}
