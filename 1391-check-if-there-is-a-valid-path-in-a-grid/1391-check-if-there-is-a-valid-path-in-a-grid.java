class Solution {
    int []dr={-1,0,+1,0};
    int []dc={0,+1,0,-1};
    char d[] = {'T','R','B','L'};
    HashMap<Character,HashSet<Integer>>map=new HashMap<>();
    HashMap<Integer,HashSet<Character>>allowed=new HashMap<>();
    public boolean hasValidPath(int[][] grid) {
       
      
      boolean vis[][]=new boolean[grid.length][grid[0].length];
      map.put('L',new HashSet<>(Arrays.asList(1,4,6)));
      map.put('R',new HashSet<>(Arrays.asList(1,3,5)));
      map.put('T',new HashSet<>(Arrays.asList(2,3,4)));
      map.put('B',new HashSet<>(Arrays.asList(2,5,6)));

      allowed.put(1, new HashSet<>(Arrays.asList('L','R')));
        allowed.put(2, new HashSet<>(Arrays.asList('T','B')));
        allowed.put(3, new HashSet<>(Arrays.asList('L','B')));
        allowed.put(4, new HashSet<>(Arrays.asList('R','B')));
        allowed.put(5, new HashSet<>(Arrays.asList('L','T')));
        allowed.put(6, new HashSet<>(Arrays.asList('R','T')));



      vis[0][0]=true;
    return solve('n',0,0,grid,vis);
      

    }
    public boolean solve(char prev,int i,int j,int [][]grid,boolean vis[][]){
        
        if(i==grid.length-1 && j==grid[0].length-1){
            return true;
        }
        for(int k=0;k<4;k++){
int nr=i+dr[k];
int nc=j+dc[k];
char p=d[k];

if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && allowed.get(grid[i][j]).contains(p) && map.get(p).contains(grid[nr][nc]) && !vis[nr][nc]){
   
    vis[nr][nc]=true;
   if( solve(p,nr,nc,grid,vis))return true;
   vis[nr][nc]=false;
}

        }

        
       
        return false;
    }
}