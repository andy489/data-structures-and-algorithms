// https://leetcode.com/problems/closest-room/

var closestRoom = function(rooms, queries) {
    const k = queries.length;
    const qIdx = Array.from({length: k}, (_, i) => i);
    qIdx.sort((a, b) => queries[b][1] - queries[a][1]);
    rooms.sort((a, b) => b[1] - a[1]);

    // Sorted array of room IDs (maintained sorted for binary search)
    const ids = [];
    const ans = new Array(k).fill(-1);
    let ri = 0;

    const insert = (val) => {
        let lo = 0, hi = ids.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (ids[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        ids.splice(lo, 0, val);
    };

    const findClosest = (preferred) => {
        let lo = 0, hi = ids.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (ids[mid] < preferred) lo = mid + 1;
            else hi = mid;
        }
        // lo = insertion point; check lo-1 and lo
        let best = -1, bestDiff = Infinity;
        for (const p of [lo - 1, lo]) {
            if (p >= 0 && p < ids.length) {
                const diff = Math.abs(ids[p] - preferred);
                if (diff < bestDiff || (diff === bestDiff && ids[p] > best)) {
                    bestDiff = diff;
                    best = ids[p];
                }
            }
        }
        return best;
    };

    for (const qi of qIdx) {
        const [preferred, minSize] = queries[qi];
        while (ri < rooms.length && rooms[ri][1] >= minSize) {
            insert(rooms[ri][0]);
            ri++;
        }
        if (ids.length > 0) {
            ans[qi] = findClosest(preferred);
        }
    }
    return ans;
};
