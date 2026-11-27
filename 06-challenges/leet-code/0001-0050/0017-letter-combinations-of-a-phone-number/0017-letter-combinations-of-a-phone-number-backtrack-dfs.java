// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// backtrack, dfs
// Time: O(4^n), where n is the number of digits

class Solution {
    private final String[] pad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private int n;
    private List<String> res;
    private StringBuilder sb;

    private void backtrack(int i, String digits) {
        if (i == n) {
            res.add(sb.toString());
            return;
        }
        for (char c : pad[digits.charAt(i) - '2'].toCharArray()) {
            sb.append(c);
            backtrack(i + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        
        res = new ArrayList<>();
        
        if (n == 0) {
            return res;
        }
        
        sb = new StringBuilder();
        backtrack(0, digits);
        
        return res;
    }
}
