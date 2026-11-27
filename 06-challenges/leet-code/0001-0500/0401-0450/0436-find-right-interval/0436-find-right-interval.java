// https://leetcode.com/problems/find-right-interval/

// Solution: TreeMap Binary Search — O(n log n) time, O(n) space
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            startToIndex.put(intervals[i][0], i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Integer ceilingStart = startToIndex.ceilingKey(intervals[i][1]);
            result[i] = ceilingStart == null ? -1 : startToIndex.get(ceilingStart);
        }
        return result;
    }
}
