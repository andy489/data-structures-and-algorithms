// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

// Solution: Greedy scan right-to-left — O(n) time, O(n) space
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                int num = Integer.parseInt(s.substring(i-2, i));
                sb.append((char)('a' + num - 1));
                i -= 3;
            } else {
                sb.append((char)('a' + (s.charAt(i) - '0') - 1));
                i--;
            }
        }
        return sb.reverse().toString();
    }
}
