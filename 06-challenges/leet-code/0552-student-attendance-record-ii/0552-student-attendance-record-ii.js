// https://leetcode.com/problems/student-attendance-record-ii/
// Solution: DP with 6 states — O(n) time, O(1) space
var checkRecord = function(n) {
    const MOD = 1_000_000_007n;
    let a0l0 = 1n, a0l1 = 0n, a0l2 = 0n;
    let a1l0 = 0n, a1l1 = 0n, a1l2 = 0n;
    for (let i = 0; i < n; i++) {
        const na0l0 = (a0l0 + a0l1 + a0l2) % MOD;
        const na0l1 = a0l0;
        const na0l2 = a0l1;
        const na1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD;
        const na1l1 = a1l0;
        const na1l2 = a1l1;
        [a0l0, a0l1, a0l2] = [na0l0, na0l1, na0l2];
        [a1l0, a1l1, a1l2] = [na1l0, na1l1, na1l2];
    }
    return Number((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD);
};
