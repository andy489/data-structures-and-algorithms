// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

var findKthBit = function(n, k) {
    if (n === 1) return '0';
    const len = (1 << n) - 1;
    const mid = Math.floor(len / 2) + 1;
    if (k === mid) return '1';
    if (k < mid) return findKthBit(n - 1, k);
    const c = findKthBit(n - 1, len - k + 1);
    return c === '0' ? '1' : '0';
};
