class Solution {
    
    public void merge(int[] nums, int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while(right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for(int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public int cntPairs(int[] nums, int low, int mid,int high){
        int right = mid + 1;
        int cnt = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long) nums[i] > 2L * nums[right]) right++;
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    public int mergeSort(int[] nums,int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += cntPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

}