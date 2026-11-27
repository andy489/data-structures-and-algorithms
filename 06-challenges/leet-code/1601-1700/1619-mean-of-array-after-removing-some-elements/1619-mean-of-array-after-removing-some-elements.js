// https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

var trimMean = function(arr) {
    arr.sort((a, b) => a - b);
    const n = arr.length;
    const trim = Math.floor(n / 20);
    let sum = 0;
    for (let i = trim; i < n - trim; i++) {
        sum += arr[i];
    }
    return sum / (n - 2 * trim);
};
