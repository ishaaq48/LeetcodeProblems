class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ind = 1;
        int res =0;
        for(int i = n - 1; i >= 0; i-- )
        {
            if(citations[i] >= ind){
                ind++;
                res++;
            }
            else
            {
                break;
            }
        }
        return res;
    }
}
