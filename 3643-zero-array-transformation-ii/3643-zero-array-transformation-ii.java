class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int low = 0, high = m, result = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canZero(nums,queries,mid,n)){
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return result;
    }
    public boolean canZero(int[] nums, int[][] q,int k,int n){
        int[] line = new int[n + 1];

        for(int i = 0; i < k; i++)
        {
            int l = q[i][0];
            int r = q[i][1];
            int val = q[i][2];

            line[l] += val;
            if(r + 1 < n){
                line[r + 1] -= val; 
            }
        }

        for(int i = 1; i < n; i++){
            line[i] += line[i-1];
        }

        for(int i = 0; i < n; i++){
            if(line[i] < nums[i])
                return false;
        }
        
        return true;
    }
}