// https://leetcode.com/problems/sliding-window-median/

// Solution: Two Heaps with Lazy Deletion — O(N log k) time, O(k) space
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> toRemove = new HashMap<>();
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            minHeap.offer(maxHeap.poll());
        }

        for (int i = k; i <= nums.length; i++) {
            result[i - k] = getMedian(maxHeap, minHeap, k);
            if (i == nums.length) {
                break;
            }

            int incoming = nums[i];
            int outgoing = nums[i - k];
            toRemove.merge(outgoing, 1, Integer::sum);

            if (incoming <= maxHeap.peek()) {
                maxHeap.offer(incoming);
            } else {
                minHeap.offer(incoming);
            }

            if (outgoing <= maxHeap.peek()) {
                // outgoing was in maxHeap side
            } else {
                // outgoing was in minHeap side
            }

            rebalance(maxHeap, minHeap, toRemove, k);
        }
        return result;
    }

    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        if (k % 2 == 1) {
            return maxHeap.peek();
        }
        return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    private void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap,
                           Map<Integer, Integer> toRemove, int k) {
        // balance sizes: maxHeap should have ceil(k/2), minHeap floor(k/2)
        while (!maxHeap.isEmpty() && toRemove.getOrDefault(maxHeap.peek(), 0) > 0) {
            toRemove.merge(maxHeap.poll(), -1, Integer::sum);
        }
        while (!minHeap.isEmpty() && toRemove.getOrDefault(minHeap.peek(), 0) > 0) {
            toRemove.merge(minHeap.poll(), -1, Integer::sum);
        }
        int maxSize = (k + 1) / 2;
        if (maxHeap.size() > maxSize) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < maxSize && !minHeap.isEmpty()) {
            maxHeap.offer(minHeap.poll());
        }
        while (!maxHeap.isEmpty() && toRemove.getOrDefault(maxHeap.peek(), 0) > 0) {
            toRemove.merge(maxHeap.poll(), -1, Integer::sum);
        }
        while (!minHeap.isEmpty() && toRemove.getOrDefault(minHeap.peek(), 0) > 0) {
            toRemove.merge(minHeap.poll(), -1, Integer::sum);
        }
    }
}
