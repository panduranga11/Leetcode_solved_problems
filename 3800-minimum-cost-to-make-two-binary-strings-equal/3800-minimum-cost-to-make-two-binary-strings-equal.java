class Solution {
    public long minimumCost(String s, String t, int flip, int swap, int cross) {
        
         int n=s.length();
         int  as0=0;
         int as1=0;
        for(int i=0;i<n;i++){
           char c1=s.charAt(i);
           char c2=t.charAt(i);
           if(c1=='0' && c2=='1'){
            as0++;
           }else if(c1=='1' && c2=='0'){
            as1++;
           }
        }
        long cost=0;
        long paired=Math.min(as0,as1);
        long rem=Math.max(as0,as1)-paired;

        cost+=Math.min(2L*flip*paired,1L*(paired*swap));
        cost+=rem/2*Math.min(2L*flip,1L*(swap+cross));
        cost+=(rem%2)*1L*flip;
        return cost;

       
        
        // System.out.println(t1+" "+t0);
        // System.out.println(s1+" "+s0);
        // for(int i=0;i<n;i++){
        //      char c1=s.charAt(i);
        //    char c2=t.charAt(i);
        //    if(c1!=c2){
        //     if(flip<=swap || as0<2 && as1<2){
        //         cost+=flip;
        //         System.out.println(cost);
        //     }else{
        //         if(c1=='0' && as0>=2){
        //             cost+=swap;
        //             as0-=2;
        //         }else if(c1=='1' && as1>=2){
        //             cost+=swap;
        //             as1-=2;
        //         }else{
        //             cost+=(swap+cross);
        //         }
        //     }
           
            
        //    }

        // }
       
    }
}