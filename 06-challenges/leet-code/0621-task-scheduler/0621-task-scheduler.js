// https://leetcode.com/problems/task-scheduler/

var leastInterval = function(tasks, n) {
    const freq = new Array(26).fill(0);
    for (const task of tasks) {
        freq[task.charCodeAt(0) - 65]++;
    }
    const maxFreq = Math.max(...freq);
    const maxCount = freq.filter(f => f === maxFreq).length;
    return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
};
