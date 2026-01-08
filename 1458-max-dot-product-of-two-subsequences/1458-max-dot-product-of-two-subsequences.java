class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int minpos;
        int maxneg;
        if(nums1[0]>0){
            minpos=nums1[0];
            for(int i:nums1){
                minpos=Math.min(i,minpos);
            }
            maxneg=nums2[0];
            for(int i:nums2){
                maxneg=Math.max(i,maxneg);
            }

        }else{
            minpos=nums2[0];
            for(int i:nums2){
                minpos=Math.min(i,minpos);
            }
             maxneg=nums1[0];
             for(int i:nums1){
                maxneg=Math.max(i,maxneg);
            }


        }
        int k=minpos*maxneg;
        int [][][]dp=new int[nums1.length][nums2.length][2];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(nums1,nums2,0,0,0,k,dp);
        




    }
    public int solve(int []num1 ,int []num2,int i,int j,int mark,int k,int [][][]dp){
       
        if(i>=num1.length || j>=num2.length){
            if(mark==1){
                return 0;
            }else{
return k;
            }
        }
        if(dp[i][j][mark]!=Integer.MIN_VALUE){
            return dp[i][j][mark];
        }
        
       
        int pick=num1[i]*num2[j]+solve(num1,num2,i+1,j+1,1,k,dp);
        
        int notpick=Math.max(solve(num1,num2,i+1,j,mark,k,dp),solve(num1,num2,i,j+1,mark,k,dp));
        return dp[i][j][mark]=Math.max(pick,notpick);
        
      
        
    }
}
