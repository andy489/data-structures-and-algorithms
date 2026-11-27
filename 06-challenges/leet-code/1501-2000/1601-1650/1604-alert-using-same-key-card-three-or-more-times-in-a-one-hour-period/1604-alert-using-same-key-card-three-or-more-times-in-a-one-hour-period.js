// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

var alertNames = function(keyName, keyTime) {
    const timeMap = new Map();
    for (let i = 0; i < keyName.length; i++) {
        const [h, m] = keyTime[i].split(':').map(Number);
        const mins = h * 60 + m;
        if (!timeMap.has(keyName[i])) {
            timeMap.set(keyName[i], []);
        }
        timeMap.get(keyName[i]).push(mins);
    }
    const alerted = [];
    for (const [name, times] of timeMap) {
        times.sort((a, b) => a - b);
        for (let j = 2; j < times.length; j++) {
            if (times[j] - times[j - 2] <= 60) {
                alerted.push(name);
                break;
            }
        }
    }
    return alerted.sort();
};
