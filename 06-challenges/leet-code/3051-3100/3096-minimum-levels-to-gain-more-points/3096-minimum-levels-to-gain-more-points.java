// https://leetcode.com/problems/minimum-levels-to-gain-more-points/

// Solution: Prefix Sum — O(n) time, O(1) space
class Solution {
    public int minimumLevels(int[] possible) {
        int total = 0;
        for (int x : possible) { total += x == 1 ? 1 : -1; }
        int prefix = 0;
        for (int k = 0; k < possible.length - 1; k++) {
            prefix += possible[k] == 1 ? 1 : -1;
            if (2 * prefix > total) { return k + 1; }
        }
        return -1;
    }
}
