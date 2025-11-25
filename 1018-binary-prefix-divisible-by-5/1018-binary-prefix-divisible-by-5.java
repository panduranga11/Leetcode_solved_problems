class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int l=nums.length;
        List<Boolean>ans=new ArrayList<>();
        long n=0;
        for(int i=0;i<l;i++){
            if(nums[i]==1){
                n=(2*n+1)%5;
                if(n%5==0){
                    ans.add(true);
                }else{
                    ans.add(false);
                }
            }else{
                n=(2*n)%5;
                if(n%5==0){
                    ans.add(true);
                }else{
                    ans.add(false);
                }
            }
        }
        return ans;
    }
}