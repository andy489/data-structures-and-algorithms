// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/
/**
 * @param {number} eventTime
 * @param {number} k
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @return {number}
 */
var maxFreeTime = function(eventTime, k, startTime, endTime) {
    const n = startTime.length;
    const gaps = new Array(n + 1);
    gaps[0] = startTime[0];
    for (let i = 1; i < n; i++) {
        gaps[i] = startTime[i] - endTime[i - 1];
    }
    gaps[n] = eventTime - endTime[n - 1];

    const windowSize = k + 1;
    let windowSum = 0;
    for (let i = 0; i < windowSize; i++) {
        windowSum += gaps[i];
    }
    let maxFree = windowSum;
    for (let i = windowSize; i <= n; i++) {
        windowSum += gaps[i] - gaps[i - windowSize];
        if (windowSum > maxFree) {
            maxFree = windowSum;
        }
    }
    return maxFree;
};
