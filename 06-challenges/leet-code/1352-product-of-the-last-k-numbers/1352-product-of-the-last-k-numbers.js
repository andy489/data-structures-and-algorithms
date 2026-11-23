// https://leetcode.com/problems/product-of-the-last-k-numbers/

// Solution: Prefix Products with Zero Reset — O(1) time, O(n) space
class ProductOfNumbers {
    constructor() {
        this.prefix = [1];
    }

    add(num) {
        if (num === 0) {
            this.prefix = [1];
        } else {
            this.prefix.push(this.prefix[this.prefix.length - 1] * num);
        }
    }

    getProduct(k) {
        const n = this.prefix.length;
        if (k >= n) return 0;
        return this.prefix[n - 1] / this.prefix[n - 1 - k];
    }
}
