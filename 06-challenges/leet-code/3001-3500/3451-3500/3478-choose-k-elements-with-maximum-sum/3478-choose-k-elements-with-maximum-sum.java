// https://leetcode.com/problems/choose-k-elements-with-maximum-sum/

// Solution: Sort + Min-Heap — O(n log n) time, O(n) space
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> nums1[a] - nums1[b]);
        long[] answer = new long[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            // Find group with same nums1 value
            while (j < n && nums1[indices[j]] == nums1[indices[i]]) {
                j++;
            }
            // Record current sum for all in group
            for (int t = i; t < j; t++) {
                answer[indices[t]] = sum;
            }
            // Add all group members to heap
            for (int t = i; t < j; t++) {
                minHeap.offer(nums2[indices[t]]);
                sum += nums2[indices[t]];
                if (minHeap.size() > k) {
                    sum -= minHeap.poll();
                }
            }
            i = j;
        }
        return answer;
    }
}
