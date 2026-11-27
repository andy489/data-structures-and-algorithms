// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

// Solution: Recursive Bit Identification — O(n) time, O(n) space
class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int len = (1 << n) - 1;
        int mid = len / 2 + 1;
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char c = findKthBit(n - 1, len - k + 1);
            return c == '0' ? '1' : '0';
        }
    }
}
