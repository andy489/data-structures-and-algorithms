// https://leetcode.com/problems/circular-permutation-in-binary-representation/

// Solution: Gray Code with XOR — O(2^n) time, O(2^n) space
// Solution: Gray Code with XOR — O(2^n) time, O(2^n) space
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) res.add(start ^ (i ^ (i >> 1)));
        return res;
    }
}
