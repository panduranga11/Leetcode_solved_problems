class Solution {
    public int minimumDeletions(String s) {
       
        int bcount=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='b'){
                bcount++;
            }else{
                if(bcount>0){
                    ans++;
                    bcount--;
                }

            }
        }
        return ans;
        
    }
}