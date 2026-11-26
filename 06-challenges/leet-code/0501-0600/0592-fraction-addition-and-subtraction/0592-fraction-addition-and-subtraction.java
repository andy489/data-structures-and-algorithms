// https://leetcode.com/problems/fraction-addition-and-subtraction/
class Solution {
    public String fractionAddition(String expression) {
        List<String> fractions = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {
                fractions.add(expression.substring(start, i));
                start = i;
            }
        }
        fractions.add(expression.substring(start));

        int numerator = 0, denominator = 1;
        for (String frac : fractions) {
            int slash = frac.indexOf('/');
            int num = Integer.parseInt(frac.substring(0, slash));
            int den = Integer.parseInt(frac.substring(slash + 1));
            numerator = numerator * den + num * denominator;
            denominator = denominator * den;
            int g = gcd(Math.abs(numerator), denominator);
            numerator /= g;
            denominator /= g;
        }
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
