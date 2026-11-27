// https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

class Solution {
    public String minimizeResult(String expression) {
        int plus = expression.indexOf('+');
        int n = expression.length();
        int best = Integer.MAX_VALUE;
        int bestI = 0, bestJ = n - 1;

        for (int i = 0; i < plus; i++) {
            for (int j = plus + 1; j < n; j++) {
                int a = i == 0 ? 1 : Integer.parseInt(expression.substring(0, i));
                int b = Integer.parseInt(expression.substring(i, plus));
                int c = Integer.parseInt(expression.substring(plus + 1, j + 1));
                int d = j == n - 1 ? 1 : Integer.parseInt(expression.substring(j + 1));
                int val = a * (b + c) * d;
                if (val < best) {
                    best = val;
                    bestI = i;
                    bestJ = j;
                }
            }
        }

        return expression.substring(0, bestI) + "(" + expression.substring(bestI, plus + 1 + (bestJ - plus)) + ")" + expression.substring(bestJ + 1);
    }
}
