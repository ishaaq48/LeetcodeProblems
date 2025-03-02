class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> id_to_value = new HashMap<>();

        for(int[] num: nums1){
            id_to_value.put(num[0], num[1]);
        }

        for(int[] num: nums2){
            id_to_value.put(num[0], id_to_value.getOrDefault(num[0],0) + num[1]);
        }

        int[][] ans = new int[id_to_value.size()][2];
        int i = 0;
        for(int id = 1; id <= 1000; id++){
            
            if(id_to_value.containsKey(id)){
                ans[i][0] = id;
                ans[i][1] = id_to_value.get(id);
                i++;
            }
        }

        return ans;
    }
}