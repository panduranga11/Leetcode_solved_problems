class Solution {
    public String shiftingLetters(String s, int[][] sh) {
        int n=s.length();
        int c[]=new int[n];
        int m=sh.length;
        for(int i=0;i<m;i++){
            int st=sh[i][0];
            int end=sh[i][1];
            int dir=sh[i][2]==0?-1:1;
            c[st]+=(dir);
            if(end+1<n){
            c[end+1]+=(-dir);
            }
        }
        int cur=0;
        for(int i=0;i<n;i++){
            cur+=c[i];
            c[i]=cur;
            
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            int v=((ch-'a')+c[i]%26+26)%26;
           
            char cc=(char)('a'+v);
            //  System.out.println(ch+" shifed to :"+cc);
            sb.append(cc);
        }
        System.out.println((int)'a');
        return sb.toString();
        
    }
}