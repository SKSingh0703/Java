public class IEEEcontest {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char ch1=coordinate1.charAt(0);
        char ch2=coordinate1.charAt(1);

        int one=ch1-'a'+1;
        int two=Integer.parseInt(ch2);
        boolean isBlack=false;
        boolean isWhite=true;
        if ((one%2==0 && two%2==0) || (one%2!=0 && two%2!=0)  ) {
            isBlack=true;
            isWhite=false;
        }
        char ch11=coordinate2.charAt(0);
        char ch22=coordinate2.charAt(1);

        int onee=ch11-'a'+1;
        int twoo=Integer.parseInt(ch22);
        boolean flag=false;
        if (isWhite) {
            if ((one%2==0 && two%2!=0) || (one%2!=0 && two%2==0)) {
                flag=true;
            }
        }
        if (isBlack) {
            if ((onee%2==0 && twoo%2==0) || (onee%2!=0 && twoo%2!=0)) {
                flag=true;
            }
        }
        if (flag) {
            return true;
        }
        else return false;
    }
    import java.util.*;

import LCPOne.TreeNode;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        Set<Integer> hs = new HashSet<>();
        int max = 0;
        for (List<Integer> row : grid) {
            Collections.sort(row, Collections.reverseOrder());
        }

        for (List<Integer> row : grid) {
            for (int value : row) {
                if (!hs.contains(value)) {
                    max += value;  
                    hs.add(value);  
                    break; 
                }
            }
        }

        return max;
    }
    
}
    public int chalkReplacer(int[] chalk, int k) {
        int sum=0;
       for(int i=0;i<chalk.length;i++){
            sum+=chalk[i];
        }
        int finalChalks=k%sum;
        int i=0;
        while (chalk[i]>k) {
            k-=chalk[i];
            i++;
        }
        return i;
    }
    public int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder("");
        int sum=0;
        for(int i=0;i<s.length;i++){
            int num=s.charAt(i)-'a'+1;
            sb.append(Integer.toString(num));
        }
        for(int i=0;i<sb.length();i++){
            sum+=Character.getNumericValue(sb.charAt(i));
        }
        k--;
        while(k>0){
            int temp=0;
            while(sum>0){
                temp+=sum%10;
                sum/=10;
            }
            sum=temp;
            k--;
        }
        return sum;
    }
    public boolean check(HashMap<Integer,ArrayList<Integer>> hm,int x,int y,int k){
        if (!hm.containsKey(x)) {
            return false;
        }
        ArrayList<Integer> arr=hm.get(x);
        for(int i=0;i<arr.size();i++){
            int curr=arr.get(i);
            if (curr>=y && curr<=y+k) {
                return true;
            }
        }
        return false;
    }
    public class ListNode {
        *     int val;
        *     ListNode next;
        *     ListNode() {}
        *     ListNode(int val) { this.val = val; }
        *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        * }
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temphead=new ListNode(0,head);
        ListNode temp=temphead;
        HashSet<Integer> hs =new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        while (temp!=null && temp.next!=null) {
            int curr=temp.next.val;
            if (hs.contains(curr)) {
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return temphead.next;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer,ArrayList<Integer>> hmX=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> hmY=new HashMap<>();
        for(int i=0;i<obstacles.length;i++){
            int x=obstacles[i][0];
            int y=obstacles[i][1];

            hmX.putIfAbsent(x, new ArrayList<>());
            hmX.get(x).add(y);
            hmY.putIfAbsent(y, new ArrayList<>());
            hmY.get(y).add(x);
        }
        int direction=2;
        int currX=0;
        int currY=0;
        for(int i=0;i<commands.length;i++){
            int currCommand=commands[i];
            if (currCommand<0) {
                if (currCommand==-2) {
                    direction+=1;
                    if (direction>4) {
                        direction=1;
                    }
                }
                if (currCommand==-1) {
                    direction-=1;
                    if (direction<1) {
                        direction=4;
                    }
                }
            }
            else{
                if (direction==1) {
                    if (!check(hmY, currY, currX, currCommand)) {
                        currX+=currCommand;
                    }
                }
                if (direction==2) {
                    if (!check(hmX, currX, currY, currCommand)) {
                        currY+=currCommand;
                    }
                }
                if (direction==3) {
                    if (!check(hmY, currY, currX, currCommand)) {
                        currX-=currCommand;
                    }
                }
                if (direction==4) {
                    if (!check(hmX, currX, currY, currCommand)) {
                        currY-=currCommand;
                    }
                }
            }
            int ans=currY*currY+currX*currX;
            return ans;
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root==null) {
            return false;
        }
        if (root.val==head.val) {
            if (isPresent(head,root)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean isPresent(ListNode head, TreeNode root){
        if (head==null) {
            return true;
        }
        if (root==null  ) {
            return false;
        }
        if (head.val!=root.val) {
            return false;
        }
        return isPresent(head.next, root.left) || isPresent(head.next, root.right);
    }
    public static void main(String[] args) {
        
    }
}
