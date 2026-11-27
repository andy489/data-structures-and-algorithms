// https://leetcode.com/problems/subarray-sum-equals-k/
// Solution: Prefix sum HashMap — O(n) time, O(n) space
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixFreq.getOrDefault(sum - k, 0);
            prefixFreq.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
