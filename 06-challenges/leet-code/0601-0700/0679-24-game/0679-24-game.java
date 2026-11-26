// https://leetcode.com/problems/24-game/

// Solution: Backtracking — O(1) time, O(1) space
class Solution {
    private static final double EPS = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = cards[i];
        }
        return solve(nums, 4);
    }

    private boolean solve(double[] nums, int n) {
        if (n == 1) {
            return Math.abs(nums[0] - TARGET) < EPS;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums[i], b = nums[j];
                double[] rest = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        rest[idx++] = nums[k];
                    }
                }
                double[] ops = {a + b, a - b, b - a, a * b, a != 0 ? b / a : Double.NaN, b != 0 ? a / b : Double.NaN};
                for (double op : ops) {
                    if (Double.isNaN(op)) {
                        continue;
                    }
                    rest[idx] = op;
                    if (solve(rest, n - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
