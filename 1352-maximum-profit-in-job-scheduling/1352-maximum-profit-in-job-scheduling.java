class Job {
    int s,e,p;

    Job(int s,int e,int p){
        this.s = s;
        this.e = e;
        this.p = p;
    }
}
class Solution {
    public int f(int curr, Job[] job,int n,int[] dp){
        if(curr == n) return 0;

        if(dp[curr] != -1) return dp[curr];
        int not_pick = f(curr+1,  job,n,dp);

        int j = curr + 1;
        while(j < n) {
            if(job[curr].e <= job[j].s)
                break;
            
            j++;
        }

        int pick = job[curr].p + f(j, job,n,dp);

        return dp[curr] = Math.max(pick, not_pick);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] job= new Job[n];
        int[] dp = new int[n];
 
        Arrays.fill(dp, -1);

        for(int i = 0; i < n; i++) {
            job[i] = new Job(startTime[i], endTime[i], profit[i]);
        }      

        Arrays.sort(job, (a, b) -> a.s - b.s);
        
        return f(0,job,n,dp);
    }
} 