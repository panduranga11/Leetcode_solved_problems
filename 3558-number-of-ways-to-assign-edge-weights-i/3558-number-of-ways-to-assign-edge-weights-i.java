class Solution {
    public int assignEdgeWeights(int[][] edges) {

    int n=edges.length+1;
     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
     for(int i=0;i<=n;i++){
    adj.add(new ArrayList<>());  
     }
     for(int i=0;i<n-1;i++){
        int u=Math.min(edges[i][0],edges[i][1]);
        int v=Math.max(edges[i][0],edges[i][1]);
        adj.get(u).add(v);
     }
    // System.out.println(adj);
   int h=0;
   Queue<Integer>q=new LinkedList<>();
   q.add(1);
   while(!q.isEmpty()){
    int k=q.size();
    for(int i=0;i<k;i++){
        //System.out.println(i);
int l=q.poll();

        for(int m:adj.get(l)){
            q.offer(m);
            //System.out.println(q);
        }

    }
     //System.out.println("height is:"+h);
    h++;
   }
  

   int depth=h-1;
   System.out.println(depth);
    long ans=pow(depth-1);
    return (int)ans;
 

  
  
    }
    public int pow(int n){
        int ans=1;
        while(n>0){
            ans=(ans*2)%1000000007;
            n--;
        }
        return ans;
    }
    
}