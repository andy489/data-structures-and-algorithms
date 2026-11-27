// https://leetcode.com/problems/detect-squares/

// Solution: HashMap — O(n) time per count, O(n) space
class DetectSquares {
    constructor() {
        this.rowPoints = new Map();
        this.pointCount = new Map();
    }
    add(point) {
        const [x, y] = point;
        if (!this.rowPoints.has(y)) this.rowPoints.set(y, new Map());
        const row = this.rowPoints.get(y);
        row.set(x, (row.get(x) || 0) + 1);
        const key = y * 1001 + x;
        this.pointCount.set(key, (this.pointCount.get(key) || 0) + 1);
    }
    count(point) {
        const [px, py] = point;
        let res = 0;
        const row = this.rowPoints.get(py);
        if (!row) return 0;
        for (const [x1, cnt] of row) {
            if (x1 === px) continue;
            const side = Math.abs(x1 - px);
            for (const ny of [py + side, py - side]) {
                res += cnt * (this.pointCount.get(ny * 1001 + px) || 0) * (this.pointCount.get(ny * 1001 + x1) || 0);
            }
        }
        return res;
    }
}
