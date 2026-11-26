// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

// Solution: Binary Search — O(n log(max)) time, O(1) space
// Solution: Binary Search — O(n log(max)) time, O(1) space
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1_000_000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int sum = 0;
            for (int x : nums) sum += (x + mid - 1) / mid;
            if (sum <= threshold) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
