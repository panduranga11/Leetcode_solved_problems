class Solution {
    public int countSequences(int[] nums, long k) {
        long mul=1;
        for(int i:nums){
            mul*=i;
        };
        if(mul<k){
            return 0;
        }
         HashMap<String, Integer> map = new HashMap<>();
        return solve(0,nums,k,1,1,map);
        
    }
    public int solve(int ind,int []nums,long tar,long num,long den,  HashMap<String, Integer> map ){
        
       if(ind==nums.length){
           return num==tar*den?1:0;
       }
        String key=ind+"*"+num+"*"+den;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        long ans=0;
        long mulnum=num*nums[ind];
        long mulden=den;
        long g1=gcd(Math.abs(mulnum),Math.abs(mulden));
        long mul=solve(ind+1,nums,tar,mulnum/g1,mulden/g1,map);
        long divnum=num;
        long divden=den*nums[ind];
        long g2=gcd(Math.abs(divnum),Math.abs(divden));

        long div=solve(ind+1,nums,tar,divnum/g2,divden/g2,map);
        
        long same=solve(ind+1,nums,tar,num,den,map);
        ans = (mul + div + same);
        int k=(int)ans;
        map.put(key,k);
        return k;
    
        
    }
     public  long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}