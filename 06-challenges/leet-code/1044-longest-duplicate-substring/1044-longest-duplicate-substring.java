// https://leetcode.com/problems/longest-duplicate-substring/

// Solution: Binary Search + Rabin-Karp Rolling Hash — O(n log n) time, O(n) space
class Solution {
    public String longestDupSubstring(String s) {
        int lo = 1, hi = s.length() - 1;
        String res = "";
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            String dup = check(s, mid);
            if (dup != null) {
                res = dup;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private String check(String s, int len) {
        long mod = (1L << 61) - 1, base = 31;
        long pw = 1;
        for (int i = 0; i < len; i++) {
            pw = mul(pw, base, mod);
        }
        long h = 0;
        for (int i = 0; i < len; i++) {
            h = (mul(h, base, mod) + s.charAt(i) - 'a' + 1) % mod;
        }
        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.computeIfAbsent(h, x -> new ArrayList<>()).add(0);
        for (int i = len; i < s.length(); i++) {
            h = (mul(h, base, mod) + s.charAt(i) - 'a' + 1) % mod;
            h = (h - mul(pw, s.charAt(i - len) - 'a' + 1, mod) + mod) % mod;
            List<Integer> positions = seen.get(h);
            if (positions != null) {
                String sub = s.substring(i - len + 1, i + 1);
                for (int pos : positions) {
                    if (s.substring(pos, pos + len).equals(sub)) {
                        return sub;
                    }
                }
            }
            seen.computeIfAbsent(h, x -> new ArrayList<>()).add(i - len + 1);
        }
        return null;
    }

    private long mul(long a, long b, long mod) {
        long hi = Math.multiplyHigh(a, b);
        long lo = a * b;
        long res = (hi << 3) | (lo >>> 61);
        res += lo & mod;
        if (res >= mod) { res -= mod; }
        return res;
    }
}
