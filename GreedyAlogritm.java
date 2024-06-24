import java.util.*;
import java.util.LinkedList;
public class GreedyAlogritm {
    public static void maxnoOfActivities(int stime[],int etime[]){
        ArrayList<Integer> ans =new ArrayList<>();
        ans.add(0);
        int count=1;
        int endingTime=etime[0];
        for(int i=1;i<stime.length;i++){
            if(stime[i]>=endingTime){
                ans.add(i);
                count++;
                endingTime=etime[i];
            }
        }
        System.out.println("The Max No. of jobs that can be done are:"+ count);
        for(int i=0;i<ans.size();i++){
            System.out.print("  A"+ans.get(i));
        }
    }

    public static void fractionalKnapsack(int val[],int weight[],int w){
        double ratio[][]=new double[val.length][2];

        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int value=0;
        int capacity=w;

        for(int i=val.length-1;i>=0;i--){
            int index=(int)ratio[i][0];
            if(capacity>weight[index]){
                value+=val[index];
                capacity-=weight[index];
            }
            else{
                
                value+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("The max value is:"+ value);

    }

    public static void minabsolutedifference(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int minsum=0;
        for(int i=0;i<a.length;i++){
            minsum+=Math.abs(a[i]-b[i]);
        }
        System.out.println("The minimum absolute difference will be "+minsum);
    }

    public static void indiancoinsystem(int amount){
        Integer coins[]={1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins,Comparator.reverseOrder());
        int count=0;
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(amount>=coins[i]){
                while(amount>=coins[i]){
                    count++;
                    a.add(coins[i]);
                    amount-=coins[i];
                }

            }
        }
        System.out.print("The minimum no. of coins that are to be used are:\n"+count);
        System.out.print(" ( ");
        for(int i=0;i<a.size();i++){
            System.out.print(" "+a.get(i));
        }
        System.out.print(" )");
    }

    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i,int d ,int p){
            this.id=i;
            this.deadline=d;
            this.profit=p;
        }
    }

    public static void jobsequencing(int jobinfo[][]){
        ArrayList<Job> jobs =new ArrayList<>();
        for(int i=0;i<jobinfo.length;i++){
            jobs.add(new Job(i, jobinfo[i][0], jobinfo[i][1]));        
        }

        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        int time=0;
        ArrayList<Integer> seq=new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        int totprofit=0;
        System.out.print("The max no.of jobs can be done is:"+seq.size()+"\n");
        for(int i=0;i<seq.size();i++){
            System.out.print(" "+seq.get(i));
            totprofit+=jobinfo[seq.get(i)][1];
        }
        System.out.println("The max profit is:"+totprofit);

    }

    public static void chocola(int m,Integer costver[],int n,Integer costhor[]){
        Arrays.sort(costver,Collections.reverseOrder());
        Arrays.sort(costhor,Collections.reverseOrder());

        int h=0,v=0,hp=1,vp=1;
        int cost=0;
        while(h<costhor.length && v<costver.length){
            if(costhor[h]<=costver[v]){
                cost+=(costhor[h]*vp);
                hp++;
                h++;
            }
            else{
                cost+=(costver[v]*hp);
                vp++;
                v++;
            }

        }
        while(h<costhor.length){
            cost+=(costhor[h]*vp);
                hp++;
                h++;
        }

        while(v<costver.length){
            cost+=(costver[v]*hp);
            vp++;
            v++;
        }

        System.out.println("Min cost of the cut:"+cost);
    }

    public static void largestKthNumber(int l ,int r,int k){
        ArrayList<Integer> arr=new ArrayList<>();
        
        
        for(int i=l;i<=r;i++){
            if(i%2!=0){
                arr.add(i);  
            }
        }
        Collections.sort(arr,Collections.reverseOrder());
        if(k>arr.size()){
            System.out.println("0");
        }
        else{
            System.out.println("The "+k+"th largest odd number in the given range is:"+arr.get(k-1));
        }
        
    }

    public static void lexographicallysmallestNcharacterstring(int n ,int k){
        ArrayList<Character> l=new ArrayList<>();
        while(k>0){
            if(k<(n-1)*26){
                l.add('a');
                k-=1;
                n--;
            }
            else{
                if(n==1){
                    char ch=(char)(64+k);
                    k=0;
                    n--;
                    l.add(ch);
                }
                else{
                    char ch=(char)(64+(k-(n-2)*26));
                    l.add(ch);
                    k=k-(k-(n-2)*26);
                    n--;
                }

                
            }
        }
        for(int i=0;i<l.size();i++){
            System.out.print(l.get(i));
        }
    }

    public static void besttimetobuyansellstock(int prices[]){
        int currprofit=0,maxprofit=0;
        int buyprice=prices[0];
        for(int i=0;i<prices.length;i++){
            int currdata=prices[i];
            if(currdata>buyprice){
                currprofit=currdata-buyprice;
                maxprofit=Math.max(currprofit,maxprofit);
            }
            else{
                buyprice=currdata;
            }
        }
        System.out.println("The max profit here will be:"+maxprofit);
    }

    public static void mincost(int arr[]){
        Arrays.sort(arr);
        int count=-arr[0];
        int x=0;
        for(int i=0;i<arr.length;i++){
            x=x+arr[i];
            count+=x;
        }
        System.out.println("Min cost is:"+count);
    }

    public static void reversefirsrKelements(Queue<Integer> q,int k){
        Stack<Integer> s=new Stack<>();
        Queue<Integer> qnew=new LinkedList<>();
        for(int i=0;i<k;i++){
            Integer x=q.remove();
            s.push(x);
        }

        while(!s.isEmpty()){
            Integer y=s.pop();
            qnew.add(y);
        }

        while(!q.isEmpty()){
            Integer z=q.remove();
            qnew.add(z);
        }

        while(!qnew.isEmpty()){
            Integer v=qnew.remove();
            q.add(v);
        }
        return;
    }

    public static void maxOfEachAndEveryContiguousSubarray(int arr[],int k){
        int max=Integer.MIN_VALUE;
        int i=0;
        for(i=0;i<k;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.print(" "+max);
        while(i!=arr.length){
            if(arr[i]>max){
                max=arr[i];
            }
            System.out.print(" "+max);
            i++;
        }
        return;
    }

    

    

    public static void main(String[] args) {
        // int stime[]={1,3,0,5,8,5};
        // int etime[]={2,4,6,7,9,9};
        // maxnoOfActivities(stime, etime);

        // int val[]={60,100,120};
        // int weight[]={10,20,30};
        // fractionalKnapsack(val, weight, 50);

        // int a[]={4,1,8,7};
        // int b[]={2,3,6,5};
        // minabsolutedifference(a, b);

        // indiancoinsystem(1059);

        // int jobinfo[][]={{4,20},{1,10},{1,40},{1,30}};
        // jobsequencing(jobinfo);

        // Integer v[]={2,1,3,1,4};
        // Integer h[]={4,1,2};
        // chocola(6, v, 4, h);

        // largestKthNumber(-3, 3, 1);

        // lexographicallysmallestNcharacterstring(3, 25);

        // int arr[]={7,6,4,3,1};
        // besttimetobuyansellstock(arr);

        // int arr[]={4,3,2,6};
        // mincost(arr);

        // Queue<Integer> q=new LinkedList<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);
        // q.add(70);
        // q.add(80);
        // q.add(90);

        // q.add(100);
        // reversefirsrKelements(q, 5);
        // while(!q.isEmpty()){
        //     System.out.print(" "+q.remove());
        // }

        int arr[]={1,2,3,1,4,5,2,3,6};
        maxOfEachAndEveryContiguousSubarray(arr, 3);
    }
}
