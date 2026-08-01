class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] p, int c) {
        int n=buses.length;
        int m=p.length;
        Arrays.sort(buses);
        Arrays.sort(p);
        //System.out.println(Arrays.toString(buses));
        //System.out.println(Arrays.toString(p));
   HashSet<Integer>set=new HashSet<>();
   int ind=0;
   int i=0;
   int lastperson=-1;
   int lastcap=-1;
   while(i<n){
    int dep=buses[i];
    int cap=0;
    while(ind<m && p[ind]<=dep && cap<c){
       
        set.add(p[ind]);
        cap++;
        ind++;

    }
    lastperson=ind;
    lastcap=cap;
    i++;


    
    
   }
   int v=buses[n-1];
if(lastcap==c){
     v=p[lastperson-1];
    }
    while(set.contains(v)){
        v--;
    }
    return v;
    }
}