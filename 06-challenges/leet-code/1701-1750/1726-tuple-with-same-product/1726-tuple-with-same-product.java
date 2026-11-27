// https://leetcode.com/problems/tuple-with-same-product/

// Solution: Hash Map of Products — O(n^2) time, O(n^2) space
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                productCount.merge(prod, 1, Integer::sum);
            }
        }
        int ans = 0;
        for (int c : productCount.values()) {
            ans += c * (c - 1) / 2 * 8;
        }
        return ans;
    }
}
