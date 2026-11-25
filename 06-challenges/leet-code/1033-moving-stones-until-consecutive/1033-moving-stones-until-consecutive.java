// https://leetcode.com/problems/moving-stones-until-consecutive/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;
        int max = (y - x - 1) + (z - y - 1);
        int min;
        if (z - x == 2) {
            min = 0;
        } else if (y - x <= 2 || z - y <= 2) {
            min = 1;
        } else {
            min = 2;
        }
        return new int[]{min, max};
    }
}
