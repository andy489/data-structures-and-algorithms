// https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/
/**
 * @param {number} n
 * @return {number[]}
 */
var getGoodIntegers = function(n) {
    const countMap = new Map();
    const limit = Math.ceil(Math.cbrt(n)) + 1;

    for (let a = 1; a <= limit; a++) {
        for (let b = a; b <= limit; b++) {
            const sum = a * a * a + b * b * b;
            if (sum > n) {
                break;
            }
            countMap.set(sum, (countMap.get(sum) || 0) + 1);
        }
    }

    const result = [];
    for (const [key, val] of countMap) {
        if (val >= 2) {
            result.push(key);
        }
    }
    result.sort((a, b) => a - b);
    return result;
};
