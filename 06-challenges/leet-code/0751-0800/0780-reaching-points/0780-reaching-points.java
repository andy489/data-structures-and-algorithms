// https://leetcode.com/problems/reaching-points/

// Solution: Reverse Reduction — O(log(max(tx,ty))) time, O(1) space
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx) {
                return (ty - sy) % sx == 0;
            }
            if (ty == sy) {
                return (tx - sx) % sy == 0;
            }
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        return false;
    }
}
