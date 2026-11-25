// https://leetcode.com/problems/previous-permutation-with-one-swap/

var prevPermOpt1 = function(arr) {
    const n = arr.length;
    let i = n - 2;
    while (i >= 0 && arr[i] <= arr[i+1]) i--;
    if (i < 0) return arr;
    let j = n - 1;
    while (arr[j] >= arr[i]) j--;
    while (j > 0 && arr[j] === arr[j-1]) j--;
    [arr[i], arr[j]] = [arr[j], arr[i]];
    return arr;
};
