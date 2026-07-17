class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int l = 0;
        long sum = 0;
        long ans = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum * (r - l + 1L) >= k) {
                sum -= nums[l];
                l++;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}