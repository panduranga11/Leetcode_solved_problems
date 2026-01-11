class Solution {
    public long countPairs(String[] words) {
        int n=words.length;
        if(words.length==1){
            return 0;
        }
        long ans=0;
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            String k=convert(words[i]);
            map.put(k,map.getOrDefault(k,0)+1);
            
        }
        for (long cnt : map.values()) {
            ans += cnt * (cnt - 1) / 2;
        }
        return ans;
    
       
}
    public String convert(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int c=(s.charAt(i)-s.charAt(0)+26)%26;
            sb.append(c);
        }
        return sb.toString();
    }
}