// https://leetcode.com/problems/delete-columns-to-make-sorted/

// Solution: Column Scan — O(n*m) time, O(1) space
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0, m = strs[0].length();
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
