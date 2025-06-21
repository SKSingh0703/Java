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
    public String robotWithString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int idx = 0;
        for(char ch : s.toCharArray()){
            pq.add(new int[]{ch-'a',idx});
            idx++;
        }
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0;i<s.length();i++){
            while(!pq.isEmpty() && pq.peek()[1]<i){
                pq.poll();
            }
            while(!st.isEmpty() && !pq.isEmpty() && st.peek()-'a'<=pq.peek()[0]){
                sb.append(st.pop());
            }

            char ideal = (char)(pq.peek()[0]+'a');
            char curr = s.charAt(i);
            if(ideal==curr){
                sb.append(curr);
            }
            else st.push(curr);

        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }
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

class Solution {

    public String clearStars(String s) {
        Deque<Integer>[] cnt = new Deque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }

    private void generateLexicalNumbers(
        int currentNumber,
        int limit,
        List<Integer> result
    ) {
        
        if (currentNumber > limit) return;

        result.add(currentNumber);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break; 
            }
        }
    }
}

class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;  
        k--;  

        while (k > 0) {
            int step = countSteps(current, n); 
            
            if (step <= k) {
                
                current++;
                k -= step;
            } else {
                
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private int countSteps(int prefix, int n) {
        long current = prefix;
        long next = prefix + 1;
        int steps = 0;

        while (current <= n) {
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }

        return steps;
    }
}
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0 || freq[i] % 2 == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0 || freq[j] % 2 != 0) continue;
                maxDiff = Math.max(maxDiff, freq[i] - freq[j]);
            }
        }

        return maxDiff == Integer.MIN_VALUE ? 0 : maxDiff;
    }
}
class Solution {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; ++right) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int left_status = getStatus(prev_a, prev_b);
                        best[left_status] = Math.min(
                            best[left_status],
                            prev_a - prev_b
                        );
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int right_status = getStatus(cnt_a, cnt_b);
                    if (best[right_status ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(
                            ans,
                            cnt_a - cnt_b - best[right_status ^ 0b10]
                        );
                    }
                }
            }
        }
        return ans;
    }

    private int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2; 
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
class Solution {

    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}
class Solution {

    public int maxDiff(int num) {
        int min_num = num;
        int max_num = num;
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                String res = change(num, x, y);
                // Check if there are leading zeros
                if (res.charAt(0) != '0') {
                    int res_i = Integer.parseInt(res);
                    min_num = Math.min(min_num, res_i);
                    max_num = Math.max(max_num, res_i);
                }
            }
        }

        return max_num - min_num;
    }

    public String change(int num, int x, int y) {
        StringBuffer num_s = new StringBuffer(String.valueOf(num));
        int length = num_s.length();
        for (int i = 0; i < length; i++) {
            char digit = num_s.charAt(i);
            if (digit - '0' == x) {
                num_s.setCharAt(i, (char) ('0' + y));
            }
        }
        return num_s.toString();
    }
    class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<=min){
                min = nums[i];
            }
            else ans = Math.max(ans,nums[i]-min);
        }
        return ans;
    }
}
class Solution {

    static final int MOD = (int) 1e9 + 7;
    static final int MX = 100000;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

    static {
        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }

    long comb(int n, int m) {
        return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        return (int) ((((comb(n - 1, k) * m) % MOD) * qpow(m - 1, n - k - 1)) %
            MOD);
    }
}
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}
}
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]-min>k){
                min = nums[i];
                count++;
            }
            else continue;
        }
        return count+1;
    }
}
class Solution {
    public int maxDistance(String str, int k) {
        int n = 0,s=0,w=0,e=0;
        int ans = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='N') n++;
            else if(str.charAt(i)=='S') s++;
            else if(str.charAt(i)=='E') e++;
            else w++;
        
        int x = Math.min(n,s);
        int y = Math.min(e,w);


        ans = Math.max( Math.abs(w-e)+Math.abs(s-n)+2*Math.min(k,x+y),ans);
        }
        return ans;
    }
}
class Solution {

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        int res = word.length();
        for (int a : cnt.values()) {
            int deleted = 0;
            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}



