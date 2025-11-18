class Solution {
    static class E{
        int node;
        int t;
        E(int node,int t){
            this.node=node;
            this.t=t;
        }
    }
    public int count(int V,List<List<E>>adj,int []dis,int []ways,int src){
        PriorityQueue<E>pq=new PriorityQueue<>((a,b)->a.t-b.t);
        pq.offer(new E(src,0));
        ways[src]=1;
        while(!pq.isEmpty()){
             E ee=pq.poll();
            int u=ee.node;
            int t=ee.t;
            if (t > dis[u]) continue;

           
            for(E e:adj.get(u)){
               int vertex=e.node;
               int time=e.t;
               if(dis[vertex]>dis[u]+time){
                   dis[vertex]=dis[u]+time;
                   pq.offer(new E(vertex,dis[vertex]));
                   ways[vertex]=ways[u];
               }else if(dis[vertex]==dis[u]+time){
                   ways[vertex]=ways[vertex]+ways[u];
               }
            }
        }
        return ways[V-1];
        
    }
    public int countPaths(int V, int[][] edges) {
        List<List<E>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int t=edges[i][2];
            adj.get(u).add(new E(v,t));
            adj.get(v).add(new E(u,t));
            
        }
        int dis[]=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int []ways=new int[V];
        return count(V,adj,dis,ways,0);
        
    }
    
}
