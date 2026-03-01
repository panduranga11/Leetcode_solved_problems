class Solution {
    public int minimumOR(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int val=0;
for (int i = 17; i >=0; i--) {
            int t=val|((1<<i)-1);
            
            if (!checker(grid, t)) {
                
                val |= (1 << i);
            }
        }
        return val;
        
        
        
        
        
    }
    public boolean checker(int [][]grid,int val){
        int m=grid.length;
        int n=grid[0].length;
       
        for(int i=0;i<m;i++){
             boolean flag=false;
            
            
            for(int j=0;j<n;j++){
               if((val |grid[i][j])==val){
                   flag=true;
                   break;
               }
                
            }
            if(!flag){
                return false;
            }
            
            
            
        }
        return true;
        
    }
    
}
