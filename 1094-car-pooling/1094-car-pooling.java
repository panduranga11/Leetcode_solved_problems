class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer,Integer>map=new TreeMap<>();
    for(int []t:trips){
        map.put(t[1],map.getOrDefault(t[1],0)+t[0]);
        map.put(t[2],map.getOrDefault(t[2],0)-t[0]);
    }
    int cap=0;
    for(int k:map.keySet()){
        cap+=map.get(k);
        if(cap>capacity){
            return false;
        }
    }
    return true;
    }
}