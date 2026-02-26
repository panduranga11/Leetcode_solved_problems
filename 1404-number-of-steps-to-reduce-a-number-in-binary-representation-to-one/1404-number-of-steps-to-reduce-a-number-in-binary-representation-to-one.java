class Solution {
   public String addOne(String s){
    StringBuilder sb=new StringBuilder(s);
    int n=s.length();
    int carry=1;
    for(int i=n-1;i>=0;i--){
        if(sb.charAt(i)=='1' && carry==1){
            sb.setCharAt(i,'0');
        }else if(sb.charAt(i)=='0' && carry==1){
            sb.setCharAt(i,'1');
            carry=0;
            break;
        }

        }
        if(carry==1){
            sb.insert(0,'1');
        }
        return sb.toString();
        
    }
   
   
    public int numSteps(String s) {
        
        int count=0;
        
        while(s.length()>1){
            int n=s.length();
            char c=s.charAt(n-1);
            if(c=='0'){
                s=s.substring(0,n-1);
            }else{
                s=addOne(s);
            }
            count++;
        }
       
        return count;
    }
}