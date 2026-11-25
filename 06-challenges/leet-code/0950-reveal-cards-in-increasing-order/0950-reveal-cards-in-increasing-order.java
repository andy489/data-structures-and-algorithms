// https://leetcode.com/problems/reveal-cards-in-increasing-order/

// Solution: Simulate with Queue — O(n log n) time, O(n) space
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        java.util.Arrays.sort(deck);
        java.util.ArrayDeque<Integer> queue = new java.util.ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int[] result = new int[n];
        for (int card : deck) {
            result[queue.poll()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return result;
    }
}
