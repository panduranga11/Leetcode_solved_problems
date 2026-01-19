class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int maxlen=0;
        int m=mat.length;
        int n=mat[0].length;
        int [][]presum=new int[m][n];
    for(int i=0;i<m;i++){
        int sum=0;
        for(int j=0;j<n;j++){
        sum+=mat[i][j];
        presum[i][j]=sum;
        }
    }
    return bs(presum,threshold);
    }
    public int bs(int [][]psum,int ts){
        int ans=0;
        int l=0;
        int m=psum.length;
        int n=psum[0].length;
        int r=Math.min(m,n);
        while(l<=r){
            int mid=(l+r)/2;
            if(check(mid,psum,ts)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    public boolean check(int k,int [][]psum,int ts){
        if(k == 0) return true;

        int m=psum.length;
        int n=psum[0].length;
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                int sum=0;
                for(int row=i;row<=i+k-1;row++){
                     if(j!=0){
                        sum+=psum[row][j+k-1]-psum[row][j-1];
                     }else{
                        sum+=psum[row][j+k-1];
                     }
                }
                if(sum<=ts){
                    return true;
                }
            }
        }
        return false;
        
    }
}