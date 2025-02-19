class Solution {
    public String getHappyString(int n, int k) {
        int total_happy = (int) (3 * Math.pow(2,n-1));

        StringBuilder s = new StringBuilder();
        String choices = "abc";
        int left = 1,right = total_happy;

        for(int i = 0; i < n; i++){
            int curr = left;
            int partition_size = (right - left + 1) / choices.length();

            for(char c : choices.toCharArray()){
                if(curr <= k && k < curr + partition_size){
                    s.append(c);
                    left = curr;
                    right = curr + partition_size - 1;
                    choices = "abc".replace(c + "","");
                    break;
                }
                curr += partition_size;
            }
        }

        return s.toString();
    }
}