class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombinationSum(0,candidates,target,list,new ArrayList<>());
        return list;
    }
    public void findCombinationSum(int ind,int[] arr,int target,List<List<Integer>> list,List<Integer> ds)
    {
        if(ind == arr.length)
        {
            if(target == 0) {
            list.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= target)
        {
            ds.add(arr[ind]);
            findCombinationSum(ind,arr,target - arr[ind],list,ds);
            ds.remove(ds.size()-1);
        }
        findCombinationSum(ind+1,arr,target,list,ds);
    }
}
