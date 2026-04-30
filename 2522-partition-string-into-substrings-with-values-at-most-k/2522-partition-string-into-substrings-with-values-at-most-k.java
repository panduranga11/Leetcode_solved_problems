class Solution {
    public int minimumPartition(String s, int k) {
        int n=s.length();
        long num=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int digit=s.charAt(i)-'0';
            if(num*10+digit<=k){
                num=num*10+digit;
            }else{
                if(num<=k){
                ans++;
                }else{
                    return -1;
                }
                num=0;
                num=num*10+digit;
                //System.out.println(num);
            }
            

        }
        if(num<=k){
                ans++;
            }else{
                return -1;
            }
        return ans;
    }
}