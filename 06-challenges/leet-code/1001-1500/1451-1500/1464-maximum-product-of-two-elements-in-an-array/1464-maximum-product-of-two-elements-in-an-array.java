// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

// Solution: Find Two Largest — O(n) time, O(1) space
class Solution {
    public int maxProduct(int[] nums) {
        int m1 = 0, m2 = 0;
        for (int n : nums) {
            if (n >= m1) { m2 = m1; m1 = n; }
            else if (n > m2) m2 = n;
        }
        return (m1-1)*(m2-1);
    }
}
