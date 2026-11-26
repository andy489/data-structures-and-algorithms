// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

var countTriplets = function(arr) {
    const n = arr.length, pre = new Array(n+1).fill(0);
    for (let i = 0; i < n; i++) pre[i+1] = pre[i] ^ arr[i];
    let ans = 0;
    for (let i = 0; i < n; i++)
        for (let k = i+1; k < n; k++)
            if (pre[i] === pre[k+1]) ans += k - i;
    return ans;
};
