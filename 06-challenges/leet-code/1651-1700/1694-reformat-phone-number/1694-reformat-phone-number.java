// https://leetcode.com/problems/reformat-phone-number/

// Solution: Linear Scan and Group — O(n) time, O(n) space
class Solution {
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0, len = digits.length();
        while (len - i > 4) {
            result.append(digits, i, i + 3).append('-');
            i += 3;
        }
        if (len - i == 4) {
            result.append(digits, i, i + 2).append('-').append(digits, i + 2, i + 4);
        } else {
            result.append(digits, i, len);
        }
        return result.toString();
    }
}
