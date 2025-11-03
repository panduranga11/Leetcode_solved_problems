class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    public static boolean check(long t,int []d,int []r){
        long t1=t-(t/r[0]);
        long t2=t-(t/r[1]);
        if(d[0]>t1 ||d[1]>t2){
            return false;
        }
        long both=t -(t/lcm(r[0],r[1]));
        return d[0]+d[1]<=both;

    }
    
    public long minimumTime(int[] d, int[] r) {
       long low=d[0]+d[1];
       long high = (long)(d[0] + d[1]) * Math.max(r[0], r[1]);
       long ans=Long.MAX_VALUE;
       while(low<=high){
        long mid=(low+high)/2;
        if(check(mid,d,r)){
        ans=mid;
        high=mid-1;
        }else{
            low=mid+1;
        }
       }
       return ans;
      
    }
}

//https://www.youtube.com/watch?v=IfBNFgv7DDc&t=12s
