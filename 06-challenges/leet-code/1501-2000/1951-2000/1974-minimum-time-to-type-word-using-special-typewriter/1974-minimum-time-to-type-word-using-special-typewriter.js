// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

// Solution: Greedy — O(n) time, O(1) space
var minTimeToType = function(word) {
    let time = 0;
    let cur = 0;
    for (const c of word) {
        const next = c.charCodeAt(0) - 97;
        const diff = Math.abs(cur - next);
        time += Math.min(diff, 26 - diff) + 1;
        cur = next;
    }
    return time;
};
