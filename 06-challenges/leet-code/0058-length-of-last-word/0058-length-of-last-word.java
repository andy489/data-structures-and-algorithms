// https://leetcode.com/problems/length-of-last-word/

// Solution: Reverse Scan — O(n) time, O(1) space
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, count = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}
