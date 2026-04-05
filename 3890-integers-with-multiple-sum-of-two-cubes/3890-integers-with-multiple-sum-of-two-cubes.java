class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer>ls=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a=1;a*a*a<=n;a++){
            for(int b=1;b<a;b++){
                
                int sum=a*a*a+b*b*b;
                
                
                map.put(sum,map.getOrDefault(sum,0)+1);
                if(map.get(sum)==2 && sum<=n){
                    System.out.println(sum);
                    ls.add(sum);
                }

            }
        }
        Collections.sort(ls);
        return ls;
       
}
        
    }
