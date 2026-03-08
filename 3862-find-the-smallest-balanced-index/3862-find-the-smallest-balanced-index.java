class Solution {
    public int smallestBalancedIndex(int[] nums) {
      
        int n=nums.length;
        long []pres=new long[n];
        long []sufp=new long[n];
        long sum=0;
        long prod=1;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            pres[i]=sum;
            prod=prod*nums[n-i-1];
            sufp[n-i-1]=prod;
        }
        System.out.println(Arrays.toString(pres));
        System.out.println(Arrays.toString(sufp));
       for(int i=0;i<n;i++){
        long left=i==0?0:pres[i-1];
        long right=i==n-1?1:sufp[i+1];
        if(left==right && i!=0){
            System.out.println(left);
            System.out.println(right);
            return i;
        }
       }
       return -1;
        
}
}
//906/907
// double log[]=new double[n];
//         log[0]=Math.log(nums[0]);
//         for(int i=1;i<n;i++){
//             log[i]=log[i-1]+Math.log(nums[i]);
            
//         }
//         double presum=0;
//         if(n==1){
//             return -1;
//         }
//         if(n==2){
//             if(nums[0]==1){
//                 return 1;
//             }else{
//                 return -1;
//             }
            
                
//             }
        
        
        
//         for(int i=0;i<n;i++){
//             double left=Double.MAX_VALUE;
//             double right=0;
//             if(i!=0 ){
//                 left=Math.log(presum);
//             }
//             if(i!=n-1){
//                 right=log[n-1]-log[i];
//             }
//             if(Math.abs(left-right)<1e-9){
//                 return i;
//             }
//             presum+=nums[i];
            
//         }
//         return -1;
//     }