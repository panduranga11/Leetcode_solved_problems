class Solution {
    public int minimumBoxes(int[] a, int[] c) {
        int sum=0;
         int n=a.length;
        int m=c.length;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
    
        Arrays.sort(c);
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
         int temp = c[i];
          c[i] = c[j];
          c[j] = temp;
}
        
       
        for(int i=1;i<m;i++){
            c[i]+=c[i-1];
        }
       
        int l=0;
        int r=m-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(c[mid]<sum){
                
                l=mid+1;
                
                
            }else{
                
                r=mid-1;
                

            }
        }
        System.out.println(l);
        return l+1;
        // int count=0;
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     sum+=a[i];
        // }
        
        
        // int inc=0;
        // for(int i=m-1;i>=0;i--){
        //   if(inc+c[i]<sum){
        //     inc+=c[i];
        //     count++;
        //   }else{
        //     break;
        //   }
        // }
      
    
    
        
        // return count+1;
        
}
}