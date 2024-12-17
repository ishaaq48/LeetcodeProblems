class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        findSum(0,n,arr,list,ds,k);
        return list;
    }
    public void findSum(int ind,int n,int[] arr,List<List<Integer>> list,List<Integer> ds,int k){
        if(ind == arr.length){
            if(n == 0 && ds.size() == k){
                list.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= n){
            ds.add(arr[ind]);
            findSum(ind+1,n-arr[ind],arr,list,ds,k);
            ds.remove(ds.size()-1);
        }
        findSum(ind+1,n,arr,list,ds,k);
    }
}