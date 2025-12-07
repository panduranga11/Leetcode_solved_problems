class Solution {
    
    private int reflect(int n) {
        String s = Integer.toBinaryString(n);
        String rs = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(rs, 2);
    }

    public int[] sortByReflection(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int ra = reflect(a);
            int rb = reflect(b);
            
            if (ra != rb) return Integer.compare(ra, rb);
            return Integer.compare(a, b);
        });

        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
}
