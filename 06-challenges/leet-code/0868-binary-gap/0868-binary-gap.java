// https://leetcode.com/problems/binary-gap/

// Solution: Single Pass — O(log n) time, O(1) space
class Solution {
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n > 0; i++, n >>= 1) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
        }
        return ans;
    }
}
