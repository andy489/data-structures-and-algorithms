// https://leetcode.com/problems/snapshot-array/

class SnapshotArray {
    constructor(length) {
        this.history = Array.from({length}, () => [[0, 0]]);
        this.snapId = 0;
    }

    set(index, val) {
        const h = this.history[index];
        if (h[h.length - 1][0] === this.snapId) {
            h[h.length - 1][1] = val;
        } else {
            h.push([this.snapId, val]);
        }
    }

    snap() {
        return this.snapId++;
    }

    get(index, snap_id) {
        const h = this.history[index];
        let lo = 0, hi = h.length - 1;
        while (lo < hi) {
            const mid = (lo + hi + 1) >> 1;
            if (h[mid][0] <= snap_id) { lo = mid; } else { hi = mid - 1; }
        }
        return h[lo][1];
    }
}
