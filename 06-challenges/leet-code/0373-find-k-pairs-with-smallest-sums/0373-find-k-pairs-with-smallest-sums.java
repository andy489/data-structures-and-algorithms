// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

// Solution: Min-Heap — O(k log k) time, O(k) space
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < k) {
            int[] top = pq.poll();
            int i = top[1], j = top[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}
