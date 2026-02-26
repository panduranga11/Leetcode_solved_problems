class Solution {
    class pair{
        TreeNode root;
        int col;
        int depth;
        pair(TreeNode root,int col,int depth){
            this.root=root;
            this.col=col;
            this.depth=depth;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<int[]>> map=new HashMap<>();
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(root,0,0));

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            pair p=q.poll();

            int col=p.col;
            int depth=p.depth;
            int value=p.root.val;

            min=Math.min(min,col);
            max=Math.max(max,col);

            map.putIfAbsent(col,new ArrayList<>());
            map.get(col).add(new int[]{depth,value});

            if(p.root.left!=null){
                q.add(new pair(p.root.left,col-1,depth+1));
            }
            if(p.root.right!=null){
                q.add(new pair(p.root.right,col+1,depth+1));
            }
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=min;i<=max;i++){
            ArrayList<int[]> list=map.get(i);

            list.sort((a,b)->{
                if(a[0]==b[0]) return Integer.compare(a[1],b[1]); 
                return Integer.compare(a[0],b[0]); 
            });

            List<Integer> temp=new ArrayList<>();
            for(int[] arr:list){
                temp.add(arr[1]);
            }
            ans.add(temp);
        }

        return ans;
    }
}