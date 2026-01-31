class MinStack {
Stack<Integer>st=new Stack<>();
Stack<Integer>mst=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            mst.push(val);
        }else{
            st.push(val);
           if(val< mst.peek()){
            mst.push(val);
           }
        }
        
    }
    
    public void pop() {
        int ele=st.peek();
        if(!st.isEmpty()){
            st.pop();
        }
        if(!mst.isEmpty() && mst.peek()==ele){
            mst.pop();
        }
        
        
    }
    
    public int top() {
        
            return st.peek();
        
        
        
    }
    
    public int getMin() {
        
            return mst.peek();
        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */