class Solution {
     
    public String getHappyString(int n, int k) {
        ArrayList<String>ls=new ArrayList<>();
     
       solve(0,"",'d',n,ls);
         System.out.println(ls);
       if(k<=ls.size()){
        Collections.sort(ls);
        //System.out.println(ls);
        return ls.get(k-1);
       }
       return "";
    }
    public void solve(int ind,String s,char prev,int n,ArrayList<String>ls){
        if(ind==n){
            
            ls.add(s);
            //System.out.println(ls);
            return;
        }
        for(int i=0;i<3;i++){
            char c=(char)('a'+i);
            if(prev!=c ){
                solve(ind+1,s+c,c,n,ls);

            }

        }
    }
}