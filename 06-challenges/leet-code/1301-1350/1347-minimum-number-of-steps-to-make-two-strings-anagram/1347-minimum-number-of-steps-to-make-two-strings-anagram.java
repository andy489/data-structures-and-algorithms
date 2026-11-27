// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

// Solution: Frequency count — O(n) time, O(1) space
class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c-'a']++;
        for (char c : t.toCharArray()) cnt[c-'a']--;
        int steps = 0;
        for (int v : cnt) if (v > 0) steps += v;
        return steps;
    }
}
