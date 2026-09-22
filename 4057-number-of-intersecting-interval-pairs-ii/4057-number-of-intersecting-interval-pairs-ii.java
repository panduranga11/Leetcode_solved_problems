class Solution {
    //sort based on st (if equal via end des )
    //for every position find the pos where st >end(of cur pos)
    //the no.of pairs is the differnce blw their indexes 

    public long countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length;
       Arrays.sort(intervals,(a,b)->{
           if(Integer.compare(a[0],b[0])==0){
               return Integer.compare(b[1],a[1]);
           }
           return Integer.compare(a[0],b[0]);
       });
        long ans=0;
        for(int i=0;i<n;i++){
            int end=intervals[i][1];
            int ind=find(intervals,end);
            ans+=(ind-i);
            
        }
        return ans;
        
        
    }
    public int find(int [][]intervals,int tar){
        int l=0;
        int r=intervals.length;
        while(l<r){
            int mid=l+(r-l)/2;
            int val=intervals[mid][0];
            if(val>tar){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l-1;
    }
    
}