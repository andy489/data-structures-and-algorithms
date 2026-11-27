// https://leetcode.com/problems/find-the-original-typed-string-i/

class Solution {
    public int possibleStringCount(String word) {
        int result = 1;
        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            if (j - i > 1) {
                result += j - i - 1;
            }
            i = j;
        }
        return result;
    }
}
