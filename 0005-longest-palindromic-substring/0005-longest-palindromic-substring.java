class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            
            String p1 = expandFromCenter(s, i, i);
            if (p1.length() > longest.length()) {
                longest = p1;
            }

            // Even length palindrome
            String p2 = expandFromCenter(s, i, i + 1);
            if (p2.length() > longest.length()) {
                longest = p2;
            }
        }
        return longest;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Substring after loop breaks
        return s.substring(left + 1, right);
    }
}



// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length()==1){
//             return s;
//         }
//         String longest="";
//         for(int i=0;i<s.length();i++){
//          for(int j=i;j<s.length();j++){
//             if(palin_check(s,i,j)){
//                 if(longest.length()<(j-i+1)){
//                     longest=s.substring(i,j+1);
//                 }

//             }
//          }
//         }
//         return longest;
//     }
//     public boolean palin_check(String s,int i,int j){
//         int l=i;
//         int r=j;
//         while(l<r){
//             if(s.charAt(l)==s.charAt(r)){
//                 l++;
//                 r--;
//             }else{
//                 return false;
//             }

//         }
//         return true;
//     }
// }