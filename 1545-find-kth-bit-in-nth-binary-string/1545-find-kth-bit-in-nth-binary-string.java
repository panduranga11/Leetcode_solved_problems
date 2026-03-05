class Solution {
    public char findKthBit(int n, int k) {
        String s1="0";
        for(int i=1;i<=n;i++){
           String si= invert(s1);
            s1+="1"+rev(si);
        }
        return s1.charAt(k-1);
    }
    public String invert(String s){
        StringBuilder sb=new StringBuilder(s);
        int l=s.length();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=sb.charAt(i);
            if(ch=='0'){
                sb.setCharAt(i,'1');
            }else{
                sb.setCharAt(i,'0');
            }
            
        }
        return sb.toString();
    }
    public String rev(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}