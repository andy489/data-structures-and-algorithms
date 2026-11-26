// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

// Solution: Parity — O(n) time, O(n) space
class Solution {
    public String generateTheString(int n) {
        return n % 2 == 1 ? "a".repeat(n) : "a".repeat(n-1) + "b";
    }
}
