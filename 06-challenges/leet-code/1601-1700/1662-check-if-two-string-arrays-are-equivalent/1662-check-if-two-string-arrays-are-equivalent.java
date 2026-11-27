// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

// Solution: Join and Compare — O(n) time, O(n) space
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
