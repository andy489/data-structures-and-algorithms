// https://leetcode.com/problems/shift-distance-between-two-strings/

// Solution: Prefix Sum on Circular Alphabet — O(n + 26) time, O(26) space
class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        // Double arrays to handle wrap-around
        long[] nextPre = new long[53];   // nextPre[i] = sum of nextCost[0..i-1] on doubled alphabet
        long[] prevPre = new long[53];   // prevPre[i] = sum of prevCost[0..i-1] on reversed doubled alphabet

        for (int i = 0; i < 52; i++) {
            nextPre[i + 1] = nextPre[i] + nextCost[i % 26];
        }
        // For backward direction: traversing from index a backward means visiting a, a-1, ...
        // We model it as: doubled prev array in reverse order
        // prevCost of going from a backward one step = previousCost[a]
        // prevCost from a backward k steps = sum of previousCost[a], previousCost[(a-1+26)%26], ...
        // Double: positions 0..51, reversed = positions 51 down to 0
        // Build prefix on the reversed doubled prev array
        long[] prevDouble = new long[52];
        for (int i = 0; i < 52; i++) {
            prevDouble[i] = previousCost[i % 26];
        }
        // Reverse and prefix
        long[] revPrevPre = new long[53];
        for (int i = 51; i >= 0; i--) {
            revPrevPre[i] = revPrevPre[i + 1] + prevDouble[i];
        }

        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            if (a == b) {
                continue;
            }
            // Forward: a -> a+1 -> ... -> b (mod 26), steps = (b-a+26)%26
            int fwdSteps = (b - a + 26) % 26;
            long fwdCost = nextPre[a + fwdSteps] - nextPre[a];

            // Backward: a -> a-1 -> ... -> b (mod 26), steps = (a-b+26)%26
            int bwdSteps = (a - b + 26) % 26;
            // backward traversal from position a: revPrevPre[51-a .. 51-a+bwdSteps-1]
            int start = 51 - a;
            long bwdCost = revPrevPre[start] - revPrevPre[start + bwdSteps];

            ans += Math.min(fwdCost, bwdCost);
        }
        return ans;
    }
}
