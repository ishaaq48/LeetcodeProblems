class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        boolean lower = false,upper = false,digit = false,special =false;
        String specialCharacters = "!@#$%^&*()-+";
        if(n < 6) return false;
        for(int i = 0; i <n;i++ )
        {
            char ch = password.charAt(i);
            if(Character.isLowerCase(ch)) lower = true;
            if(Character.isUpperCase(ch)) upper = true;
            if(Character.isDigit(ch)) digit =true;
            if(specialCharacters.indexOf(ch) >= 0) special = true;

            if(i > 0 && ch == password.charAt(i-1)) return false;
        }
        return lower&&upper&&digit&&special;
    }
}
