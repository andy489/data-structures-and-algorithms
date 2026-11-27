// https://leetcode.com/problems/find-right-interval/

var findRightInterval = function(intervals) {
    const starts = intervals
        .map(([start], i) => [start, i])
        .sort((a, b) => a[0] - b[0]);
    const startVals = starts.map(([s]) => s);

    function binarySearch(target) {
        let lo = 0, hi = startVals.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (startVals[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    return intervals.map(([, end]) => {
        const pos = binarySearch(end);
        return pos < starts.length ? starts[pos][1] : -1;
    });
};
