class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        int sum =0;
        for(int i =0; i < word.length();i++)
        {
            arr[word.charAt(i)- 'a']++; 
        }
        Arrays.sort(arr);
        int press = 1;
        int keyInd = 0;
        for(int j =25; j >= 0;j--)
        {
                sum += (arr[j] * press);
                keyInd++;
                if(keyInd == 8)
                {
                    press++;
                    keyInd = 0;
                }
        }
        return sum;
    }
}
