class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs=new HashSet<>();
        int n=s.length();

        for(int i=0;i+k<=n;i++){
            String str=s.substring(i,i+k);
            hs.add(str);
        }
    return hs.size()==(int)Math.pow(2,k);
    }
}









// class Solution {
//     public boolean hasAllCodes(String s, int k) {
    
        
//         int n=s.length();
//     if (s.length() < (1 << k) + k - 1) return false;
//         HashSet<String>set=new HashSet<>();
//         StringBuilder sb = new StringBuilder(s.substring(0,k));
        
        
//         for(int i=k;i<n;i++){
//             System.out.println(sb.toString());
//             set.add(sb.toString());
//             sb.deleteCharAt(0);
//             sb.append(s.charAt(i));
//             if(set.size()==Math.pow(2,k)){
//                 return true;
//             }
            
//         }
       
//       set.add(sb.toString());
    

//         return set.size()==Math.pow(2,k);

//     }
// }