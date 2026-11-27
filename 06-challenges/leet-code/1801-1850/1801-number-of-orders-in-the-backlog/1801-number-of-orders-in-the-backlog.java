// https://leetcode.com/problems/number-of-orders-in-the-backlog/

// Solution: Two Heaps — O(n log n) time, O(n) space
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);  // max-heap
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) { // buy order
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] top = sell.poll();
                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;
                    if (top[1] > 0) {
                        sell.offer(top);
                    }
                }
                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }
            } else { // sell order
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] top = buy.poll();
                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;
                    if (top[1] > 0) {
                        buy.offer(top);
                    }
                }
                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
                }
            }
        }
        long total = 0;
        int mod = 1_000_000_007;
        for (int[] b : buy) {
            total += b[1];
        }
        for (int[] s : sell) {
            total += s[1];
        }
        return (int)(total % mod);
    }
}
