class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int n = nums.length;
        int p = 1;

       
        while (p < n && nums[p] > nums[p - 1]) {
            p++;
        }

        if (p >= n - 1 || p == 1)
            return false;

        int q = p;

        
        while (q < n && nums[q] < nums[q - 1]) {
            q++;
        }

        if (q >= n || q == p)
            return false;

        int r = q;

        
        while (r < n && nums[r] > nums[r - 1]) {
            r++;
        }

        return r == n;
    }
}
