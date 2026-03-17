class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int lds[][] = new int[m][n];
        int rds[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int addr = 0;
                if (i > 0 && j > 0) {
                    addr = rds[i - 1][j - 1];
                }
                rds[i][j] = grid[i][j] + addr;

                int addl = 0;
                if (i > 0 && j < n - 1) {
                    addl = lds[i - 1][j + 1];
                }
                lds[i][j] = grid[i][j] + addl;
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int move = Math.min(Math.min(j, n - 1 - j), (m - 1 - i) / 2);

                for (int k = 0; k <= move; k++) {

                    if (k == 0) {
                        ls.add(grid[i][j]);
                    } else {

                        int lr = i + k;
                        int lc = j - k;
                        int rr = i + k;
                        int rc = j + k;
                        int br = i + 2 * k;
                        int bc = j;

                        int removel = (i > 0 && j < n - 1) ? lds[i - 1][j + 1] : 0;
                        int remover = (i > 0 && j > 0) ? rds[i - 1][j - 1] : 0;

                        int leftSum = lds[lr][lc] - removel;
                        int rightSum = rds[rr][rc] - remover;

                        int bright = (lr > 0 && lc > 0) ? rds[lr - 1][lc - 1] : 0;
                        int brs = rds[br][bc] - bright;

                        int bleft = (rr > 0 && rc < n - 1) ? lds[rr - 1][rc + 1] : 0;
                        int bls = lds[br][bc] - bleft;

                        int ts = leftSum + rightSum + bls + brs
                                - grid[i][j]
                                - grid[br][bc]
                                - grid[lr][lc]
                                - grid[rr][rc];

                        ls.add(ts);
                    }
                }
            }
        }

        ls.sort((a, b) -> Integer.compare(b, a));

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ls.size() && ans.size() < 3; i++) {
            if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(ls.get(i))) {
                ans.add(ls.get(i));
            }
        }

        int ansarray[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansarray[i] = ans.get(i);
        }

        return ansarray;
    }
}