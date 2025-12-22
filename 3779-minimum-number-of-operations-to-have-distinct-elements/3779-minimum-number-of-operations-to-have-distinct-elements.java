class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        int n=nums.length;
        int ind=-1;
        for(int i=n-1;i>=0;i--){
            if(!s.contains(nums[i])){
                s.add(nums[i]);
            }else{
                ind=i;
                break;

            }
            }
            System.out.println(ind);
            if(ind==-1){
                return 0;
            }

            int ans=(ind+1)/3;
            if((ind+1)%3!=0){
                ans+=1;
            }
            return ans;

           
}
}