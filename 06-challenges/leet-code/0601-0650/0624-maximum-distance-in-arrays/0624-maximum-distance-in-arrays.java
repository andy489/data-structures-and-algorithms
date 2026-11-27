// https://leetcode.com/problems/maximum-distance-in-arrays/

// Solution: Running Min/Max — O(m) time, O(1) space
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int first = arr.get(0);
            int last = arr.get(arr.size() - 1);
            result = Math.max(result, Math.max(last - globalMin, globalMax - first));
            globalMin = Math.min(globalMin, first);
            globalMax = Math.max(globalMax, last);
        }
        return result;
    }
}
