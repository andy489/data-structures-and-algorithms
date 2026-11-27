// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;
        for (int p : piles) {
            maxHeap.offer(p);
            total += p;
        }
        for (int i = 0; i < k; i++) {
            int top = maxHeap.poll();
            int remove = top / 2;
            total -= remove;
            maxHeap.offer(top - remove);
        }
        return total;
    }
}
