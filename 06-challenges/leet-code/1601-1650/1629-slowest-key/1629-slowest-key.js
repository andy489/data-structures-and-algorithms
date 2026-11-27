// https://leetcode.com/problems/slowest-key/

var slowestKey = function(releaseTimes, keysPressed) {
    let maxDur = releaseTimes[0];
    let ans = keysPressed[0];
    for (let i = 1; i < releaseTimes.length; i++) {
        const dur = releaseTimes[i] - releaseTimes[i - 1];
        const key = keysPressed[i];
        if (dur > maxDur || (dur === maxDur && key > ans)) {
            maxDur = dur;
            ans = key;
        }
    }
    return ans;
};
