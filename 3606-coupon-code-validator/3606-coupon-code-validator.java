class Solution {
    class pair{
        String code,bline;
        boolean active;
        pair(String c,String bline,boolean a){
            this.code=c;
            this.bline=bline;
            this.active=a;
        }
    }
    public boolean valcode(String s){
    if (s == null || s.length() == 0) {
    return false;
}

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!Character.isLetter(c) &&!Character.isDigit(c) && c!=95){
                return false;

            }
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] b, boolean[] isActive) {
        int n=code.length;
        ArrayList<pair> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(valcode(code[i]) && !b[i].equals("invalid") && isActive[i]){
                a.add(new pair(code[i],b[i],isActive[i]));

            }
        }
        List<String>ans=new ArrayList<>();
        Collections.sort(a,(k,m)->{
            if(k.bline.compareTo(m.bline)==0){
                return k.code.compareTo(m.code);
            }else{
                return k.bline.compareTo(m.bline);
            }
        });
        for(int i=0;i<a.size();i++){
            ans.add(a.get(i).code);
        }
        return ans;
    }
}