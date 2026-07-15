class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int rank[]=new int [n];
        int par[]=new int [n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            union(u,v,par,rank);
        }
        //System.out.println("par:"+Arrays.toString(par));
       HashMap<Integer,Integer>nodes=new HashMap<>();
       HashMap<Integer,Integer>ee=new HashMap<>();
       for(int i=0;i<n;i++){
        int root = find(i, par);
        nodes.put(root,nodes.getOrDefault(root,0)+1);
       }
       for(int []i:edges){
        
        int root = find(i[0], par);
        //System.out.println(pare);
        ee.put(root,ee.getOrDefault(root,0)+1);
        //System.out.println(ee);


       }
       //System.out.println(ee);
       int ans=0;
       for(int pp:nodes.keySet()){
        int ce=ee.getOrDefault(pp,0);
        int nn=nodes.get(pp);
        if(ce==(nn*(nn-1)/2)){
            ans++;
        }

       }
       return ans;

      
    }
    public void union(int a,int b,int []par,int []rank){
int p1=find(a,par);
int p2=find(b,par);
if(p1==p2){
    return;
}
int r1=rank[p1];
int r2=rank[p2];
if(r1>r2){
par[p2]=p1;
}else if(r1<r2){
par[p1]=p2;
}else{
    par[p2]=p1;
    rank[p1]++;

}
    }
    public int find(int a,int []par){
        if(par[a]==a){
return a;
        }
        return find(par[a],par);
    
}
}