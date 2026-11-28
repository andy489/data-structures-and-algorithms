// https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/

var maxDistance = function(side, points, k) {
    const n = points.length;
    const perim = 4 * side;

    function toPos(x, y) {
        if (y === 0) return x;
        if (x === side) return side + y;
        if (y === side) return 2 * side + (side - x);
        return 3 * side + (side - y);
    }

    const pos = points.map(([x, y]) => toPos(x, y)).sort((a, b) => a - b);

    function canPlace(d) {
        for (let start = 0; start < n; start++) {
            let count = 1;
            let last = pos[start];
            for (let i = start + 1; i < start + n; i++) {
                const cur = pos[i % n];
                const gap = ((cur - last) % perim + perim) % perim;
                if (gap >= d) {
                    count++;
                    last = cur;
                }
            }
            if (count >= k) return true;
        }
        return false;
    }

    let lo = 1, hi = 2 * side, ans = 0;
    while (lo <= hi) {
        const mid = Math.floor((lo + hi) / 2);
        if (canPlace(mid)) {
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return ans;
};
