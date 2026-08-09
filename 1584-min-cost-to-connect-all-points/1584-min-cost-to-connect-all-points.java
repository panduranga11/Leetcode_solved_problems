class Solution {
    
    public int minCostConnectPoints(int[][] points) {
     ArrayList<int[]>ls =new ArrayList<>();
     
     int n=points.length;
     int ans=0;
     int []par=new int [n];
     for(int i=0;i<n;i++){
        par[i]=i;
     }
     int rank[]=new int[n];
     for(int i=0;i<points.length;i++){
        for(int j=i+1;j<n;j++){
            int x1=points[i][0];
            int x2=points[j][0];
            int y1=points[i][1];
            int y2=points[j][1];
            int val=Math.abs(x1-x2)+Math.abs(y1-y2);
            ls.add(new int []{i,j,val});
        }
     }
    ls.sort((a,b)->{
        return a[2]-b[2];
    });
    for(int i[]:ls){
        int a=i[0];
        int b=i[1];
        int v=i[2];
        if(union(par,rank,a,b)){
            ans+=v;
        }
    }
     return ans;
    }
    public int find(int node,int []par){
        if(par[node]!=node){
            return par[node]=find(par[node],par);
        }
        return node;
    }
    
    public boolean union(int []par,int []rank,int a ,int b){
        int p1=find(a,par);
        int p2=find(b,par);
        int r1=rank[p1];
        int r2=rank[p2];
        if(p1==p2){
            return false;
        }
        if(r1>r2){
par[p2]=p1;

        }else if(r1<r2){
par[p1]=p2;
        }else{
par[p2]=p1;
rank[p1]++;
        }
        return true;
    }
}