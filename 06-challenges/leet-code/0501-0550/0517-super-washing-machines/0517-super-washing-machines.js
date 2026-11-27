// https://leetcode.com/problems/super-washing-machines/

var findMinMoves = function(machines) {
    const total = machines.reduce((a, b) => a + b, 0);
    const n = machines.length;
    if (total % n !== 0) return -1;
    const avg = total / n;
    let ans = 0, prefixSum = 0;
    for (const m of machines) {
        const balance = m - avg;
        prefixSum += balance;
        ans = Math.max(ans, Math.abs(prefixSum), balance);
    }
    return ans;
};
