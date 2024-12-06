class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        int maxLen = 0;

        for(int num : numSet){
            if(!numSet.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                //to find longest sequence
                while(numSet.contains(currNum + 1))
                {
                    currNum += 1;
                    currLen += 1;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }

        return maxLen; 
    }
}