// https://leetcode.com/problems/scramble-string/

// Solution: Memoized Recursion — O(n^4) time, O(n^3) space
class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    private boolean helper(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int n = s1.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) {
                memo.put(key, false);
                return false;
            }
        }
        for (int k = 1; k < n; k++) {
            if (helper(s1.substring(0, k), s2.substring(0, k)) &&
                helper(s1.substring(k), s2.substring(k))) {
                memo.put(key, true);
                return true;
            }
            if (helper(s1.substring(0, k), s2.substring(n - k)) &&
                helper(s1.substring(k), s2.substring(0, n - k))) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        return helper(s1, s2);
    }
}
