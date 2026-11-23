// https://leetcode.com/problems/integer-to-english-words/

// Solution: Recursive Chunking by Thousands — O(1) time, O(1) space
class Solution {
    private static final String[] ONES = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] SCALES = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            int divisor = (int) Math.pow(1000, i);
            if (num / divisor > 0) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(helper(num / divisor)).append(SCALES[i]);
                num %= divisor;
            }
        }
        return sb.toString();
    }

    private String helper(int n) {
        if (n == 0) {
            return "";
        }
        if (n < 20) {
            return ONES[n];
        }
        if (n < 100) {
            return TENS[n / 10] + (n % 10 != 0 ? " " + ONES[n % 10] : "");
        }
        return ONES[n / 100] + " Hundred" + (n % 100 != 0 ? " " + helper(n % 100) : "");
    }
}
