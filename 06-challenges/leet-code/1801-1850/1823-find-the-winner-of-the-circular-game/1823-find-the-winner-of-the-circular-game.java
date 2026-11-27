// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

// Solution: Josephus Formula — O(n) time, O(1) space
class Solution {
    public int findTheWinner(int n, int k) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + k) % i;
        }
        return pos + 1;
    }
}
