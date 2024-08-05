class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long res=1;
        ans.add((int)res);
        for(int i =0;i < rowIndex;i++)
        {
            res = res * (rowIndex-i);
            res = res / (i+1);
            ans.add((int)res);
        }
        return ans;
        
    }
    
}
