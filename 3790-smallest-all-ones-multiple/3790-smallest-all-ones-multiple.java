class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0){
            return -1;
        }
        int c=1;
        int num=1;
        for(int i=0;i<k;i++){
            num=(num*10+1)%k;
            if(num%k==0){
                return c+1;
            }
            c++;
        }
        return c;
        

}
}