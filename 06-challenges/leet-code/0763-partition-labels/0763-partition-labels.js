// https://leetcode.com/problems/partition-labels/

var partitionLabels = function(s) {
    const last = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) last[s.charCodeAt(i) - 97] = i;
    const result = [];
    let start = 0, end = 0;
    for (let i = 0; i < s.length; i++) {
        end = Math.max(end, last[s.charCodeAt(i) - 97]);
        if (i === end) { result.push(end - start + 1); start = i + 1; }
    }
    return result;
};
