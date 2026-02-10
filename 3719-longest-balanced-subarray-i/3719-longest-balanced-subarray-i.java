class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;
        int maxi=0;
        for(int i=0;i<n;i++){
        HashSet<Integer>e=new HashSet<>();
         HashSet<Integer>o=new HashSet<>();
        for(int j=i;j<n;j++){
            if((nums[j]&1)==0){
                e.add(nums[j]);
            }else{
                o.add(nums[j]);
            }
            if(o.size()==e.size()){
                maxi=Math.max(maxi,j-i+1);
            }
        }
        }
        return maxi;
    
    }
}