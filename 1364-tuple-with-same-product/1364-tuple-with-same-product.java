class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        int count = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                int prd = nums[i] * nums[j];
                freq.put(prd,freq.getOrDefault(prd,0)+1);
            }
        }

        for(int f : freq.values()){
           if(f > 1)
                count += f * (f - 1) / 2;
           
        }

        return count * 8;

    }
}