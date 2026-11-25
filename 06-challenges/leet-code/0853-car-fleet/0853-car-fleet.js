// https://leetcode.com/problems/car-fleet/

var carFleet = function(target, position, speed) {
    const n = position.length;
    const pairs = position.map((p, i) => [p, speed[i]]).sort((a, b) => b[0] - a[0]);
    const stack = [];
    for (const [pos, spd] of pairs) {
        const time = (target - pos) / spd;
        if (!stack.length || time > stack[stack.length - 1]) {
            stack.push(time);
        }
    }
    return stack.length;
};
