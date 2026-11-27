// https://leetcode.com/problems/the-skyline-problem/

// Solution: Sweep Line + lazy-deletion max-heap — O(n log n) time, O(n) space
var getSkyline = function(buildings) {
    const events = [];
    for (const [l, r, h] of buildings) {
        events.push([l, -h, r]);
        events.push([r, 0, 0]);
    }
    events.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]);

    // Min-heap storing [-height, rightEdge] — simulate max-heap with negatives
    // JS has no built-in heap; use sorted array for correctness (n <= 1e4)
    const active = [[0, Infinity]]; // [negHeight, rightEdge]
    let prevMax = 0;
    const result = [];

    function heapPush(arr, val) {
        arr.push(val);
        let i = arr.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (arr[p][0] <= arr[i][0]) break;
            [arr[p], arr[i]] = [arr[i], arr[p]];
            i = p;
        }
    }

    function heapPop(arr) {
        const top = arr[0];
        const last = arr.pop();
        if (arr.length > 0) {
            arr[0] = last;
            let i = 0;
            while (true) {
                let smallest = i;
                const l = 2 * i + 1, r = 2 * i + 2;
                if (l < arr.length && arr[l][0] < arr[smallest][0]) smallest = l;
                if (r < arr.length && arr[r][0] < arr[smallest][0]) smallest = r;
                if (smallest === i) break;
                [arr[i], arr[smallest]] = [arr[smallest], arr[i]];
                i = smallest;
            }
        }
        return top;
    }

    for (const [x, h, r] of events) {
        if (h < 0) heapPush(active, [h, r]);
        while (active[0][1] <= x) heapPop(active);
        const currMax = -active[0][0];
        if (currMax !== prevMax) {
            result.push([x, currMax]);
            prevMax = currMax;
        }
    }
    return result;
};
