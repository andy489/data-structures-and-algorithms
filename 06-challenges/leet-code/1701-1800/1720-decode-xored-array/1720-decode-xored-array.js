// https://leetcode.com/problems/decode-xored-array/

var decode = function(encoded, first) {
    const arr = [first];
    for (const x of encoded) {
        arr.push(arr[arr.length - 1] ^ x);
    }
    return arr;
};
