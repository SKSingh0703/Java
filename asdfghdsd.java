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
class Solution {

    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>(); // grouped string
        int n = s.length();
        int curr = 0; // starting index of each group
        // split string
        while (curr < n) {
            int end = Math.min(curr + k, n);
            res.add(s.substring(curr, end));
            curr += k;
        }
        // try to fill in the last group
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }
        return res.toArray(new String[0]);
    }
}
class Solution {

    private int[] digit = new int[100];

    public long kMirror(int k, int n) {
        int left = 1, count = 0;
        long ans = 0;
        while (count < n) {
            int right = left * 10;
            // op = 0 indicates enumerating odd-length palindromes
            // op = 1 indicates enumerating even-length palindromes
            for (int op = 0; op < 2; ++op) {
                // enumerate i'
                for (int i = left; i < right && count < n; ++i) {
                    long combined = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        combined = combined * 10 + (x % 10);
                        x /= 10;
                    }
                    if (isPalindrome(combined, k)) {
                        ++count;
                        ans += combined;
                    }
                }
            }
            left = right;
        }
        return ans;
    }

    private boolean isPalindrome(long x, int k) {
        int length = -1;
        while (x > 0) {
            ++length;
            digit[length] = (int) (x % k);
            x /= k;
        }
        for (int i = 0, j = length; i < j; ++i, --j) {
            if (digit[i] != digit[j]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // traverse number pairs
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    res.add(i);
                    break; // early termination to prevent duplicate addition
                }
            }
        }
        return res;
    }
}
class Solution {

    int f(int[] nums2, long x1, long v) {
        int n2 = nums2.length;
        int left = 0, right = n2 - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long prod = (long) nums2[mid] * x1;
            if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (x1 >= 0) {
            return left;
        } else {
            return n2 - left;
        }
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        long left = -10000000000L, right = 10000000000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < n1; i++) {
                count += f(nums2, nums1[i], mid);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
class Solution {

    public int longestSubsequence(String s, int k) {
        int sm = 0;
        int cnt = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < bits && sm + (1 << i) <= k) {
                    sm += 1 << i;
                    cnt++;
                }
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}
class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        List<Character> candidate = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidate.add((char) ('a' + i));
            }
        }

        Queue<String> q = new LinkedList<>();
        for (char ch : candidate) {
            q.add(String.valueOf(ch));
        }
        String ans = "";
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > ans.length()) {
                ans = curr;
            }
            // generate the next candidate string
            for (char ch : candidate) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) {
                    q.add(next);
                }
            }
        }

        return ans;
    }

    private boolean isKRepeatedSubsequence(String s, String t, int k) {
        int pos = 0, matched = 0;
        int m = t.length();
        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(pos)) {
                pos++;
                if (pos == m) {
                    pos = 0;
                    matched++;
                    if (matched == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
class Solution {

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2]; // two-dimensional array stores index and value
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i; // store index
            vals[i][1] = nums[i]; // store value
        }
        // sort by numerical value in descending order
        Arrays.sort(vals, (x1, x2) -> Integer.compare(x2[1], x1[1]));
        // select the first k elements and sort them in ascending order by index
        Arrays.sort(vals, 0, k, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] res = new int[k]; // target subsequence
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
    }
}
class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}
class Solution {
    public int possibleStringCount(String word) {
        long ans = 1;                               // flawless string
        for (int i = 0, n = word.length(); i < n; ) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) j++;
            ans += (j - i - 1);                     // L‑1 extras
            i = j;
        }
        return (int) ans;
    }
}

public class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) return 0;

        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);

        long total = 1;
        for (int num : groups) total = (total * num) % MOD;

        if (k <= groups.size()) return (int)total;

        int[] dp = new int[k];
        dp[0] = 1;
        for (int num : groups) {
            int[] newDp = new int[k];
            long sum = 0;
            for (int s = 0; s < k; s++) {
                if (s > 0) sum = (sum + dp[s - 1]) % MOD;
                if (s > num) sum = (sum - dp[s - num - 1] + MOD) % MOD;
                newDp[s] = (int)sum;
            }
            dp = newDp;
        }
        long invalid = 0;
        for (int s = groups.size(); s < k; s++) invalid = (invalid + dp[s]) % MOD;

        return (int)((total - invalid + MOD) % MOD);
    }
}
class Solution {

    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}
