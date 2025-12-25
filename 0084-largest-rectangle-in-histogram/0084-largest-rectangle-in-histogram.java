class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int ps[] = new int[n];
        int ns[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int max = h[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, h[i]);
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            ps[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            ns[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = max;

        for (int i = 0; i < n; i++) {
            int psmall = ps[i];
            int nsmall = ns[i];

           long width=nsmall-psmall-1;
           ans=Math.max(ans,1L*h[i]*width);
        
    }
    return (int) ans;
}
}
