// https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/

/**
 * @param {number[][]} rectangles
 * @param {number[][]} points
 * @return {number[]}
 */
var countRectangles = function (rectangles, points) {
    const byHeight = Array.from({ length: 101 }, () => []);
    for (const [l, h] of rectangles) {
        byHeight[h].push(l);
    }
    for (let h = 1; h <= 100; h++) {
        byHeight[h].sort((a, b) => a - b);
    }

    function lowerBound(arr, target) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    const ans = [];
    for (const [x, y] of points) {
        let cnt = 0;
        for (let h = y; h <= 100; h++) {
            const lengths = byHeight[h];
            const idx = lowerBound(lengths, x);
            cnt += lengths.length - idx;
        }
        ans.push(cnt);
    }
    return ans;
};
