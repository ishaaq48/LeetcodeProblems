class ProductOfNumbers {
    List<Integer> nums;
    public ProductOfNumbers() {
        nums = new ArrayList<>();
        nums.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            nums = new ArrayList<>();
            nums.add(1);
        } else {
            nums.add(nums.get(nums.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = nums.size();
        if(k >= size) return 0;
        return nums.get(size-1)/nums.get(size-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */