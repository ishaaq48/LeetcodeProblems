class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0,l = 0,r = 0,zero = 0;
        int len=0,n=nums.length;
        while(r < n)
        {
            if(nums[r] == 0) zero++;
            if(zero > k)
            {
                if(nums[l] == 0 ) zero--;
                l++;
            }
            if(zero <= k)
            {
                len = r-l+1;
                maxlen = Math.max(maxlen,len);
            }
            r++;
        }
        return maxlen;
    }
}
