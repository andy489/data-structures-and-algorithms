// https://leetcode.com/problems/decode-xored-array/

// Solution: XOR Prefix Reconstruction — O(n) time, O(n) space
class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}
