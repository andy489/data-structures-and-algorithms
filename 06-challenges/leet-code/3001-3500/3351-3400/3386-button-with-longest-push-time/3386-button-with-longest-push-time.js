// https://leetcode.com/problems/button-with-longest-push-time/

var buttonWithLongestTime = function(events) {
    let bestIdx = events[0][0], bestTime = events[0][1];
    for (let i = 1; i < events.length; i++) {
        const duration = events[i][1] - events[i - 1][1];
        if (duration > bestTime || (duration === bestTime && events[i][0] < bestIdx)) {
            bestTime = duration;
            bestIdx = events[i][0];
        }
    }
    return bestIdx;
};
