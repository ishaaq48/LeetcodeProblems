class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        k = k - 1;
        String ans = "";

        for(int i = 1; i < n;i++){
            fact *= i;
            nums.add(i);
        }
        nums.add(n);

        while(true){
            int temp = k / fact;
            ans = ans + "" + nums.get(temp);
            nums.remove(temp);

            if(nums.size() == 0) break;

            k = k % fact;
            fact = fact / nums.size();
        }

        return ans;
    }
}