class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int heights[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                heights[i][j]=maxones(matrix,i,j);
            }
        }
        
    int ans=0;
    for(int i=0;i<m;i++){
        ans=Math.max(ans,maxarea(heights[i]));
    }
    return ans;
    }
public int maxarea(int[] h) {
    int ans=0;
   int n=h.length;
        Arrays.sort(h);
        for(int i=0;i<n;i++){
ans=Math.max(h[i]*(n-i),ans);

        }
        return ans;
}
public int maxones(int [][]matrix,int i,int j){
        if(matrix[i][j]=='0'){
            return 0;
        }
        int m=matrix.length;
        int count=0;
        for(int k=i;k<m;k++){
            if(matrix[k][j]==1){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}