class Solution {
    public boolean search(int[] nums, int target) {
        int pivot=pivotindexinDup(nums);
        if(pivot !=-1 && nums[pivot]==target){
            return true;
        }
        if(pivot==-1){
            return searchbinary(nums,target,0,nums.length-1);
        }
        int st=0;
        if(target>=nums[st]){
            return searchbinary(nums,target,0,pivot);
        }else{
            return searchbinary(nums,target,pivot+1,nums.length-1);
        }

        
    }
    public int pivotindexinDup(int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    while (l <= r) {
        int mid = (l + r) / 2;

        if (mid < r && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > l && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if (arr[mid] == arr[l] && arr[mid] == arr[r]) {
            if (l + 1 < arr.length && arr[l] > arr[l + 1]) {
                return l;
            }
            l++;
            if (r - 1 >= 0 && arr[r] < arr[r - 1]) {
                return r - 1;
            }
            r--;
        } else if (arr[l] < arr[mid] || (arr[l] == arr[mid] && arr[mid] > arr[r])) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return -1;
}

     

     public boolean searchbinary(int[] nums, int target,int l,int r) {
       

        while(l<=r){
            int mid=(l+r)/2;
            if(target==nums[mid]){
                return true;
              
            }else if(target>nums[mid]){
                l=mid+1;

            }else{
                r=mid-1;
            }
            
        }
        return false;
    }
}