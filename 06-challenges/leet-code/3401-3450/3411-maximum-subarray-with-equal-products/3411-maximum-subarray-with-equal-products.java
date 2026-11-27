// https://leetcode.com/problems/maximum-subarray-with-equal-products/

// Solution: Brute-Force Sliding Window — O(n² log M) time, O(1) space
class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int best = 1;
        for (int i = 0; i < n; i++) {
            long prod = nums[i];
            long g = nums[i];
            long l = nums[i];
            for (int j = i + 1; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                if (prod == l * g) {
                    best = Math.max(best, j - i + 1);
                } else if (prod > l * g) {
                    break;
                }
            }
        }
        return best;
    }
}
