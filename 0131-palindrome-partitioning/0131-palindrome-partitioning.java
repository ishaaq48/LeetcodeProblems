class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        int n = s.length();
        helper(0,s,n,res,ds);
        return res;    
    }

    public void helper(int ind, String s,int n,List<List<String>> res,List<String> ds){
        if(ind == n){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < n; i++){
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                helper(i + 1,s,n,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}