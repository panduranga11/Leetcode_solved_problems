class Solution {
    public int getLength(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer>map=new HashMap<>();
            //this gives how many numbers having this freq
           // frequency -> count of values having that frequency
           //this is a new type that have n't seen before 
            
            HashMap<Integer,Integer>freq=new HashMap<>();
            
            for(int j=i;j<n;j++){
                int val=nums[j];
                int oldfreq=map.getOrDefault(val,0);
                if(oldfreq>0){
                    int c=freq.get(oldfreq);
                    if(c==1){
                        freq.remove(oldfreq);
                    }else{
                        freq.put(oldfreq,c-1);
                    }
                }
                int newfreq=oldfreq+1;
                freq.put(newfreq,freq.getOrDefault(newfreq,0)+1);
                
                 map.put(nums[j],oldfreq+1);
                
               // System.out.println(map);
               if(check(map,freq)){
                ans=Math.max(ans,(j-i+1));
            
            }
            
            
        }
        }
        return ans;
        
    
    }
        public boolean check(HashMap<Integer,Integer>map,HashMap<Integer,Integer>freq){
            //System.out.println(map);
            if(map.size()==1){
                return true;
            }
           if(freq.size()>2){
               return false;
           }
            for(int i :freq.keySet()){
                if(freq.containsKey(2*i)){
                    return true;
                }
            }
            return false;
           
          
    }

}