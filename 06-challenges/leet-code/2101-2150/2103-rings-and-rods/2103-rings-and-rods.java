// https://leetcode.com/problems/rings-and-rods/

// Solution: Bitmask per Rod — O(n) time, O(1) space
class Solution {
    public int countPoints(String rings) {
        int[] mask = new int[10];

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                mask[rod] |= 1;
            } else if (color == 'G') {
                mask[rod] |= 2;
            } else {
                mask[rod] |= 4;
            }
        }

        int count = 0;
        for (int m : mask) {
            if (m == 7) {
                count++;
            }
        }

        return count;
    }
}
