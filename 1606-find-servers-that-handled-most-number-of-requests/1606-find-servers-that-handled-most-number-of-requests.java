class Solution {
    class Pair{
        int ind;
        int et;
        Pair(int i,int e){
            this.ind=i;
            this.et=e;
        }
    }
    public List<Integer> busiestServers(int k, int[] a, int[] l) {
        List<Integer>ans=new ArrayList<>();
        int []et=new int [k];
        int []c=new int [k];
        int n=a.length;
        int max=Integer.MIN_VALUE;
        // int minend=Integer.MAX_VALUE;
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->{
            return x.et-y.et;
        });

        for(int i=0;i<n;i++){
           int at=a[i]; 
            if(et[i%k]<=at){
                
                et[i%k]=at+l[i];
              pq.offer(new Pair(i%k,at+l[i]));
                c[i%k]++;
            }else{
                
               Pair p=pq.peek();
               
               int time=p.et;
               if(time>at){
                continue;
               }else{
Pair cur=pq.poll();
int idx=cur.ind;

                    et[idx]=at+l[i];
                    c[idx]++;
                   pq.offer(new Pair(idx,at+l[i]));
               }
                
               
            }
            

        }
        //System.out.println(Arrays.toString(c));
        for(int i:c){
            max=Math.max(max,i);
        }
      //  System.out.println(max);
        for(int i=0;i<k;i++){
            if(c[i]==max){
                ans.add(i);
            }
        }
return ans;
    }
}