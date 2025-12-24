class Solution {
    public int minimumBoxes(int[] a, int[] c) {
        Arrays.sort(c);
        int count=0;
        int sum=0;
        int n=a.length;
        int m=c.length;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        System.out.println(sum);
        System.out.println(Arrays.toString(c));
        int inc=0;
        for(int i=m-1;i>=0;i--){
          if(inc+c[i]<sum){
            inc+=c[i];
            count++;
          }else{
            break;
          }
            
           
           
        }
      
    
    
        
        return count+1;
        
}
}