class Solution {
    public boolean checkDivisibility(int n) {
     int sum=0;
     int k=n;
     int prod=1;
     while(n>0){
        int d=n%10;
        sum+=d;
        prod*=d;
        n=n/10;
     }  
     //System.out.println(sum+ " "+prod);
     return k%(sum+prod)==0; 
    }
}