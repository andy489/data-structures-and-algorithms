// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
var numberOfWays = function(corridor) {
    const MOD = 1_000_000_007n;
    const seatIndices = [];
    for (let i = 0; i < corridor.length; i++) {
        if (corridor[i] === 'S') {
            seatIndices.push(i);
        }
    }
    const total = seatIndices.length;
    if (total === 0 || total % 2 !== 0) {
        return 0;
    }
    let result = 1n;
    for (let i = 1; i < total / 2; i++) {
        const gap = BigInt(seatIndices[2 * i] - seatIndices[2 * i - 1]);
        result = (result * gap) % MOD;
    }
    return Number(result);
};
