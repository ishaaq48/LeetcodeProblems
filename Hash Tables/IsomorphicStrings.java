class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        int size = 256;
        if(m !=n) return false;

        int[] indexS = new int[size];
        int[] indexT = new int[size];

        for(int i = 0; i < n; i++)
        {
          if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) return false;

          indexS[s.charAt(i)] = i+1;
          indexT[t.charAt(i)] = i+1;
        }
        return true;
    }
}
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int size = 256;
//         if(m !=n) return false;

//         boolean[] marked = new boolean[size];
//         Arrays.fill(marked, Boolean.FALSE);

//         int[] map = new int[size];
//         Arrays.fill(map, -1);

//         for(int i = 0; i < n; i++)
//         {
//             if(map[s.charAt(i)] == -1)
//             {
//                 if(marked[t.charAt(i)] == true) return false;

//                 marked[t.charAt(i)] = true;
//                 map[s.charAt(i)] = t.charAt(i);
//             }
//             else if (map[s.charAt(i)] != t.charAt(i))
//                 return false;
//         }
//         return true;
//     }
// }
