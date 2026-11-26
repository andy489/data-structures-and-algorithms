// https://leetcode.com/problems/matchsticks-to-square/

// Solution: Backtracking — O(4^N) time, O(N) space
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }
        if (total % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        int target = total / 4;
        return backtrack(matchsticks, sides, matchsticks.length - 1, target);
    }

    private boolean backtrack(int[] sticks, int[] sides, int idx, int target) {
        if (idx < 0) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        int stick = sticks[idx];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (backtrack(sticks, sides, idx - 1, target)) {
                    return true;
                }
                sides[i] -= stick;
            }
            if (sides[i] == 0) {
                break;
            }
        }
        return false;
    }
}
