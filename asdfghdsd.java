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
class Solution {
    public String answerString(String word, int numFriends) {
        int freq[] = new int[26];
        int sizeOfWindow = word.length()-numFriends;

        if(numFriends==1){
            return word;
        }

        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        char largest = 'z';
        for(int i = 25;i>=0;i--){
            if(freq[i]>0){
                largest = (char)(i+'a');
                break;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<word.length();i++){
            if(word.charAt(i)==largest){
                q.add(i);
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        while(!q.isEmpty()){
            int st = q.poll();
            StringBuilder curr = new StringBuilder("");

            for(int i = st;i<= Math.min(st+sizeOfWindow,word.length()-1) ; i++){
                curr.append(word.charAt(i));
            }
            System.out.println(curr);
            
            ans = check(ans,curr)==false?ans:curr;
        }

        return ans.toString();

    }
    private boolean check(StringBuilder x , StringBuilder y){
        int n = x.length();
        int m = y.length();

        for(int i = 0;i<Math.min(n,m);i++){
            if(x.charAt(i)==y.charAt(i)){
                continue;
            }
            else if(x.charAt(i)>y.charAt(i)){
                return false;
            }
            else return true;
        }

        return n>=m?false:true;
    }
    class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            int[] parent = new int[26];
            for (int i = 0; i < 26; i++) parent[i] = i;
    
            for (int i = 0; i < s1.length(); i++) {
                int a = s1.charAt(i) - 'a';
                int b = s2.charAt(i) - 'a';
                union(a, b, parent);
            }
    
            StringBuilder sb = new StringBuilder();
            for (char ch : baseStr.toCharArray()) {
                int p = find(ch - 'a', parent);
                sb.append((char) (p + 'a'));
            }
    
            return sb.toString();
        }
    
        private void union(int a, int b, int[] parent) {
            int pa = find(a, parent);
            int pb = find(b, parent);
            if (pa == pb) return;
            if (pa < pb) parent[pb] = pa;
            else parent[pa] = pb;
        }
    
        private int find(int x, int[] parent) {
            if (x != parent[x]) parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }
    
}
