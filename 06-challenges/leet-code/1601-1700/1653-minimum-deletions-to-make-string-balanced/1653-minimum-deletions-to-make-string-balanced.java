// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

// Solution: Greedy One Pass — O(n) time, O(1) space
class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0, deletions = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }
}
