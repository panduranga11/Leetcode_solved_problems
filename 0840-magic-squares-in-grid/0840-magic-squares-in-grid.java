class Solution {
    public int numMagicSquaresInside(int[][] g) {
        int n=g.length;
        int m=g[0].length;
        int count=0;
        if(n<3 ||m<3){
            return 0;
        }
        for(int i=0;i<n-2;i++){
        for(int j=0;j<m-2;j++){
                int e1=g[i][j];
                int e2=g[i][j+1];
                int e3=g[i][j+2];
                int e4=g[i+1][j];
                int e5=g[i+1][j+1];
                int e6=g[i+1][j+2];
                int e7=g[i+2][j];
                int e8=g[i+2][j+1];
                int e9=g[i+2][j+2];
                boolean[] seen = new boolean[10];

             int[] vals = {e1, e2, e3, e4, e5, e6, e7, e8, e9};

           boolean valid = true;

for (int v : vals) {
    if (v<=0|| v > 9 || seen[v]) {
        valid = false;
        break;
    }
    seen[v] = true;
}
if(!valid){
    continue;
}               int r1=e1+e2+e3;
                int r2=e4+e5+e6;
                int r3=e7+e8+e9;
                int c1=e1+e4+e7;
                int c2=e2+e5+e8;
                int c3=e3+e6+e9;
                int d1=e1+e5+e9;
                int d2=e3+e5+e7;
               if (r1 == r2 && r2 == r3 &&
    r1 == c1 && c1 == c2 && c2 == c3 &&
    r1 == d1 && d1 == d2) {
count++;
    
}



            }
        }
        return count;

    }
}