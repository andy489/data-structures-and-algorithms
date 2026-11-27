// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
var minStoneSum = function(piles, k) {
    const heap = new MaxHeap();
    let total = 0;
    for (const p of piles) {
        heap.push(p);
        total += p;
    }
    for (let i = 0; i < k; i++) {
        const top = heap.pop();
        const remove = Math.floor(top / 2);
        total -= remove;
        heap.push(top - remove);
    }
    return total;
};

class MaxHeap {
    constructor() {
        this.data = [];
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
            const parent = (i - 1) >> 1;
            if (this.data[parent] < this.data[i]) {
                [this.data[parent], this.data[i]] = [this.data[i], this.data[parent]];
                i = parent;
            } else {
                break;
            }
        }
    }
    _sinkDown(i) {
        const n = this.data.length;
        while (true) {
            let largest = i;
            const l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && this.data[l] > this.data[largest]) {
                largest = l;
            }
            if (r < n && this.data[r] > this.data[largest]) {
                largest = r;
            }
            if (largest !== i) {
                [this.data[largest], this.data[i]] = [this.data[i], this.data[largest]];
                i = largest;
            } else {
                break;
            }
        }
    }
}
