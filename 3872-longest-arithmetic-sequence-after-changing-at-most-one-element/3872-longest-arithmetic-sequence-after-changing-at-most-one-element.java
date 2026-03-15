class Solution {
    public int longestArithmetic(int[] nums) {
        int n=nums.length;
        int []p=new int [n];
        int []s=new int [n];
        if(n<=2){
            return n;
        }
        
       

        p[0]=1;
        p[1]=2;
        
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                p[i]=p[i-1]+1;
            }else{
                
                p[i]=2;
            }
        }
        s[n-1]=1;
        s[n-2]=2;
        
       
        for(int i=n-3;i>=0;i--){
           if(nums[i+1]-nums[i]==nums[i+2]-nums[i+1]){
                s[i]=s[i+1]+1;
            }else{
                
                s[i]=2;
            }
        }
        
        System.out.println(Arrays.toString(p));
         System.out.println(Arrays.toString(s));
        int maxlen=1;

        for(int i=0;i<n;i++){
            if(i==0){
                maxlen=Math.max(maxlen,s[i+1]+1);
                
            }else if(i==n-1){
                maxlen=Math.max(maxlen,p[i-1]+1);
            }else{
                int p1=1;
                int n1=1;
                int prev=p[i-1];
                int next=s[i+1];
                maxlen=Math.max(maxlen,Math.max(prev,next)+1);
                int sum=nums[i-1]+nums[i+1];
                if((sum)%2==0){
                    int mid=sum/2;
                    int diff=(nums[i+1]-nums[i-1])/2;
                    if(i>=2 && nums[i-1]-nums[i-2]==diff){
                        p1=prev;
                    }
                    if(i<=n-3 && nums[i+2]-nums[i+1]==diff){
                        n1=next;
                    }
                    maxlen=Math.max(maxlen,p1+n1+1);
                }

                

                

                }
                
                
                
                }


        
        
        return maxlen;
      
        
            
    }
}