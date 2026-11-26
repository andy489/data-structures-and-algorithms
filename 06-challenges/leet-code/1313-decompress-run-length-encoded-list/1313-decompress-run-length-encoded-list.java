// https://leetcode.com/problems/decompress-run-length-encoded-list/

// Solution: Simulation — O(n * max_freq) time, O(output) space
class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) res.add(nums[i+1]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
