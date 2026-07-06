class Solution {
    public int minOperations(String s1, String s2) {
        char []s11=s1.toCharArray();
        char []s22=s2.toCharArray();
      int ans=0;
     int n=s1.length();
     if(s1.length()==1){
        char c1=s1.charAt(0);
        char c2=s2.charAt(0);
        if(c1==c2){
            return 0;
        }else{
        if(c1=='0'){
            return 1;
        }else{
            return -1;
        }
        }
     }
     for(int i=0;i<n;i++){
        char  c11=s11[i];
        char c22=s22[i];
        if(c11==c22){
            continue;
        }else{
            if(c11=='0'){
                ans+=1;
            }else{
                if(i+1<n && s11[i+1]=='1'){
                    ans+=1;
                    s11[i+1]='0';

                }else if(i+1<n && s11[i+1]=='0'){
                    ans+=2;
                    
                }else{
                    ans+=2;
                }
            }
        }
     }
     return ans;
        
}
}