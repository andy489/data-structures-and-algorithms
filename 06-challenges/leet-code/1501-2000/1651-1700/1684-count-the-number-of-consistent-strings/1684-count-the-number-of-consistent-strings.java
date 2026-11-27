// https://leetcode.com/problems/count-the-number-of-consistent-strings/

// Solution: Bitmask — O(n) time, O(1) space
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (char c : allowed.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        int count = 0;
        for (String word : words) {
            boolean consistent = true;
            for (char c : word.toCharArray()) {
                if ((mask & (1 << (c - 'a'))) == 0) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                count++;
            }
        }
        return count;
    }
}
