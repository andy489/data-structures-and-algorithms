// https://leetcode.com/problems/maximum-binary-string-after-change/

var maximumBinaryString = function(binary) {
    const n = binary.length;
    const firstZero = binary.indexOf('0');
    if (firstZero === -1) {
        return binary;
    }
    let zeros = 0;
    for (let i = firstZero; i < n; i++) {
        if (binary[i] === '0') {
            zeros++;
        }
    }
    const result = Array(n).fill('1');
    result[firstZero + zeros - 1] = '0';
    return result.join('');
};
