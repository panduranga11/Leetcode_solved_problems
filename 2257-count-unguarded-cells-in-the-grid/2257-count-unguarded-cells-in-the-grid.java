class Solution {
    public int countUnguarded(int m, int n, int[][] g, int[][] w) {
        int arr[][] = new int[m][n];
        
        // mark guards
        for (int i = 0; i < g.length; i++) {
            int r = g[i][0];
            int c = g[i][1];
            arr[r][c] = 2;
        }

        // mark walls
        for (int i = 0; i < w.length; i++) {
            int r = w[i][0];
            int c = w[i][1];
            arr[r][c] = 3;
        }

        // spread guard vision
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    int l = j + 1;
                    int r = j - 1;
                    int u = i - 1;
                    int d = i + 1;

                    // right
                    while (l < n && arr[i][l] != 3 && arr[i][l] != 2) {
                        arr[i][l] = 4;
                        l++;
                    }

                    // left
                    while (r >= 0 && arr[i][r] != 3 && arr[i][r] != 2) {
                        arr[i][r] = 4;
                        r--;
                    }

                    // up
                    while (u >= 0 && arr[u][j] != 3 && arr[u][j] != 2) {
                        arr[u][j] = 4;
                        u--;
                    }

                    // down
                    while (d < m && arr[d][j] != 3 && arr[d][j] != 2) {
                        arr[d][j] = 4;
                        d++;
                    }
                }
            }
        }

        // count unguarded
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
