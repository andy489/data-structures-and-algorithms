// https://leetcode.com/problems/second-largest-digit-in-a-string/

var secondHighest = function(s) {
    let first = -1, second = -1;
    for (const c of s) {
        if (c >= '0' && c <= '9') {
            const d = Number(c);
            if (d > first) {
                second = first;
                first = d;
            } else if (d < first && d > second) {
                second = d;
            }
        }
    }
    return second;
};
