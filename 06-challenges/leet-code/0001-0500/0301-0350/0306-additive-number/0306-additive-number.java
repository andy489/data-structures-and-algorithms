// https://leetcode.com/problems/additive-number/

// Solution: Enumerate First Two + BigInteger Addition — O(n³) time, O(n) space
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String num, int start, int i, int j) {
        String s1 = num.substring(start, i);
        String s2 = num.substring(i, j);
        if ((s1.length() > 1 && s1.charAt(0) == '0') || (s2.length() > 1 && s2.charAt(0) == '0')) {
            return false;
        }
        String sum = add(s1, s2);
        if (num.startsWith(sum, j)) {
            if (j + sum.length() == num.length()) {
                return true;
            }
            return check(num, i, j, j + sum.length());
        }
        return false;
    }

    private String add(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int s = carry;
            if (i >= 0) { s += a.charAt(i--) - '0'; }
            if (j >= 0) { s += b.charAt(j--) - '0'; }
            sb.append(s % 10);
            carry = s / 10;
        }
        return sb.reverse().toString();
    }
}
