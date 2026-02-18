class Solution {
    class Pair{
        int diff;
        int row;
        int col;
        Pair(int diff,int row,int col){
            this.diff=diff;
            this.row=row;
            this.col=col;
        }
    }
    static int []dr={-1,0,+1,0};
    static int []dc={0,+1,0,-1};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(a->a.diff));
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair u=pq.poll();
            int r=u.row;
            int c=u.col;
            int d=u.diff;
            if(r==m-1 && c==n-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int cur=Math.abs(heights[r][c]-heights[nr][nc]);
                    int di=Math.max(d,cur);
                    if(di<dis[nr][nc]){
                        
                        dis[nr][nc]=di;
                        pq.offer(new Pair(di,nr,nc));

                    }

                }
            }
        }
        return 0;
        


        
    }
    
}