// https://leetcode.com/problems/xor-operation-in-an-array/

// Solution: Linear XOR — O(n) time, O(1) space
class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) res ^= start + 2 * i;
        return res;
    }
}
