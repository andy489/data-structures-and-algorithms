// https://leetcode.com/problems/minimize-deviation-in-array/

// Solution: Max Heap with Normalization — O(n log n * log(max)) time, O(n) space
class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            int val = (num % 2 == 1) ? num * 2 : num;
            maxHeap.offer(val);
            minVal = Math.min(minVal, val);
        }
        int minDeviation = maxHeap.peek() - minVal;
        while (maxHeap.peek() % 2 == 0) {
            int maxVal = maxHeap.poll();
            minDeviation = Math.min(minDeviation, maxVal - minVal);
            maxVal /= 2;
            minVal = Math.min(minVal, maxVal);
            maxHeap.offer(maxVal);
        }
        return Math.min(minDeviation, maxHeap.peek() - minVal);
    }
}
