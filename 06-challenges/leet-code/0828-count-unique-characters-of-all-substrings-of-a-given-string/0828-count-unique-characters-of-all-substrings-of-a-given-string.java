// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

// Solution: Contribution Counting — O(n) time, O(26) space
class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length(), total = 0;
        int[][] last = new int[26][2];
        for (int[] row : last) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            total += (i - last[c][1]) * (last[c][1] - last[c][0]);
            last[c][0] = last[c][1];
            last[c][1] = i;
        }
        for (int c = 0; c < 26; c++) {
            total += (n - last[c][1]) * (last[c][1] - last[c][0]);
        }
        return total;
    }
}
