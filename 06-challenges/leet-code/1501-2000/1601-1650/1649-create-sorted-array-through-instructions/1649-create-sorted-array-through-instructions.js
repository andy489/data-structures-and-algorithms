// https://leetcode.com/problems/create-sorted-array-through-instructions/

var createSortedArray = function(instructions) {
    const MOD = 1_000_000_007n;
    const MAX = 100_001;
    const bit = new Int32Array(MAX + 1);

    const update = (i) => {
        for (; i <= MAX; i += i & -i) {
            bit[i]++;
        }
    };

    const query = (i) => {
        let s = 0;
        for (; i > 0; i -= i & -i) {
            s += bit[i];
        }
        return s;
    };

    let cost = 0n;
    for (let i = 0; i < instructions.length; i++) {
        const v = instructions[i];
        const less = query(v - 1);
        const greater = i - query(v);
        cost += BigInt(Math.min(less, greater));
        update(v);
    }
    return Number(cost % MOD);
};
