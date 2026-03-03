class Solution {
    public int minSwaps(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int []arr=new int [m];
        for(int i=0;i<m;i++){
            int c=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0){
                    c++;
                }else{
                    break;
                }
            }
            arr[i]=c;
        }
        System.out.println(Arrays.toString(arr));
        int ans=0;
        for(int i=0;i<n;i++){
            int req=n-i-1;
            int j=i;
            while(j<n && arr[j]<req){
                j++;
               
            }
           
            if(j==n)return -1;
            while(j>i){
                int t=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=t;
                j--;
                ans++;
            }

        }
        return ans;
        
       
    }
}