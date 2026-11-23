// https://leetcode.com/problems/longest-repeating-character-replacement/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            charFreq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxFreq > k) {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }
}
