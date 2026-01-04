class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
  HashMap<Integer,Integer>map=new HashMap<>();
  int l=0;
  int r=0;
  int sum=0;
  int ans=Integer.MAX_VALUE;
  while(r<n){
    
        map.put(nums[r],map.getOrDefault(nums[r],0)+1);
        if(map.get(nums[r])==1){
            sum+=nums[r];
        }
        while(sum>=k){
        ans=Math.min(r-l+1,ans);
        map.put(nums[l],map.get(nums[l])-1);
        if(map.get(nums[l])==0){
            sum-=nums[l];
        }
        l++;
        }
        r++;


  }
 
  if(ans==Integer.MAX_VALUE){
    return -1;
  }
  return ans;
    }
}

//         HashSet<Integer>s=new HashSet<>();
//         int su=0;
//         for(int i=0;i<nums.length;i++){
//             if(!s.contains(nums[i])){
//                 s.add(nums[i]);
//                 su+=nums[i];
//             }
//         }
//         if(su<k){
//             return -1;
//         }
//       return bs(nums,k);
       
        
//     }
//     public boolean possible(int mid,int []nums,int k){
//         if(mid==0)return k==0;
//         int sum=0;
//         int n=nums.length;
        
//         HashMap<Integer,Integer>map=new HashMap<>();
        
//         for(int i=0;i<mid;i++){
//         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//             if(map.get(nums[i])==1){
//                 sum+=nums[i];
//             }
//         }
//         if(sum>=k){
//             return true;
//         }
//             int l=0;
//             for(int i=mid;i<n;i++){
//                 map.put(nums[l],map.get(nums[l])-1);
//                 if(map.get(nums[l])==0){
//                     sum-=nums[l];
//                 }
//                 l++;
//                 map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//                 if(map.get(nums[i])==1){
//                     sum+=nums[i];
//                 }
                
                
//                 if(sum>=k){
//                     return true;
//                 }
//             }
        
//             return false;
        
        
       
//     }
//     public int bs(int []nums,int k){
//         int l=1;
//         int r=nums.length;
//         int ans=-1;
//         while(l<=r){
//             int mid=(l+r)/2;
//             if(possible(mid,nums,k)){
//                 ans=mid;
//                 r=mid-1;
//             }else{
//                 l=mid+1;
//             }
//         }
//         return ans;
//     }
// }