// https://leetcode.com/problems/the-score-of-students-solving-math-expression/

// Solution: Interval DP — O(n^3 * S^2) time, O(n^2 * S) space
class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < s.length(); i += 2) { nums.add(s.charAt(i) - '0'); }
        for (int i = 1; i < s.length(); i += 2) { ops.add(s.charAt(i)); }
        int n = nums.size();
        @SuppressWarnings("unchecked")
        Set<Integer>[][] dp = new Set[n][n];
        for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) { dp[i][j] = new HashSet<>(); } }
        for (int i = 0; i < n; i++) { dp[i][i].add(nums.get(i)); }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    char op = ops.get(k);
                    for (int a : dp[i][k]) {
                        for (int b : dp[k + 1][j]) {
                            int v = op == '+' ? a + b : a * b;
                            if (v <= 1000) { dp[i][j].add(v); }
                        }
                    }
                }
            }
        }
        int correct = 0;
        for (int x : nums) { correct = correct == 0 ? x : correct; }
        // evaluate correct answer
        correct = nums.get(0);
        int acc = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == '*') { acc *= nums.get(i + 1); }
            else { correct += acc; acc = nums.get(i + 1); }
        }
        correct += acc;
        // wait just compute properly
        correct = eval(s);
        int total = 0;
        for (int ans : answers) {
            if (ans == correct) { total += 5; }
            else if (dp[0][n - 1].contains(ans)) { total += 2; }
        }
        return total;
    }
    private int eval(String s) {
        // standard order-of-operations eval
        Deque<Integer> vals = new ArrayDeque<>();
        Deque<Character> oops = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                vals.push(c - '0');
                if (!oops.isEmpty() && oops.peek() == '*') {
                    oops.pop(); int b = vals.pop(), a = vals.pop(); vals.push(a * b);
                }
            } else { oops.push(c); }
        }
        int res = 0;
        while (!vals.isEmpty()) { res += vals.pop(); }
        return res;
    }
}
