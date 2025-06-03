public class asdfghdsd {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0]=1;
        for(int i = 1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                left[i] = left[i-1]+1;
            }
            else left[i]=1;
        }

        right[n-1]=1;
        for(int i = n-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right[i] = right[i+1]+1;
            }
            else right[i]=1;
        }


        int ans = 0;
        for(int i = 0;i<n;i++){
            ans+=Math.max(left[i],right[i]);
        }

        return ans;
    }
}
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;

        for(int num : initialBoxes){
            q.add(num);
        }

        HashSet<Integer> locked = new HashSet<>();
        while(!q.isEmpty()){
            int curr = q.poll();

            if(status[curr]==0){
                locked.add(curr);
                continue;
            }

            ans+=candies[curr];
            for(int key : keys[curr]){
                status[key]=1;
                if(locked.contains(key)){
                    q.add(key);
                    locked.remove(key);
                }
            }

            for(int next : containedBoxes[curr]){
                q.add(next);
            }
        }

        return ans;
    }
}