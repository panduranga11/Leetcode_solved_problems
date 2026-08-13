class NumArray {
   
    int []tree;
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        tree=new int[4*n];
        build(0,0,n-1,nums,tree);
    }
    
    public void update(int index, int val) {
        update(tree,0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return query(tree,0,0,n-1,left,right);
    }

    public void build(int node,int l,int r,int []nums,int []tree){
        if(l==r){
            tree[node]=nums[l];
            return;
        }

        int mid=l+(r-l)/2;

        build(2*node+1,l,mid,nums,tree);
        build(2*node+2,mid+1,r,nums,tree);

        tree[node]=tree[2*node+1]+tree[2*node+2];
    }

    public void update(int []tree,int node,int l,int r,int ind,int val){
        
        if(l==r){
            tree[node]=val;
            return;
        }

        int mid=l+(r-l)/2;

        if(ind<=mid){
            update(tree,2*node+1,l,mid,ind,val);
        }else{
            update(tree,2*node+2,mid+1,r,ind,val);
        }

        tree[node]=tree[2*node+1]+tree[2*node+2];
    }

    public int query(int []tree,int node,int l,int r,int qs,int qe){
        
        if(r<qs || l>qe){
            return 0;
        }

        if(l>=qs && r<=qe){
            return tree[node];
        }

        int mid=l+(r-l)/2;

        int left=query(tree,2*node+1,l,mid,qs,qe);
        int right=query(tree,2*node+2,mid+1,r,qs,qe);
        
        return left+right;
    }
}