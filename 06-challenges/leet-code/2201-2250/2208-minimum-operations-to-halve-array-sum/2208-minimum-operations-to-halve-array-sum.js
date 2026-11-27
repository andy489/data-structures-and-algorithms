// https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
var halveArray = function(nums) {
    // Use a max-heap via a sorted structure (simple approach for JS)
    const heap = [...nums].map(x => x);
    // Build max-heap
    const heapify = (arr, i, n) => {
        let largest = i;
        const l = 2 * i + 1;
        const r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) { largest = l; }
        if (r < n && arr[r] > arr[largest]) { largest = r; }
        if (largest !== i) {
            [arr[i], arr[largest]] = [arr[largest], arr[i]];
            heapify(arr, largest, n);
        }
    };
    for (let i = Math.floor(heap.length / 2) - 1; i >= 0; i--) {
        heapify(heap, i, heap.length);
    }
    const pop = (arr) => {
        const top = arr[0];
        arr[0] = arr[arr.length - 1];
        arr.pop();
        heapify(arr, 0, arr.length);
        return top;
    };
    const push = (arr, val) => {
        arr.push(val);
        let i = arr.length - 1;
        while (i > 0) {
            const parent = Math.floor((i - 1) / 2);
            if (arr[parent] < arr[i]) {
                [arr[parent], arr[i]] = [arr[i], arr[parent]];
                i = parent;
            } else {
                break;
            }
        }
    };
    let total = nums.reduce((a, b) => a + b, 0);
    const target = total / 2;
    let reduced = 0;
    let ops = 0;
    while (reduced < target) {
        const top = pop(heap);
        const half = top / 2;
        reduced += half;
        push(heap, half);
        ops++;
    }
    return ops;
};
