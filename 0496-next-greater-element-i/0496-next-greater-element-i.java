class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++)
            map.put(nums2[i],i);
        
        for(int j = 0; j < nums1.length; j++)
        {
            int indVal = map.get(nums1[j]);
            int nextGreatest = -1;
            for(int k = indVal + 1; k < nums2.length;k++){
                if(nums2[k] > nums1[j]){
                    nextGreatest = nums2[k];
                    break;
                }
            }
            ans[j] = nextGreatest;
        }

        return ans;
    }
}