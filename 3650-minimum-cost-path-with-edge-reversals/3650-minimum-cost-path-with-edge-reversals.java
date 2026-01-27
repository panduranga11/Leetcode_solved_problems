class Solution {
    class pair{
        int v;
        int c;
        pair(int v,int c){
            this.v=v;
            this.c=c;
        }
    }
    public int minCost(int n, int[][] edges) {
        int m=edges.length;
       ArrayList<ArrayList<pair>>adj=new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());

       }
       for(int i=0;i<m;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int w=edges[i][2];
        adj.get(u).add(new pair(v,w));
        adj.get(v).add(new pair(u,2*w));
       }
       int dis[]=new int[n];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[0]=0;
       PriorityQueue<pair> pq = new PriorityQueue<>(
      Comparator.comparingInt(x -> x.c)
);
pq.offer(new pair(0,0));
while(!pq.isEmpty()){
    pair pp=pq.poll();
    int u=pp.v;
    int c=pp.c;
    if(dis[u]<c){
        continue;
    }
    for(pair p:adj.get(u)){
        int v=p.v;
        int cost=p.c;
        if(dis[u]+cost<dis[v]){
            dis[v]=dis[u]+cost;
            pq.offer(new pair(v,dis[v]));
        }
    }
}
System.out.println(Arrays.toString(dis));
return dis[n-1]==2147483647?-1:dis[n-1];


    }
}