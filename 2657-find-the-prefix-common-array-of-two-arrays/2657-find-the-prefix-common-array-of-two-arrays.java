class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
       int n=A.length;
       int []ans=new int [n];
       int count=0;
       int a[]=new int[51];
       int b[]=new int[51];
       for(int i=0;i<n;i++){
        int p1=A[i];
        int p2=B[i];
        if(a[p2]!=0){
            count++;
        }
        if(b[p1]!=0){
            count++;
        }
        if(p1==p2){
            count++;
        }
        a[p1]++;
        b[p2]++;
       
        ans[i]=count;
       

       }
       return ans;
    }
}