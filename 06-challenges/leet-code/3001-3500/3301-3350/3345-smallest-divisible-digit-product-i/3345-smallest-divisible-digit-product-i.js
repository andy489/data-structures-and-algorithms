// https://leetcode.com/problems/smallest-divisible-digit-product-i/

// Solution: Linear Scan — O(1) time (bounded n), O(1) space
var smallestNumber = function(n, t) {
    const digitProduct = (x) => {
        let prod = 1;
        while (x > 0) {
            prod *= x % 10;
            x = Math.floor(x / 10);
        }
        return prod;
    };

    let x = n;
    while (digitProduct(x) % t !== 0) {
        x++;
    }
    return x;
};