class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0; // total number of +1 (mod 26) operations
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1) shift++;
            }
            // else: k remains the same
        }

        // Apply total shift from 'a'
        return (char) ((('a' - 'a' + shift) % 26) + 'a');
    }
}
class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> cnt;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();
        for (int num : nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        cnt.put(oldVal, cnt.get(oldVal) - 1);
        nums2[index] += val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            int rest = tot - num;
            ans += cnt.getOrDefault(rest, 0);
        }
        return ans;
    }
}
class Solution {

    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
}
class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, -1, events, k);
    }
    
    private int dfs(int curIndex, int count, int prevEndingTime, int[][] events, int k) {
        if (curIndex == events.length || count == k) {
            return 0;
        }
        
        if (prevEndingTime >= events[curIndex][0]) {
            return dfs(curIndex + 1, count, prevEndingTime, events, k);
        }
        
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        
        int ans = Math.max(dfs(curIndex + 1, count, prevEndingTime, events, k),
                           dfs(curIndex + 1, count + 1, events[curIndex][1], events, k) + events[curIndex][2]);
        dp[count][curIndex] = ans;
        return ans;
    }
}
public class Solution {

    public int maxFreeTime(
        int eventTime,
        int k,
        int[] startTime,
        int[] endTime
    ) {
        int n = startTime.length;
        int res = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            res = Math.max(res, right - left - t);
            if (i >= k - 1) {
                t -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return res;
    }
}
class Solution {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] q = new boolean[n];
        for (int i = 0, t1 = 0, t2 = 0; i < n; i++) {
            if (endTime[i] - startTime[i] <= t1) {
                q[i] = true;
            }
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));

            if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                q[n - i - 1] = true;
            }
            t2 = Math.max(
                t2,
                (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]
            );
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            if (q[i]) {
                res = Math.max(res, right - left);
            } else {
                res = Math.max(res, right - left - (endTime[i] - startTime[i]));
            }
        }
        return res;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> roomsAvailable = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            roomsAvailable.add(i);
        }

        PriorityQueue<int[]> roomBusyTill = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0]; 
            return a[1] - b[1];
        });

        int[] freq = new int[n];

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            int duration = endTime - startTime;

            while (!roomBusyTill.isEmpty() && roomBusyTill.peek()[1] <= startTime) {
                roomsAvailable.add(roomBusyTill.poll()[0]);
            }

            int room;
            int actualStart;

            if (!roomsAvailable.isEmpty()) {
                room = roomsAvailable.poll();
                actualStart = startTime;
            } else {
                int[] nextFree = roomBusyTill.poll();
                room = nextFree[0];
                actualStart = nextFree[1]; 
            }

            freq[room]++;
            roomBusyTill.add(new int[]{room, actualStart + duration});
        }

        int max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ans = i;
            }
        }

        return ans;
    }
}
class Solution {

    private int[][][] F = new int[30][30][30];
    private int[][][] G = new int[30][30][30];

    private int[] dp(int n, int f, int s) {
        if (F[n][f][s] != 0) {
            return new int[] { F[n][f][s], G[n][f][s] };
        }
        if (f + s == n + 1) {
            return new int[] { 1, 1 };
        }
        // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
        if (f + s > n + 1) {
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return new int[] { F[n][f][s], G[n][f][s] };
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;
        int n_half = (n + 1) / 2;
        if (s <= n_half) {
            // On the left or in the middle
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            // s on the right
            int s_prime = n + 1 - s;
            int mid = (n - 2 * s_prime + 1) / 2;
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s_prime - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + mid + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        F[n][f][s] = earliest + 1;
        G[n][f][s] = latest + 1;
        return new int[] { F[n][f][s], G[n][f][s] };
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // F(n,f,s) = F(n,s,f)
        if (firstPlayer > secondPlayer) {
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }

        int[] res = dp(n, firstPlayer, secondPlayer);
        return new int[] { res[0], res[1] };
    }
}
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int i=0;
        int count = 0;
        int n = players.length , m = trainers.length;

        for(int j = 0;j<m && i<n;j++){
            if(players[i]<=trainers[j]){
                count++;
                i++;
            }
        }

        return count;
    }
}
class Solution {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (
                    ch == 'a' ||
                    ch == 'e' ||
                    ch == 'i' ||
                    ch == 'o' ||
                    ch == 'u'
                ) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }
}
class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0,even=0,toggle1=0,toggle2=0;
        int n = nums.length;
        int target1=0;
        int target2=1;

        for(int i  = 0;i<n;i++){
            if(nums[i]%2==0){
                even++;
            }
            else odd++;

            if( nums[i]%2 == target1 ){
                target1 = (target1+1)%2;
                toggle1++;
            }

            if( nums[i]%2 == target2 ){
                target2 = (target2+1)%2;
                toggle2++;
            }
        }

        return Math.max(Math.max(even,odd),Math.max(toggle1,toggle2));
    }
}
// class Solution {
//     public int maximumLength(int[] nums, int k) {
//         int ans = 0;
//         int n = nums.length;
//         for(int i = 0;i<k;i++){
//             int dp[][] = new int[n][n+1];
//             for(int[] x:dp){
//                 Arrays.fill(x,-1);
//             }
//             ans = Math.max(ans,helper(0,-1,i,nums,k,dp));
//         }
//         return ans;
//     }
//     private int helper(int idx,int prevIdx,int rem ,int nums[],int k,int dp[][]){
//         if(idx==nums.length){
//             return 0;
//         }
//         if(dp[idx][prevIdx+1]!=-1){
//             return dp[idx][prevIdx+1];
//         }
//         int ans1 = helper(idx+1 , prevIdx ,rem,nums,k,dp);
//         int ans2 = 0;

