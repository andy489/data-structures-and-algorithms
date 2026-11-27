// https://leetcode.com/problems/intervals-between-identical-elements/
var getDistances = function(arr) {
    const n = arr.length;
    const result = new Array(n).fill(0);
    const indicesMap = new Map();
    for (let i = 0; i < n; i++) {
        if (!indicesMap.has(arr[i])) indicesMap.set(arr[i], []);
        indicesMap.get(arr[i]).push(i);
    }
    for (const group of indicesMap.values()) {
        const k = group.length;
        const prefix = new Array(k + 1).fill(0);
        for (let j = 0; j < k; j++) {
            prefix[j + 1] = prefix[j] + group[j];
        }
        const total = prefix[k];
        for (let j = 0; j < k; j++) {
            const idx = group[j];
            const left = idx * j - prefix[j];
            const right = (total - prefix[j + 1]) - idx * (k - j - 1);
            result[idx] = left + right;
        }
    }
    return result;
};
