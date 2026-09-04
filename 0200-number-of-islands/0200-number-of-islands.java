class Solution {
    int dr[]={0,-1,0,1};
    int dc[]={-1,0,1,0};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean vis[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
count++;
bfs(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char [][]grid,boolean vis[][],int i,int j){
        Queue<int []>q=new LinkedList<>();
        q.offer(new int []{i,j});
          vis[i][j]=true;
        while(!q.isEmpty()){
            int []c=q.poll();
            int r=c[0];
            int col=c[1];
          
            for(int k=0;k<=3;k++){
                int nr=r+dr[k];
                int nc=col+dc[k];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='1'){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }


        }
    }
}