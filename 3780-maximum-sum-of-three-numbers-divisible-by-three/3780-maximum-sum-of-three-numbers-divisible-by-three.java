import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = nums[i] % 3;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(b[0], a[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] st = {-1, -1, -1};
        for (int i = 0; i < n; i++) {
            int k = arr[i][1];
            if (st[k] == -1) st[k] = i;
        }

        long maxSum = -1;

        for (int r = 0; r < 3; r++) {
            if (st[r] != -1) {
                int end = n;
                for (int next = r + 1; next < 3; next++) {
                    if (st[next] != -1) {
                        end = st[next];
                        break;
                    }
                }
                
                if (end - st[r] >= 3) {
                    long currentSum = (long) arr[st[r]][0] + arr[st[r] + 1][0] + arr[st[r] + 2][0];
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        if (st[0] != -1 && st[1] != -1 && st[2] != -1) {
            long mixedSum = (long) arr[st[0]][0] + arr[st[1]][0] + arr[st[2]][0];
            maxSum = Math.max(maxSum, mixedSum);
        }
        if(maxSum==-1){
            return 0;
        }

        return (int) maxSum;
    }
}