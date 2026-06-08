class Solution {
    public long maxTotal(int[] nums, String s) {
       boolean vis[]=new boolean[nums.length];
       long [][]dp=new long[nums.length+1][2];
       for(int i=0;i<dp.length;i++){
       Arrays.fill(dp[i],-1);
       }
       return solve(0,nums,s,vis,dp);
        

    }
    public long solve(int ind,int nums[],String s, boolean vis[],long [][]dp){
        if(ind ==nums.length){
            return 0;
        }
        int val= ind!=0 && vis[ind-1]?1:0;
        if(dp[ind][val]!=-1){
            return dp[ind][val];
        }
        
        long pick=0;
        long pickl=0;
        if(s.charAt(ind)=='0'){
            return solve(ind+1,nums,s,vis,dp);
        }
        if(s.charAt(ind)=='1'){
            if(ind!=0 && !vis[ind-1]){
                vis[ind]=true;
                pick+=nums[ind]+solve(ind+1,nums,s,vis,dp);
                vis[ind]=false;
                vis[ind-1]=true;
                pickl=nums[ind-1]+solve(ind+1,nums,s,vis,dp);
                vis[ind-1]=false;
            }else{
                vis[ind]=true;
                pick+=nums[ind]+solve(ind+1,nums,s,vis,dp);
                vis[ind]=false;
            }
        }
        return dp[ind][val]=Math.max(pick,pickl);
    }
}