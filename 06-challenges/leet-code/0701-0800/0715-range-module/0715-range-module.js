// https://leetcode.com/problems/range-module/

class RangeModule {
    constructor() {
        this.intervals = [];
    }

    addRange(left, right) {
        const merged = [];
        let inserted = false;
        for (const [l, r] of this.intervals) {
            if (r < left) {
                merged.push([l, r]);
            } else if (l > right) {
                if (!inserted) {
                    merged.push([left, right]);
                    inserted = true;
                }
                merged.push([l, r]);
            } else {
                left = Math.min(left, l);
                right = Math.max(right, r);
            }
        }
        if (!inserted) merged.push([left, right]);
        this.intervals = merged;
    }

    queryRange(left, right) {
        for (const [l, r] of this.intervals) {
            if (l <= left && r >= right) return true;
        }
        return false;
    }

    removeRange(left, right) {
        const result = [];
        for (const [l, r] of this.intervals) {
            if (r <= left || l >= right) {
                result.push([l, r]);
            } else {
                if (l < left) result.push([l, left]);
                if (r > right) result.push([right, r]);
            }
        }
        this.intervals = result;
    }
}
