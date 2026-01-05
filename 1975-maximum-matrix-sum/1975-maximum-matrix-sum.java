class Solution {
    public long maxMatrixSum(int[][] mat) {
        int n=mat.length;
       
        int cneg=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]<=0){
                    cneg++;
                    ;
                }
                sum+=Math.abs(mat[i][j]);
                
                min=Math.min(min,Math.abs(mat[i][j]));
            }
        }
        if(cneg%2==0){
            return sum;
        }else{
            return sum-2*min;
        }
    }
}