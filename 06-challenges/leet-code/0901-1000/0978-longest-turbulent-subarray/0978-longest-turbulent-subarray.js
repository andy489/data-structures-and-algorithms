// https://leetcode.com/problems/longest-turbulent-subarray/

var maxTurbulenceSize = function(arr) {
    const n = arr.length;
    let ans = 1, cur = 1;
    for (let i = 1; i < n; i++) {
        const cmp = Math.sign(arr[i] - arr[i-1]);
        if (cmp === 0) cur = 1;
        else if (i > 1 && Math.sign(arr[i-1]-arr[i-2]) * cmp > 0) cur = 2;
        else cur++;
        ans = Math.max(ans, cur);
    }
    return ans;
};
