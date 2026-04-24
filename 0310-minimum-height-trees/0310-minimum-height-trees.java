class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        int degree[]=new int[n];
        
        if(n==1){
            ans.add(0);
            return ans;
        }
      

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            degree[u]++;

            adj.get(v).add(u);
            degree[v]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        int k=n;
        while(k>2 && !q.isEmpty()){
           
            int s=q.size();
            for(int i=0;i<s;i++){
                 int node=q.poll();
                 degree[node]--;
                 k--;
                 if(k<2){
                    break;
                 }
                 for(int j:adj.get(node)){
                    degree[j]--;
                    if(degree[j]==1){
                        q.offer(j);
                    }
                 }

            }
        }
            
            while(!q.isEmpty()){
                ans.add(q.poll());
            }
            return ans;

        }
        
        
    }
    