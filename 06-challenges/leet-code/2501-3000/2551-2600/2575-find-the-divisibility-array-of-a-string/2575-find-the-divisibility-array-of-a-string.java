// https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder * 10 + (word.charAt(i) - '0')) % m;
            div[i] = remainder == 0 ? 1 : 0;
        }
        return div;
    }
}
