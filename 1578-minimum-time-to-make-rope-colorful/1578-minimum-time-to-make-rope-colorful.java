class Solution {
    public int minCost(String colors, int[] nt) {
        int mincost=0;
        int prev=nt[0];
        for(int i=1;i<colors.length();i++){
            char c=colors.charAt(i);
             char cpre=colors.charAt(i-1);
            if(c==cpre){
                
                if(prev>=nt[i]){
                    mincost+=nt[i];
                }else{
                    mincost+=prev;
                    prev=nt[i];
                }


            }else{
            prev=nt[i];
            }

        }
        return mincost;
    }
}
//SOL 2(EFFICIENT)
class Solution {
    public int minCost(String colors, int[] nt) {
        int mincost=0;
        int prev=nt[0];
        for(int i=1;i<colors.length();i++){
            char c=colors.charAt(i);
             char cpre=colors.charAt(i-1);
            if(c==cpre){
                
               mincost+=Math.min(nt[i],nt[i-1]);
               nt[i]=Math.max(nt[i],nt[i-1]);


        }
        
    }
    return mincost;
    }
}
