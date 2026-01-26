class Solution {
    public int minTaps(int n, int[] ranges) {
        int le=ranges.length;
        ArrayList<int []>intervals=new ArrayList<>();
        for(int i=0;i<le;i++){
            if(ranges[i]!=0){
            int l=Math.max(i-ranges[i],0);
            int r=Math.min(i+ranges[i],n);
            
            intervals.add(new int []{l,r});
            }
        }
        intervals.sort((a,b)->{
            if(a[0]-b[0]==0){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        // for(int [] i:intervals){
        //     System.out.println(Arrays.toString(i));
        // }

      
     int count=0;
int curr=0;
int i=0;
while (curr < n) {
            int farthest = curr;

            while (i < intervals.size() && intervals.get(i)[0] <= curr) {
                farthest = Math.max(farthest, intervals.get(i)[1] );
                i++;
            }

            if (farthest == curr) {
                return -1; 
            }

            count++;
            curr = farthest;
        }
        return count;
    
    
}
    }
