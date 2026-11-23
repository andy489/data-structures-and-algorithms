// https://leetcode.com/problems/longest-uncommon-subsequence-i/

// Solution: Observation — O(n) time, O(1) space
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
