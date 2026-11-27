// https://leetcode.com/problems/pancake-sorting/

var pancakeSort = function(arr) {
    const flip = (k) => { let lo = 0, hi = k; while (lo < hi) { [arr[lo++], arr[hi--]] = [arr[hi], arr[lo-1]]; } };
    const res = [];
    for (let size = arr.length; size > 1; size--) {
        let maxIdx = 0;
        for (let i = 1; i < size; i++) if (arr[i] > arr[maxIdx]) maxIdx = i;
        if (maxIdx === size - 1) continue;
        if (maxIdx !== 0) { flip(maxIdx); res.push(maxIdx + 1); }
        flip(size - 1); res.push(size);
    }
    return res;
};
