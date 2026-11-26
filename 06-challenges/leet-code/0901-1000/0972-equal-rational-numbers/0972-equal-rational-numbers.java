// https://leetcode.com/problems/equal-rational-numbers/

// Solution: Convert to Fraction — O(1) time, O(1) space
class Solution {
    public boolean isRationalEqual(String s, String t) {
        return toFraction(s).equals(toFraction(t));
    }

    private long[] toFraction(String s) {
        // Returns [numerator, denominator] in reduced form
        long num = 0, den = 1;
        int dot = s.indexOf('.');
        int lp = s.indexOf('(');
        if (dot == -1) {
            num = Long.parseLong(s);
        } else {
            long intPart = Long.parseLong(s.substring(0, dot));
            String nonRep = lp == -1 ? s.substring(dot + 1) : s.substring(dot + 1, lp);
            long nonRepLen = nonRep.length();
            long nonRepNum = nonRep.isEmpty() ? 0 : Long.parseLong(nonRep);
            if (lp == -1) {
                long scale = pow10(nonRepLen);
                num = intPart * scale + nonRepNum;
                den = scale;
            } else {
                String rep = s.substring(lp + 1, s.length() - 1);
                long repLen = rep.length();
                long repNum = Long.parseLong(rep);
                long repDen = pow10(repLen) - 1;
                long scale = pow10(nonRepLen);
                // fraction = intPart + nonRep/scale + rep/(scale*(10^repLen - 1))
                den = scale * repDen;
                num = intPart * den + nonRepNum * repDen + repNum;
            }
        }
        long g = gcd(Math.abs(num), den);
        return new long[]{num / g, den / g};
    }

    private long pow10(long exp) {
        long r = 1;
        for (long i = 0; i < exp; i++) { r *= 10; }
        return r;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
