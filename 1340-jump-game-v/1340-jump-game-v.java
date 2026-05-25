class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int max=1;
        int dp[]=new int [n+1];
        for(int i=0;i<n;i++){
            max=Math.max(max,solve(i,arr,d,dp));
        }
        return max;
        
    }
    public int solve(int ind,int []arr,int d,int []dp){
        if(ind<0 ||ind >=arr.length){
            return 0;
        }
        if(dp[ind]!=0){
            return dp[ind];
        }
        int max=1;
       for(int l=ind-1;l>=ind-d;l--){
        if(l>=0 && l<arr.length && arr[ind]>arr[l]){
        max=Math.max(max,1+solve(l,arr,d,dp));
        }else{
            break;
        }
       }
      for(int r=ind+1;r<=ind+d;r++){
        if(r>=0 && r<arr.length && arr[ind]>arr[r]){
            max=Math.max(max,1+solve(r,arr,d,dp));

        }else{
            break;
        }
      }
      return dp[ind]=max;
       }
    }
