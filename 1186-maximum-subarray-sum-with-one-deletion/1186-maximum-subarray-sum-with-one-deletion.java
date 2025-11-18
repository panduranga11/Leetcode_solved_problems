class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
         if(arr.length==1){
        return arr[0];
    }
        int l[]=new int[n];
        int r[]=new int[n];
        l[0]=arr[0];
        int sum=arr[0];
        for(int i=1;i<n;i++){
            if(l[i-1]+arr[i]>arr[i]){
                l[i]=l[i-1]+arr[i];
            }else{
                l[i]=arr[i];
            }
            sum+=arr[i];
        }
        r[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]+r[i+1]>arr[i]){
                r[i]=arr[i]+r[i+1];
            }else{
                r[i]=arr[i];
            }
        }
        int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
 if(i==0){
            max=Math.max(max,Math.max(arr[i],r[i+1]));

        }else if(i==n-1){
            max=Math.max(max,Math.max(arr[i],l[i-1]));
        }else{
            int le=l[i-1];
            int ri=r[i+1];
            
            if(le>0 && ri>0){
                max=Math.max(max,Math.max(arr[i],le+ri));
            }else{
                max=Math.max(max,Math.max(arr[i],Math.max(le,ri)));
               
            }
        }
       }
       return sum>max?sum:max;

    }
}