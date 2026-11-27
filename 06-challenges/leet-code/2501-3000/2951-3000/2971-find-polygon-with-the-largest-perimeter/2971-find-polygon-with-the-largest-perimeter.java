// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefixSum = 0;
        long result = -1;
        for (int num : nums) {
            if (prefixSum > num) {
                result = prefixSum + num;
            }
            prefixSum += num;
        }
        return result;
    }
}
