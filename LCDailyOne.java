import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class LCDailyOne {

    class CustomStack {
        int arr[];
        int top;
        int size;
        int currsize;

        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            size = maxSize;
            top = -1;
            currsize = 0;
        }

        public void push(int x) {
            if (top == size - 1) {
                return;
            } else if (top == -1) {
                top = 0;
            } else
                top++;
            arr[top] = x;
            currsize++;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            } else {
                int x = arr[top];
                top--;
                currsize--;
                return x;
            }
        }

        public void increment(int k, int val) {
            int n = Math.min(k, currsize);
            for (int i = 0; i < n; i++) {
                arr[i] += val;
            }
        }
    }

    public boolean check(String one[],String two[]){
        int i=0,j=0;
        int m=one.length,n=two.length;
        boolean flag=false;
        while (one[i].equals(two[j]) && j<n) {
            i++,j++;
        }
        if (j==n) {
            return true;
        }
        while (!one[i].equals(two[j])) {
            i++;
        }
        while (one[i].equals(two[j]) && j<n) {
            i++,j++;
        }
        if (i!=m || j!=n) {
            return false;
        }
        return true;

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String one[] = sentence1.split(" ");
        String two[] = sentence2.split(" ");
        if (one.length > two.length) {
            return check(one, two);
        } else
            return check(two, one);
    }

    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'B') {
                sb.delete(i, i + 2);
                i = 0;
            } else if (sb.charAt(i) == 'C' && sb.charAt(i) == 'D') {
                sb.delete(i, i + 2);
                i = 0;
            } else
                i++;
        }
        return sb.length();
    }

    public int minSwaps(String str) {
        char arr[] = str.toCharArray();
        Stack<Character> s = new Stack<>();
        int open = 0, close = 0;
        for (int i = 0; i < str.length(); i++) {
            char curr = arr[i];
            if (curr == '[') {
                s.push(curr);
                open = i;
            } else {
                if (!s.isEmpty() && s.peek() == '[') {
                    s.pop();
                } else
                    s.push(curr);
            }
        }

        return s.size() / 2;
    }

    public int maximumSwap3(int num) {
        char[] str = Integer.toString(num).toCharArray();
        int idx=-1;
        int max=str[0]-'0';
        for(int i=1;i<str.length;i++){
            int curr = str.[i] -'0';
            if (curr>max) {
                max=curr;
                idx=i;
            }
        }
        if (idx==-1) {
            return num;
        }
        char temp=str[idx];
        str[idx]=str[0];
        str[0]=temp;

        return Integer.parseInt(str.toString());
    }

    public class Pair implements Comparable<Pair> {
        int idx;
        int val;

        public Pair(int i, int v) {
            idx = i;
            val = v;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder("");
                while (s.peek() != "(") {
                    sb.append(s.pop());
                }
                s.pop();
                char op = s.pop();
                char curr = 't';
                if (op == '!') {
                    curr = notOperation(sb.toString());
                } else if (op == '|') {
                    curr = orOperation(sb.toString());
                } else
                    curr = andOperation(sb.toString());
                s.push(curr);
            } else
                s.push(expression.charAt(i));
        }
        return s.pop() == 't' ? true : false;
    }

    public char notOperation(String str) {
        return str.charAt(0) == 't' ? 't' : 'f';
    }

    public char orOperation(String str) {
        boolean flag = str.charAt(0) == 't' ? true : false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == 't') {
                flag = (flag | true);
            } else
                flag = (flag | false);
        }
        return flag ? 't' : 'f';
    }

    public char andOperation(String str) {
        boolean flag = str.charAt(0) == 't' ? true : false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == 't') {
                flag = (flag & true);
            } else
                flag = (flag & false);
        }
        return flag ? 't' : 'f';
    }

    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int max = str[0] - '0';
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(idx, str[i] - '0'));
        }
        for (int i = 0; i < arr.length; i++) {
            Pair curr = pq.poll();
            if (curr.val > max) {
                char temp = arr[curr.idx];
                arr[curr.idx] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }

    public int minGroups(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq_copy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals);
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        int count = 0;
        while (!pq.isEmpty() || !pq_copy.isEmpty()) {
            int start = true, end = 0;
            if (!pq.isEmpty()) {
                while (!pq.isEmpty()) {
                    int curr[] = pq.poll();
                    if (start) {
                        start = false;
                        end = curr[1];
                        continue;
                    }
                    if (curr[0] > end) {
                        continue;
                    } else
                        pq_copy.add(curr);
                }
            } else {
                while (!pq_copy.isEmpty()) {
                    int curr[] = pq_copy.poll();
                    if (start) {
                        start = false;
                        end = curr[1];
                        continue;
                    }
                    if (curr[0] > end) {
                        continue;
                    } else
                        pq.add(curr);
                }
            }
            count++;
        }
        return count;

    }

    class AllOne {
        HashMap<String, Integer> hm;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringBuilder maxStr;
        StringBuilder minStr;

        public AllOne() {
            hm = new HashMap<>();
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            maxStr = new StringBuilder("");
            minStr = new StringBuilder("");
        }

        public void inc(String key) {
            hm.put(key, hm.getOrDefault(key, 0) + 1);
            if (max < hm.get(key)) {
                max = hm.get(key);
                maxStr = new StringBuilder(key);
            }
        }

        public void dec(String key) {
            hm.put(key, hm.getOrDefault(key, 0) - 1);
            if (hm.get(key) == 0) {
                hm.remove(key);
                return;
            }
            if (min < hm.get(key)) {
                min = hm.get(key);
                minStr = new StringBuilder(key);
            }
        }

        public String getMaxKey() {
            return maxStr.toString();
        }

        public String getMinKey() {
            return minStr.toString();
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList();
        if (root == null) {
            return -1;
        }
        ArrayList<Long> arr = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long curr = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode c = q.poll();
                curr += c.val;
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
            arr.add(curr);
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr.size() <= k - 1 ? -1 : arr.get(k - 1);
    }

    class test {
        final int MAX = 10;

        void show(final int x) {
            System.out.println(MAX);
            x++;
            System.out.println(x);
        }
    }

    public class demo {
        public static void main(String args[]) {
            test t1 = new test();
            t1.show(12);
        }
    }

    class test {
        final int MAX = 10;

        void show() {
            System.out.println(MAX);
            MAX++;
            System.out.println(MAX);
        }
    }

    public class demo {
        public static void main(String args[]) {
            test t1 = new test();
            t1.show();
        }
    }

    public abstract class Employee {
        private String name, address;
        private int number;

public Employee( ) {. . . . }

public Employee(String n, String add, int num) 
{ . . . }

        public double computePay() {
            System.out.println("Inside Employee computePay");
            return 0.0;
        }

        public void mailCheck() {
            System.out.println("Mailing to " + this.name +
                    " " + this.address);
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String newAddress) {
            address = newAddress;
        }

        public int getNumber() {
            return number;
        }
    }

    public class AbstractDemo {
  public static void main(String [] args) {
     Salary s = new Salary("Abc", "UP", 1243, 3600.00); 
    System.out.println("Call mailCheck using Salary 
    reference --"); 
    s.mailCheck(); 
    }
    }

}
