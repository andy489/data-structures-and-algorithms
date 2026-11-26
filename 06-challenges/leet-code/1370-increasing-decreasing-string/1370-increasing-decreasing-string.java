// https://leetcode.com/problems/increasing-decreasing-string/

// Solution: Frequency sweep — O(n * 26) time, O(26) space
class Solution {
    public String sortString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c-'a']++;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) if (cnt[i] > 0) { sb.append((char)('a'+i)); cnt[i]--; }
            for (int i = 25; i >= 0; i--) if (cnt[i] > 0) { sb.append((char)('a'+i)); cnt[i]--; }
        }
        return sb.toString();
    }
}
