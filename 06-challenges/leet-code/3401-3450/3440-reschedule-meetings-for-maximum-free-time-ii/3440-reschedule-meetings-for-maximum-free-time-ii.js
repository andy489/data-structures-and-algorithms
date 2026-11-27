// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/
/**
 * @param {number} eventTime
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @return {number}
 */
var maxFreeTime = function(eventTime, startTime, endTime) {
    const n = startTime.length;
    const gaps = new Array(n + 1);
    gaps[0] = startTime[0];
    for (let i = 1; i < n; i++) {
        gaps[i] = startTime[i] - endTime[i - 1];
    }
    gaps[n] = eventTime - endTime[n - 1];

    const duration = startTime.map((s, i) => endTime[i] - s);

    const prefixMax = new Array(n + 2).fill(0);
    for (let i = 1; i <= n + 1; i++) {
        prefixMax[i] = Math.max(prefixMax[i - 1], gaps[i - 1]);
    }

    const suffixMax = new Array(n + 2).fill(0);
    for (let i = n; i >= 0; i--) {
        suffixMax[i] = Math.max(suffixMax[i + 1], gaps[i]);
    }

    let ans = 0;
    for (let i = 0; i < n; i++) {
        const merged = gaps[i] + duration[i] + gaps[i + 1];
        const bestOther = Math.max(prefixMax[i], suffixMax[i + 2]);
        if (bestOther >= duration[i]) {
            ans = Math.max(ans, merged);
        } else {
            ans = Math.max(ans, gaps[i] + gaps[i + 1]);
        }
    }
    return ans;
};
