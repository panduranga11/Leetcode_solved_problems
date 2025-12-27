class Solution {
    public int bestClosingTime(String cs) {
        int n=cs.length();
        int ans=0;
        int profit=0;
        int p=0;
        for(int i=0;i<n;i++){
            char c=cs.charAt(i);
            if(c=='Y'){
                p+=1;
                
            }else{
                p-=1;
            }
            
            if(p>profit){
            profit=p;
            ans=Math.max(ans,i+1);
                
            }


        }
        return ans;

    }
}