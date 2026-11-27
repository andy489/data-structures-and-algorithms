// https://leetcode.com/problems/xor-queries-of-a-subarray/

// Solution: Prefix XOR — O(n+q) time, O(n) space
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) prefix[i+1] = prefix[i] ^ arr[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][1]+1] ^ prefix[queries[i][0]];
        }
        return ans;
    }
}
