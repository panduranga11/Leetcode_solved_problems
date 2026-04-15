class Solution {
    public int removeDuplicates(int[] nums) {
       int n=nums.length;
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<n;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       HashSet<Integer>hs=new HashSet<>();
       ArrayList<Integer>ls=new ArrayList<>();
       for(int i:nums){
        if(!hs.contains(i)){
        int l=Math.min(2,map.get(i));
        for(int j=0;j<l;j++){
            ls.add(i);
        }
        hs.add(i);
        }

       }
       int k=ls.size();
       for(int i=0;i<k;i++){
        nums[i]=ls.get(i);
       }


     return k;  
    
}
}
