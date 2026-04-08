class Solution {
  class Pair{
    int val;
    int ind;
    Pair(int val,int ind){
        this.val=val;
        this.ind=ind;
    }
  }
    public long maxPoints(int[] t1, int[] t2, int k) {
      int n=t1.length;  
    ArrayList<Pair>ls=new ArrayList<>();
   for(int i=0;i<n;i++){
ls.add(new Pair(t1[i],i));
   }
   ls.sort((Pair a,Pair b)->{
    int d1=t1[a.ind]-t2[a.ind];
    int d2=t1[b.ind]-t2[b.ind];
    return d2-d1;
   });
   HashSet<Integer>set=new HashSet<>();
   int m=0;
   long total=0;
   if(k>=1){
   for(int i=0;i<k;i++){
    set.add(ls.get(i).ind);
    total+=ls.get(i).val;
   }
  
   }
   for(int i=0;i<n;i++){
    if(!set.contains(i)){
        total+=Math.max(t1[i],t2[i]);
    }
   }
   return total;
}
}