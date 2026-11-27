// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

// Solution: Count Runs — O(n) time, O(1) space
class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        char prev = ' ';
        int run = 0;
        for (char c : colors.toCharArray()) {
            if (c == prev) { run++; } else { run = 1; prev = c; }
            if (run >= 3) { if (c == 'A') { alice++; } else { bob++; } }
        }
        return alice > bob;
    }
}
