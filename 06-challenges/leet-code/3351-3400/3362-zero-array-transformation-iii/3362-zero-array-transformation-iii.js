// https://leetcode.com/problems/zero-array-transformation-iii/

// Solution: Greedy + Max-Heap (Sweep Line) — O((n + q) log q) time, O(n + q) space
var maxRemoval = function(nums, queries) {
    const n = nums.length;
    const q = queries.length;
    const byLeft = Array.from({length: n + 1}, () => []);
    for (const [l, r] of queries) {
        byLeft[l].push(r);
    }

    // Max-heap using a simple sorted structure — use a priority queue
    // JS doesn't have a built-in heap; implement a max-heap
    const heap = [];

    function heapPush(val) {
        heap.push(val);
        let i = heap.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (heap[p] < heap[i]) {
                [heap[p], heap[i]] = [heap[i], heap[p]];
                i = p;
            } else {
                break;
            }
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
                if (largest !== i) {
                    [heap[largest], heap[i]] = [heap[i], heap[largest]];
                    i = largest;
                } else {
                    break;
                }
            }
        }
        return top;
    }

    const diff = new Array(n + 1).fill(0);
    let coverage = 0;
    let used = 0;

    for (let i = 0; i < n; i++) {
        coverage += diff[i];
        for (const r of byLeft[i]) {
            heapPush(r);
        }
        while (coverage < nums[i]) {
            if (heap.length === 0 || heap[0] < i) {
                return -1;
            }
            const r = heapPop();
            diff[i]++;
            diff[r + 1]--;
            coverage++;
            used++;
        }
    }
    return q - used;
};
