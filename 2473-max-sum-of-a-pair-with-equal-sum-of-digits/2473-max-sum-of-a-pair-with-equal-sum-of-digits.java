class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int digitKey = digitSum(nums[i]);

            map.putIfAbsent(digitKey,new PriorityQueue<>((a,b) -> b - a));
            map.get(digitKey).add(nums[i]);
        }

        int maxSum = -1;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()){
            int key = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();

            if(value.size() < 2) continue;

            int first = value.poll();
            int second = value.peek();

            maxSum = Math.max(maxSum, first + second);
        }

        return maxSum;
    }

    public int digitSum(int num){
        int ans = 0;
        while(num > 0){
            int rem = num % 10;
            ans += rem;
            num /= 10;
        }

        return ans;
    }
}