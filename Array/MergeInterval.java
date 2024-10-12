import java.util.*;
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
            
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1)[1])
            {
                ans.add(intervals[i]);
            }
            else
            {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            
            }
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
