// https://leetcode.com/problems/decode-string/

// Solution: Stack — O(n * max_k) time, O(n) space
var decodeString = function(s) {
    const stack = [];
    let current = "", k = 0;
    for (const c of s) {
        if (c >= '0' && c <= '9') {
            k = k * 10 + Number(c);
        } else if (c === '[') {
            stack.push([current, k]);
            current = "";
            k = 0;
        } else if (c === ']') {
            const [prev, times] = stack.pop();
            current = prev + current.repeat(times);
        } else {
            current += c;
        }
    }
    return current;
};
