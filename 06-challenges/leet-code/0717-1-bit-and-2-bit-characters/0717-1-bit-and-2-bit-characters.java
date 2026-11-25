// https://leetcode.com/problems/1-bit-and-2-bit-characters/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == bits.length - 1;
    }
}
