// https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/

// Solution: Bitwise Identity — O(n + m) time, O(1) space
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for (int x : arr1) {
            xor1 ^= x;
        }
        for (int x : arr2) {
            xor2 ^= x;
        }
        return xor1 & xor2;
    }
}
