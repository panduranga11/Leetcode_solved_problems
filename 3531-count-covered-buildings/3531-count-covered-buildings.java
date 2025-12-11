class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        int mmrow[][] = new int[n+1][2];
        int mmcol[][] = new int[n+1][2];

        for (int i = 0; i < b.length; i++) {
            int r = b[i][0];
            int c = b[i][1];

           
            if (mmrow[r][0] == 0) {
                mmrow[r][0] = c;
            }else{
                mmrow[r][0]=Math.min(mmrow[r][0],c);
            }
            if (mmrow[r][1] == 0) {
                mmrow[r][1] = c;
            }else{
             mmrow[r][1]=Math.max(mmrow[r][1],c);
            }

        
            if (mmcol[c][0] == 0) {
                mmcol[c][0] = r;
            }else{
            mmcol[c][0]=Math.min(mmcol[c][0],r);
            }
            if (mmcol[c][1] == 0) {
                mmcol[c][1] = r;
            }else{
            mmcol[c][1]=Math.max(mmcol[c][1],r);
            }
        }
        for(int i=0;i<=n;i++){
            if(mmrow[i][0]==0){
                mmrow[i][0]=Integer.MAX_VALUE;
            }
            if(mmrow[i][1]==0){
                mmrow[i][1]=Integer.MIN_VALUE;
            }
             if(mmcol[i][0]==0){
                mmcol[i][0]=Integer.MAX_VALUE;
            }
            if(mmcol[i][1]==0){
                mmcol[i][1]=Integer.MIN_VALUE;
            }
        }

        for(int i=0;i<=n;i++){
            System.out.println(i);
            System.out.println(mmrow[i][0]+" "+mmrow[i][1]);
        }
        for(int i=0;i<=n;i++){
            System.out.println(mmcol[i][0]+" "+mmcol[i][1]);
        }
        int count=0;
        for(int i=0;i<b.length;i++){
      int r=b[i][0];
      int c=b[i][1];
      if (mmrow[r][0] < c && c < mmrow[r][1] &&
    mmcol[c][0] < r && r < mmcol[c][1]) {
    count++;
}
        }
        return count;

       
        

    }
}
