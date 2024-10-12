import java.util.*;
import java.lang.*;
public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            } else {
                return Integer.compare(a[1], b[1]); 
            }
        });
        List<int[] > ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size()-1)[1]) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                if(intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
                }
                else{
                    break;
                }
            }
            ans.add(new int[] { start, end });
        }

        return ans.toArray(new int[ans.size()][2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int intervals[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
        }
        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
