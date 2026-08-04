class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n=tasks.length;
        int m=shifts.length;
        long ps[]=new long[n];
        int ans[]=new int [m];
        TreeMap<Long,Integer>map=new TreeMap<>();
        for(int i=0;i<n;i++){
            if(i==0){
                ps[i]=tasks[i];
            }else{
                ps[i]=ps[i-1]+tasks[i];

            }
            map.put(ps[i],i);
        }
       // System.out.println(Arrays.toString(ps));
        //System.out.println(map);
        int prev=-1;
        long cur=0;
        for(int i=0;i<m;i++ ){
            if(prev !=n-1){
                cur+=shifts[i];
            }else{
                cur=shifts[i];
            }
           
         long pos=map.floorKey(cur)!=null?map.floorKey(cur):-1;
         prev=pos!=-1?map.get(pos):-1;
         ans[i]=n-prev-1;
         
            
           
      
        }
        return ans;
    }  
}