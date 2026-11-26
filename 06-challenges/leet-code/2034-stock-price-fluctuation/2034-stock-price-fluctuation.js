// https://leetcode.com/problems/stock-price-fluctuation/

// Solution: TreeMap — O(log n) per op, O(n) space
class StockPrice {
    constructor() {
        this.priceMap = new Map();
        this.freq = new Map();
        this.maxTime = 0;
    }
    update(timestamp, price) {
        this.maxTime = Math.max(this.maxTime, timestamp);
        if (this.priceMap.has(timestamp)) {
            const old = this.priceMap.get(timestamp);
            this.freq.set(old, this.freq.get(old) - 1);
            if (this.freq.get(old) === 0) this.freq.delete(old);
        }
        this.priceMap.set(timestamp, price);
        this.freq.set(price, (this.freq.get(price) || 0) + 1);
    }
    current() { return this.priceMap.get(this.maxTime); }
    maximum() { return Math.max(...this.freq.keys()); }
    minimum() { return Math.min(...this.freq.keys()); }
}
