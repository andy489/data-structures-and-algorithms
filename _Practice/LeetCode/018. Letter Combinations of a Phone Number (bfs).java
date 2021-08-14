// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Time: O(4^n), where n is the number of digits

class Solution {
    private final String[] pad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Queue<String> q = new LinkedList<>();
        q.add("");
        int n = digits.length();
        int SIZE = 1, i = 0;
        while (q.peek().length() < n) {
            while (SIZE > 0) {
                String cur = q.remove();
                SIZE--;
                for (char c : pad[digits.charAt(i) - '2'].toCharArray()) {
                    q.add(cur + c);
                }
            }
            SIZE = q.size();
            i++;
        }
        res.addAll(q);
        return res;
    }
}
