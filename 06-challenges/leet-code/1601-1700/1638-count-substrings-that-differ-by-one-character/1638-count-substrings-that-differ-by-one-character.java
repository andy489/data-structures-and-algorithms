// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

// Solution: Fix the Mismatch Position — O(m * n) time, O(1) space
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length(), ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    int left = 0;
                    while (i - left - 1 >= 0 && j - left - 1 >= 0
                            && s.charAt(i - left - 1) == t.charAt(j - left - 1)) {
                        left++;
                    }
                    int right = 0;
                    while (i + right + 1 < m && j + right + 1 < n
                            && s.charAt(i + right + 1) == t.charAt(j + right + 1)) {
                        right++;
                    }
                    ans += (left + 1) * (right + 1);
                }
            }
        }
        return ans;
    }
}
