// https://leetcode.com/problems/happy-number/

// Solution: Floyd's cycle detection — O(log n) time, O(1) space
const next = (n) => {
    let sum = 0;
    while (n > 0) {
        const d = n % 10;
        sum += d * d;
        n = Math.floor(n / 10);
    }
    return sum;
};

var isHappy = function(n) {
    let slow = n, fast = next(n);
    while (fast !== 1 && slow !== fast) {
        slow = next(slow);
        fast = next(next(fast));
    }
    return fast === 1;
};

// Solution 2: Hash set cycle detection — O(log n) time, O(log n) space
var isHappy2 = function(n) {
    const seen = new Set();
    while (n !== 1 && !seen.has(n)) {
        seen.add(n);
        n = String(n).split('').reduce((s, d) => s + d * d, 0);
    }
    return n === 1;
};
