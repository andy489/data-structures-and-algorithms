// https://leetcode.com/problems/finding-mk-average/

class MKAverage {
    constructor(m, k) {
        this.m = m;
        this.k = k;
        this.window = [];
        this.sorted = [];  // maintain sorted window
        this.middleSum = 0;
    }

    _insertSorted(arr, val) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        arr.splice(lo, 0, val);
    }

    _removeSorted(arr, val) {
        let lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] === val) { arr.splice(mid, 1); return; }
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
    }

    addElement(num) {
        this.window.push(num);
        this._insertSorted(this.sorted, num);
        if (this.window.length > this.m) {
            const old = this.window.shift();
            this._removeSorted(this.sorted, old);
        }
        if (this.sorted.length === this.m) {
            this.middleSum = 0;
            for (let i = this.k; i < this.m - this.k; i++) {
                this.middleSum += this.sorted[i];
            }
        }
    }

    calculateMKAverage() {
        if (this.window.length < this.m) return -1;
        return Math.floor(this.middleSum / (this.m - 2 * this.k));
    }
}
