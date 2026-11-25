// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

var maxChunksToSorted = function(arr) {
    const n = arr.length;
    const leftMax = new Array(n), rightMin = new Array(n);
    leftMax[0] = arr[0];
    for (let i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i-1], arr[i]);
    rightMin[n-1] = arr[n-1];
    for (let i = n-2; i >= 0; i--) rightMin[i] = Math.min(rightMin[i+1], arr[i]);
    let chunks = 1;
    for (let i = 0; i < n-1; i++) {
        if (leftMax[i] <= rightMin[i+1]) chunks++;
    }
    return chunks;
};
