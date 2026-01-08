    class Solution {
        public List<List<String>> wordSquares(String[] words) {
            int n=words.length;
        
            
             List<List<String>>ans=new ArrayList<>();
            for(int t=0;t<n;t++){
                
                for(int l=0;l<n;l++){
                    for(int r=0;r<n;r++){
                        for(int b=0;b<n;b++){
                            if(t==l || t==r || t==b || l==r ||l==b || r==b){
                                continue;

                            }
                            if(words[t].charAt(0)==words[l].charAt(0)&&
                            words[t].charAt(3)==words[r].charAt(0)&&
                            words[b].charAt(0)==words[l].charAt(3)&&
                            words[b].charAt(3)==words[r].charAt(3)
                            
                            
                            ){
                                ans.add(Arrays.asList(words[t],words[l],words[r],words[b]));
                            }
                        }
                    }
                }
            }
            Collections.sort(ans, (a, b) -> {
    String sa = String.join(",", a);
    String sb = String.join(",", b);
    return sa.compareTo(sb);
});
            return ans;
    }
    }