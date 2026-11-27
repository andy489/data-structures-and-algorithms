// https://leetcode.com/problems/exclusive-time-of-functions/

var exclusiveTime = function(n, logs) {
    const time = new Array(n).fill(0);
    const stack = [];
    let prevTime = 0;
    for (const log of logs) {
        const parts = log.split(":");
        const id = parseInt(parts[0]);
        const type = parts[1];
        const ts = parseInt(parts[2]);
        if (type === "start") {
            if (stack.length > 0) {
                time[stack[stack.length - 1]] += ts - prevTime;
            }
            stack.push(id);
            prevTime = ts;
        } else {
            time[stack.pop()] += ts - prevTime + 1;
            prevTime = ts + 1;
        }
    }
    return time;
};
