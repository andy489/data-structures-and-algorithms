// https://leetcode.com/problems/good-subsequence-queries/
/**
 * @param {number[]} nums
 * @param {number} p
 * @param {number[][]} queries
 * @return {number}
 */
var goodSubsequenceQueries = function(nums, p, queries) {
    const n = nums.length;
    const maxVal = 50001;
    const cnt = new Int32Array(maxVal);
    for (const v of nums) {
        cnt[v]++;
    }

    function gcd(a, b) {
        while (b !== 0) {
            [a, b] = [b, a % b];
        }
        return a;
    }

    function hasGood() {
        let countP = 0, g = 0;
        for (let m = p; m < maxVal; m += p) {
            if (cnt[m] > 0) {
                countP += cnt[m];
                g = gcd(g, m / p);
            }
        }
        if (countP < 2 || g !== 1) {
            return false;
        }
        if (countP < n) {
            return true;
        }
        for (let m = p; m < maxVal; m += p) {
            if (cnt[m] > 0) {
                let tempG = 0;
                for (let m2 = p; m2 < maxVal; m2 += p) {
                    const c = cnt[m2] - (m2 === m ? 1 : 0);
                    if (c > 0) {
                        tempG = gcd(tempG, m2 / p);
                    }
                }
                if (tempG === 1) {
                    return true;
                }
            }
        }
        return false;
    }

    let result = 0;
    for (const [ind, val] of queries) {
        cnt[nums[ind]]--;
        nums[ind] = val;
        cnt[val]++;
        if (hasGood()) {
            result++;
        }
    }
    return result;
};
