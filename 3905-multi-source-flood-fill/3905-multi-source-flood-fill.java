class Solution {
    class Pair{
        int r;
        int c;
        int col;
        
        Pair(int r,int c,int col){
            this.r=r;
            this.c=c;
            this.col=col;
           
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
     Queue<Pair>q=new LinkedList<>();
        int r=sources.length;
        int c=sources[0].length;
        int ans[][]=new int[n][m];
        // Arrays.sort(sources,(a,b)->{
        //     return b[2]-a[2];
        // });
              for(int i=0;i<r;i++){
           
                int row=sources[i][0];
                int col=sources[i][1];
                int colo=sources[i][2];
               q.offer(new Pair(row,col,colo));
                ans[row][col]=colo;
                
        }
        //   q.forEach((Pair p)->{
        //     System.out.println(p.r+" "+p.c+" "+p.col);
        // });
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        while(!q.isEmpty()){
           int size=q.size();
           ArrayList<Pair>ls=new ArrayList<>();
           for(int i=0;i<size;i++){
            Pair p=q.poll(); 
ls.add(p);

           }
           ls.sort((a,b)->{
return b.col-a.col;
           });

for(int k=0;k<ls.size();k++){
    Pair p=ls.get(k);
            int cr=p.r;
            int cc=p.c;
            int col=p.col;
            

            for(int i=0;i<4;i++){
                int nr=cr+dr[i];
                int nc=cc+dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && ans[nr][nc]==0){
                    // System.out.println(nr +" "+nc);
                    q.offer(new Pair(nr,nc,col));
                    ans[nr][nc]=col;
                }
            }
}
            

        }
        return ans;
    }
}