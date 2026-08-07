class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int par[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int r1=stones[i][0];
                int c1=stones[i][1];
                int r2=stones[j][0];
                int c2=stones[j][1];
                if(r1==r2 || c1==c2){
                  //  System.out.println(i+" "+j);
                union(par,rank,i,j);
                }
            }
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int pp=find(par,i);
            //System.out.println(pp);
            map.put(pp,map.getOrDefault(pp,0)+1);
        }
        System.out.println(map);
        System.out.println(Arrays.toString(par));
        int ans=0;
        for(int key:map.keySet()){
ans+=map.get(key)-1;
        }
        return ans;
    }
    public int find(int []par,int node){
        if(par[node]!=node){
return par[node]=find(par,par[node]);
        }
        return node;
    }
    public void union(int []par,int []rank,int a,int b){
        int p1=find(par,a);
        //System.out.println("p1:"+p1);
        int p2=find(par,b);
          //System.out.println("p2:"+p2);
          //System.out.println("r1:"+rank[p1]);
          //System.out.println("r2:"+rank[p2]);

        if(rank[p1]==rank[p2]){
            par[p2]=p1;
            rank[p1]++;
        }else if(rank[p1]>rank[p2]){
par[p2]=p1;
        }else{
par[p1]=p2;
        }
    }

}