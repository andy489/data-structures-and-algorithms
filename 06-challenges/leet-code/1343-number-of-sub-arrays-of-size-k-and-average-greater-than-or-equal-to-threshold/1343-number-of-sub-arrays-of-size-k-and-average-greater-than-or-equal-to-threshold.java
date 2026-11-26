// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0, limit = k * threshold;
        for (int i = 0; i < k; i++) sum += arr[i];
        if (sum >= limit) count++;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i-k];
            if (sum >= limit) count++;
        }
        return count;
    }
}
