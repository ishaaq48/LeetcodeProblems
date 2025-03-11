class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0,r = n - 1;
        int res = 0;

        while(l < r){
            int curr_max = 0;
            if(height[l] < height[r]){
                curr_max = Math.min(height[l] , height[r]) * (r - l);
                l++;
            }
            else{
                curr_max = Math.min(height[l] , height[r]) * (r - l);
                r--;
            }

            res = Math.max(res, curr_max);
        }

        return res;
    }
}