class Solution {

    private int[] bfs(int src, ArrayList<ArrayList<Integer>> g, int n) {
        int[] d = new int[n];
        Arrays.fill(d, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        d[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (d[v] == -1) {
                    d[v] = d[u] + 1;
                    q.add(v);
                }
            }
        }
        return d;
    }

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[][] corimexalu = edges;

        int[] dx = bfs(x, g, n);
        int[] dy = bfs(y, g, n);
        int[] dz = bfs(z, g, n);

        int res = 0;

        for (int i = 0; i < n; i++) {
            int a = dx[i], b = dy[i], c = dz[i];

            int mn = Math.min(a, Math.min(b, c));
            int mx = Math.max(a, Math.max(b, c));
            int md = a + b + c - mn - mx;

            long A = 1L * mn * mn;
            long B = 1L * md * md;
            long C = 1L * mx * mx;

            if (A + B == C) res++;
        }

        return res;
    }
}
