// https://leetcode.com/problems/strong-password-checker/

var strongPasswordChecker = function(s) {
    const n = s.length;
    let hasLower = false, hasUpper = false, hasDigit = false;
    for (const ch of s) {
        if (ch >= 'a' && ch <= 'z') { hasLower = true; }
        else if (ch >= 'A' && ch <= 'Z') { hasUpper = true; }
        else if (ch >= '0' && ch <= '9') { hasDigit = true; }
    }
    const missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

    const runs = [];
    let i = 0;
    while (i < n) {
        let j = i;
        while (j < n && s[j] === s[i]) { j++; }
        if (j - i >= 3) { runs.push(j - i); }
        i = j;
    }

    if (n < 6) {
        return Math.max(6 - n, missingTypes);
    }

    let repeatReplacements = runs.reduce((sum, len) => sum + Math.floor(len / 3), 0);

    if (n <= 20) {
        return Math.max(repeatReplacements, missingTypes);
    }

    let toDelete = n - 20;
    const deletions = toDelete;

    for (let k = 0; k < runs.length && toDelete > 0; k++) {
        if (runs[k] % 3 === 0) {
            runs[k]--;
            repeatReplacements--;
            toDelete--;
        }
    }
    for (let k = 0; k < runs.length && toDelete > 0; k++) {
        if (runs[k] % 3 === 1) {
            const reduce = Math.min(2, toDelete);
            runs[k] -= reduce;
            repeatReplacements -= Math.floor(reduce / 2);
            toDelete -= reduce;
        }
    }
    for (let k = 0; k < runs.length && toDelete > 0; k++) {
        if (runs[k] >= 3) {
            const reduce = Math.min(runs[k] - 2, Math.floor(toDelete / 3) * 3);
            runs[k] -= reduce;
            repeatReplacements -= Math.floor(reduce / 3);
            toDelete -= reduce;
        }
    }

    return deletions + Math.max(repeatReplacements, missingTypes);
};
