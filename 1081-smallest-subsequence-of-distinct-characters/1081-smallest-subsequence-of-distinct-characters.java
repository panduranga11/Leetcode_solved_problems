class Solution {
    public String smallestSubsequence(String s) {
        boolean vis[]=new boolean[26];
        Stack<Character>st=new Stack<>();
        int lastidx[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            lastidx[ch-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            
            char ch=s.charAt(i);
            if(vis[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>=ch && lastidx[st.peek()-'a']>i){
                char c=st.pop();
                vis[c-'a']=false;

            }
            st.push(ch);
            vis[ch-'a']=true;

           
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}