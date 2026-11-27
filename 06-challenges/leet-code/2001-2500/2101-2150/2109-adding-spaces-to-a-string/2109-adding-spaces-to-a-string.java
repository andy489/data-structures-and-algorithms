// https://leetcode.com/problems/adding-spaces-to-a-string/

// Solution: Two Pointers with StringBuilder — O(n + m) time, O(n + m) space
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
