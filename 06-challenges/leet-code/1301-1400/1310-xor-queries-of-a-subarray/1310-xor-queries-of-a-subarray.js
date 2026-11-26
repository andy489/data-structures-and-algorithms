// https://leetcode.com/problems/xor-queries-of-a-subarray/

var xorQueries = function(arr, queries) {
    const prefix = [0];
    for (const v of arr) prefix.push(prefix[prefix.length-1] ^ v);
    return queries.map(([l,r]) => prefix[r+1] ^ prefix[l]);
};
