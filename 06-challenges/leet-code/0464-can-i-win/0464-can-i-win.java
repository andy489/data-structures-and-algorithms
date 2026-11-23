// https://leetcode.com/problems/can-i-win/

// Solution: Bitmask DP (Memoization) — O(2^n · n) time, O(2^n) space
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean canWin(int maxN, int remaining, int usedMask, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedMask)) {
            return memo.get(usedMask);
        }
        for (int i = 1; i <= maxN; i++) {
            if ((usedMask & (1 << i)) != 0) {
                continue;
            }
            if (i >= remaining || !canWin(maxN, remaining - i, usedMask | (1 << i), memo)) {
                memo.put(usedMask, true);
                return true;
            }
        }
        memo.put(usedMask, false);
        return false;
    }
}
