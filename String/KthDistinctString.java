class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        // Count frequency of each string
        for (String s : arr) {
            //map gets the key value if already exist if not return 0 as default value.
            //First time default value 0 + 1 --> ("a",1);
            // second time map.get("a",1)+1 --> ("a",2);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Find the k-th distinct string
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 1) { // Check if the string is distinct
                count++;
                if (count == k) {
                    return key;
                }
            }
        }
        return "";
    }
}
