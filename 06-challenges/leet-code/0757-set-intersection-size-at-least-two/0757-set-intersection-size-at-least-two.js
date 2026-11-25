// https://leetcode.com/problems/set-intersection-size-at-least-two/

var intersectionSizeTwo = function(intervals) {
    intervals.sort((a, b) => a[1] !== b[1] ? a[1] - b[1] : b[0] - a[0]);
    let count = 0, p1 = -1, p2 = -1;
    for (const [s, e] of intervals) {
        if (s > p1) { count += 2; p2 = e - 1; p1 = e; }
        else if (s > p2) { count++; p2 = p1; p1 = e; }
    }
    return count;
};
