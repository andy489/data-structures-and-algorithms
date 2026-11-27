// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

// Solution: Custom Sort — O(n log n * L) time, O(1) extra space
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        return nums[nums.length - k];
    }
}
