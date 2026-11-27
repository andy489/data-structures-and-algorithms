// https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
var digArtifacts = function(n, artifacts, dig) {
    const excavated = new Set();
    for (const [r, c] of dig) {
        excavated.add(r * n + c);
    }
    let count = 0;
    for (const [r1, c1, r2, c2] of artifacts) {
        let canExtract = true;
        outer:
        for (let r = r1; r <= r2; r++) {
            for (let c = c1; c <= c2; c++) {
                if (!excavated.has(r * n + c)) {
                    canExtract = false;
                    break outer;
                }
            }
        }
        if (canExtract) {
            count++;
        }
    }
    return count;
};
