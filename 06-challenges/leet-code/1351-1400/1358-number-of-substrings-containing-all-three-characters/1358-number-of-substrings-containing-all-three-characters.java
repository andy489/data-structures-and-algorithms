// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

// Solution: Last index tracking — O(n) time, O(1) space
class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            count += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return count;
    }
}
