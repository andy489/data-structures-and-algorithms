// https://leetcode.com/problems/calculate-digit-sum-of-a-string/

// Solution: Simulation — O(n / k · n) time, O(n) space
var digitSum = function(s, k) {
    while (s.length > k) {
        let next = "";
        for (let i = 0; i < s.length; i += k) {
            const chunk = s.slice(i, i + k);
            const sum = chunk.split("").reduce((acc, c) => acc + Number(c), 0);
            next += sum;
        }
        s = next;
    }
    return s;
};
