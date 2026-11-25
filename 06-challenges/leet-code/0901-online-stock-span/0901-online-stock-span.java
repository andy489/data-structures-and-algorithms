// https://leetcode.com/problems/online-stock-span/

// Solution: Monotonic Stack — O(1) amortized time, O(n) space
class StockSpanner {
    private int[] prices;
    private int[] spans;
    private int top;

    public StockSpanner() {
        prices = new int[10001];
        spans = new int[10001];
        top = -1;
    }

    public int next(int price) {
        int span = 1;
        while (top >= 0 && prices[top] <= price) {
            span += spans[top--];
        }
        prices[++top] = price;
        spans[top] = span;
        return span;
    }
}
