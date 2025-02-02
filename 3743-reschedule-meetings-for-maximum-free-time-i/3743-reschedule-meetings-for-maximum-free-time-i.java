class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gap = new ArrayList<>();
        gap.add(startTime[0]);

        for(int i = 1; i < startTime.length;i++){
            gap.add(startTime[i] - endTime[i-1]);
        }
        gap.add(eventTime - endTime[endTime.length-1]);
        
        int maxGap = 0;
        int currSum = 0;
        for(int i = 0; i < gap.size();i++){
            currSum += gap.get(i) - ((i >= k+1) ? gap.get(i - (k+1)) : 0);
            maxGap = Math.max(maxGap,currSum);
        }

        return maxGap;
    }
}