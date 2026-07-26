class Solution {
    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};

    class Pair {
        int i;
        int j;
        long cost;
        int t;

        Pair(int i, int j, long cost, int t) {
            this.i = i;
            this.j = j;
            this.cost = cost;
            this.t = t;
        }
    }

    public long minCost(int m, int n, int[][] penalty) {
        long[][][] dis = new long[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dis[i][j], Long.MAX_VALUE);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        dis[0][0][1] = 1;
        pq.offer(new Pair(0, 0, 1, 1));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int r = p.i;
            long c = p.cost;
            int col = p.j;
            int time = p.t;
            int par = time % 2;

            if (c > dis[r][col][par]) {
                continue;
            }

            if (r == m - 1 && col == n - 1) {
                return c;
            }

if (time % 2 == 1) {
   for (int k = 0; k <= 3; k++) {
      int nr = r + dr[k];
        int nc = col + dc[k];

        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                 if (k % 2 == 1) {
                if (c + (nr + 1) * 1L * (nc + 1) < dis[nr][nc][0]) {
                     pq.offer(new Pair(nr, nc, c + (nr + 1) * 1L * (nc + 1), time + 1));
                                dis[nr][nc][0] = c + (nr + 1) * 1L * (nc + 1);
                            }
                 } else {
             if (c + (nr + 1) * 1L * (nc + 1) + penalty[r][col] < dis[nr][nc][0]) {
                                pq.offer(new Pair(nr, nc, c + (nr + 1) * 1L *(nc + 1) + penalty[r][col], time + 1));
                                dis[nr][nc][0] = c + (nr + 1) * 1L * (nc + 1) + penalty[r][col];
                            }
                        }
                    }
                }
            } else {
                for (int k = 0; k <= 3; k++) {
                    int nr = r + dr[k];
                    int nc = col + dc[k];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (k % 2 == 0) {
                            if (c + (nr + 1) * 1L * (nc + 1) < dis[nr][nc][1]) {
                                pq.offer(new Pair(nr, nc, c + (nr + 1) * 1L * (nc + 1), time + 1));
                                dis[nr][nc][1] = c + (nr + 1) * 1L * (nc + 1);
                            }
                        } else {
                            if (c + (nr + 1) * 1L * (nc + 1) + penalty[r][col] < dis[nr][nc][1]) {
                                pq.offer(new Pair(nr, nc, c + (nr + 1) * 1L * (nc + 1) + penalty[r][col], time + 1));
                                dis[nr][nc][1] = c + (nr + 1) * 1L * (nc + 1) + penalty[r][col];
                            }
                        }
                    }
                }
            }

            int pp = (par + 1) % 2;
            if (c + penalty[r][col] < dis[r][col][pp]) {
                pq.offer(new Pair(r, col, c + penalty[r][col], time + 1));
                dis[r][col][pp] = c + penalty[r][col];
            }
        }

        return -1;
    }
}