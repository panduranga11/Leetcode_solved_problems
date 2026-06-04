class Solution {
    public static int count(String s){
        char c[]=s.toCharArray();
        int count=0;
        for(int i=1;i<c.length-1;i++){
            if(c[i-1]<c[i] &&c[i+1]<c[i] || c[i-1]>c[i] && c[i+1]>c[i]){
                count++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int co=0;
       for(int i=num1;i<=num2;i++){
           String n=String.valueOf(i);
           co+=count(n);
       } 
        return co;
    }
}