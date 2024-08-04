class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int l=0,r=0,sum=0;
        List<Integer> arr = new ArrayList<>();
        for(int i =0;i <n;i++)
        {
            sum = 0;
            for(int j = i;j <n;j++)
            {
                sum += nums[j];
                arr.add(sum);
            }
        }
        Collections.sort(arr);
        long res =0;
        long mod = 1000000007;
        for(int i = left-1 ; i < right ;i++)
        {
            res = (res + arr.get(i)) % mod;
        }
        return (int) res;
    }
}
