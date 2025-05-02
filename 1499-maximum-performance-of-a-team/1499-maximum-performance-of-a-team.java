class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];

        for(int i = 0; i < n; i++) {
            eng[i] = new int[] {efficiency[i], speed[i]};
        }   
        
        Arrays.sort(eng, (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0,sum = 0;

        for(int[] e : eng) {
            pq.add(e[1]);
            sum += e[1];

            if(pq.size() > k) sum -= pq.poll();
            
            res = Math.max(res, sum * e[0]);
        }

        return (int) (res % ( long ) (1e9 + 7));
    }
}