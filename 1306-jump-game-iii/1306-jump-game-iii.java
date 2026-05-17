class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean vis[]=new boolean[n];
        Boolean dp[]=new Boolean[n];
       return solve(start,arr,vis,dp); 

    }
    public boolean solve(int ind,int []arr,boolean []vis,Boolean dp[]){
         
        if(ind >=arr.length ||ind<0){
            return false;
        }
        if(arr[ind]==0){
            return true;
        }
       
        if(vis[ind]){
            return false;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        vis[ind]=true;
        if(solve(ind+arr[ind],arr,vis,dp)){
            return true;
        }
        

        if(solve(ind-arr[ind],arr,vis,dp)){
            return true;
        }
       
        return dp[ind]=false;
        
    }
}