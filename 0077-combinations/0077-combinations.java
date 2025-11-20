class Solution {
    public static void comb(int n,int k,int i,List<Integer>adj,List<List<Integer>>ans){
        if(adj.size()==k){
ans.add(new ArrayList<>(adj));
return;
        }
        if(i>n){
            return;
        }
        adj.add(i);
        comb(n,k,i+1,adj,ans);
        adj.remove(adj.size()-1);
        comb(n,k,i+1,adj,ans);


    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>adj=new ArrayList<>();
        comb(n,k,1,adj,ans);
        return ans;
    }
}