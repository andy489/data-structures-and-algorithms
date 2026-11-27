// https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

// Solution: Math (Combinatorics) — O(n) time, O(1) space
class Solution {
    public long countSubstrings(String s, char c) {
        long k = 0;
        for (char ch : s.toCharArray()) { if (ch == c) { k++; } }
        return k * (k + 1) / 2;
    }
}
