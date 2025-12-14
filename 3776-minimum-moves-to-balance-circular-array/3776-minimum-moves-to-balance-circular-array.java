class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;

        long total = 0;
        int negIdx = -1;

        
        for (int i = 0; i < n; i++) {
            total += balance[i];
            if (balance[i] < 0) {
                negIdx = i;
            }
        }

        
        if (total < 0) return -1;

        
        if (negIdx == -1) return 0;

        long need = -balance[negIdx];
        long moves = 0;

        int left = (negIdx - 1 + n) % n;
        int right = (negIdx + 1) % n;
        
        int dis=1;


        
        while (need > 0) {
           
           
           
            
            if(balance[left] > 0){
                
                long take=Math.min(balance[left],need);
                balance[left] -= take;
                need-=take;
                moves+=take*dis;
                
             
               
               

            }
            if(need > 0 && balance[right] > 0){
                
               long take=Math.min(balance[right],need);
                 balance[right] -= take;
                need-=take;
                moves+=take*dis;
            }
            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            dis++;

            }
          


          
            
            return moves;
        }

        
    
}