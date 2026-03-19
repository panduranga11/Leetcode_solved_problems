class Solution {
    public boolean fillbuckets(int ind,int []nums,int bucketsum,int reqsum,int []used,int totalbuckets,int curbucket){
        if(curbucket > totalbuckets) return true; // all buckets filled

        if(bucketsum == reqsum){
            return fillbuckets(0, nums, 0, reqsum, used, totalbuckets, curbucket+1);
        }

        for(int i = ind; i < nums.length; i++){
            if(used[i] == 1) continue;
            if(bucketsum + nums[i] > reqsum) continue;

            used[i] = 1;
            if(fillbuckets(i+1, nums, bucketsum+nums[i], reqsum, used, totalbuckets, curbucket))
                return true;
            used[i] = 0;

            
            if(bucketsum == 0) return false;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % k != 0) return false;

        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n-1] > sum/k) return false;

        int[] used = new int[n];
        return fillbuckets(0, nums, 0, sum/k, used, k, 1);
    }
}
