

class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int arr[]=new int[128];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c]++;
        }
        int target=n/4;

        int l = 0;
        int r = 0;
        int ans=n;

        while (r < n) {
            char c = s.charAt(r);
            arr[c]--;

          while(l<n&& arr['Q']<=target && arr['W']<=target && arr['E']<=target && arr['R']<=target){
            char ch=s.charAt(l);
            arr[ch]++;
            ans=Math.min(ans,r-l+1);
            l++;
          }

            

            r++;
        }

        return ans;
    }
}
