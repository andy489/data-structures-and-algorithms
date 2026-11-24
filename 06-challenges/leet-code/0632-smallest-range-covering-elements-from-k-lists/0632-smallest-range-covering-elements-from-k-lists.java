// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

// Solution: Min Heap + Max Tracker — O(n log k) time, O(k) space
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0], listIdx = curr[1], elemIdx = curr[2];
            if (currentMax - val < rangeEnd - rangeStart) {
                rangeStart = val;
                rangeEnd = currentMax;
            }
            if (elemIdx + 1 == nums.get(listIdx).size()) {
                break;
            }
            int nextVal = nums.get(listIdx).get(elemIdx + 1);
            minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
            currentMax = Math.max(currentMax, nextVal);
        }
        return new int[]{rangeStart, rangeEnd};
    }
}
