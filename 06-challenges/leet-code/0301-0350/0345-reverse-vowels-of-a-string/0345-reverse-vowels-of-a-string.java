// https://leetcode.com/problems/reverse-vowels-of-a-string/

// Solution: Two Pointers — O(n) time, O(n) space
class Solution {
    private static final String VOWELS = "aeiouAEIOU";

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && VOWELS.indexOf(chars[left]) == -1) {
                left++;
            }
            while (left < right && VOWELS.indexOf(chars[right]) == -1) {
                right--;
            }
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
