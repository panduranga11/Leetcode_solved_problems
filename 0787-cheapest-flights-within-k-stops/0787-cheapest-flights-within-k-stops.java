class Solution {
    class Pair{
        
        int t;
        int p;
        int k;
        Pair(int t,int p,int k){
           
            this.t=t;
            this.p=p;
            this.k=k;
        }
        Pair(int t,int p){
            this.t=t;
            this.p=p;
        }
        public String toString(){
            return this.t+" "+this.p;
        }


    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int kf) {
        List<List<Pair>>ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
           int from= flights[i][0];
           int to=flights[i][1];
           int pri=flights[i][2];
            ls.get(from).add(new Pair(to,pri));
        }
        //System.out.println(ls);
        int dis[][]=new int[n][kf+1];
        for(int []i:dis){
            Arrays.fill(i,10000000);
        }
        dis[src][0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return a.p-b.p;
        });
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.t;
            int price=p.p;
            int k=p.k;
            //System.out.println(node+" "+price+" "+" "+k);
            if(node==dst){
                return price;
            }
            if(dis[node][k]<price){
                continue;
            }
            
            for(Pair pp:ls.get(node)){
                int v=pp.t;
                int cost=pp.p;
                int kk=k+1;
                if(v==dst){
                    kk=k;
                }
                if(kk<=kf && dis[node][k]+cost<dis[v][kk]){
                    dis[v][kk]=dis[node][k]+cost;
                    pq.offer(new Pair(v,dis[v][kk],kk));
                }

            }



        }
        return -1;


        
    }

}