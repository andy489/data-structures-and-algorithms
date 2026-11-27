// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

// Solution: Greedy — O(n) time, O(n) space
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i + 1;
            sum += i + 1;
        }
        ans[n-1] = -sum;
        return ans;
    }
}
