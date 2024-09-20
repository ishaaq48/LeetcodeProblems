import java.util.*;

class Main {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max_length = 0;
        while(right < s.length())
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right));
                max_length = Math.max(max_length, right - left + 1 );
                right++;

            }
            else
            {
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return max_length;
    }
    
}
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        String s = sc.nextLine();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);

        sc.close();
    }
}