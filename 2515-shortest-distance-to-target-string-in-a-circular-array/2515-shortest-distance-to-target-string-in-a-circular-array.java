class Solution {
    public int closestTarget(String[] words, String target, int st) {
        int n=words.length;
        int f=-1;
        int b=-1;
        int move=Math.max(st,n-st);
        for(int i=0;i<=move;i++){
            if(f==-1 && words[(st+i)%n].equals(target)){
               f=i;
            }
            if(b==-1 && words[(st-i+n)%n].equals(target)){
                b=i;
            }
        }
     if(f==-1 && b==-1){
        return -1;
     }
     return Math.min(f,b);
    }
}