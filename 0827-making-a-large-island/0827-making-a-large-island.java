class Solution {
    int []dr={-1,0,1,0};
    int []dc={0,+1,0,-1};
    public int largestIsland(int[][] grid) {
       int max=0;
       int m=grid.length;
       int n=grid[0].length;
       boolean zero=false;
       boolean vis[][]=new boolean[m][n];
       HashMap<Integer,Integer>map=new HashMap<>();
    int ind=1;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            if(grid[i][j]==1){
                 
              ind++;
              grid[i][j]=ind;
              vis[i][j]=true;
                int val=dfs(i,j,grid,vis,ind);
                
                map.put(ind,val);
            }
        }
       }
      // System.out.println(map);
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==0){
                zero=true;
                int cur=1;
                Set<Integer>set=new HashSet<>();
        for(int k=0;k<4;k++){
            
            int nr=i+dr[k];
            int nc=j+dc[k];
        if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length){
            if(grid[nr][nc]!=0){
            if(!set.contains(grid[nr][nc])){
            cur+=map.get(grid[nr][nc]);
            set.add(grid[nr][nc]);
            }
            
            }
        }
        
       
        }
         max=Math.max(max,cur);
         
        }
           
            }
        }
    // for(int i=0;i<m;i++){
        
    //         System.out.println(Arrays.toString(grid[i]));
        
    // }
       
        if(!zero){
            return m*n;
        }
         return max;
       }
       
    
    public int dfs(int i,int j,int grid[][],boolean [][]vis,int ind){
     int count=1;
     for(int k=0;k<4;k++){
        int nr=i+dr[k];
        int nc=j+dc[k];
        if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
            vis[nr][nc]=true;
            grid[nr][nc]=ind;
            count+=dfs(nr,nc,grid,vis,ind);
        }
     }
     return count;

    }
}
