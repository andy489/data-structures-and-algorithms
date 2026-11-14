// https://leetcode.com/problems/excel-sheet-column-number/

// Solution: Base-26 Conversion — O(n) time, O(1) space
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }
}
