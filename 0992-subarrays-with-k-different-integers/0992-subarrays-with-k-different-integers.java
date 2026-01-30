class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        return kdis(nums,k)-kdis(nums,k-1);
        

        
    }
    public int kdis(int []nums,int k){
        int l=0;
        int r=0;
        int n =nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;

        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                if(map.get(nums[l])==1){
                    map.remove(nums[l]);
                }else{
                    map.put(nums[l],map.get(nums[l])-1);
                }
                l++;

            }
           
            ans+=(r-l+1);
            r++;



        }
       
        return ans;
    }
    
}