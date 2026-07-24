class Solution {
    public boolean find132pattern(int[] nums) {
       int n=nums.length;
       int pmin[]=new int[n];
       pmin[0]=nums[0];
       
       for(int i=1;i<n;i++){
        pmin[i]=Math.min(nums[i],pmin[i-1]);
       }
      // System.out.println(Arrays.toString(pmin));

     TreeSet<Integer>set=new TreeSet<>();
     set.add(nums[n-1]);
     for(int j=n-2;j>0;j--){
        // System.out.println(j+" "+set.floor(nums[j]));
        // System.out.println(sm[j+1]);

if(set.lower(nums[j])!=null && set.lower(nums[j])!=nums[j] && set.lower(nums[j])>pmin[j-1]){
    return true;

}
set.add(nums[j]);

     }
     return false;
    }
}