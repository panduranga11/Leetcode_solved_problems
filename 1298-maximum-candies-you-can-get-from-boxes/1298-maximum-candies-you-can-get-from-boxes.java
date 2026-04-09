class Solution {
    
    public int maxCandies(int[] s, int[] c, int[][] k, int[][] cb, int[] i) {
    int n=s.length;
   
     HashSet<Integer>bfound=new HashSet<>();
    int total=0;
    boolean vis[]=new boolean[n];
    for(int in:i){
        total+=dfs(in,vis,s,c,k,cb,bfound);
    }
    return total;
    }
    public int dfs(int i,boolean []vis,int []s,int []c,int [][]k,int [][]cb, HashSet<Integer>bfound){
        if(vis[i]==true){
            return 0;
        }
        if(s[i]==0){
            bfound.add(i);
            return 0;

        }
        vis[i]=true;
        int can=c[i];
        for(int ins:cb[i]){
  can+=dfs(ins,vis,s,c,k,cb,bfound);
        }
        for(int key:k[i]){
            s[key]=1;
            if(bfound.contains(key)){
                can+=dfs(key,vis,s,c,k,cb,bfound);
            }
        }
        return can;
    }

    }
