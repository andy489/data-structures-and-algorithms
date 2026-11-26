// https://leetcode.com/problems/stock-price-fluctuation/

// Solution: TreeMap — O(log n) per op, O(n) space
class StockPrice {
    private Map<Integer, Integer> priceMap = new HashMap<>();
    private TreeMap<Integer, Integer> freq = new TreeMap<>();
    private int maxTime = 0;

    public void update(int timestamp, int price) {
        maxTime = Math.max(maxTime, timestamp);
        if (priceMap.containsKey(timestamp)) {
            int old = priceMap.get(timestamp);
            freq.merge(old, -1, Integer::sum);
            if (freq.get(old) == 0) { freq.remove(old); }
        }
        priceMap.put(timestamp, price);
        freq.merge(price, 1, Integer::sum);
    }

    public int current() { return priceMap.get(maxTime); }
    public int maximum() { return freq.lastKey(); }
    public int minimum() { return freq.firstKey(); }
}
