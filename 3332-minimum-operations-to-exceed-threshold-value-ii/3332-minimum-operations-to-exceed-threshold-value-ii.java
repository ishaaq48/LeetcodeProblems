class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int operation = 0;
        for(int i = 0; i < nums.length;i++){
            pq.add((long)nums[i]);
        }

        while(pq.size() >= 2 && pq.peek() < k){
            long x = pq.poll();
            long y = pq.poll();

            long ans = (Math.min(x,y) * 2L) + Math.max(x,y); 
            
            pq.add(ans);
            operation++;
        }

        return pq.peek() >= k ? operation : -1;
    }
}