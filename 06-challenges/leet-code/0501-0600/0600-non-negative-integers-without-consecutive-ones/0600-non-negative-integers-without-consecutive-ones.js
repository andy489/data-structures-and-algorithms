// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
var findIntegers = function(n) {
    const fib = new Array(32).fill(0);
    fib[0] = 1;
    fib[1] = 2;
    for (let i = 2; i < 32; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    let result = 0;
    let prevBit = 0;
    for (let i = 30; i >= 0; i--) {
        if (n & (1 << i)) {
            result += fib[i];
            if (prevBit === 1) {
                return result;
            }
            prevBit = 1;
        } else {
            prevBit = 0;
        }
    }
    return result + 1;
};
