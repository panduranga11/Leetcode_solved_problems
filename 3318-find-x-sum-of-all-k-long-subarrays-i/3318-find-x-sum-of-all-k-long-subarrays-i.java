class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int n = nums.length; 

        for (int i = 0; i < n - k + 1; i++) {
            int subarr[] = Arrays.copyOfRange(nums, i, i + k);

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < subarr.length; j++) { 
                map.put(subarr[j], map.getOrDefault(subarr[j], 0) + 1);
            }

            List<int[]> fre = new ArrayList<>(); 

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                fre.add(new int[]{entry.getKey(), entry.getValue()});
            }

           
            Collections.sort(fre, (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            int xsum = 0;

            for (int j = 0; j < Math.min(x, fre.size()); j++) { 
                xsum += fre.get(j)[0] * fre.get(j)[1];
            }

            res.add(xsum);
        }

        int ans[] = new int[res.size()]; 

        for (int i = 0; i < res.size(); i++) { 
            ans[i] = res.get(i);
        }
        return ans;
    }
}
