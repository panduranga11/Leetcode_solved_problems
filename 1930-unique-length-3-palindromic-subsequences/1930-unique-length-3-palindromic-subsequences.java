class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] pos = new int[26][2];

        
        for (int i = 0; i < 26; i++) {
            pos[i][0] = -1;
            pos[i][1] = -1; 
        }

       
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (pos[idx][0] == -1) {
                pos[idx][0] = i;
            }
            pos[idx][1] = i;
        }

        int count = 0;

       
        for (int c = 0; c < 26; c++) {
            int left = pos[c][0];
            int right = pos[c][1];

            if (left != -1 && left < right) {
                HashSet<Character> middle = new HashSet<>();

                for (int i = left + 1; i < right; i++) {
                    middle.add(s.charAt(i));
                }

                count += middle.size();
            }
        }

        return count;
    }
}
