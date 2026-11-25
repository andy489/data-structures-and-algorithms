// https://leetcode.com/problems/degree-of-an-array/

// Solution: HashMap — O(n) time, O(n) space
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            count.merge(v, 1, Integer::sum);
            first.putIfAbsent(v, i);
            last.put(v, i);
        }
        int degree = Collections.max(count.values());
        int minLen = nums.length;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == degree) {
                int v = entry.getKey();
                minLen = Math.min(minLen, last.get(v) - first.get(v) + 1);
            }
        }
        return minLen;
    }
}
