class Solution {
    public String removeDuplicateLetters(String s) {
        int ch []=new int[26];
        for(char c:s.toCharArray()){
ch[c-'a']++;
        }
       // System.out.println(Arrays.toString(ch));
        Stack<Character>st=new Stack<>();
        for(char c :s.toCharArray()){
            ch[c-'a']--;
            
            while(!st.contains(c) && !st.isEmpty() && c<st.peek() && ch[st.peek()-'a']>0){
                st.pop();
                
            }
            if(!st.contains(c)){
            st.push(c);
            }
           System.out.println(st);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}