//         if(prevIdx==-1 || (nums[prevIdx]+nums[idx])%k==rem){
//             ans2 = 1+helper(idx+1,idx,rem,nums,k,dp);
//         }

//         return dp[idx][prevIdx+1]=Math.max(ans1,ans2);
//     }
// }

// TLE

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        int[][] dp = new int[n][k];

        for(int i = 0;i<n;i++){
            
            for(int j = 0;j<i;j++){

                int rem =( nums[i]+nums[j])%k;
                dp[i][rem] = Math.max(dp[i][rem],dp[j][rem]+1);
                ans = Math.max(ans,dp[i][rem]);
            }
        }

        return ans+1;
    }
}
public class Solution {

    public long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;
        long[] part1 = new long[n + 1];
        long sum = 0;
        // max heap (simulate with opposite numbers)
        PriorityQueue<Integer> ql = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
        }
        part1[0] = sum;
        for (int i = n; i < n * 2; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
            sum -= ql.poll();
            part1[i - (n - 1)] = sum;
        }

        long part2 = 0;
        // min heap
        PriorityQueue<Integer> qr = new PriorityQueue<>();
        for (int i = n * 3 - 1; i >= n * 2; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
        }
        long ans = part1[n] - part2;
        for (int i = n * 2 - 1; i >= n; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
            part2 -= qr.poll();
            ans = Math.min(ans, part1[i - n] - part2);
        }
        return ans;
    }
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> arr = new ArrayList<>();
        Stack<String> s = new Stack<>();
        Arrays.sort(folder);
        for(int i=0;i<folder.length;i++){
            String curr = folder[i];
            if(s.isEmpty()) s.push(curr);
            else{
                if(curr.contains(s.peek()+"/") && curr.charAt(1)==s.peek().charAt(1)) continue;
                arr.add(s.pop());
                s.push(curr);
            }
        }
        while(!s.isEmpty()) arr.add(s.pop());
        return arr;
    }
}
class Solution {

    class Trie {

        String serial; // current node structure's serialized representation
        Map<String, Trie> children = new HashMap<>(); // current node's child nodes
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie(); // root node

        // build a trie tree
        for (List<String> path : paths) {
            Trie cur = root;
            for (String node : path) {
                cur.children.putIfAbsent(node, new Trie());
                cur = cur.children.get(node);
            }
        }

        Map<String, Integer> freq = new HashMap<>(); // hash table records the occurrence times of each serialized representation
        // post-order traversal based on depth-first search, calculate the serialized representation of each node structure
        construct(root, freq);
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        // operate the trie, delete duplicate folders
        operate(root, freq, path, ans);
        return ans;
    }

    private void construct(Trie node, Map<String, Integer> freq) {
        if (node.children.isEmpty()) return; // if it is a leaf node, no operation is needed.

        List<String> v = new ArrayList<>();
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            construct(entry.getValue(), freq);
            v.add(entry.getKey() + "(" + entry.getValue().serial + ")");
        }

        Collections.sort(v);
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        node.serial = sb.toString();
        freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
    }

    private void operate(
        Trie node,
        Map<String, Integer> freq,
        List<String> path,
        List<List<String>> ans
    ) {
        if (freq.getOrDefault(node.serial, 0) > 1) return; // if the serialization representation appears more than once, it needs to be deleted

        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }

        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            path.add(entry.getKey());
            operate(entry.getValue(), freq, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
class Solution {

    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int frequency = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                // If the current character is equal to the previous character, increment the
                // frequency.
                frequency++;
            } else {
                // Otherwise, we can restart the frequency counter with 1, and store the current
                // character's value in prev.
                prev = s.charAt(i);
                frequency = 1;
            }
            // If the frequency counter has value less than 3, add the character to the
            // answer string.
            if (frequency < 3) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < n; right++) {
            while (seen[nums[right]]) {
                currentSum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            currentSum += nums[right];
            seen[nums[right]] = true;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return maxSum;
    }
}
