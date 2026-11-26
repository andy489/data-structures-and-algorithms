// https://leetcode.com/problems/expression-add-operators/

// Solution: Backtracking with Multiplication Tracking — O(4^n · n) time, O(n) space
class Solution {
    private List<String> res;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        this.num = num;
        this.target = target;
        backtrack(0, new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(int pos, StringBuilder expr, long eval, long mult) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(expr.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = expr.length();
            if (pos == 0) {
                expr.append(cur);
                backtrack(i + 1, expr, cur, cur);
                expr.setLength(len);
            } else {
                expr.append('+').append(cur);
                backtrack(i + 1, expr, eval + cur, cur);
                expr.setLength(len);

                expr.append('-').append(cur);
                backtrack(i + 1, expr, eval - cur, -cur);
                expr.setLength(len);

                expr.append('*').append(cur);
                backtrack(i + 1, expr, eval - mult + mult * cur, mult * cur);
                expr.setLength(len);
            }
        }
    }
}
