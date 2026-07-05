class Solution {
    public int divisibleGame(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            for (int d = 2; (long) d * d <= i; d++) {
                if (i % d == 0) {
                    set.add(d);
                    set.add(i / d);
                }
            }
            if (i >= 2) set.add(i);  
        }

        
        if (set.isEmpty()) {
            long ans = -1L * 2;
            return (int) ((ans % mod + mod) % mod);
        }

        Integer[] ks = set.toArray(new Integer[0]);
        Arrays.sort(ks);

        int[] arr = new int[2];
        arr[0] = Integer.MIN_VALUE;

        for (int k : ks) {
            int[] cur = new int[n];
            for (int i = 0; i < n; i++) {
                cur[i] = nums[i] % k == 0 ? nums[i] : -nums[i];
            }
            int maxsum = cur[0];
            int cursum = cur[0];
            for (int i = 1; i < n; i++) {
                if (cursum + cur[i] > cur[i]) {
                    cursum += cur[i];
                } else {
                    cursum = cur[i];
                }
                maxsum = Math.max(maxsum, cursum);
            }
            if (arr[0] < maxsum) {   
                arr[0] = maxsum;
                arr[1] = k;
            }
        }

        long ans = 1L * arr[0] * arr[1];
        return (int) ((ans % mod + mod) % 1000000007);
    }
}