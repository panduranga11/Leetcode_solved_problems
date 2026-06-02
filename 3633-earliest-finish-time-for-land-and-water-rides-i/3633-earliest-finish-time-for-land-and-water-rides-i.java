class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           int cur=landStartTime[i]+ landDuration[i];
           //System.out.println(i+" "+cur);
      for(int j=0;j<m;j++){
        if(cur>=waterStartTime[j]){
            
            ans=Math.min(ans,cur+waterDuration[j]);
        }else{
            int k=waterStartTime[j]+waterDuration[j];
            ans=Math.min(ans,k);
        }

      }
        }
      for(int i=0;i<m;i++){
           int cur=waterStartTime[i]+ waterDuration[i];
          // System.out.println(i+" "+cur);
      for(int j=0;j<n;j++){
        
        if(cur>=landStartTime[j]){
           
            ans=Math.min(ans,cur+landDuration[j]);
        }else{
            int k=landStartTime[j]+landDuration[j];
          
            ans=Math.min(ans,k);
        }

      }
        }
        return ans;
    }
}