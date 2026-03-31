class Solution {
    public boolean checkStrings(String s1, String s2) {
        
        int n=s1.length();
        int ce=0;
        int co=0;
        int []f1=new int[26];
        int []f2=new int[26];
        HashMap<Character,Integer>opos=new HashMap<>();
        HashMap<Character,Integer>epos=new HashMap<>();
        int mp=0;

//checking for equality of character first;
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
           f1[c1-'a']++;
           f2[c2-'a']++;
           if(c1!=c2){
            if(i%2==0){
epos.put(c1,epos.getOrDefault(c1,0)+1);
            }else{
opos.put(c1,epos.getOrDefault(c1,0)+1);
            }
           }
           


        }
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1!=c2){
                if(i%2==0){
                    if(epos.containsKey(c2) && epos.get(c2)>0){
                        epos.put(c2,epos.get(c2)-1);
                    }else{
                        return false;
                    }
                }else{
                     if(opos.containsKey(c2) && opos.get(c2)>0){
                        opos.put(c2,opos.get(c2)-1);
                    }else{
                        return false;
                    }

                }
            }
            
        }
        return true;

        
    }
}
