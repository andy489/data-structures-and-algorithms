// https://leetcode.com/problems/count-special-subsequences/
var countSpecialSubsequences = function(nums) {
    const n = nums.length;
    const MAX_VAL = 1001;

    // Build suffix counts
    const suffixCount = Array.from({length: n + 1}, () => new Array(MAX_VAL).fill(0));
    for (let i = n - 1; i >= 0; i--) {
        for (let v = 0; v < MAX_VAL; v++) {
            suffixCount[i][v] = suffixCount[i + 1][v];
        }
        suffixCount[i][nums[i]]++;
    }

    let ans = 0n;
    const pCount = new Array(MAX_VAL).fill(0);

    const gcd = (a, b) => { while (b) { [a, b] = [b, a % b]; } return a; };

    for (let q = 1; q < n - 2; q++) {
        if (q >= 2) {
            pCount[nums[q - 2]]++;
        }
        const nq = nums[q];
        for (let r = q + 2; r < n - 1; r++) {
            const nr = nums[r];
            const g = gcd(nq, nr);
            const aq = nq / g, ar = nr / g;
            for (let t = 1; t * aq < MAX_VAL; t++) {
                const a = t * aq;
                const b = t * ar;
                if (b < MAX_VAL) {
                    ans += BigInt(pCount[a]) * BigInt(suffixCount[r + 2][b]);
                }
            }
        }
    }
    return Number(ans);
};
