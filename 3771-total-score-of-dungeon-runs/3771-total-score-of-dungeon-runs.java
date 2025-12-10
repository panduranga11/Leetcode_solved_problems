class Solution {
    
    public static int bs(int i, int[] r, long[] psum, int hp) {
        int l = 0;
        int h = i;
        int ans = i + 1; 
        while (l <= h) {
            int mid = (l + h) / 2;
            long segSum = (mid == 0) ? psum[i] : (psum[i] - psum[mid - 1]);

            if (hp - segSum >= r[i]) {
                ans = mid;   
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public long totalScore(int hp, int[] d, int[] r) {
        int n = d.length;
        long[] psum = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d[i];
            psum[i] = sum;
        }

        long s = 0;
        for (int i = 0; i < n; i++) {
            int j = bs(i, r, psum, hp);

            if (j <= i) {
                s += (i - j + 1);
            }
        }
        return s;
    }
}
