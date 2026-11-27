// https://leetcode.com/problems/largest-substring-between-two-equal-characters/

// Solution: First Occurrence Map — O(n) time, O(1) space
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            } else {
                ans = Math.max(ans, i - first[c] - 1);
            }
        }
        return ans;
    }
}
