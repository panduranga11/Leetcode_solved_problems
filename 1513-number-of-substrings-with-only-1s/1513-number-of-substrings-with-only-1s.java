class Solution {
    public int numSub(String s) {
        int count=0;
        int ans=0;
        int mod=1000000007;
        int n=s.length();
        for(int i=0;i<n;i++){
           int c='1';
           if(s.charAt(i)==c){
            count++;
           }else{
            long val=count*(count+1)/2;
            System.out.print(count);
            ans=(ans+(int)val)%mod;
            count=0;


           }
           
        }
        long val=count*(count+1)/2;
        ans=(ans+(int)val)%mod;

        return ans;
    }
}