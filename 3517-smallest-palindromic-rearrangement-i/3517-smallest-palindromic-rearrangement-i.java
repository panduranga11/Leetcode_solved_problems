class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder st=new StringBuilder();
        StringBuilder m=new StringBuilder();
        


        System.out.println(Arrays.toString(freq));
        for(int i=0;i<26;i++){
            char c=(char)('a'+i);
            if(freq[i]%2==0){
                int v=freq[i]/2;
                for(int j=0;j<v;j++){
                    
                    st.append(c);
                    
                }
            }else{
                int v=(freq[i]-1)/2;
               
                for(int j=0;j<v;j++){
                    
                    st.append(c);
                    
                }
                m.append(c);
                
            }
        }
        return st.toString()+m.toString()+st.reverse().toString();

    }
}