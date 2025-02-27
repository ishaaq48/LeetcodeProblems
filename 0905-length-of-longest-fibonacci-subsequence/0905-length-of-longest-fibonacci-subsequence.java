class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max_len = 0;

        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }

        for(int i = 0; i < arr.length-1; i++){
            for(int j = i + 1; j < arr.length; j++){
                int prev = arr[i], curr = arr[j]; 
                int next = prev + curr;
                int len = 2;

                while(set.contains(next)){
                    len++;
                    prev = curr;
                    curr = next;
                    next = prev + curr;
                    max_len = Math.max(max_len, len);
                }
            }
        }

        return max_len;
    }
}