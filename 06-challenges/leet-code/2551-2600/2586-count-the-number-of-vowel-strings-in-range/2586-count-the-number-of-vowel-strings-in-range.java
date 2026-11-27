// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        String vowels = "aeiou";
        int count = 0;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (vowels.indexOf(w.charAt(0)) >= 0 && vowels.indexOf(w.charAt(w.length() - 1)) >= 0) {
                count++;
            }
        }
        return count;
    }
}
