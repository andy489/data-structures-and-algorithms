// https://leetcode.com/problems/range-frequency-queries/

// Solution: Binary Search on Precomputed Indices — O(n) build, O(log n) query
class RangeFreqQuery {
    constructor(arr) {
        this.indices = new Map();
        for (let i = 0; i < arr.length; i++) {
            if (!this.indices.has(arr[i])) this.indices.set(arr[i], []);
            this.indices.get(arr[i]).push(i);
        }
    }
    query(left, right, value) {
        const list = this.indices.get(value) || [];
        const bs = (v, lo) => { let hi = list.length; while (lo < hi) { const m = (lo+hi)>>1; list[m]<v?lo=m+1:hi=m; } return lo; };
        const bsr = (v, lo) => { let hi = list.length; while (lo < hi) { const m = (lo+hi)>>1; list[m]<=v?lo=m+1:hi=m; } return lo; };
        return bsr(right, bs(left, 0)) - bs(left, 0);
    }
}
