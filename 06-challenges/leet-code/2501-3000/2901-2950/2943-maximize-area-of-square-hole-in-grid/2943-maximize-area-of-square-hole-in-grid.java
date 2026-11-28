// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/

// Solution: Max Consecutive Run — O(h log h + v log v) time, O(1) extra space
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int side = Math.min(maxConsecutive(hBars), maxConsecutive(vBars)) + 1;
        return side * side;
    }

    private int maxConsecutive(int[] bars) {
        Arrays.sort(bars);
        int maxRun = 1, run = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                run++;
                maxRun = Math.max(maxRun, run);
            } else {
                run = 1;
            }
        }
        return maxRun;
    }
}
