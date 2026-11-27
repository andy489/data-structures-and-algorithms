// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

// Solution: Max Digit — O(n) time, O(1) space
class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
            if (maxDigit == 9) {
                break;
            }
        }
        return maxDigit;
    }
}
