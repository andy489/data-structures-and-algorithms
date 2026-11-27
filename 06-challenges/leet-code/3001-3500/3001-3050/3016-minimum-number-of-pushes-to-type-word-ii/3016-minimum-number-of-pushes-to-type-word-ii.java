// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

// Solution: Greedy (Sort by Frequency) — O(n) time, O(1) space
class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) { freq[c - 'a']++; }
        java.util.Arrays.sort(freq);
        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += freq[25 - i] * (i / 8 + 1);
        }
        return total;
    }
}
