class Solution {
    public boolean canFinish(int n, int[][] pr) {
       ArrayList<ArrayList<Integer>>ls=new ArrayList<>();
       for(int i=0;i<n;i++){
        ls.add(new ArrayList<>());

       }
       int m=pr.length;
       for(int i=0;i<m;i++){
        int a=pr[i][1];
        int b=pr[i][0];
        ls.get(a).add(b);
       }
       int []inde=new int[n];
       for(int i=0;i<n;i++){
        for(int j:ls.get(i)){
            inde[j]++;
        }
       }
      
      
       int count=0;
       Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
        if(inde[i]==0){
            q.offer(i);
            count++;
        }
       }
       
       
       while(!q.isEmpty()){
int ind=q.poll();
for(int i:ls.get(ind)){
    inde[i]--;
    if(inde[i]==0){
        count++;
        q.offer(i);
    }

}
    

    }
     return count==n;
}
}