class Solution {

    class State {
        int n;
        int mask;
        int dis;

        public State(int n, int mask, int dis) {
            this.n = n;
            this.mask = mask;
            this.dis = dis;
        }
    }

    public int shortestPathLength(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                adj.get(i).add(v);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, bfs(adj, i, 1 << i, n));
        }

        return ans;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj, int node, int mask, int n) {

        boolean[][] vis = new boolean[n][(int) Math.pow(2, n)];

        Queue<State> q = new LinkedList<>();

        int imask = mask | (1 << node);

        q.offer(new State(node, imask, 0));
        vis[node][imask] = true;

        while (!q.isEmpty()) {

            State pp = q.poll();

            int nn = pp.n;
            int dd = pp.dis;
            int mm = pp.mask;

            if (mm == (1 << n) - 1) {
                return dd;
            }

          

            for (int k : adj.get(nn)) {

                int nm = mm | (1 << k);

                if (!vis[k][nm]) {
                    vis[k][nm] = true;
                    q.offer(new State(k, nm, dd + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}