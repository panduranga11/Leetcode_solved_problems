class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long []ans=new long[nums.length];
        HashMap<Integer,Integer>rf=new HashMap<>();
        HashMap<Integer,Integer>lf=new HashMap<>();
        HashMap<Integer,Long>ls=new HashMap<>();
        HashMap<Integer,Long>rs=new HashMap<>();
        for(int i=0;i<n;i++){
          rf.put(nums[i],rf.getOrDefault(nums[i],0)+1);
          rs.put(nums[i],rs.getOrDefault(nums[i],0L)+i);
        }
        System.out.println(rs);
        for(int i=0;i<n;i++){
            
                rf.put(nums[i],rf.get(nums[i])-1);
                rs.put(nums[i],rs.get(nums[i])-i);
            

            int leftfreq=lf.getOrDefault(nums[i],0);
            int rightfreq=rf.getOrDefault(nums[i],0);
            long leftsum=ls.getOrDefault(nums[i],0L);
            long rightsum=rs.getOrDefault(nums[i],0L);
ans[i]=1L*(1L*leftfreq*i+rightsum-1L*rightfreq*i-leftsum);
 lf.put(nums[i],lf.getOrDefault(nums[i],0)+1);
  ls.put(nums[i],ls.getOrDefault(nums[i],0L)+i);


            
           


        }
      return ans;
        
        
    }
}