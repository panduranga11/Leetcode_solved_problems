class Solution {
    class Pair {
        int ind;
        int et;

        Pair(int i, int e) {
            this.ind = i;
            this.et = e;
        }
    }

    public List<Integer> busiestServers(int k, int[] a, int[] l) {

        List<Integer> ans = new ArrayList<>();

        int[] c = new int[k];
        int n = a.length;
//it is used to find the possible freeserver at a index;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(x.et, y.et)
        );
//it is used to find the next possible server 
//if next possible is null(means there is no server greater or equal to pre which is free ) we go to set.first() will give the first free server because of circular is there 
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        for (int i = 0; i < n; i++) {

            int at = a[i];

            
            while (!pq.isEmpty() && pq.peek().et <= at) {
                Pair p = pq.poll();
                set.add(p.ind);
            }

         
            if (set.isEmpty()) {
                continue;
            }

           
            int preferred = i % k;

            Integer idx = set.ceiling(preferred);

            if (idx == null) {
                idx = set.first();
            }

           
            set.remove(idx);

            int endTime = at + l[i];

            pq.offer(new Pair(idx, endTime));

            c[idx]++;
        }

        int max = 0;

        for (int i : c) {
            max = Math.max(max, i);
        }

        for (int i = 0; i < k; i++) {
            if (c[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}