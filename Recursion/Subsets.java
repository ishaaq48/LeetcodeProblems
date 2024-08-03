class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> arr = new ArrayList<>();
      int n = nums.length;

      subsequence(0,arr,nums,n,new ArrayList<>());
      return arr;
    }
    public void subsequence(int ind,List<List<Integer>> arr,int[] nums,int n,List<Integer> ds)
    {
        if(ind == n)
        {
            arr.add(new ArrayList<>(ds));
            return;
        }
        subsequence(ind+1,arr,nums,n,ds);
        ds.add(nums[ind]);
        subsequence(ind+1,arr,nums,n,ds);
        ds.removeLast();      
    }
}
