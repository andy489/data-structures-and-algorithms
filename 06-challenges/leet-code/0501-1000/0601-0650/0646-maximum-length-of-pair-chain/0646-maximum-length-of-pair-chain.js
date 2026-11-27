// https://leetcode.com/problems/maximum-length-of-pair-chain/

var findLongestChain = function(pairs) {
    pairs.sort((a, b) => a[1] - b[1]);
    let chainEnd = -Infinity;
    let count = 0;
    for (const [left, right] of pairs) {
        if (left > chainEnd) {
            chainEnd = right;
            count++;
        }
    }
    return count;
};
