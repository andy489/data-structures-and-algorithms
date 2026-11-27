// https://leetcode.com/problems/maximum-value-of-concatenated-binary-segments/
/**
 * @param {number[]} nums1
 * @param {number[]} nums0
 * @return {number}
 */
var maximumValue = function(nums1, nums0) {
    const MOD = 1_000_000_007n;
    const n = nums1.length;

    function pow2Mod(exp) {
        let result = 1n;
        let base = 2n;
        let e = BigInt(exp);
        while (e > 0n) {
            if (e & 1n) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            e >>= 1n;
        }
        return result;
    }

    // Sort: A before B if A*2^len(B) + val(B) > B*2^len(A) + val(A)
    const indices = Array.from({length: n}, (_, i) => i);
    indices.sort((a, b) => {
        const onesA = nums1[a], zerosA = nums0[a];
        const onesB = nums1[b], zerosB = nums0[b];
        const lenA = onesA + zerosA;
        const lenB = onesB + zerosB;

        if (lenA + lenB <= 50) {
            const valA = ((1 << onesA) - 1) * (1 << zerosA);
            const valB = ((1 << onesB) - 1) * (1 << zerosB);
            const lhs = valA * (1 << lenB) + valB;
            const rhs = valB * (1 << lenA) + valA;
            return rhs - lhs;
        } else {
            const valA = (Math.pow(2, onesA) - 1) * Math.pow(2, zerosA);
            const valB = (Math.pow(2, onesB) - 1) * Math.pow(2, zerosB);
            const lhs = valA * Math.pow(2, lenB) + valB;
            const rhs = valB * Math.pow(2, lenA) + valA;
            return rhs > lhs ? 1 : rhs < lhs ? -1 : 0;
        }
    });

    let result = 0n;
    for (const idx of indices) {
        const ones = nums1[idx];
        const zeros = nums0[idx];
        const length = ones + zeros;
        const segVal = (pow2Mod(ones) - 1n + MOD) % MOD * pow2Mod(zeros) % MOD;
        result = (result * pow2Mod(length) + segVal) % MOD;
    }

    return Number(result);
};
