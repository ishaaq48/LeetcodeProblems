import java.util.*;

public class ReversePrefixOfWord {
    public static String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        boolean flag = true;
        for(int i = 0; i < word.length(); i++)
        {
            st.push(word.charAt(i));
            if(word.charAt(i) == ch)
            {
               flag = false; 
               break; 
            }
        }
        if(flag == false){
            StringBuilder modifiedWord = new StringBuilder(word);
            for(int i = 0; i < word.length(); i++)
            {
                if (!st.isEmpty()) {
                    modifiedWord.setCharAt(i, st.pop());
                }
            }
            word = modifiedWord.toString();
            return word;
        }
        else{
            return word;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.nextLine().charAt(0);
        String word = sc.nextLine();

        String result = reversePrefix(word,ch);

        System.out.println(result);
    }
}
