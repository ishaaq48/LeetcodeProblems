class Solution {
    public int countSeniors(String[] details) {
        int val =0,cnt=0;
        for(int i =0; i < details.length;i++)
        {
            val = Integer.parseInt(details[i].substring(11,13));
            if(val > 60) 
            {
                cnt++;
            }
        }
        return cnt;
    }
}
