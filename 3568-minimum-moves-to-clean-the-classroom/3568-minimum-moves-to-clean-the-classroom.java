class Solution {     

    int dr[] = {0, -1, 0, 1};     
    int dc[] = {-1, 0, 1, 0};     
         
    public int minMoves(String[] classroom, int energy) {     
          
           
        int n = classroom.length;     
        int m = classroom[0].length();     
        int a = -1;     
        int b = -1;     
        int l = 0;  
         
        int ind[][] = new int[n][m];  
  
        for (int i = 0; i < n; i++) {     
            for (int j = 0; j < m; j++) {     
                char c = classroom[i].charAt(j);  
  
                if (c == 'S') {     
                    a = i;     
                    b = j;     
                }     
  
                if (c == 'L') {    
                    ind[i][j] = l;  
                    l++;     
                }     
            }     
        } 

        boolean vis[][][][] = new boolean[n][m][energy + 1][1 << l];
        Queue<int[]> q = new ArrayDeque<>(); 
        int cur[] = {a, b, energy, 0, 0}; 
        q.offer(cur); 
        int ans = 0; 

        while (!q.isEmpty()) { 

            int arr[] = q.poll(); 
            int r = arr[0]; 
            int c = arr[1]; 
            int cure = arr[2]; 
            int mask = arr[3]; 
            int moves = arr[4]; 

            if (mask == (1 << l) - 1) { 
                
                return moves; 
            } 

            if (vis[r][c][cure][mask]) { 
                continue; 
            } 

            vis[r][c][cure][mask] = true; 

            for (int k = 0; k <= 3; k++) { 
                int nr = r + dr[k]; 
                int nc = c + dc[k]; 

                if (nr >= 0 && nr < n && nc >= 0 && nc < m  ) { 
                    int newen = cure - 1; 
                    char ch = classroom[nr].charAt(nc); 
                     
                    if (cure > 0 && ch!='X') { 
                         
                        if (ch == 'R') { 
                            newen = energy; 
                        } 
                    int litmask=mask;
                        if (ch == 'L') { 
                           litmask = litmask | (1 << ind[nr][nc]); 
                        } 

                        q.offer(new int[]{nr, nc, newen, litmask, moves + 1}); 
                    } 
                } 
            } 
        } 

        return -1;
    }     
}