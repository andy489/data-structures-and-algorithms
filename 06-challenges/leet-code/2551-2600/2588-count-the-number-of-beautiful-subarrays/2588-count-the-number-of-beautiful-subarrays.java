// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int xor = 0;
        long result = 0;
        for (int num : nums) {
            xor ^= num;
            result += prefixCount.getOrDefault(xor, 0);
            prefixCount.put(xor, prefixCount.getOrDefault(xor, 0) + 1);
        }
        return result;
    }
}
