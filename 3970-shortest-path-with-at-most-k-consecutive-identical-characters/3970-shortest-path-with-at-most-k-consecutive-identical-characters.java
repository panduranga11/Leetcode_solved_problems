class Solution {
    class Pair {
        int node;
        int wt;
        int count;

        Pair(int n, int wt, int c) {
            this.node = n;
            this.wt = wt;
            this.count = c;
        }

        Pair(int n, int wt) {
            this.node = n;
            this.wt = wt;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int dis[][] = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        dis[0][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int p[] = pq.poll();

            int nn = p[0];
            int d = p[1];
            int ct = p[2];

            if (d > dis[nn][ct]) {
                continue;
            }

            for (Pair nd : adj.get(nn)) {
                int vv = nd.node;
                int wt = nd.wt;
                int newct = (labels.charAt(nn) == labels.charAt(vv)) ? ct + 1 : 1;

                if (newct <= k) {
                    if (dis[nn][ct]!=Integer.MAX_VALUE && dis[nn][ct] + wt < dis[vv][newct]) {
                        dis[vv][newct] = dis[nn][ct] + wt;
                        pq.offer(new int[]{vv, dis[vv][newct], newct});
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            min = Math.min(min, dis[n - 1][i]);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}