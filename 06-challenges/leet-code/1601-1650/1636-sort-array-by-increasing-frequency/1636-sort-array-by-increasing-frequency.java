// https://leetcode.com/problems/sort-array-by-increasing-frequency/

// Solution: Frequency Map + Custom Sort — O(n log n) time, O(n) space
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }
        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }
        Arrays.sort(boxed, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            return fa != fb ? fa - fb : b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }
        return nums;
    }
}
