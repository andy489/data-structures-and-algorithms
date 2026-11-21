// https://leetcode.com/problems/compare-version-numbers/

// Solution 1: Split — O(n+m) time, O(n+m) space
var compareVersion = function(version1, version2) {
    const v1 = version1.split('.'), v2 = version2.split('.');
    const n = Math.max(v1.length, v2.length);
    for (let i = 0; i < n; i++) {
        const r1 = i < v1.length ? parseInt(v1[i]) : 0;
        const r2 = i < v2.length ? parseInt(v2[i]) : 0;
        if (r1 < r2) return -1;
        if (r1 > r2) return 1;
    }
    return 0;
};
