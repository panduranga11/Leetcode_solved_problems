class Solution {
    class Pair{
        int ind;
        int val;
        Pair(int ind,int val){
            this.ind=ind;
            this.val=val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        
        Deque<Pair>dq=new ArrayDeque<>();
        int ans[]=new int[n-k+1];
        for(int i=0;i<k;i++){
            if(!dq.isEmpty() && dq.peekLast().val<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(new Pair(i,nums[i]));
        }
    
    int l=1;
    ans[0]=dq.peekFirst().val;
    for(int i=k;i<n;i++){
        while(!dq.isEmpty()&&dq.peekLast().val<=nums[i]){
            dq.pollLast();
        }
        dq.offerLast(new Pair(i,nums[i]));
        while(!dq.isEmpty() && dq.peekFirst().ind<=i-k){
            dq.pollFirst();
        }
        ans[l]=dq.peekFirst().val;
        l++;
 
    }
    return ans;
    
}
}


//USED PRIORITY QUEUE TLE (ON^2)
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
        
//         int ans[]=new int[n-k+1];
//         PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
//             return b-a;
//         });
//         for(int i=0;i<k;i++){
//             pq.offer(nums[i]);
//         }
//         ans[0]=pq.peek();
//        int l=1;
//         for(int i=k;i<nums.length;i++){
//             pq.remove(nums[i-k]);
//             pq.offer(nums[i]);
//             ans[l]=pq.peek();
//             l++;
//         }
//         return ans;
//     }
    
// }