class Solution {
    int count=0;
    public int makeConnected(int n, int[][] c) {
       
      int []par=new int [n];
      int []rank=new int[n];
      for(int i=0;i<n;i++){
    par[i]=i;
}
     

      for(int i=0;i<c.length;i++){
        int a=c[i][0];
        int b=c[i][1];
        union(a,b,par,rank);
      }
      HashSet<Integer> set = new HashSet<>();
for(int i = 0; i < n; i++){
    set.add(find(i,par));
}
      
     
      int k=set.size();
      if(count>=k-1){
        return k-1;
      }else{
        return -1;
      }

     
    }
    public void union(int a ,int b,int []par,int []rank){
int p1=find(a,par);
int p2=find(b,par);
if(p1==p2){
    count++;
    return ;
}
if(rank[p1]==rank[p2]){
    par[p2]=p1;
    rank[p1]++;

}else if(rank[p1]>rank[p2]){
par[p2]=p1;
}else{
    par[p1]=p2;
    
}

    }
    public int find(int a,int []par){
        if(a==par[a]){
            return a;
        }
        return find(par[a],par);
    }
}