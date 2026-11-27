// https://leetcode.com/problems/count-the-number-of-powerful-integers/
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return count(finish, limit, s) - count(start - 1, limit, s);
    }

    // Count powerful integers in [1..n]
    private long count(long n, int limit, String s) {
        if (n <= 0) {
            return 0;
        }
        String t = Long.toString(n);
        int tLen = t.length();
        int sLen = s.length();
        if (sLen > tLen) {
            return 0;
        }
        int prefLen = tLen - sLen;
        long result = 0;

        // Count powerful integers with exactly `len` total digits, for len < tLen
        for (int len = sLen; len < tLen; len++) {
            int pLen = len - sLen;
            if (pLen == 0) {
                // Number == s itself
                if (isValid(s, limit)) {
                    result++;
                }
            } else {
                // First prefix digit: 1..limit, rest: 0..limit
                result += (long) limit * pow(limit + 1, pLen - 1);
            }
        }

        // Count powerful integers with exactly tLen digits that are <= n
        // These have prefix of length prefLen, followed by s
        // We iterate digit by digit through the prefix
        boolean tight = true;
        for (int i = 0; i < prefLen; i++) {
            int tDigit = t.charAt(i) - '0';
            int lo = (i == 0) ? 1 : 0; // no leading zeros
            int hi = tight ? Math.min(tDigit - 1, limit) : limit;
            if (hi >= lo) {
                // For digits lo..hi at position i, the remaining (prefLen-i-1) prefix digits are free
                result += (long)(hi - lo + 1) * pow(limit + 1, prefLen - i - 1);
            }
            if (!tight || tDigit > limit) {
                tight = false;
                break;
            }
            // Stay tight
        }
        // If still tight after all prefix digits, check if suffix fits
        if (tight) {
            String candidate = t.substring(0, prefLen) + s;
            if (Long.parseLong(candidate) <= n) {
                result++;
            }
        }
        return result;
    }

    private boolean isValid(String s, int limit) {
        for (char c : s.toCharArray()) {
            if (c - '0' > limit) {
                return false;
            }
        }
        return true;
    }

    private long pow(long base, int exp) {
        long r = 1;
        for (int i = 0; i < exp; i++) {
            r *= base;
        }
        return r;
    }
}
