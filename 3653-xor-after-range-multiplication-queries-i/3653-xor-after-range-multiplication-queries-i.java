class Solution {
    static int mod=1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] q) {
    int n=nums.length;
    int r=q.length;
   
    for(int i=0;i<r;i++){
        int st=q[i][0];
        int end=q[i][1];
        int k=q[i][2];
        int v=q[i][3];
solve(nums,st,end,k,v);
    }
    int xor=0;
    for(int i:nums){
        xor^=i;
    }
    return xor;

    }
    public void solve(int []nums,int st,int end,int k,int v){
        for(int i=st;i<=end;i+=k){
            nums[i] = (int)((1L * nums[i] * v) % mod);
            

        }
    }
}