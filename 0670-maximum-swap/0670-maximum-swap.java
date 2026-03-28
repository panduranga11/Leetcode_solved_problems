class Solution {
    public int maximumSwap(int num) {
        int swap_l = -1;
        int swap_r = -1;
        char max;
        int max_i = -1;

        StringBuilder sb = new StringBuilder(Integer.toString(num));
        max = sb.charAt(sb.length() - 1); 
        max_i = sb.length() - 1;

        
        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) > max) {
                max = sb.charAt(i);
                max_i = i;
            } else if (sb.charAt(i) < max) {
                swap_l = i;
                swap_r = max_i;
            }
        }

      
        if (swap_l == -1) return num;

       
        char c = sb.charAt(swap_l);
        sb.setCharAt(swap_l, sb.charAt(swap_r));
        sb.setCharAt(swap_r, c);

        return Integer.parseInt(sb.toString());
    }
}
