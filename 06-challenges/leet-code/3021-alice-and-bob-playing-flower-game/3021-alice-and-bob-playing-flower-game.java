// https://leetcode.com/problems/alice-and-bob-playing-flower-game/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public long flowerGame(long n, long m) {
        long oddX = (n + 1) / 2, evenX = n / 2;
        long oddY = (m + 1) / 2, evenY = m / 2;
        return oddX * evenY + evenX * oddY;
    }
}
