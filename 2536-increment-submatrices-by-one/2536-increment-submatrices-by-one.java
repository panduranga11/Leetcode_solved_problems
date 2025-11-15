class Solution {
    public void adder(int r1,int r2,int c1,int c2,int [][]arr){
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
            arr[i][j]+=1;
            }
        }

    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][]=new int[n][n];
        for(int []i:queries){
            adder(i[0],i[2],i[1],i[3],ans);
        }
        return ans;
    }
}