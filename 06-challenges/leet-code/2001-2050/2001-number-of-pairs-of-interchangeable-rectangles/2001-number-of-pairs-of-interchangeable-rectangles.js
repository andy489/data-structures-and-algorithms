// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/

// Solution: HashMap of GCD-Reduced Ratios — O(n log m) time, O(n) space
var interchangeableRectangles = function(rectangles) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const freq = new Map();
    for (const [w, h] of rectangles) {
        const g = gcd(w, h);
        const key = (w / g) + ':' + (h / g);
        freq.set(key, (freq.get(key) || 0) + 1);
    }
    let res = 0;
    for (const c of freq.values()) { res += c * (c - 1) / 2; }
    return res;
};
