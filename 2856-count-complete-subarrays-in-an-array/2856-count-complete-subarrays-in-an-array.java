class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums){
            set.add(num);
        }
        int distinct = set.size();

        int complete = 0;

        for(int i = 0; i < n; i++) 
        {
            Set<Integer> set2 = new HashSet<>();
            for(int j = i; j < n; j++){
                set2.add(nums[j]);
                if(set2.size() == distinct)
                    complete++;
            }
        }


        return complete;

        // Set<Integer> set2 = new HashSet<>();
        // int complete = 0;
        // int left = 0;
        // int right = 0;
        // while(right < nums.length){
        //     if(!set.contains(nums[right])) {
        //         set.add(nums[right]);
        //         if(set.size() == distinct) 
        //             complete += Math.max(complete, right - left);
        //         right++;
        //     } else {
        //         set.remove(nums[left]);
        //         left++;
        //     }
        // }

        // return complete;
    }
}