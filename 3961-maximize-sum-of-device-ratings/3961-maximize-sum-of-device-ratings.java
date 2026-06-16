class Solution {
    public long maxRatings(int[][] units) {
int n=units.length;
int fis[]=new int[n];
int sec[]=new int[n];
for(int i=0;i<n;i++){
    Arrays.sort(units[i]);
    if(units[i].length>=2){
        fis[i]=units[i][0];
        sec[i]=units[i][1];
    }else{
        fis[i]=units[i][0];
    }
}
int min=1000000;
long sum=0;
int gmin=1000000;
// System.out.println(Arrays.toString(fis));
// System.out.println(Arrays.toString(sec));
for(int i=0;i<n;i++){
    if(sec[i]!=0){
    sum+=sec[i];
    min=Math.min(min,sec[i]);
     gmin=Math.min(gmin,fis[i]);
   
    }else{
        sum+=fis[i];
    }
    


}
return sum-min+gmin;


    }
}