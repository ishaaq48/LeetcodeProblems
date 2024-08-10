class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
       
        answer[0] = 1;
        //prefix multiplication
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        //prefix * suffix
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        
        return answer;
    }
}
