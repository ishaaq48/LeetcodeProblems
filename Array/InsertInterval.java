import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i < intervals.length)
        {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] intervals = new int[n][2];
        int[] newInterval = new int[2];
        
        for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
        }
        for(int i = 0; i < 2;i++)
        {
            newInterval[i] = sc.nextInt();
        }

        int[][] result = insert(intervals,newInterval);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
