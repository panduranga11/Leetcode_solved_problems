class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer>q=new LinkedList<>();
        Queue<Integer>q1=new LinkedList<>();
        int c=0;
        for(int i:nums){
            if(i<pivot){
                q.offer(i);
            }else if(i==pivot){
                c++;
            }else{
                q1.offer(i);
            }
        }
        int ind=0;
        while(!q.isEmpty()){
            nums[ind]=q.poll();
            ind++;
        }
        while(c>0){
            nums[ind]=pivot;
            ind++;
            c--;

        }
        while(!q1.isEmpty()){
            nums[ind]=q1.poll();
            ind++;
        }
        return nums;
    }

}