// https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/

var subsequencesWithAUniqueMiddleMode = function(nums) {
    const MOD = 1_000_000_007n;
    const n = nums.length;
    let ans = 0n;
    const leftMap = new Map();

    const comb = (n, r) => {
        if (r < 0 || r > n) { return 0n; }
        if (r === 0 || r === n) { return 1n; }
        if (r === 1) { return BigInt(n); }
        if (r === 2) { return BigInt(n) * BigInt(n - 1) / 2n; }
        return 0n;
    };

    for (let mid = 2; mid < n - 2; mid++) {
        const prev = nums[mid - 1];
        leftMap.set(prev, (leftMap.get(prev) || 0) + 1);

        const m = nums[mid];
        const lm = leftMap.get(m) || 0;
        const lt = mid;

        const rightMap = new Map();
        for (let j = mid + 1; j < n; j++) {
            rightMap.set(nums[j], (rightMap.get(nums[j]) || 0) + 1);
        }
        const rm = rightMap.get(m) || 0;
        const rt = n - mid - 1;

        const total = comb(lt, 2) * comb(rt, 2);
        let bad = 0n;

        for (const [v, lv] of leftMap) {
            if (v === m) { continue; }
            const rv = rightMap.get(v) || 0;
            for (let lvc = 0; lvc <= Math.min(lv, 2); lvc++) {
                for (let rvc = 0; rvc <= Math.min(rv, 2); rvc++) {
                    if (lvc + rvc === 0) { continue; }
                    const lRemain = 2 - lvc;
                    const rRemain = 2 - rvc;
                    for (let lmc = 0; lmc <= Math.min(lm, lRemain); lmc++) {
                        for (let rmc = 0; rmc <= Math.min(rm, rRemain); rmc++) {
                            if (lvc + rvc <= lmc + rmc) { continue; }
                            const lOther = lRemain - lmc;
                            const rOther = rRemain - rmc;
                            const lPool = lt - lm - lv;
                            const rPool = rt - rm - rv;
                            if (lPool < lOther || rPool < rOther) { continue; }
                            const ways = comb(lv, lvc) * comb(lm, lmc) % MOD
                                * comb(lPool, lOther) % MOD
                                * comb(rv, rvc) % MOD
                                * comb(rm, rmc) % MOD
                                * comb(rPool, rOther) % MOD;
                            bad = (bad + ways) % MOD;
                        }
                    }
                }
            }
        }
        ans = (ans + total - bad + MOD) % MOD;
    }
    return Number(ans);
};
