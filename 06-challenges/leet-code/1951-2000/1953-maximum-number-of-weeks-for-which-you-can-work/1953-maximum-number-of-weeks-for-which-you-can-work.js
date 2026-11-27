// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
var numberOfWeeks = function(milestones) {
    let max = 0n, rest = 0n;
    for (const m of milestones) {
        const bm = BigInt(m);
        if (bm > max) {
            max = bm;
        }
        rest += bm;
    }
    rest -= max;
    if (max <= rest + 1n) {
        return Number(max + rest);
    } else {
        return Number(2n * rest + 1n);
    }
};
