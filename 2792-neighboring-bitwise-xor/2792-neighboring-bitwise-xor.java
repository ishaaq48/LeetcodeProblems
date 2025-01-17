class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        
        for(int num : derived){
            xor ^= num;
        }

        if(xor == 1) return false;

        return true;
    }
}