class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, Integer> rf = new HashMap<>();
        HashMap<Integer, Integer> lf = new HashMap<>();
        HashMap<Integer, Long> ls = new HashMap<>();
        HashMap<Integer, Long> rs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            rf.put(nums[i], rf.getOrDefault(nums[i], 0) + 1);
            rs.put(nums[i], rs.getOrDefault(nums[i], 0L) + i);
        }

        for (int i = 0; i < n; i++) {
            int val = nums[i];

           
            rf.put(val, rf.get(val) - 1);
            rs.put(val, rs.get(val) - i);

            int leftfreq = lf.getOrDefault(val, 0);
            int rightfreq = rf.getOrDefault(val, 0);
            long leftsum = ls.getOrDefault(val, 0L);
            long rightsum = rs.getOrDefault(val, 0L);

            ans[i] = (long) i * leftfreq - leftsum + rightsum - (long) i * rightfreq;

            
            lf.put(val, leftfreq + 1);
            ls.put(val, leftsum + i);
        }

        return ans;
    }
}