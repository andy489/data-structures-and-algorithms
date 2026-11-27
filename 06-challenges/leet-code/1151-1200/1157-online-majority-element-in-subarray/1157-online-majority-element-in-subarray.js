// https://leetcode.com/problems/online-majority-element-in-subarray/

class MajorityChecker {
    constructor(arr) {
        this.n = arr.length;
        this.candidate = new Int32Array(4 * this.n);
        this.count = new Int32Array(4 * this.n);
        this.positions = new Map();
        for (let i = 0; i < arr.length; i++) {
            if (!this.positions.has(arr[i])) {
                this.positions.set(arr[i], []);
            }
            this.positions.get(arr[i]).push(i);
        }
        this._build(arr, 1, 0, this.n - 1);
    }

    _build(arr, node, l, r) {
        if (l === r) {
            this.candidate[node] = arr[l];
            this.count[node] = 1;
            return;
        }
        const mid = (l + r) >> 1;
        this._build(arr, 2 * node, l, mid);
        this._build(arr, 2 * node + 1, mid + 1, r);
        this._merge(node);
    }

    _merge(node) {
        const lc = this.candidate[2 * node], rc = this.candidate[2 * node + 1];
        const lv = this.count[2 * node], rv = this.count[2 * node + 1];
        if (lc === rc) {
            this.candidate[node] = lc;
            this.count[node] = lv + rv;
        } else if (lv >= rv) {
            this.candidate[node] = lc;
            this.count[node] = lv - rv;
        } else {
            this.candidate[node] = rc;
            this.count[node] = rv - lv;
        }
    }

    _query(node, l, r, ql, qr) {
        if (ql <= l && r <= qr) {
            return [this.candidate[node], this.count[node]];
        }
        const mid = (l + r) >> 1;
        if (qr <= mid) {
            return this._query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return this._query(2 * node + 1, mid + 1, r, ql, qr);
        }
        const [lc, lv] = this._query(2 * node, l, mid, ql, qr);
        const [rc, rv] = this._query(2 * node + 1, mid + 1, r, ql, qr);
        if (lc === rc) {
            return [lc, lv + rv];
        } else if (lv >= rv) {
            return [lc, lv - rv];
        } else {
            return [rc, rv - lv];
        }
    }

    query(left, right, threshold) {
        const [cand] = this._query(1, 0, this.n - 1, left, right);
        const pos = this.positions.get(cand) || [];
        const lo = lowerBound(pos, left);
        const hi = upperBound(pos, right);
        return (hi - lo >= threshold) ? cand : -1;
    }
}

function lowerBound(arr, target) {
    let lo = 0, hi = arr.length;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (arr[mid] < target) { lo = mid + 1; } else { hi = mid; }
    }
    return lo;
}

function upperBound(arr, target) {
    let lo = 0, hi = arr.length;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (arr[mid] <= target) { lo = mid + 1; } else { hi = mid; }
    }
    return lo;
}
