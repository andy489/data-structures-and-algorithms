// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                res[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return res;
    }
}
