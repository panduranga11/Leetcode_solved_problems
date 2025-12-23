class Solution {
    public int bs(int[][] e, int i) {
        int l = i + 1;
        int r = e.length - 1;
        int ans = e.length;

        int end = e[i][1];

        while (l <= r) {
            int mid = (l + r) / 2;
            if (e[mid][0] > end) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int maxTwoEvents(int[][] e) {
        int n = e.length;
        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] sufm = new int[n];
        sufm[n - 1] = e[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            sufm[i] = Math.max(sufm[i + 1], e[i][2]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = e[i][2];
            int idx = bs(e, i);
            if (idx < n) {
                cur += sufm[idx];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
