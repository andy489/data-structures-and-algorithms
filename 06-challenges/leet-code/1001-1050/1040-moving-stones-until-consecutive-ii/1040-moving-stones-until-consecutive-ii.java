// https://leetcode.com/problems/moving-stones-until-consecutive-ii/

// Solution: Sorting + Sliding Window — O(n log n) time, O(1) space
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int maxMoves = Math.max(stones[n-1] - stones[1] - n + 2, stones[n-2] - stones[0] - n + 2);
        int minMoves = n;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] < n) {
                j++;
            }
            int inWindow = j - i + 1;
            if (inWindow == n - 1 && stones[j] - stones[i] == n - 2) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - inWindow);
            }
        }
        return new int[]{minMoves, maxMoves};
    }
}
