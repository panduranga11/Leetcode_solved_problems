class Solution {

    public long countFancy(long l, long r) {

        return getans(r) - getans(l - 1);
    }

    public long getans(long num){
        if(num==0){
            return 0;
        }
         String s1 = String.valueOf(num);
         char c1[] = s1.toCharArray();
         long [][][][][][][]dp=new long [16][2][2][2][11][144][2];
        for (int i = 0; i <=15; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int k = 0; k <2 ; k++) {
                    for (int l = 0; l <2; l++) {
                        for (int m = 0; m <11 ; m++) {
                            for (int n = 0; n <144; n++) {
                                for (int o = 0; o <2; o++) {
                                    dp[i][j][k][l][m][n][o] = -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return solve(c1,0,1,1,1,10,0,0,dp);
    }

    public long solve(char ch[], int ind, int inc, int dec, int tight,
            int prev, int sum, int start,
            long dp[][][][][][][]) {

        if (ind == ch.length) {
            if ((inc == 1 || dec == 1) || checkMonotonic(sum)) {
                return (start & 1);
            }
            return 0;
        }

        if (dp[ind][inc][dec][tight][prev][sum][start] != -1) {
            return dp[ind][inc][dec][tight][prev][sum][start];
        }

        long ans = 0;

        int end = (tight == 1) ? ch[ind] - '0' : 9;

        for (int i = 0; i <= end; i++) {

            if (i == 0 && start == 0) {
                ans += solve(ch, ind + 1, 1, 1, tight==1 && i==end?1:0, 10, sum, 0, dp);
            } else {

                ans += solve(ch, ind + 1, inc == 1 && (start==0 ||i > prev )? 1 : 0, dec == 1 && (start==0 ||prev > i )? 1 : 0,
                        tight == 1 && i == end ? 1 : 0, i, sum + i, 1, dp);
            }
        }

        return dp[ind][inc][dec][tight][prev][sum][start] = ans;
    }

    public static boolean checkMonotonic(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        boolean inc = true;
        boolean dec = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) > s.charAt(i - 1))
                dec = false;
            if (s.charAt(i) < s.charAt(i - 1))
                inc = false;
            if (s.charAt(i) == s.charAt(i - 1))
                return false;
        }

        return inc || dec;
    }
}