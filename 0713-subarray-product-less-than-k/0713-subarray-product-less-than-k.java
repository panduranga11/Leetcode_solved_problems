class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        long prod = 1;
        int ans = 0;

        for (int r = 0; r < n; r++) {
            prod *= nums[r];

            while (prod >= k) {
                prod /= nums[l];
                l++;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}