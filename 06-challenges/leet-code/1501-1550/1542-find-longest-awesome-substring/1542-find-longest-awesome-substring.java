// https://leetcode.com/problems/find-longest-awesome-substring/

// Solution: Bitmask Prefix XOR — O(n) time, O(1) space
class Solution {
    public int longestAwesome(String s) {
        int[] firstSeen = new int[1 << 10];
        Arrays.fill(firstSeen, -2);
        firstSeen[0] = -1;
        int mask = 0;
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= 1 << (s.charAt(i) - '0');
            if (firstSeen[mask] != -2) {
                best = Math.max(best, i - firstSeen[mask]);
            } else {
                firstSeen[mask] = i;
            }
            // try flipping each bit (allowing one odd-frequency digit)
            for (int d = 0; d < 10; d++) {
                int flipped = mask ^ (1 << d);
                if (firstSeen[flipped] != -2) {
                    best = Math.max(best, i - firstSeen[flipped]);
                }
            }
        }
        return best;
    }
}
