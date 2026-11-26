// https://leetcode.com/problems/least-operators-to-express-number/

// Solution: Digit DP on Base-x Representation — O(log target) time, O(1) space
class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int pos = 0, neg = 0, k = 0;
        while (target > 0) {
            int d = target % x;
            target /= x;
            if (k == 0) {
                pos = d * 2;
                neg = (x - d) * 2;
            } else {
                int newPos = Math.min(pos + d * 2 * k, neg + (d + 1) * 2 * k);
                int newNeg = Math.min(pos + (x - d) * 2 * k, neg + (x - d - 1) * 2 * k);
                pos = newPos;
                neg = newNeg;
            }
            k++;
        }
        return Math.min(pos, neg + 2 * k) - 1;
    }
}
