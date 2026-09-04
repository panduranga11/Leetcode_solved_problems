class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            
            map.put(i,map.getOrDefault(i,0)+1);
        }
         PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
           return  Integer.compare(map.get(a),map.get(b));
        }
        );
        for(int i:map.keySet()){
            if(pq.size()<k){
                
                pq.offer(i);
                
            }else{
                if(map.get(pq.peek())<map.get(i)){
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        int n=pq.size();
        int ans[]=new int[n];
        int l=0;
        while(!pq.isEmpty()){
            ans[l++]=pq.poll();
        } 
        return ans;

    }
}