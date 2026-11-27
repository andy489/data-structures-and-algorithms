// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

var checkValidCuts = function(n, rectangles) {
    const hasEnoughGaps = (axis) => {
        const intervals = rectangles.map(r => [r[axis], r[axis + 2]]);
        intervals.sort((a, b) => a[0] - b[0]);
        let gaps = 0, maxEnd = intervals[0][1];
        for (let i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= maxEnd) {
                gaps++;
                if (gaps >= 2) {
                    return true;
                }
            }
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }
        return false;
    };
    return hasEnoughGaps(1) || hasEnoughGaps(0);
};
