class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int heights[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                heights[i][j]=maxones(matrix,i,j);
            }
        }
        
    int ans=0;
    for(int i=0;i<m;i++){
        ans=Math.max(ans,maxarea(heights[i]));
    }
    return ans;
     
    }
    public int maxarea(int[] h) {
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
    public int maxones(char [][]matrix,int i,int j){
        if(matrix[i][j]=='0'){
            return 0;
        }
        int m=matrix.length;
        int count=0;
        for(int k=i;k<m;k++){
            if(matrix[k][j]=='1'){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}