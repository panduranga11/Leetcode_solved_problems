class Solution {

    class Square {
        int left;
        int right;
        int height;

        Square(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {

        List<Square> squares = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int globalMax = 0;

        for (int[] position : positions) {

            int left = position[0];
            int side = position[1];
            int right = left + side;

            int baseHeight = 0;

           
            for (Square s : squares) {

                if (left < s.right && s.left < right) {
                    baseHeight = Math.max(baseHeight, s.height);
                }
            }

            int newHeight = baseHeight + side;

            squares.add(new Square(left, right, newHeight));

            globalMax = Math.max(globalMax, newHeight);

            ans.add(globalMax);
        }

        return ans;
    }
}