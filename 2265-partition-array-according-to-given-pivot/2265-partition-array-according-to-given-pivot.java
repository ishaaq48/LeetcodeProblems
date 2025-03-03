class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < pivot) 
                small.add(nums[i]);
            else if(nums[i] == pivot) 
                cnt++;
            else 
                big.add(nums[i]);
        }

        int index = 0;
        for(int i = 0; i < small.size();i++)
        {
            nums[index++] = small.get(i);
        }
        for(int i = 0; i < cnt; i++)
        {
            nums[index++] = pivot;
            
        }

        for(int i = 0; i < big.size(); i++){
            nums[index++] = big.get(i); 
        }
    
        return nums;
    }
}