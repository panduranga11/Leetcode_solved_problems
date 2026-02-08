class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        Deque<Integer>max=new LinkedList<>();
        Deque<Integer>min=new LinkedList<>();
        long ans=0;
        int l=0;
    
        for(int r=0;r<n;r++){
            while(!max.isEmpty() && nums[max.peekLast()]<=nums[r]){
                max.pollLast();
            }
            max.offerLast(r);
            while(!min.isEmpty() && nums[min.peekLast()]>=nums[r]){
                min.pollLast();
            }
            min.offerLast(r);
           long cal=(nums[max.peekFirst()]-nums[min.peekFirst()])*1L*(r-l+1);
           while(cal>k){
            int ele=l;
            l++;
            if(max.peekFirst()==ele){
                max.pollFirst();
            }
            if(min.peekFirst()==ele){
                min.pollFirst();
            }
            cal=(nums[max.peekFirst()]-nums[min.peekFirst()])*1L*(r-l+1);
           }
           ans+=r-l+1;

        }
      return ans;


    }
}