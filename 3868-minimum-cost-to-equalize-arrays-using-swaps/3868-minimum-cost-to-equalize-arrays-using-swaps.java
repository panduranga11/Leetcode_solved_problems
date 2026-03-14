class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        HashMap<Integer,Integer>map2=new HashMap<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i:nums1){
            map1.put(i,map1.getOrDefault(i,0)+1);
            map.put(i,map.getOrDefault(i,0)+1);

        }
        for(int i:nums2){
            map2.put(i,map2.getOrDefault(i,0)+1);
             map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
           
            if(map.get(key)%2!=0){
                
                return -1;
            }
        }
        int ans=0;
       
        int a1=0;
        int a2=0;
        for(int i:map1.keySet()){
            int m1=map1.get(i);
            int t1=map.get(i);
            int half=t1/2;
            a1+=Math.max(0,m1-half);

        }
        for(int i:map2.keySet()){
              int m1=map2.get(i);
            int t1=map.get(i);
            int half=t1/2;
            a2+=Math.max(0,m1-half);
          
        }
        return Math.min(a1,a2);
       
        
}
}