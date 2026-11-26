// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

// Solution: Prefix/Suffix Distinct Count — O(n) time, O(1) space
class Solution {
    public int numSplits(String s) {
        int[] freq = new int[26];
        int rightDistinct = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a']++ == 0) {
                rightDistinct++;
            }
        }
        int leftDistinct = 0;
        int[] leftFreq = new int[26];
        int result = 0;
        for (char c : s.toCharArray()) {
            if (leftFreq[c - 'a']++ == 0) {
                leftDistinct++;
            }
            if (--freq[c - 'a'] == 0) {
                rightDistinct--;
            }
            if (leftDistinct == rightDistinct) {
                result++;
            }
        }
        return result;
    }
}
