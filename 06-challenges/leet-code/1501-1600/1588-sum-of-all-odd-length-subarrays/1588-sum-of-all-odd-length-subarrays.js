// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

var sumOddLengthSubarrays = function(arr) {
    const n = arr.length;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        const left = i + 1, right = n - i;
        const total = left * right;
        const oddCount = Math.floor((total + 1) / 2);
        sum += arr[i] * oddCount;
    }
    return sum;
};
