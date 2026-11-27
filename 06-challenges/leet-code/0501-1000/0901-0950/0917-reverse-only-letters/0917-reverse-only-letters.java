// https://leetcode.com/problems/reverse-only-letters/

// Solution: Two Pointers — O(n) time, O(n) space
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            if (left < right) {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
        return new String(chars);
    }
}
