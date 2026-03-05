class Solution {
    public int minOperations(String s) {
    Stack<Character>st1=new Stack<>();
     Stack<Character>st2=new Stack<>();

    int n=s.length();
    int count1=0;
    int count2=0;
    boolean st=false;
    if(s.charAt(0)=='1'){
        st=true;
    }
    st1.push('0');
    st2.push('1');
    for(int i=1;i<n;i++ ){
        char ch=s.charAt(i);
     if(st1.peek()==ch){
        count1++;
        char c=st1.peek()=='1'?'0':'1';
        st1.push(c);
     }else{
        st1.push(s.charAt(i));
     }
      if(st2.peek()==ch){
        count2++;
        char c=st2.peek()=='1'?'0':'1';
        st2.push(c);
     }else{
        st2.push(s.charAt(i));
     }

     }
     if(st){
        count1++;
     }else{
        count2++;
     }
     return Math.min(count1,count2);
    }
    }
