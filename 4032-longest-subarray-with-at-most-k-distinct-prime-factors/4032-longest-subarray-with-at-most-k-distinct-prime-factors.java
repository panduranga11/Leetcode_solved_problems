class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
      HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        
        for(int i=0;i<n;i++){
           int num=nums[i];
            HashSet<Integer>set=new HashSet<>();
            for(int j=2;j*j<=num;j++){
                if(num%j==0){
                   set.add(j);
                }
                while(num%j==0){
                    num=num/j;
                }
            }
            if(num>1){
                set.add(num);
            }
            map.put(i,set);
            
        }
       // System.out.println(map);
    int l=0;
    int ans=0;
    HashMap<Integer,Integer>amap=new HashMap<>();
    for(int r=0;r<n;r++){
        for(int nn:map.get(r)){
            amap.put(nn,amap.getOrDefault(nn,0)+1);
        }
        while(amap.size()>k){
            for(int nn:map.get(l)){
                amap.put(nn,amap.get(nn)-1);
                if(amap.get(nn)==0){
                    amap.remove(nn);
                }
            }
            l++;
        }
       // System.out.println(r+" "+l);
        ans=Math.max(ans,(r-l+1));
    }
        return ans;
    }
    
}