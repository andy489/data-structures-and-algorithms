// https://leetcode.com/problems/count-sorted-vowel-strings/

// Solution: Combinatorics — O(1) time, O(1) space
class Solution {
    public int countVowelStrings(int n) {
        // C(n+4, 4) = (n+1)(n+2)(n+3)(n+4) / 24
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
