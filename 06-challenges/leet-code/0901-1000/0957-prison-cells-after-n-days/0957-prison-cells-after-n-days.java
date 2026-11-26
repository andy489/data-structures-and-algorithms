// https://leetcode.com/problems/prison-cells-after-n-days/

// Solution: Cycle Detection — O(1) time, O(1) space
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        for (int day = 0; day < n; day++) {
            String key = java.util.Arrays.toString(cells);
            if (seen.containsKey(key)) {
                int cycleLen = day - seen.get(key);
                int remaining = (n - day) % cycleLen;
                for (int i = 0; i < remaining; i++) {
                    cells = nextDay(cells);
                }
                return cells;
            }
            seen.put(key, day);
            cells = nextDay(cells);
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }
}
