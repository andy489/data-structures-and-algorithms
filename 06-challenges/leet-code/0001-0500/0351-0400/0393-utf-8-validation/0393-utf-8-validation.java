// https://leetcode.com/problems/utf-8-validation/

// Solution: Bit Masking — O(n) time, O(1) space
class Solution {
    public boolean validUtf8(int[] data) {
        int continuations = 0;
        for (int b : data) {
            b &= 0xFF;
            if (continuations > 0) {
                if ((b & 0xC0) != 0x80) {
                    return false;
                }
                continuations--;
            } else if ((b & 0x80) == 0) {
                continuations = 0;
            } else if ((b & 0xE0) == 0xC0) {
                continuations = 1;
            } else if ((b & 0xF0) == 0xE0) {
                continuations = 2;
            } else if ((b & 0xF8) == 0xF0) {
                continuations = 3;
            } else {
                return false;
            }
        }
        return continuations == 0;
    }
}
