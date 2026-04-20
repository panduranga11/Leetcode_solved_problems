class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int i:nums){
            max=Math.max(max,i);
        }
      
 int arr[]=new int[max+1];
 for(int ele:nums){
    arr[ele]++;
 }
 int dp[]=new int[arr.length];
 Arrays.fill(dp,-1);
 return maxsum(0,arr,dp);
 
    }
    public int maxsum(int ind,int []arr,int []dp){
        if(ind>=arr.length){
            return  0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick=ind*arr[ind]+maxsum(ind+2,arr,dp);
        int notpick=maxsum(ind+1,arr,dp);
        return dp[ind]= Math.max(pick,notpick);
    }
   
}

//TLE
//  public int points(int i,int []nums,HashMap<Integer,Integer>hs){
//         if(i==nums.length){
//             return 0;
//         }
        
//         int pick=0;
//         if(!hs.containsKey(nums[i])){
//             hs.put(nums[i]-1,hs.getOrDefault(nums[i]-1,0)+1);
//             hs.put(nums[i]+1,hs.getOrDefault(nums[i]+1,0)+1);
//             pick=nums[i]+points(i+1,nums,hs);
//             if(hs.get(nums[i]-1)==1){
//                 hs.remove(nums[i]-1);
//             }else{
//                hs.put(nums[i]-1,hs.get(nums[i]-1)-1);
//             }
//             if(hs.get(nums[i]+1)==1){
//                 hs.remove(nums[i]+1);
//             }else{
//                hs.put(nums[i]+1,hs.get(nums[i]+1)-1);
//             }
            
//         }
//         int notpick=points(i+1,nums,hs);
//         //System.out.println("index is"+i+" "+Math.max(pick,notpick));
//         return Math.max(pick,notpick);
//     }