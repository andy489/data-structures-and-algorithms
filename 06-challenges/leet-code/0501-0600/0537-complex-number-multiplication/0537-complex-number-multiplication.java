// https://leetcode.com/problems/complex-number-multiplication/

// Solution: Parse and multiply — O(1) time, O(1) space
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] c1 = parse(num1);
        int[] c2 = parse(num2);
        int real = c1[0] * c2[0] - c1[1] * c2[1];
        int imag = c1[0] * c2[1] + c1[1] * c2[0];
        return real + "+" + imag + "i";
    }

    private int[] parse(String s) {
        int plusIdx = s.lastIndexOf('+');
        int a = Integer.parseInt(s.substring(0, plusIdx));
        int b = Integer.parseInt(s.substring(plusIdx + 1, s.length() - 1));
        return new int[]{a, b};
    }
}
