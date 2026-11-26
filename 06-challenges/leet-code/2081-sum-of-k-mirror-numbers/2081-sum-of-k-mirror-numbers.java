// https://leetcode.com/problems/sum-of-k-mirror-numbers/

// Solution: Enumerate Base-10 Palindromes — O(n * L) time, O(L) space
class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int found = 0;
        for (int len = 1; found < n; len++) {
            List<Long> palins = generatePalindromes(len);
            for (long p : palins) {
                if (isKPalindrome(p, k)) {
                    sum += p;
                    if (++found == n) { break; }
                }
            }
        }
        return sum;
    }
    private List<Long> generatePalindromes(int len) {
        List<Long> res = new ArrayList<>();
        int half = (len + 1) / 2;
        int start = (int)Math.pow(10, half - 1), end = (int)Math.pow(10, half);
        for (int i = start; i < end; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            if (len % 2 == 0) { sb.append(sb.reverse().toString()); sb.reverse(); }
            else { String rev = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString(); sb.append(rev); }
            res.add(Long.parseLong(sb.toString()));
        }
        return res;
    }
    private boolean isKPalindrome(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) { sb.append(num % k); num /= k; }
        String s = sb.toString();
        return s.equals(sb.reverse().toString());
    }
}
