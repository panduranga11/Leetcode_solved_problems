class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        if(intervals.length==1){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]!=0?a[0]-b[0]:a[1]-b[1];
        });
        int ans=0;
        int st=intervals[0][0];
        int end=intervals[0][1];
       for(int i=1;i<n;i++){
        int curst=intervals[i][0];
        int curend=intervals[i][1];
        if(curst>=end){
          st=curst;
          end=curend;
        }else{
            st=curst;
            end=Math.min(end,curend);
            ans++;

        }

       }
       return ans;

    }
}