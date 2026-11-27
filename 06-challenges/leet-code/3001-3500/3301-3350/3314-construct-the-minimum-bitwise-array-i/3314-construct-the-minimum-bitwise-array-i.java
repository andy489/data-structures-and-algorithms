// https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            if (p == 2) {
                ans[i] = -1;
                continue;
            }
            // Find lowest zero bit (starting from bit 1, since bit 0 is 1 for odd primes)
            ans[i] = -1;
            for (int bit = 1; bit < 30; bit++) {
                if ((p & (1 << bit)) == 0) {
                    int x = p ^ (1 << bit);
                    if ((x | (x + 1)) == p) {
                        ans[i] = x;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
