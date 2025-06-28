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
        int not_pick = f(curr+1, job,n,dp);

        // this technique avoids prev variable tracking
        int j = binarySearch(curr, curr+1,n-1,job);

        int pick = job[curr].p + f(j, job,n,dp);

        return dp[curr] = Math.max(pick, not_pick);
    }
    public int binarySearch(int i,int l, int h,Job[] job){
        int res = job.length;
        while(l <= h) {
            int mid = (l + h) / 2;
            if(job[i].e <= job[mid].s){
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
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