// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
var divideString = function(s, k, fill) {
    const rem = s.length % k;
    if (rem !== 0) {
        s += fill.repeat(k - rem);
    }
    const result = [];
    for (let i = 0; i < s.length; i += k) {
        result.push(s.slice(i, i + k));
    }
    return result;
};
