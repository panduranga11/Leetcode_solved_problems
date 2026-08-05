class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans = solve(adj, 0, -1, hasApple);

        return ans == 0 ? 0 : ans - 2;
    }

    public int solve(List<List<Integer>> adj, int node, int parent,
                     List<Boolean> hasApple) {

        int ans = 0;

        for (int child : adj.get(node)) {
            if (child == parent)
                continue;

            ans += solve(adj, child, node, hasApple);
        }

        if (ans > 0 || hasApple.get(node))
            return ans + 2;

        return 0;
    }
}