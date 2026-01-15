class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
          Arrays.sort(h);
          Arrays.sort(v);
          int hmin;
          int vmin;
          int l1=h.length;
          int l2=v.length;
          int c1=1;
          int c2=1;
          int maxh=1;
          int maxv=1;

          for(int i=1;i<l1;i++){
            if(h[i]-h[i-1]==1){
                c1++;
            }else{
               
                maxh=Math.max(maxh,c1);
                 c1=1;
            }

          }
          
          maxh=Math.max(maxh,c1);
          for(int i=1;i<l2;i++){
            if(v[i]-v[i-1]==1){
                c2++;
            }else{
                
                maxv=Math.max(maxv,c2);
                c2=1;
            }

          }
          maxv=Math.max(maxv,c2);
          int side=Math.min(maxh,maxv)+1;
          return side*side;

    }
}