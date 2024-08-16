class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for(String str : strs)
        {
            String frequencyString = getFrequencyString(str);

            if(frequencyStringMap.containsKey(frequencyString))
            {
                frequencyStringMap.get(frequencyString).add(str);
            }
            else
            {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString,strList);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }
    
    public String getFrequencyString(String str)
    {
        int[] freq = new int[26];

        for(char c : str.toCharArray())
        {
            freq[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder("");
        char c ='a';
        for(int i : freq)
        {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }
}

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if(strs == null || strs.length == 0) return new ArrayList<>();
//         Map<String, List<String>> ans = new HashMap<>();
//         for(int i = 0; i < strs.length;i++)
//         {
//             char c[] = strs[i].toCharArray();
//             Arrays.sort(c);
//             String sortedWord = new String(c);
//             if(!ans.containsKey(sortedWord))
//             {
//                 ans.put(sortedWord, new ArrayList<>());
//             }
//             ans.get(sortedWord).add(strs[i]);
//         }
//         return new ArrayList<>(ans.values());
//     }
// }
