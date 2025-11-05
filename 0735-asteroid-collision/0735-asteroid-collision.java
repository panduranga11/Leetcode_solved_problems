class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int ele=arr[i];
            if(arr[i]>0){
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(ele)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(ele)){
                    st.pop();
                }else if(st.isEmpty() ||st.peek()<0){
                    st.push(ele);
                }
            }

        }
        int ans[]=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
ans[i]=st.pop();
        }
        return ans;
    }
}