// https://leetcode.com/problems/car-fleet-ii/

var getCollisionTimes = function(cars) {
    const n = cars.length;
    const ans = new Array(n).fill(-1);
    const stack = [];
    for (let i = n - 1; i >= 0; i--) {
        const [pos, speed] = cars[i];
        while (stack.length > 0) {
            const j = stack[stack.length - 1];
            const [posJ, speedJ] = cars[j];
            if (speed <= speedJ) {
                stack.pop();
                continue;
            }
            const t = (posJ - pos) / (speed - speedJ);
            if (ans[j] !== -1 && t >= ans[j]) {
                stack.pop();
                continue;
            }
            ans[i] = t;
            break;
        }
        stack.push(i);
    }
    return ans;
};
