class Solution {
    public String minWindow(String s, String t) {
       if(t.length()>s.length()){
        return "";
        
       }
       String ans="";
       int n=s.length();
       int m=t.length();
       
       HashMap<Character,Integer>map=new HashMap<>();
       for(int i=0;i<m;i++){
        char ch=t.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       }
       int len=Integer.MAX_VALUE;

       int l=0;
       int []freq=new int[128];
       for(int r=0;r<n;r++){
        char ch=s.charAt(r);
        freq[ch]++;
        while(check(map,freq)){
        if(r-l+1<len){
            ans=s.substring(l,r+1);
            //System.out.println(ans);
            len=r-l+1;

        }
            char c=s.charAt(l);
            freq[c]--;
            

           l++;
        }
    
        
       }
       return ans;
      
    }
    public boolean check(HashMap<Character,Integer>map,int []freq){
        for(char val:map.keySet()){
            // System.out.println(map.get(val));
            if(map.get(val)>freq[val]){
                return false;
            }
        }
        return true;
    }
}