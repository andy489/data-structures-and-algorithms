// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

// Solution: Prefix XOR — O(n^2) time, O(n) space
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) pre[i+1] = pre[i] ^ arr[i];
        for (int i = 0; i < n; i++)
            for (int k = i+1; k < n; k++)
                if (pre[i] == pre[k+1]) ans += k - i;
        return ans;
    }
}
