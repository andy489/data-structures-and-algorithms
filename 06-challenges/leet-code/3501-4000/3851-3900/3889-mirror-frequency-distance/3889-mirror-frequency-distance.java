// https://leetcode.com/problems/mirror-frequency-distance/
class Solution {
    public int mirrorFrequencyDistance(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int result = 0;

        // Letter pairs: (a,z), (b,y), ..., (m,n) — 13 pairs
        for (int i = 0; i < 13; i++) {
            char c = (char)('a' + i);
            char m = (char)('z' - i);
            result += Math.abs(freq[c] - freq[m]);
        }

        // Digit pairs: (0,9), (1,8), ..., (4,5) — 5 pairs
        for (int i = 0; i < 5; i++) {
            char c = (char)('0' + i);
            char m = (char)('9' - i);
            result += Math.abs(freq[c] - freq[m]);
        }

        return result;
    }
}
