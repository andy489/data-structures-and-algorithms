// https://leetcode.com/problems/fraction-to-recurring-decimal/

// Long division with HashMap — O(d) time, O(d) space
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append('-');
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        sb.append(num / den);
        long rem = num % den;
        if (rem == 0) return sb.toString();
        sb.append('.');
        Map<Long, Integer> remainderIndex = new HashMap<>();
        while (rem != 0) {
            if (remainderIndex.containsKey(rem)) {
                sb.insert((int) remainderIndex.get(rem), '(');
                sb.append(')');
                break;
            }
            remainderIndex.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }
        return sb.toString();
    }
}
