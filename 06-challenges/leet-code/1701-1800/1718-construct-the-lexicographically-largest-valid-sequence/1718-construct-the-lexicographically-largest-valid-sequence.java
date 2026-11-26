// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

// Solution: Backtracking — O(n!) time, O(n) space
class Solution {
    private int[] result;
    private boolean[] used;
    private int n;

    private boolean backtrack(int pos) {
        if (pos == result.length) {
            return true;
        }
        if (result[pos] != 0) {
            return backtrack(pos + 1);
        }
        for (int v = n; v >= 1; v--) {
            if (used[v]) {
                continue;
            }
            if (v == 1) {
                result[pos] = 1;
                used[1] = true;
                if (backtrack(pos + 1)) {
                    return true;
                }
                result[pos] = 0;
                used[1] = false;
            } else {
                int second = pos + v;
                if (second < result.length && result[second] == 0) {
                    result[pos] = v;
                    result[second] = v;
                    used[v] = true;
                    if (backtrack(pos + 1)) {
                        return true;
                    }
                    result[pos] = 0;
                    result[second] = 0;
                    used[v] = false;
                }
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        result = new int[2 * n - 1];
        used = new boolean[n + 1];
        backtrack(0);
        return result;
    }
}
