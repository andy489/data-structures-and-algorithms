// https://leetcode.com/problems/maximum-of-absolute-value-expression/

var maxAbsValExpr = function(arr1, arr2) {
    let ans = 0;
    for (const s1 of [1, -1]) {
        for (const s2 of [1, -1]) {
            let maxF = -Infinity, minF = Infinity;
            let maxG = -Infinity, minG = Infinity;
            for (let k = 0; k < arr1.length; k++) {
                const f = s1 * arr1[k] + s2 * arr2[k] + k;
                const g = s1 * arr1[k] + s2 * arr2[k] - k;
                maxF = Math.max(maxF, f); minF = Math.min(minF, f);
                maxG = Math.max(maxG, g); minG = Math.min(minG, g);
            }
            ans = Math.max(ans, maxF - minF, maxG - minG);
        }
    }
    return ans;
};
