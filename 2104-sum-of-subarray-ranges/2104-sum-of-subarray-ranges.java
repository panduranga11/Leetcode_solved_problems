class Solution {
     public long sumSubarrayMins(int[] arr) {
      
        int n = arr.length;

        int[] nextSmaller = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            nextSmaller[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        int[] prevSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

       
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            sum = (sum + (long) arr[i] * left * right);
        }

        return sum;
    }
     public long sumSubarrayMax(int[] arr) {
       
        int n = arr.length;

        int[] nextLarger = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            nextLarger[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        int[] prevLarger = new int[n];
        Stack<Integer> st = new Stack<>();

       
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            prevLarger[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLarger[i];
            long right = nextLarger[i] - i;
            sum = (sum + (long) arr[i] * left * right) ;
        }

        return  sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums)-sumSubarrayMins(nums); 
    }
}