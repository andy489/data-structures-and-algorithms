// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
class Solution {
    public int minSwaps(String s) {
        int unmatched = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                unmatched--;
            } else {
                unmatched++;
            }
            if (unmatched < 0) {
                unmatched = 0;
            }
        }
        return (unmatched + 1) / 2;
    }
}
