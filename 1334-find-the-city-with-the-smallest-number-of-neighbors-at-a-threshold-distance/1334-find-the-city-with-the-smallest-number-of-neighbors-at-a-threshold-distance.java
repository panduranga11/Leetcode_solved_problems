class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int dist[][]=new int[n][n];
        int max=(int)1e9;
        for(int i=0;i<n;i++){
Arrays.fill(dist[i],max);
dist[i][i]=0;
        }

        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];

            dist[u][v]=w;
            dist[v][u]=w;
        }
      
        
    
    for (int k = 0; k < n; k++) {

          
            for (int i = 0; i < n; i++) {

                
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != max && dist[k][j] != max &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
          //.out.println(Arrays.deepToString(dist));
       int city=0;
       int minc=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<n;j++){
if( i!=j && dist[i][j]<=dt){
    count++;
}
        }
        //System.out.println(i+" "+count);
        if(count<=minc){
            city =i;
            minc=count;
        }
       }
    return city;
    }
}