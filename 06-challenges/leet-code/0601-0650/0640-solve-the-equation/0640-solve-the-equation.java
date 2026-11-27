// https://leetcode.com/problems/solve-the-equation/

// Solution: Parse Both Sides — O(n) time, O(1) space
class Solution {
    public String solveEquation(String equation) {
        int idx = equation.indexOf('=');
        int[] left = parse(equation.substring(0, idx));
        int[] right = parse(equation.substring(idx + 1));
        int xCoef = left[0] - right[0];
        int constVal = right[1] - left[1];
        if (xCoef == 0) {
            return constVal == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (constVal / xCoef);
    }

    private int[] parse(String expr) {
        int xCoef = 0, constant = 0, sign = 1, num = 0;
        boolean hasNum = false;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-') {
                constant += sign * (hasNum ? num : 0);
                sign = (c == '+') ? 1 : -1;
                num = 0;
                hasNum = false;
            } else if (c == 'x') {
                xCoef += sign * (hasNum ? num : 1);
                num = 0;
                hasNum = false;
            } else {
                num = num * 10 + (c - '0');
                hasNum = true;
            }
        }
        constant += sign * (hasNum ? num : 0);
        return new int[]{xCoef, constant};
    }
}
