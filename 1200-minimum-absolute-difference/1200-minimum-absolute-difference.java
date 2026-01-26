class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
int curdiff=Math.abs(arr[i+1]-arr[i]);
//System.out.println(curdiff);
if(curdiff<mindiff){
    mindiff=curdiff;
    ans.clear();
    List<Integer>cur=new ArrayList<>();
    cur.add(arr[i]);
    cur.add(arr[i+1]);
    ans.add(cur);

}else if(curdiff==mindiff){
    List<Integer>cur=new ArrayList<>();
    cur.add(arr[i]);
    cur.add(arr[i+1]);
    ans.add(cur);
}

}
return ans;

        }
       
    }
