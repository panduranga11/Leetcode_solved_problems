class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int co=0;
        int c1=0;
    ArrayList<Integer>ls=new ArrayList<>();
    for(int i=0;i<n;i++){
        char c=s.charAt(i);
        if(c=='0'){
         co++;
         if(c1!=0){
            ls.add(c1);
         }
         c1=0;
        }else{
         c1++;
         if(co!=0){
            ls.add(co);
         }
         co=0;
        }

    }
    if(co!=0){
        ls.add(co);
    }
    if(c1!=0){
        ls.add(c1);
    }
   int ans=0;
   for(int i=0;i<ls.size()-1;i++){
  ans+=Math.min(ls.get(i),ls.get(i+1));
   }
   return ans;
    }
}