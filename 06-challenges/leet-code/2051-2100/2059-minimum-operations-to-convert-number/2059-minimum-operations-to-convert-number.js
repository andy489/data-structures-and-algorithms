// https://leetcode.com/problems/minimum-operations-to-convert-number/

// Solution: BFS — O(n*1000) time, O(1000) space
var minimumOperations = function(nums, start, goal) {
    const visited = new Array(1001).fill(false);
    visited[start] = true;
    const q = [[start, 0]];
    for (let qi = 0; qi < q.length; qi++) {
        const [cur, steps] = q[qi];
        for (const num of nums) {
            for (const nxt of [cur + num, cur - num, cur ^ num]) {
                if (nxt === goal) return steps + 1;
                if (nxt >= 0 && nxt <= 1000 && !visited[nxt]) { visited[nxt] = true; q.push([nxt, steps+1]); }
            }
        }
    }
    return -1;
};
