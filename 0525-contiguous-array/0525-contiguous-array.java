class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0;
        int n=nums.length;
        int maxlen=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(sum==0){
            maxlen=i+1;
        }
            // System.out.println("sum at index "+i+" "+sum);
            
            if(map.containsKey(sum)){
              //  System.out.println("index "+i+" " +map.get(sum));
                maxlen=Math.max(maxlen,i-map.get(sum));
            }else{
                map.put(sum,i);
            }

        }
        
        return maxlen;
    }
}