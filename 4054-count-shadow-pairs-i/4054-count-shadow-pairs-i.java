class Solution {
    public long shadowPairs(int[] nums) {
      long ans=0;
      int n=nums.length;
      
     Stack<Integer>st=new Stack<>();
    for(int i:nums){
        if(st.isEmpty()){
            st.push(i);
        }else{
            while(!st.isEmpty() && st.peek()>i){
                st.pop();
            }
            if(!st.isEmpty()){
ans+=bs(st,i);
            }
            st.push(i);
        }

    }
    return ans;

    }
    public int bs(Stack <Integer>st,int t){
        if(st.isEmpty()){
            return 0;
        }
        int l=0;
        int r=st.size();
        
        while(l<r){
            int mid=l+(r-l)/2;
            if(st.get(mid)>=t){
                r=mid;
              
            }else{
                l=mid+1;

            }
           

        }
       return l;
        
    }
}