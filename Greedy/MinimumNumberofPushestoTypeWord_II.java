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
// Approach 2
// class Solution {
//     public int minimumPushes(String word) {
//         int[] arr = new int[26];
//         int sum =0;
//         for(int i =0; i < word.length();i++)
//         {
//             arr[word.charAt(i)- 'a']++; 
//         }
//         Integer[] sortedFreq = new Integer[26];
//         for (int i = 0; i < 26; i++) {
//             sortedFreq[i] = arr[i];
//         }
//         Arrays.sort(sortedFreq, Collections.reverseOrder());

//         for(int j = 0; j < 26;j++)
//         {
//             if(sortedFreq[j] == 0) break;
//             sum += (j / 8 + 1) * sortedFreq[j];

//         }
//         return sum;
//     }
// }
