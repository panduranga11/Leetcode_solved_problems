class Solution {
   

    public int maxEnvelopes(int[][] env) {
        int n=env.length;
        Arrays.sort(env,(a,b)->{
        if(Integer.compare(a[0],b[0])==0){
            return Integer.compare(b[1],a[1]);
        }
        return Integer.compare(a[0],b[0]);
       });
       int len=0;
       
int dp[]=new int[env.length];
       
       for(int i=0;i<n;i++){
        int x=env[i][1];
        
            int pos=bs(dp,x,len);
            if(pos==len){
            len++;
            dp[pos]=x;
            }else{
                dp[pos]=x;
            }

        



       }
       return len;



    } 
    public int bs(int [] arr, int x, int r){
        int l=0;
       
        int ans=-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=x){
                r=mid;
                ans=mid;
            }else{
                l=mid+1;
            }
        }
        return ans==-1?r:ans;
    }
    }

//THIS DP SOLUTION WORKS FOR LOW CONSTRAINS NOT FOR THE LARGER like 10^5

//        int [][]dp=new int[env.length][env.length+1];
//        for(int i=0;i<env.length;i++){
//         Arrays.fill(dp[i],-1);
//        }
//        return solve(0,env,-1,dp);
//     }
//     public int solve(int ind ,int [][]env,int prev,int [][]dp){
//         if(ind>=env.length){
//             return 0;
//         }
//         if(dp[ind][prev+1]!=-1){
//             return dp[ind][prev+1];
//         }
//         int pick=0;
//         int np=0;
//         int h=env[ind][1];
//         int w=env[ind][0];
        
//         if(prev==-1 || (env[prev][0]<w && env[prev][1]<h) ){
//             pick=1+solve(ind+1,env,ind,dp);
//         }
//         np=solve(ind+1,env,prev,dp);
//         return dp[ind][prev+1]= Math.max(pick,np);
//     }