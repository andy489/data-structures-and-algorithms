// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

var numsSameConsecDiff = function(n, k) {
    let cur = Array.from({length: 9}, (_, i) => i + 1);
    for (let i = 1; i < n; i++) {
        const next = [];
        for (const num of cur) {
            const last = num % 10;
            if (last + k <= 9) next.push(num * 10 + last + k);
            if (k !== 0 && last - k >= 0) next.push(num * 10 + last - k);
        }
        cur = next;
    }
    return cur;
};
