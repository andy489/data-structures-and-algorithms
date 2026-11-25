// https://leetcode.com/problems/longest-mountain-in-array/

var longestMountain = function(arr) {
    const n = arr.length;
    const up = new Array(n).fill(0);
    const down = new Array(n).fill(0);
    for (let i = 1; i < n; i++) {
        if (arr[i] > arr[i - 1]) up[i] = up[i - 1] + 1;
    }
    for (let i = n - 2; i >= 0; i--) {
        if (arr[i] > arr[i + 1]) down[i] = down[i + 1] + 1;
    }
    let ans = 0;
    for (let i = 0; i < n; i++) {
        if (up[i] > 0 && down[i] > 0) ans = Math.max(ans, up[i] + down[i] + 1);
    }
    return ans;
};
