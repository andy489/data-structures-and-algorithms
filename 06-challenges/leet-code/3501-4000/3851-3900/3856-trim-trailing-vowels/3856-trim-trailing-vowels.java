// https://leetcode.com/problems/trim-trailing-vowels/

class Solution {
    public String trimTrailingVowels(String s) {
        String vowels = "aeiou";
        int i = s.length() - 1;
        while (i >= 0 && vowels.indexOf(s.charAt(i)) != -1) {
            i--;
        }
        return s.substring(0, i + 1);
    }
}
