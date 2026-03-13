class Solution {
    public static final long mod=1000000007;
    class Pair{
        int v;
        long t;
        Pair(int v,long t){
            this.v=v;
            this.t=t;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>>ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        long time[]=new long[n];
        long ways[]=new long[n];
        ways[0]=1;
        Arrays.fill(time,Long.MAX_VALUE);
       
        int m=roads.length;
        for(int i=0;i<m;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            long t=roads[i][2];
            ls.get(u).add(new Pair(v,t));
             ls.get(v).add(new Pair(u,t));
        }
        long count=0;
        time[0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingLong(a->a.t));
        pq.offer(new Pair(0,0));
while(!pq.isEmpty()){
 Pair p=pq.poll();
 int u=p.v;
 long t=p.t;
 if(time[u]<t){
    continue;
 }

 for(Pair pp:ls.get(u)){
    int v=pp.v;
    long tm=pp.t;
    if(time[u]+tm<time[v]){
        time[v]=time[u]+tm;
        pq.offer(new Pair(v,time[v]));
        ways[v]=ways[u];
        // System.out.println(v+" "+time[v]);
        
    }
    else if(time[u]+tm==time[v] ){
            ways[v]=(ways[u]+ways[v])%mod;
        }
 }
  

        }
        return (int)(ways[n-1]);
    }
}
//GOT TLE FOR THIS
// class Solution {
//     public static final long mod=1000000007;
//     class Pair{
//         int v;
//         long t;
//         Pair(int v,long t){
//             this.v=v;
//             this.t=t;
//         }
//     }
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<Pair>>ls=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             ls.add(new ArrayList<>());
//         }
//         long time[]=new long[n];
//         Arrays.fill(time,Long.MAX_VALUE);
       
//         int m=roads.length;
//         for(int i=0;i<m;i++){
//             int u=roads[i][0];
//             int v=roads[i][1];
//             long t=roads[i][2];
//             ls.get(u).add(new Pair(v,t));
//              ls.get(v).add(new Pair(u,t));
//         }
//         long count=0;
//         time[0]=0;
//         PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingLong(a->a.t));
//         pq.offer(new Pair(0,0));
//         while(!pq.isEmpty()){
//  Pair p=pq.poll();
//  int u=p.v;
//  long t=p.t;
//  if(time[u]<t){
//     continue;
//  }

//  for(Pair pp:ls.get(u)){
//     int v=pp.v;
//     long tm=pp.t;
//     if(time[u]+tm<=time[v]){
//         time[v]=time[u]+tm;
//         pq.offer(new Pair(v,time[v]));
//         // System.out.println(v+" "+time[v]);
//         if(v==n-1 && time[u]+tm==time[v] ){
//             count=(count+1)%mod;
//         }
//     }
//  }
  

//         }
//         return (int)count;
//     }
// }