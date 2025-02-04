class Solution {
    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        for(int i = 0;i < lenA; i++){
            int j = 0;
            while(j < lenB && a.charAt((i + j) % lenA) == b.charAt(j)){
                j++;
            } 
            if(j == lenB) return (i + j + lenA - 1) / lenA;
        }

        return -1;
    }
}