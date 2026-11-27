// https://leetcode.com/problems/minimize-deviation-in-array/

var minimumDeviation = function(nums) {
    // Max heap via negation with a sorted array approach
    const heap = [];
    let minVal = Infinity;
    for (let num of nums) {
        const val = num % 2 === 1 ? num * 2 : num;
        heap.push(val);
        minVal = Math.min(minVal, val);
    }
    // Use a simple max-heap (priority queue)
    heap.sort((a, b) => b - a);

    function heapPush(val) {
        heap.push(val);
        let i = heap.length - 1;
        while (i > 0) {
            const parent = (i - 1) >> 1;
            if (heap[parent] >= heap[i]) {
                break;
            }
            [heap[parent], heap[i]] = [heap[i], heap[parent]];
            i = parent;
        }
    }

    function heapPop() {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let largest = i;
                const l = 2 * i + 1, r = 2 * i + 2;
                if (l < heap.length && heap[l] > heap[largest]) {
                    largest = l;
                }
                if (r < heap.length && heap[r] > heap[largest]) {
                    largest = r;
                }
                if (largest === i) {
                    break;
                }
                [heap[i], heap[largest]] = [heap[largest], heap[i]];
                i = largest;
            }
        }
        return top;
    }

    // Build proper max-heap
    heap.sort((a, b) => b - a);
    // Re-heapify properly
    const arr = [...heap];
    arr.sort((a, b) => b - a);

    let minDev = arr[0] - minVal;
    while (arr[0] % 2 === 0) {
        const maxVal = arr.shift();
        minDev = Math.min(minDev, maxVal - minVal);
        const newVal = maxVal / 2;
        minVal = Math.min(minVal, newVal);
        // Insert newVal back and re-sort (simple but O(n log n) per step)
        arr.push(newVal);
        arr.sort((a, b) => b - a);
    }
    return Math.min(minDev, arr[0] - minVal);
};
