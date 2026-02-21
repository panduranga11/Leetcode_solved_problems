class Solution {
    public int countPrimeSetBits(int left, int right) {
       boolean []prime=new boolean[33];
       prime[0]=true;
       prime[1]=true;
       for(int i=2;i*i<=32;i++){
        
        for(int j=i*i;j<=32;j+=i){
            prime[j]=true;

        }
       }
       System.out.println(Arrays.toString(prime));
       int count=0;
       for(int i=left;i<=right;i++){
        System.out.println(Integer.bitCount(i));

        if(prime[Integer.bitCount(i)]==false){
            count++;
        }
       }
       return count;
    }
}