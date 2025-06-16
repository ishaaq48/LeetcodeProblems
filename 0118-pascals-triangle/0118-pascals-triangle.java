class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
        List<Integer> ds = new ArrayList<>();    
        long c = 1;

            for(int j = 1; j <= i; j++) {

                ds.add((int) c);
                c = c * (i - j) / j;
            }
            ans.add(ds);
        }

        return ans;
    }
}