// https://leetcode.com/problems/abbreviating-the-product-of-a-range/
class Solution {
    public String abbreviateProduct(int left, int right) {
        // Count trailing zeros: factors of 2 and 5
        long c2 = 0, c5 = 0;
        for (int i = left; i <= right; i++) {
            int x = i;
            while (x % 2 == 0) { c2++; x /= 2; }
            while (x % 5 == 0) { c5++; x /= 5; }
        }
        long C = Math.min(c2, c5);

        // Try exact computation first
        java.math.BigInteger product = java.math.BigInteger.ONE;
        boolean overflow = false;
        for (int i = left; i <= right; i++) {
            product = product.multiply(java.math.BigInteger.valueOf(i));
            if (product.bitLength() > 100) {
                overflow = true;
                break;
            }
        }

        if (!overflow) {
            // Remove trailing zeros
            java.math.BigInteger ten = java.math.BigInteger.TEN;
            while (product.mod(ten).equals(java.math.BigInteger.ZERO)) {
                product = product.divide(ten);
            }
            String s = product.toString();
            if (s.length() <= 10) {
                return s + "e" + C;
            }
        }

        // Large product: track suffix (last 5 digits without trailing zero factors)
        // and prefix via log
        long suf = 1;
        long MOD = 100000L;
        long extra2 = c2 - C;
        long extra5 = c5 - C;

        for (int i = left; i <= right; i++) {
            int x = i;
            while (extra2 > 0 && x % 2 == 0) { x /= 2; extra2--; }
            while (extra5 > 0 && x % 5 == 0) { x /= 5; extra5--; }
            suf = (suf * x) % MOD;
        }

        // Compute prefix via log10
        double logSum = 0;
        for (int i = left; i <= right; i++) {
            logSum += Math.log10(i);
        }
        logSum -= C; // remove trailing zeros contribution
        double frac = logSum - Math.floor(logSum);
        long pre = (long) Math.pow(10, frac + 4); // first 5 digits

        String sufStr = String.format("%05d", suf);
        return pre + "..." + sufStr + "e" + C;
    }
}
