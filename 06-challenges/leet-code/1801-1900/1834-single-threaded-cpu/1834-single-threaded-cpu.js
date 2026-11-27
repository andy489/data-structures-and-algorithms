// https://leetcode.com/problems/single-threaded-cpu/

var getOrder = function(tasks) {
    const n = tasks.length;
    const indexed = tasks.map((t, i) => [t[0], t[1], i]);
    indexed.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[2] - b[2]);

    // Min-heap by [processingTime, originalIndex]
    class MinHeap {
        constructor() { this.h = []; }
        push(val) {
            this.h.push(val);
            this._up(this.h.length - 1);
        }
        pop() {
            const top = this.h[0];
            const last = this.h.pop();
            if (this.h.length) { this.h[0] = last; this._down(0); }
            return top;
        }
        get size() { return this.h.length; }
        _cmp(a, b) { return a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]; }
        _up(i) {
            while (i > 0) {
                const p = (i - 1) >> 1;
                if (this._cmp(this.h[p], this.h[i]) <= 0) break;
                [this.h[p], this.h[i]] = [this.h[i], this.h[p]];
                i = p;
            }
        }
        _down(i) {
            const n = this.h.length;
            while (true) {
                let s = i, l = 2*i+1, r = 2*i+2;
                if (l < n && this._cmp(this.h[l], this.h[s]) < 0) s = l;
                if (r < n && this._cmp(this.h[r], this.h[s]) < 0) s = r;
                if (s === i) break;
                [this.h[s], this.h[i]] = [this.h[i], this.h[s]];
                i = s;
            }
        }
    }

    const pq = new MinHeap();
    const result = [];
    let time = 0, idx = 0;

    while (result.length < n) {
        while (idx < n && indexed[idx][0] <= time) {
            pq.push([indexed[idx][1], indexed[idx][2]]);
            idx++;
        }
        if (pq.size === 0) {
            time = indexed[idx][0];
            continue;
        }
        const [proc, orig] = pq.pop();
        result.push(orig);
        time += proc;
    }
    return result;
};
