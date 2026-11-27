// https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

// Solution: Greedy Two-Pointer — O(n^2) time, O(n) space
class Solution {
    public int longestDecomposition(String text) {
        int ans = 0;
        int l = 0, r = text.length() - 1;
        while (l <= r) {
            boolean found = false;
            for (int len = 1; len <= (r - l + 1) / 2; len++) {
                if (text.substring(l, l + len).equals(text.substring(r - len + 1, r + 1))) {
                    ans += 2;
                    l += len;
                    r -= len;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans += 1;
                break;
            }
        }
        return ans;
    }
}

// Solution 2: Greedy with Rolling Hash — O(n) expected time, O(n) space
class Solution2 {
    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 31L;

    public int longestDecomposition(String text) {
        int n = text.length();
        int ans = 0;
        long prefHash = 0, sufHash = 0, pow = 1;
        int l = 0, r = n - 1;
        for (int len = 1; l + len - 1 < r - len + 1; len++) {
            prefHash = (prefHash * BASE + (text.charAt(l + len - 1) - 'a' + 1)) % MOD;
            sufHash = ((text.charAt(r - len + 1) - 'a' + 1) * pow + sufHash) % MOD;
            pow = pow * BASE % MOD;
            if (prefHash == sufHash
                    && text.substring(l, l + len).equals(text.substring(r - len + 1, r + 1))) {
                ans += 2;
                l += len;
                r -= len;
                len = 0;
                prefHash = sufHash = 0;
                pow = 1;
            }
        }
        if (l <= r) {
            ans += 1;
        }
        return ans;
    }
}
