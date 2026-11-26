// https://leetcode.com/problems/cinema-seat-allocation/

// Solution: Bitmask per row — O(reserved) time, O(reserved) space
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();
        for (int[] s : reservedSeats) {
            if (s[1] >= 2 && s[1] <= 9) rows.merge(s[0], 1 << s[1], (a, b) -> a | b);
        }
        int count = 2 * (n - rows.size());
        for (int mask : rows.values()) {
            boolean left = (mask & 0b0000111100) == 0;   // seats 2-5
            boolean mid  = (mask & 0b0001111000) == 0;   // seats 4-7 (1-indexed 2-9 → bits 2-9)
            boolean right= (mask & 0b0111100000) == 0;   // seats 6-9
            if (left && right) count += 2;
            else if (left || mid || right) count += 1;
        }
        return count;
    }
}
