// https://leetcode.com/problems/determine-if-string-halves-are-alike/

// Solution: Two-Pointer Count — O(n) time, O(1) space
class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                count++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                count--;
            }
        }
        return count == 0;
    }
}
