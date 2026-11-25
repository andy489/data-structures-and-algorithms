// https://leetcode.com/problems/distant-barcodes/

var rearrangeBarcodes = function(barcodes) {
    const freq = new Map();
    for (const b of barcodes) freq.set(b, (freq.get(b)||0)+1);
    const entries = [...freq.entries()].sort((a,b) => b[1]-a[1]);
    const res = new Array(barcodes.length);
    let idx = 0;
    for (const [val, cnt] of entries) {
        for (let i = 0; i < cnt; i++) {
            if (idx >= barcodes.length) idx = 1;
            res[idx] = val;
            idx += 2;
        }
    }
    return res;
};
