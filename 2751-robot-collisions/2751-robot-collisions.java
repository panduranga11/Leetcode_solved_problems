class Solution {
    class Pair{
        char c;
        int pos;
        int ind;

        Pair(char c,int pos,int ind){
            this.c=c;
            this.pos=pos;
            this.ind=ind;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] p, int[] h, String d) {
        int n=p.length;
        List<Integer>ls=new ArrayList<>();
        List<Pair>arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Pair(d.charAt(i),p[i],i));
        }
        arr.sort((a,b)->{
            return a.pos-b.pos;
        });

        Stack<Pair>st=new Stack<>();
        for(int i=0;i<n;i++){
            char dir=arr.get(i).c;
            int curind=arr.get(i).ind;
            if(dir=='R'){
                st.push(arr.get(i));
            }else{
                while(!st.isEmpty() && h[st.peek().ind]<h[curind]){
                    h[st.peek().ind]=-1;
                    st.pop();
                    h[curind]-=1;
                    if(h[curind]<=0){
                        break;
                    }
                }
                if(!st.isEmpty() && h[st.peek().ind]==h[curind]){
                   
                    h[st.peek().ind]=-1;
                    h[curind]=-1;
                    st.pop();


                }else{
                    if(!st.isEmpty()){
                        h[st.peek().ind]-=1;
                        h[curind]=-1;

                    }
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(h[i]>0){
                ans.add(h[i]);
            }
        }
        return ans;
        
        
        
    }
}