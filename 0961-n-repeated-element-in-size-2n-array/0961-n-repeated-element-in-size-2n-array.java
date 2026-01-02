class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }else{
                return nums[i];
            }
        }
        return -1;
        
    }
}