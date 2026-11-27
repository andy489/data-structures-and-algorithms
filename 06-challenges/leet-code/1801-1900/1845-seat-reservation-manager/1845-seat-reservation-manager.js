// https://leetcode.com/problems/seat-reservation-manager/

class SeatManager {
    constructor(n) {
        this._heap = [];
        for (let i = 1; i <= n; i++) {
            this._heap.push(i);
        }
        // heap is already sorted 1..n, which is a valid min-heap
    }

    reserve() {
        return this._heapPop();
    }

    unreserve(seatNumber) {
        this._heapPush(seatNumber);
    }

    _heapPush(val) {
        this._heap.push(val);
        let i = this._heap.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this._heap[p] <= this._heap[i]) break;
            [this._heap[p], this._heap[i]] = [this._heap[i], this._heap[p]];
            i = p;
        }
    }

    _heapPop() {
        const top = this._heap[0];
        const last = this._heap.pop();
        if (this._heap.length) {
            this._heap[0] = last;
            let i = 0;
            const n = this._heap.length;
            while (true) {
                let s = i, l = 2*i+1, r = 2*i+2;
                if (l < n && this._heap[l] < this._heap[s]) s = l;
                if (r < n && this._heap[r] < this._heap[s]) s = r;
                if (s === i) break;
                [this._heap[s], this._heap[i]] = [this._heap[i], this._heap[s]];
                i = s;
            }
        }
        return top;
    }
}
