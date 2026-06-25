class Solution {
    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>>ls=new ArrayList<>();
        int m=p.length;
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int [] i:p){
            ls.get(i[1]).add(i[0]);
        }
        int inorder[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j:ls.get(i)){
                inorder[j]++;
            }
        }
        //System.out.println(Arrays.toString(inorder));
        int count=0;
      int []ans=new int [n];
      int ind=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0){
           
q.offer(i);
ans[ind]=i;
ind++;



            }
        }
        //System.out.println(q);
        //System.out.println(Arrays.toString(inorder));
       

    
//System.out.println(ls);
    while(!q.isEmpty()){
        int nn=q.poll();
        for(int i:ls.get(nn)){
            inorder[i]--;
           // System.out.println(Arrays.toString(inorder));
            if(inorder[i]==0){
                System.out.println(i);
                q.offer(i);
                 if(ind>=n){
                    return new int []{};
                }
                ans[ind]=i;
ind++;
               
            }
        }
    }
    //System.out.println(ind);
    return ind==n ?ans:new int []{};
}
}