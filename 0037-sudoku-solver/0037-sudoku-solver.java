class Solution {
    public boolean solveSudoku(char[][] board) {
        return check(0, 0, board);
    }

    public boolean check(int i, int j, char[][] b) {
        if(i == 9) return true;
        if(j == 9) return check(i + 1, 0, b);

        if(b[i][j] != '.'){
            return check(i, j + 1, b);
        }

        for(int n = 1; n <= 9; n++){
            char c = (char)(n + '0');
            if(issafe(b, i, j, c)){
                b[i][j] = c;
                if(check(i, j + 1, b)) return true;
                b[i][j] = '.';
            }
        }
        return false;
    }

    public boolean issafe(char[][] b, int i, int j, char ele){
        for(int k = 0; k < 9; k++){
            if(k != j && b[i][k] == ele) return false;
            if(k != i && b[k][j] == ele) return false;
        }

        int sr = (i / 3) * 3;
        int sc = (j / 3) * 3;

        for(int r = sr; r < sr + 3; r++){
            for(int c = sc; c < sc + 3; c++){
                if((r != i || c != j) && b[r][c] == ele)
                    return false;
            }
        }
        return true;
    }
}
