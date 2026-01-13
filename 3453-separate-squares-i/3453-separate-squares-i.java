class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE, high = 0;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, (double)s[1] + s[2]);
        }

        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2.0;
            double diff = areaDiff(squares, mid);

            if (diff >= 0) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private double areaDiff(int[][] squares, double Y) {
        double below = 0, above = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            double top = y + l;
            double area = l * l;

            if (Y <= y) {
                above += area;
            } else if (Y >= top) {
                below += area;
            } else {
                below += (Y - y) * l;
                above += (top - Y) * l;
            }
        }
        return below - above;
    }
}
