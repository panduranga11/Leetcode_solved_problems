class Solution {
    int []dr={-1,0,+1,0};
    int []dc={0,+1,0,-1};
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean vis[][]=new boolean[m][n];
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a[2],b[2]);
        });
        
        pq.offer(new int []{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int []cur=pq.poll();

            int ci=cur[0];
            int cj=cur[1];
            int time=cur[2];
            if(ci==m-1 && cj==n-1){
                return time;
            }
           
            
            for(int k=0;k<4;k++){
         int nr=ci+dr[k];
         int nc=cj+dc[k];
         if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc]){
             vis[nr][nc]=true;
            int t=Math.max(time,grid[nr][nc]);
            pq.offer(new int []{nr,nc,t});

         }
            }
        }
        return -1;
    }
}