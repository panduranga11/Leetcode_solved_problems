class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
               // System.out.println(sum);
               int last=(int)(sum%10);

               
               if(last==x){
               String s=Long.toString(sum);
            //    System.out.println(s);
              
               if((s.charAt(0)-'0')==x){
                count++;
               }

                
            }
        }
       
    }
     return count;
    
}
}