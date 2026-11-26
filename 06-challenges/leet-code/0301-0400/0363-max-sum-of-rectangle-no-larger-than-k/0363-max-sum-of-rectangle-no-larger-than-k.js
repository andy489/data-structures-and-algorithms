// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

// Solution: Column Compression + Prefix Sum + Sorted Array — O(m²·n²) time, O(m) space
var maxSumSubmatrix = function(matrix, k) {
    const m = matrix.length, n = matrix[0].length;
    let ans = -Infinity;
    for (let l = 0; l < n; l++) {
        const rowSum = new Array(m).fill(0);
        for (let r = l; r < n; r++) {
            for (let i = 0; i < m; i++) rowSum[i] += matrix[i][r];
            const prefixes = [0];
            let prefix = 0;
            for (const s of rowSum) {
                prefix += s;
                // Find smallest prefix >= prefix - k
                const target = prefix - k;
                for (const p of prefixes) {
                    if (p >= target) {
                        ans = Math.max(ans, prefix - p);
                        break;
                    }
                }
                // Insert in sorted order
                let pos = prefixes.findIndex(p => p > prefix);
                if (pos === -1) prefixes.push(prefix);
                else prefixes.splice(pos, 0, prefix);
            }
        }
    }
    return ans;
};
