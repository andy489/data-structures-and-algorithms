// https://leetcode.com/problems/split-array-with-same-average/

var splitArraySameAverage = function(nums) {
    const n = nums.length;
    const total = nums.reduce((a, b) => a + b, 0);
    let possible = false;
    for (let k = 1; k <= Math.floor(n / 2); k++) {
        if ((total * k) % n === 0) { possible = true; break; }
    }
    if (!possible) { return false; }
    const half = Math.floor(n / 2);
    const left = Array.from({length: half + 1}, () => new Set());
    left[0].add(0);
    for (let i = 0; i < half; i++) {
        for (let k = i; k >= 0; k--) {
            for (const s of left[k]) {
                left[k + 1].add(s + nums[i]);
            }
        }
    }
    for (let k = 1; k <= half; k++) {
        if ((total * k) % n === 0 && left[k].has(total * k / n)) { return true; }
    }
    const right = Array.from({length: n - half + 1}, () => new Set());
    right[0].add(0);
    for (let i = half; i < n; i++) {
        for (let k = i - half; k >= 0; k--) {
            for (const s of right[k]) {
                right[k + 1].add(s + nums[i]);
            }
        }
    }
    for (let lk = 1; lk <= half; lk++) {
        for (let rk = 1; rk <= n - half; rk++) {
            const tk = lk + rk;
            if (tk > Math.floor(n / 2) || (total * tk) % n !== 0) { continue; }
            const need = total * tk / n;
            for (const ls of left[lk]) {
                if (right[rk].has(need - ls)) { return true; }
            }
        }
    }
    return false;
};
