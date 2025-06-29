class Solution {
    public List<String> partitionString(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < n){
            boolean found = false;
            String s2 = "";
            for(int j = i; j < n; j++){
                s2 += s.charAt(j);
                if(!seen.contains(s2)) {
                    found = true;
                    result.add(s2);
                    seen.add(s2);
                    i = j + 1;
                    break;
                }
            }
            if(!found) break;
        }

        return result;
    }
}