class Solution {
    public int numSub(String s) {
        long count=0;
        long ans=0;
        int mod=1000000007;
        int n=s.length();
        for(int i=0;i<n;i++){
           
           if(s.charAt(i)=='1'){
            count++;
           }else{
         ans=(ans+(count*(count+1)/2)%mod)%mod;
            count=0;
}
           
        }
       
          ans=(ans+(count*(count+1)/2)%mod)%mod;
        
      

        return (int)ans;
    }
}