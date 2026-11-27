// https://leetcode.com/problems/elimination-game/

// Solution: Track Head — O(log n) time, O(1) space
var lastRemaining = function(n) {
    let head = 1, step = 1, remaining = n, left = true;
    while (remaining > 1) {
        if (left || remaining % 2 === 1) head += step;
        remaining = Math.floor(remaining / 2);
        step *= 2;
        left = !left;
    }
    return head;
};
