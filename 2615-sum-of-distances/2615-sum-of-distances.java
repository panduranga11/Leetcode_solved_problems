class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long []ans=new long[nums.length];
        HashMap<Integer,Integer>rf=new HashMap<>();
        HashMap<Integer,Integer>lf=new HashMap<>();
        HashMap<Integer,Integer>ls=new HashMap<>();
        HashMap<Integer,Integer>rs=new HashMap<>();
        for(int i=0;i<n;i++){
          rf.put(nums[i],rf.getOrDefault(nums[i],0)+1);
          rs.put(nums[i],rs.getOrDefault(nums[i],0)+i);
        }
        System.out.println(rs);
        for(int i=0;i<n;i++){
            if(rf.get(nums[i])==1){
                rf.remove(nums[i]);
            }else{
                rf.put(nums[i],rf.get(nums[i])-1);
            }
            if(rs.get(nums[i])==i){
                rs.remove(nums[i]);
            }else{
                rs.put(nums[i],rs.get(nums[i])-i);
            }

            int leftfreq=lf.containsKey(nums[i])?lf.get(nums[i]):0;
            int rightfreq=rf.containsKey(nums[i])?rf.get(nums[i]):0;
            int leftsum=ls.containsKey(nums[i])?ls.get(nums[i]):0;
            int rightsum=rs.containsKey(nums[i])?rs.get(nums[i]):0;
ans[i]=1L*(1L*leftfreq*i+rightsum-1L*rightfreq*i-leftsum);
 lf.put(nums[i],lf.getOrDefault(nums[i],0)+1);
  ls.put(nums[i],ls.getOrDefault(nums[i],0)+i);


            
           


        }
      return ans;
        
        
    }
}