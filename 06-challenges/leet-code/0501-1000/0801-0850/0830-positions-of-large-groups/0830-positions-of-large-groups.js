// https://leetcode.com/problems/positions-of-large-groups/

var largeGroupPositions = function(s) {
    const result = [];
    let start = 0;
    for (let i = 1; i <= s.length; i++) {
        if (i === s.length || s[i] !== s[start]) {
            if (i - start >= 3) { result.push([start, i - 1]); }
            start = i;
        }
    }
    return result;
};
