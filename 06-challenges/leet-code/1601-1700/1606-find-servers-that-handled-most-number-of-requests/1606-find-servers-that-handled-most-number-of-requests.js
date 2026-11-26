// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

var busiestServers = function(k, arrival, load) {
    const count = new Array(k).fill(0);
    // Use sorted arrays; for large k a proper sorted set would be O(log k) per op
    // Here we simulate with a min-heap for busy and sorted set for available
    const available = [];
    for (let i = 0; i < k; i++) {
        available.push(i);
    }
    // busy: [finishTime, serverIndex]
    const busy = new MinHeap();

    for (let i = 0; i < arrival.length; i++) {
        const t = arrival[i];
        while (!busy.isEmpty() && busy.peek()[0] <= t) {
            const [, server] = busy.pop();
            insertSorted(available, server);
        }
        if (available.length === 0) {
            continue;
        }
        const preferred = i % k;
        let idx = lowerBound(available, preferred);
        if (idx === available.length) {
            idx = 0;
        }
        const server = available.splice(idx, 1)[0];
        count[server]++;
        busy.push([t + load[i], server]);
    }

    const maxCount = Math.max(...count);
    return count.reduce((res, c, i) => {
        if (c === maxCount) {
            res.push(i);
        }
        return res;
    }, []);
};

function lowerBound(arr, target) {
    let lo = 0, hi = arr.length;
    while (lo < hi) {
        const mid = (lo + hi) >>> 1;
        if (arr[mid] < target) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return lo;
}

function insertSorted(arr, val) {
    const idx = lowerBound(arr, val);
    arr.splice(idx, 0, val);
}

class MinHeap {
    constructor() {
        this.data = [];
    }
    isEmpty() {
        return this.data.length === 0;
    }
    peek() {
        return this.data[0];
    }
    push(val) {
        this.data.push(val);
        this._bubbleUp(this.data.length - 1);
    }
    pop() {
        const top = this.data[0];
        const last = this.data.pop();
        if (this.data.length > 0) {
            this.data[0] = last;
            this._sinkDown(0);
        }
        return top;
    }
    _bubbleUp(i) {
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this.data[p][0] > this.data[i][0]) {
                [this.data[p], this.data[i]] = [this.data[i], this.data[p]];
                i = p;
            } else {
                break;
            }
        }
    }
    _sinkDown(i) {
        const n = this.data.length;
        while (true) {
            let smallest = i;
            const l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && this.data[l][0] < this.data[smallest][0]) {
                smallest = l;
            }
            if (r < n && this.data[r][0] < this.data[smallest][0]) {
                smallest = r;
            }
            if (smallest !== i) {
                [this.data[smallest], this.data[i]] = [this.data[i], this.data[smallest]];
                i = smallest;
            } else {
                break;
            }
        }
    }
}
