// https://leetcode.com/problems/decode-xored-permutation/

// Solution: XOR Total + Even-index Groups — O(n) time, O(n) space
class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int rest = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            rest ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ rest;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}
