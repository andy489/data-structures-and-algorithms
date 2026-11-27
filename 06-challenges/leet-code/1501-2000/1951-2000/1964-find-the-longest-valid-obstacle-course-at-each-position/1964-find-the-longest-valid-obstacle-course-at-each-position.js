// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
var longestObstacleCourseAtEachPosition = function(obstacles) {
    const tails = [];
    const ans = [];

    for (const h of obstacles) {
        let lo = 0, hi = tails.length;
        while (lo < hi) {
            const mid = (lo + hi) >>> 1;
            if (tails[mid] <= h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        tails[lo] = h;
        ans.push(lo + 1);
    }
    return ans;
};
