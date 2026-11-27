// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

// Solution: Bit Mask — O(n) time, O(1) space
class Solution {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (char c : sentence.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask == (1 << 26) - 1;
    }
}
