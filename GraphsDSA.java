import java.util.*;
import java.util.LinkedList;

// import javax.swing.plaf.synth.SynthDesktopIconUI;
public class GraphsDSA {
    public static class edge{
        int src;
        int des;
        int wt;
        public edge(int s,int d,int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
    }
    public static void bfs(ArrayList<edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr=q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e=graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!vis[e.des]){
                dfs(graph, e.des, vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<edge> graph[],int src,int des,boolean vis[]){
        if(src==des) return true;
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);
            if(!vis[e.des] && hasPath(graph, e.des, des, vis)){
                return true; 
          }
        }
        return false;
         
    }
    public static void dfsmain(ArrayList<edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfs(graph, i, vis);
        }
    }
    public static boolean isBipartite(ArrayList<edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        int col[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            col[i]=-1;
        }
        
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                col[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        edge e=graph[curr].get(j);
                        if(col[e.des]==col[curr]){
                            return false;
                        }
                        else if(col[e.des]==-1){
                            int nextcolor=col[curr]==0?1:0;
                            col[e.des]=nextcolor;
                            q.add(e.des);
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isCycleDirectedUtil(ArrayList<edge> graph[],int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(stack[e.des]){
                return true;
            }
            else if (vis[e.des]==false) {
                if(isCycleDirectedUtil(graph, e.des, vis, stack)){
                    return true;
                }
            }
        }
        stack[curr]=false;
        return false;
    }
    public static boolean isCycleDirected(ArrayList<edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==false){
                if(isCycleDirectedUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void topologicalSort(ArrayList<edge> graph[]){
        Stack<Integer> s =new Stack<>();
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==false){
                topologicalSortUtil(graph,i,vis,s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<edge> graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!vis[e.des]){
                topologicalSortUtil(graph, e.des, vis, s);
            }
        }
        s.push(curr);
    }
    public static void indegree(ArrayList<edge> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                edge e=graph[i].get(j);
                indeg[e.des]++;
            }
        }
    }
    public static void TSBfs(ArrayList<edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        int indeg[]=new int[graph.length];
        indegree(graph, indeg);
        for(int i=0;i<graph.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for(int j=0;j<graph[curr].size();j++){
                edge e=graph[curr].get(j);
                indeg[e.des]--;
                if(indeg[e.des]==0){
                    q.add(e.des);
                }
            }
        }
        System.out.println();
    }
    public static void pathAll(ArrayList<edge> graph[],int src,int des,String path){
        if(src==des) {
            System.out.println(path+des);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            edge e=graph[src].get(i);
            pathAll(graph, e.des, des, path+src);
        }
    }
    public static class pair implements Comparable<pair>{
        int src;
        int cost;
        public pair(int src,int cost){
            this.src=src;
            this.cost=cost;
        }
        @Override
        public int compareTo(pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void shortestPath(ArrayList<edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        int cost[]=new int[graph.length];
        for(int i=0;i<cost.length;i++){
            cost[i]=Integer.MAX_VALUE;
        }
        cost[0]=0;
        pq.add(new pair(0, 0));
        while (!pq.isEmpty()) {
            pair curr=pq.remove();
            if(vis[curr.src]==false){
                vis[curr.src]=true;
                for(int j=0;j<graph[curr.src].size();j++){
                    edge e=graph[curr.src].get(j);
                    
                    int costTillnow=curr.cost+e.wt;
                    int prevCost=cost[e.des];

                    if(costTillnow<prevCost){
                        prevCost=costTillnow;
                        cost[e.des]=costTillnow;
                        pq.add(new pair(e.des, prevCost));
                    }
                }
            }
        }
        for(int i=0;i<cost.length;i++){
            System.out.print(cost[i]+" ");
        }
    }
    public static void bellmanFord(ArrayList<edge> graph[],int src){
        int des[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            des[i]=Integer.MAX_VALUE;
        }
        des[src]=0;
        int v=graph.length;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    edge e=graph[j].get(k);
                    if(des[src]!=Integer.MAX_VALUE && des[e.src]+e.wt<des[e.des]){
                        des[e.des]=des[e.src]+e.wt;
                    }
                }
            }
        }
        for(int i=0;i<des.length;i++){
            System.out.print(des[i]+" ");
        }
    }
    public static void prims(ArrayList<edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        int finalCost=0;
        pq.add(new pair(0, 0));
        while (!pq.isEmpty()) {
            pair curr=pq.remove();
            if(!vis[curr.src]){
                vis[curr.src]=true;
                finalCost+=curr.cost;
                for(int i=0;i<graph[curr.src].size();i++){
                    edge e=graph[curr.src].get(i);
                    pq.add(new pair(e.des, e.wt));
                }
            }
        }
        System.out.println("The Final Cost is :"+finalCost);
    }
    public static class info{
        int src;int cost;int stops;
        public info(int s,int c,int k){
            this.src=s;
            this.cost=c;
            this.stops=k;
        }
    }
    public static void createGraph(int arr[][],ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            edge z=new edge(arr[i][0], arr[i][1], arr[i][2]);
            graph[arr[i][0]].add(z);
        }
        
    }
    public static void shortFlightPath(int arr[][],int k,int src,int des){
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[arr.length+1];
        createGraph(arr, graph);

        int cost[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                cost[i]=Integer.MAX_VALUE;
            }
        }
        Queue<info> q=new LinkedList<>();
        q.add(new info(src, 0, 0));
        while(!q.isEmpty()){
            info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.src].size();i++){
                edge e=graph[curr.src].get(i);
                if(curr.cost+e.wt<cost[e.des] && curr.stops<=k && cost[curr.src]!=Integer.MAX_VALUE){
                    cost[e.des]=curr.cost+e.wt;
                    q.add(new info(e.des, cost[e.des], curr.stops+1));
                }
            }
        }
        if(cost[des]==Integer.MAX_VALUE){
            System.out.println("Does Not Exist");
        }
        else System.out.println("Value:"+cost[des]);
    }
    public static int n=7;
    public static int par[]=new int[n];
    public static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<par.length;i++){
            par[i]=i;
        }
    }

    public static int fint(int x){
        if(par[x]==x) return x;
        return par[x]=fint(par[x]);
    }
    public static void union(int a,int b){
        int parA=fint(a);
        int parB=fint(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
    }
    public static void main(String[] args) {
        // int v=4;
        // @SuppressWarnings("unchecked")
        // ArrayList<edge> graph[]=new ArrayList[v];
        // for(int i=0;i<v;i++){
        //     graph[i]=new ArrayList<>();
        // }
        // graph[0].add(new edge(0,1,10));
        // graph[0].add(new edge(0,2,15));
        // graph[0].add(new edge(0,3,30));
        // graph[1].add(new edge(1,0,10));
        // graph[1].add(new edge(1,3,40));
        // graph[2].add(new edge(2,0,15));
        // graph[2].add(new edge(2,3,50));
        // graph[3].add(new edge(3,1,40));
        // graph[3].add(new edge(3,2,50));
        // graph[4].add(new edge(4,5,5));
        
        // for(int i=0;i<graph[2].size();i++){
        //     edge e=graph[2].get(i);
        //     System.out.println(e.des);
        // }
        // bfs(graph);
        // boolean vis[]=new boolean[v];
        
        // System.out.println();
        // dfs(graph, 0, vis);
        // System.out.println();
        // System.out.println(hasPath(graph, 0, 3, vis));

        // dfsmain(graph);
        // System.out.println();
        // System.out.println(isBipartite(graph));
        // System.out.println(isCycleDirected(graph));
        // System.out.println(topologicalSort(););
        // topologicalSort(graph);
        // TSBfs(graph);
        // pathAll(graph, 5, 1, " ");

        // shortestPath(graph);
        // bellmanFord(graph, 0);
        // prims(graph);

        int n=1;
        int flight[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int des=3;
        shortFlightPath(flight, n, src, des);
        

    }


}
