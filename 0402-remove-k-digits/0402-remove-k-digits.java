class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Character>st=new Stack<>();
       for(int i=0;i<num.length();i++){
        char c=num.charAt(i);
        while(!st.isEmpty() && k>0 && st.peek()>c){
            st.pop();
            k--;
        }
        
        st.push(c);
       
       }
      
        while(k>0){
            st.pop();
            k--;
        }
         
       
       if(st.isEmpty()){
            return "0";
        }
StringBuilder sb = new StringBuilder();

while (!st.isEmpty()) {
    sb.append(st.pop());
}

sb.reverse();

int idx = 0;
while (idx < sb.length() && sb.charAt(idx) == '0') {
    idx++;
}

String ans = (idx == sb.length()) ? "0" : sb.substring(idx);
return ans;

      

    }
}