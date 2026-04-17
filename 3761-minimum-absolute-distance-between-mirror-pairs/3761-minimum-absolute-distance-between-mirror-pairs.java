class Solution {
    public int minMirrorPairDistance(int[] nums) {
      HashMap<Integer,Integer>map=new HashMap<>();
      int n=nums.length;
      int min=Integer.MAX_VALUE;
      for(int i=n-1;i>=0;i--){
int num=rev(nums[i]);
if(map.containsKey(num)){
   min=Math.min(min,Math.abs(i-map.get(num)));
}
map.put(nums[i],i);

}


if(min==Integer.MAX_VALUE){
    return -1;
}
return min;
 


    }
    
public int rev(int num){
    int ans=0;
    while(num>0){
        int d=num%10;
        ans=ans*10+d;
        num=num/10;

    }
    return ans;
}
public int rtz(int num){
    while(num >0 && num%10==0){
        num=num/10;
    }
    return num;
}

}