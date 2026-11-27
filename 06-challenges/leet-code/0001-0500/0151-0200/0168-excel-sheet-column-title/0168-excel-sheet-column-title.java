// https://leetcode.com/problems/excel-sheet-column-title/

// Solution: Iterative Base-26 Conversion — O(log n) time, O(log n) space
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

// Solution 2: Recursive — O(log n) time, O(log n) space
class Solution2 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        columnNumber--;
        return convertToTitle(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }
}
