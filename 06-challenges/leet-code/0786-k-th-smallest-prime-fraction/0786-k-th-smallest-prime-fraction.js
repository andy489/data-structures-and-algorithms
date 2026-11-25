// https://leetcode.com/problems/k-th-smallest-prime-fraction/

var kthSmallestPrimeFraction = function(arr, k) {
    const n = arr.length;
    const heap = [];
    for (let i = 0; i < n - 1; i++) heap.push([arr[i] / arr[n-1], i, n-1]);
    heap.sort((a, b) => a[0] - b[0]);
    for (let step = 0; step < k - 1; step++) {
        heap.sort((a, b) => a[0] - b[0]);
        const [, i, j] = heap.shift();
        if (j - 1 > i) heap.push([arr[i] / arr[j-1], i, j-1]);
    }
    heap.sort((a, b) => a[0] - b[0]);
    const [, i, j] = heap[0];
    return [arr[i], arr[j]];
};
