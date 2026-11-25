// https://leetcode.com/problems/24-game/

var judgePoint24 = function(cards) {
    function solve(nums) {
        if (nums.length === 1) return Math.abs(nums[0] - 24) < 1e-6;
        for (let i = 0; i < nums.length; i++) {
            for (let j = 0; j < nums.length; j++) {
                if (i === j) continue;
                const rest = nums.filter((_, k) => k !== i && k !== j);
                const a = nums[i], b = nums[j];
                const ops = [a + b, a - b, a * b];
                if (b !== 0) ops.push(a / b);
                for (const c of ops) {
                    if (solve([...rest, c])) return true;
                }
            }
        }
        return false;
    }
    return solve(cards.map(Number));
};
