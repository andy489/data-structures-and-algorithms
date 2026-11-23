// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/

// Solution: Prefix Tree Counting — O(log²n) time, O(1) space
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private long countSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1L, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}
