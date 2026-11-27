// https://leetcode.com/problems/minimum-time-to-complete-all-tasks/
/**
 * @param {number[][]} tasks
 * @return {number}
 */
var findMinimumTime = function(tasks) {
    tasks.sort((a, b) => a[1] - b[1]);
    const running = new Array(2001).fill(false);
    let total = 0;
    for (const [start, end, duration] of tasks) {
        let dur = duration;
        for (let t = start; t <= end; t++) {
            if (running[t]) {
                dur--;
            }
        }
        for (let t = end; t >= start && dur > 0; t--) {
            if (!running[t]) {
                running[t] = true;
                dur--;
                total++;
            }
        }
    }
    return total;
};
